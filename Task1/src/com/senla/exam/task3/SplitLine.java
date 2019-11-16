/*3.	Создать программу, которая будет:
•	подсчитывать количество слов в предложении
•	выводить их в отсортированном виде
•	делать первую букву каждого слова заглавной.
Предложение вводится вручную. (Разделитель пробел (“ ”))
*/
package com.senla.exam.task3;

import java.util.*;

public class SplitLine {
    private static long numberOfWords;
    private static String[] wordsOfLine;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите Ваш текст:");

        String stringForSplit = scanner.nextLine();

        numberOfWords = wordsCount(stringForSplit);
        System.out.println("Количество слов в тексте: " + numberOfWords);

        printWords(sortedWords(wordsOfLine));

        scanner.close();

    }

    // Разделение текста на слова по разделителю (" ")
    private static long wordsCount(String s){
        wordsOfLine = s.split(" ");
        numberOfWords = wordsOfLine.length;
        return numberOfWords;
    }

    // Сортировка списка слов по возрастанию
    private static ArrayList<String> sortedWords(String[] strings){
        ArrayList<String> array = new ArrayList<>(Arrays.asList(strings));
        Collections.sort(array);
        return array;
    }

    // Печать слов с переводом начальной буквы слова в верхний регистр
    private static void printWords(ArrayList<String> array){
        for (String word : array)
        {
            System.out.println(word.substring(0,1).toUpperCase() + word.substring(1));

        }
    }


}
