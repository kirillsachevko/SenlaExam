/*2. Создать программу, которая будет вычислять и выводить на экран НОК (наименьшее общее кратное)
 и НОД (наибольший общий делитель) двух целых чисел, введенных пользователем.
Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.*/

package com.senla.exam.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonDivisors {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long firstNumber;
        long secondNumber;

        while (true) {
            System.out.println("Введите первое целое число: ");
            try {
                firstNumber = scanner.nextLong();
                break;
            } catch (InputMismatchException exception) {
                System.out.println("Вы ввели не целое число!");
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.println("Введите второе целое число: ");
            try {
                secondNumber = scanner.nextLong();
                break;
            } catch (InputMismatchException exception) {
                System.out.println("Вы ввели не целое число!");
                scanner.nextLine();
            }
        }

        scanner.close();

        long gsd = greatestCommonDivisor(firstNumber, secondNumber);
        long lcm = leastCommonMultiple(firstNumber, secondNumber);

        System.out.println("Наибольший общий делитель для чисел " + firstNumber + " и " + secondNumber + " это число " + gsd);
        System.out.println("Наименьшее общее кратное для чисел " + firstNumber + " и " + secondNumber + " это число " + lcm);
    }

    // Определение наибольшего общего делителя
    private static long greatestCommonDivisor(long m, long k) {
        long res = m % k;
        while (res != 0) {
            m = k;
            k = res;
            res = m % k;
        }
        return k;
    }

    // Определение наименьшего общего кратного
    private static long leastCommonMultiple(long a, long b) {
        return a * b / greatestCommonDivisor(a, b);
    }
}

