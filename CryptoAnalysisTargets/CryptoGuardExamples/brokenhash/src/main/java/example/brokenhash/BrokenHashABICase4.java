package example.brokenhash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BrokenHashABICase4 {
    public static void main (String [] args) throws NoSuchAlgorithmException {
        String str = "abcdef";
        String crypto = "MD2";
        go(str,crypto);
    }
    public static void go (String str, String crypto) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(crypto);
        md.update(str.getBytes());
        System.out.println(md.digest());
    }
}
