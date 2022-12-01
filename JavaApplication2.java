import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class JavaApplication2 {
  
    public static void main(String[] args) throws Exception {
      

    }

    public static byte[] getEncryptedPassword(String password, byte[] salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        
        
        String algorithm = "PBKDF2WithHmacSHA1";
       
        int derivedKeyLength = 512;
       
        
        int iterations = 4096;

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);

        SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);

        return f.generateSecret(spec).getEncoded();
    }

     public static byte[] generateSalt() throws NoSuchAlgorithmException {
      
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

        byte[] salt = new byte[8];
        random.nextBytes(salt);

        return salt;
    }
    

}
