package lec11.app03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by student on 02.11.16.
 */

public class App {
    public static void main(String[] args) {
        LinkedList<String> stringLinkedList = new LinkedList<String>();
        stringLinkedList.add("abc");
        stringLinkedList.add("cba");
        stringLinkedList.add("воз");
        stringLinkedList.add("зов");
        stringLinkedList.add("лук");
        stringLinkedList.add("куль");

        for (String it:stringLinkedList) {
            System.out.print(it + " ");
        }
    }

    private static void checkAnagram(LinkedList<String> stringLinkedList) {
//        LinkedList<String> result = new LinkedList<String>();
        Map<Integer, String[]> resultMap = new HashMap<Integer, String[]>();

        for (String iterator:stringLinkedList) {
            for (String iterator2:stringLinkedList) {
//                char[] chars = iterator.toCharArray();
            }
        }
    }

    private static boolean checkEquals(String s1, String s2) {
        if (s1.equalsIgnoreCase(s2)) {
            return true;
        }
        return false;
    }
}