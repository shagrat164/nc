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
        stringLinkedList.add("укл");
        stringLinkedList.add("кул");

        for (String s : stringLinkedList) {
            System.out.print(s + " ");
        }
        System.out.println();
        checkAnagram(stringLinkedList);
    }

    private static void checkAnagram(LinkedList<String> stringLinkedList) {
        LinkedList<String> tmpList = new LinkedList<>();
        Map<String, Integer> hashMap = new HashMap<>();
        LinkedList<Integer> indexWrd = new LinkedList<>();

        for (String s : stringLinkedList) {
            String str = sortString(s.toLowerCase());
            tmpList.add(str);
            hashMap.put(str, 0);
        }

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            for (String s : tmpList) {
                if (entry.getKey().equals(s)) {
                    entry.setValue(entry.getValue() + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 1) {
                for (int i = 0; i < tmpList.size(); i++) {
                    if (entry.getKey().equals(tmpList.get(i))) {
                        indexWrd.add(i);
                    }
                }
            }
        }

        for (Integer pos : indexWrd) {
            System.out.println(stringLinkedList.get(pos));
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
}
