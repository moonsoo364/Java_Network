package org.example.ch3;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestRunnable implements Runnable{
    private String filename;

    public DigestRunnable(String filename){
        this.filename = filename;
    }


    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha  = MessageDigest.getInstance("SHA-256");

            DigestInputStream din = new DigestInputStream(in,sha);
            while(din.read() != -1);
            din.close();
            // SHA-2 메시지 다이제스트를 계산하여 digest 값을 얻는다.
            byte[] digest = sha.digest();
            StringBuffer result = new StringBuffer(filename);
            result.append(": ");
            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);

        } catch (NoSuchAlgorithmException | FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        for (String filename : args) {
            Thread t = new DigestThread(filename);
            t.start();
        }
    }

}
