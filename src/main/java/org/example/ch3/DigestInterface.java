package org.example.ch3;

import javax.xml.bind.DatatypeConverter;

public class DigestInterface {
    public static void main(String[] args) {
        for (String filename: args){
            ReturnDigest dr = new ReturnDigest(filename);
            dr.start();
            raceCondition(filename, dr);
        }

    }
    public static void raceCondition(String filename, ReturnDigest dr){
        StringBuilder result = new StringBuilder((filename));
        result.append(": ");
        byte[] digest = dr.getDigest();
        result.append(DatatypeConverter.printHexBinary(digest));
        System.out.println(result);
    }

}

