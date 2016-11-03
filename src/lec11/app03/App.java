package lec11.app03;

import java.util.*;

/**
 * Created by student on 02.11.16.
 */

public class App {
    public static void main(String[] args) {
        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("abc");
        stringLinkedList.add("cba");
        stringLinkedList.add("воз");
        stringLinkedList.add("Зов");
        stringLinkedList.add("лук");
        stringLinkedList.add("кукиш");
        stringLinkedList.add("куль");

        for (String it:stringLinkedList) {
            System.out.print(it + " ");
        }

        checkAnagram(stringLinkedList);
    }

    private static void checkAnagram(LinkedList<String> stringLinkedList) {
        LinkedList<String> tmpList = new LinkedList<>();
        
        for (String iteratorI : stringLinkedList) {

        }
    }

    private static String sortString(String str) {
        char[] mass = str.toCharArray();
        for (int i = mass.length; i > 0; i--) {
            boolean flag = true;
            for (int j = 1; j < i; j++) {
                if (mass[j] < mass[j-1]) { // по убыванию
                    char ch = mass[j-1];
                    mass[j-1] = mass[j];
                    mass[j]=ch;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return new String(mass);
    }

    private static boolean checkEquals(String s1, String s2) {
        if (s1.equalsIgnoreCase(s2)) {
            return true;
        }
        return false;
    }
}
