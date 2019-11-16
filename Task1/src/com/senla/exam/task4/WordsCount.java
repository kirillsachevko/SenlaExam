/*4.	Создать программу, которая подсчитывает сколько раз употребляется слово в тексте (без учета регистра).
Текст и слово вводится вручную.
*/
package com.senla.exam.task4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordsCount {


    public static void main(String[] args) {

        System.out.println("Введите ваш текст:");

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] words = text.split(" "); // Разделение текста по на слова по разделителю (" ")
        ArrayList<String> wordToLowCase = new ArrayList<>(); // Создание списка слов

        // Перевод всех слов в нижний регистр
        for (String word: words
             ) {
            wordToLowCase.add(word.toLowerCase());
        }

        // Создание таблицы слов и количества их повторений
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word: wordToLowCase
             ) {
            if (!wordsCount.containsKey(word)){
                wordsCount.put(word, 0);
            }

            wordsCount.put(word, wordsCount.get(word) + 1);
        }

       System.out.println("Введите слово для проверки:");

        String wordToCheck = scanner.nextLine().toLowerCase();
        int count = wordsCount.get(wordToCheck);

        System.out.println("Ваше слово " + wordToCheck + " повторяется в тексте " + count + " раз(а)");
    }
}
