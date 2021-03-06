package pkc.enc.insecurePadding;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public final class InsecurePaddingRSA3 {

	public static void main(String args[]) {
		try {
			Security.addProvider(new BouncyCastleProvider());
			byte[] msg1 = ("demo msg").getBytes();
			KeyPairGenerator g = KeyPairGenerator.getInstance("RSA", "BC");
			g.initialize(2048);
			KeyPair kp = g.generateKeyPair();

			Cipher enc = Cipher.getInstance("RSA/NONE/NoPadding", "BC");
			enc.init(Cipher.ENCRYPT_MODE, kp.getPublic());
			Cipher dec = Cipher.getInstance("RSA/NONE/NoPadding", "BC");
			dec.init(Cipher.DECRYPT_MODE, kp.getPrivate());

			byte[][] ct = new byte[2][];
			for (int i = 0; i < 2; i++) {
				ct[i] = enc.doFinal(msg1);
				byte[] deciphered = dec.doFinal(ct[i]);
			}

		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException | NoSuchProviderException e) {
		}
	}
}
