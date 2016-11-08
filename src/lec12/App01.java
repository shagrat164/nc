package lec12;

import java.io.*;

/**
 * Created by student on 07.11.16.
 */
public class App01 {
    public static void main(String[] args) {
//        try {
//            FileWriter fileWriter = new FileWriter("src/lec12/out.txt");
//            String string = "test";
//            fileWriter.write(string);
//            fileWriter.flush();
//            fileWriter.close();
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//
//        try {
//            FileReader fileReader = new FileReader("src/lec12/out.txt");
//            int c;
//            while ((c=fileReader.read())!=-1) {
//                System.out.println((char) c);
//            }
//            fileReader.close();
//        } catch (IOException e) {
//            System.out.println();
//        }
        try {
            FileInputStream fileInputStream = new FileInputStream("out/production/NetCracker/lec12/App01.class");
            System.out.println("Размер файла \"App01.class\": "  + fileInputStream.available());
            byte[] byteBuffer = new byte[fileInputStream.available()];
            fileInputStream.read(byteBuffer, 0, fileInputStream.available());
            fileInputStream.close();
            StringBuffer stringBuffer = new StringBuffer();
            int count = 0;
            for (byte aByteBuffer : byteBuffer) {
                count++;
                stringBuffer.append(String.format("%02x", aByteBuffer));
                stringBuffer.append(" ");
                if (count == 4) {
                    stringBuffer.append("\n");
                    count = 0;
                }
            }
            String string = new String(stringBuffer);
            PrintStream printStream = new PrintStream("out/production/NetCracker/lec12/App01.class.txt");
            printStream.print(string);
            printStream.flush();
            printStream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}