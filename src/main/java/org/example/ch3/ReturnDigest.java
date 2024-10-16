package org.example.ch3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//p74
public class ReturnDigest extends Thread{
    private String filename;
    private byte[] digest;
    public ReturnDigest(String filename){
        this.filename = filename;
    }

    @Override
    public void run(){
        try {
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in, sha);
            while(din.read() != -1);
            din.close();
            digest =sha.digest();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //run method 이 끝나기전 호출되면 NullPoint 예외발생
    public byte[] getDigest(){
        return digest;
    }
}
