package org.example.ch3.callback;

import javax.xml.bind.DatatypeConverter;

public class InstanceCallbackDigestUserInterface {

    private String filename;
    private byte[] digest;

    public InstanceCallbackDigestUserInterface(String filename){
        this.filename = filename;
    }
    public void calculateDigest(){
        InstanceCallbackDigest cb = new InstanceCallbackDigest(filename,this);
        Thread t = new Thread(cb);
        t.start();
    }
    public static void main(String[] args) {
        for(String filename : args){
            InstanceCallbackDigestUserInterface d = new InstanceCallbackDigestUserInterface(filename);
            d.calculateDigest();
        }
    }

    public void receiveDigest(byte[] digest, String name){
        StringBuilder result = new StringBuilder(name);
        result.append(": ");
        result.append(DatatypeConverter.printHexBinary(digest));
        System.out.println(result);

    }
}
