package org.example.ch2;

import java.io.*;
//p46 ~ 47
public class FilterConnection {
    public static void main(String[] args) throws FileNotFoundException {

    }
    //Reference가 Rewrite 될 수 있음
    static void exam_1() throws FileNotFoundException {
        FileInputStream fin = new FileInputStream("/src/main/resources/data.txt");
        BufferedInputStream bin = new BufferedInputStream(fin);
    }
    // 내장된 파일 입력 스트림에 접근하지 못하게 처리
    static void exam_2() throws FileNotFoundException {
        InputStream fin = new FileInputStream("/src/main/resources/data.txt");
        fin = new BufferedInputStream(fin);
    }
    //이렇게 생성된 필터의 연결은 영구적이다.
    static void exam_3() throws  FileNotFoundException{
        DataOutputStream dout = new DataOutputStream(
                new BufferedOutputStream(
                new FileOutputStream("/src/main/resources/data.txt")
        ));
    }
}
