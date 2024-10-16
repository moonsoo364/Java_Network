package org.example.ch3.callback;

import javax.xml.bind.DatatypeConverter;

public class CallbackDigestUserInterface {
    public static void main(String[] args) {
        for(String filename : args){
            CallbackDigest cb =new CallbackDigest(filename);
            Thread t =new Thread(cb);
            t.start();
        }
    }

    //콜백 : 작업이 끝났을 때 자신을 생성한 클래스를 다시 호출하는 방법
    //CallbackDigest에서 해당 함수를 호출
    public static void receiveDigest(byte[] digest, String name){
        StringBuilder result = new StringBuilder(name);
        result.append(": ");
        result.append(DatatypeConverter.printHexBinary(digest));
        System.out.println(result);

    }
}
