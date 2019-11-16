/*5.	Создать программу, которая в последовательности от 0 до N,
находит все числа-палиндромы (зеркальное значение равно оригинальному).
Длина последовательности N вводится вручную и не должна превышать 100.
 */
package com.senla.exam.task5;

import java.util.Scanner;
import java.util.StringTokenizer;

public class FindPalindroms {
    public static void main(String[] args) {

       String [] numberForCheck;

        while (true) {
            System.out.println("Введите все числа в одну строку разделяя запятой. По окончании нажмите Enter. Количество чисел не должно превышать 100!");
            Scanner scanner = new Scanner(System.in);
            String numbers = scanner.nextLine();
            numberForCheck = token(numbers);
            if (numberForCheck.length < 100) {
                break;
            }
        }
        toCheckPalindromNumber(numberForCheck);
    }

    // Разделение пользовательского ввода на отдельные числа
    private static String[] token(String numbers) {
        StringTokenizer num = new StringTokenizer(numbers, ", ");
        int count = num.countTokens();
        String[] numText = new String[count];
        for (int i = 0; i < numText.length; i++) {
            numText[i] = num.nextToken();
        }
        return numText;
    }

    // Проверка целого числа, является ли оно палиндромом
    private static boolean checkNumbers(int num) {
        char[] x = String.valueOf(num).toCharArray();
        boolean check = false;
        for (int i = 0, j = x.length - 1; i < x.length; i++, j--) {
            if (x[i] == x[j]) {
                check = true;
            } else {
                return false;
            }
        }
        return check;
    }

    // Проверка вещественного числа, является ли оно палиндромом
    private static boolean checkNumbers(double num) {
        char[] x = String.valueOf(num).toCharArray();
        boolean check = false;
        for (int i = 0, j = x.length - 1; i < x.length; i++, j--) {
            if (x[i] == x[j]) {
                check = true;
            } else {
                return false;
            }
        }
        return check;
    }

    // Проверка пользовательского ввода и вывод результатов
    private static void toCheckPalindromNumber(String[] nums) {
        for (String number : nums
        ) {
            try {
                int a = Integer.parseInt(number);
                if (checkNumbers(a)) {
                    System.out.println("Число " + a + " является палиндромом");
                }
            } catch (NumberFormatException e) {
                try {
                    double b = Double.parseDouble(number);
                    if (checkNumbers(b)) {
                        System.out.println("Число " + b + " является палиндромом");
                    }
                } catch (NumberFormatException f) {
                    System.out.println("Введенное вами выражение '" + number +
                            "' не является целым или вещественным числом");
                }
            }
        }
    }
}
