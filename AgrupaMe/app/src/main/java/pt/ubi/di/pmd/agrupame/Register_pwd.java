package pt.ubi.di.pmd.agrupame;

import java.math.BigInteger;
import java.security.*;
import java.util.Random;


public class Register_pwd {

    private String secure_password;
    private String username;
    private String email;
    BigInteger hash;
    private byte[] rep;

    static SecureRandom secureRandomGenerator = new SecureRandom();
    static Random random = new Random();


    public Register_pwd(String password, String username, String email) throws NoSuchProviderException, NoSuchAlgorithmException {
        byte[] salt = Secure_salt();
        this.email = email;
        this.username = username;
        this.secure_password = getSecurePassword(password,salt);
    }

    //-> $salt = MD5(rand()) -> guardado com username para verificação da password
    //$rep = hash("SHA256",$salt,$pass);---> representação da password
    //username + salt + rep -> guardados -> email/username -> salt + pass + sha256 = rep = rep -> confirma.
    //Seguro e fiável.

    private static String getSecurePassword(String password, byte[] salt){
        String generatedPassord = null;
        try{
            MessageDigest msgDigest = MessageDigest.getInstance("MD5");
            msgDigest.update(salt);
            byte[] bytes = msgDigest.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<bytes.length;i++) {
                sb.append(Integer.toString((bytes[i] &0xff) + 0x100, 16).substring(1));
            }
            generatedPassord = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassord;
    }

    private static byte[] Secure_salt() throws NoSuchProviderException, NoSuchAlgorithmException {
        //Always use SecureRandom generator
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG","SUN");

        //create array for salt
        byte[] salt = new byte[16]; //size of byte array = 16

        //get a random salt
        secureRandom.nextBytes(salt); //
        return salt;
    }
}
