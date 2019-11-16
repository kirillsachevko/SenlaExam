/*1.	Создать программу, которая будет сообщать, является ли целое число,
введенное пользователем, чётным или нечётным, простым или составным.
Если пользователь введёт не целое число, то сообщать ему об ошибке.
 */

package com.senla.exam.task1;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumbersCheck {
    private static long numberForCheck;
    private static String isPrime;
    private static String isEven;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите целое число: ");
            try {
                numberForCheck = scanner.nextLong();
                if (numberForCheck <= 1) {
                    System.out.println("Вы ввели не целое число!");
                } else {
                    break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Вы ввели не целое число!");
                scanner.nextLine();
            }
        }

        scanner.close();

        isPrime(numberForCheck);
        isEven(numberForCheck);

        System.out.println("Ваше число " + isPrime + " и " + isEven);

    }

    // Метод для проверки является ли число простым
    private static void isPrime(long a) {
        Long number = a;
        BigInteger bigInteger = BigInteger.valueOf(a);
        boolean probablyPrime = bigInteger.isProbablePrime((int) Math.log(number));
        if (probablyPrime) {
            isPrime = "простое";
        } else {
            isPrime = "составное";
        }
    }

    // Проверка является ли число четным либо нечетным
    private static void isEven(long b) {
        if (b % 2 == 0) {
            isEven = "четное";
        } else {
            isEven = "нечетное";
        }
    }
}
