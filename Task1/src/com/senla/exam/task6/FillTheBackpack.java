/*6.	Имеется набор вещей, которые необходимо поместить в рюкзак. Рюкзак обладает заданной грузоподъемностью.
Вещи в свою очередь обладают двумя параметрами — весом и стоимостью.
Цель задачи заполнить рюкзак не превысив его грузоподъемность и максимизировать суммарную ценность груза.
 */
package com.senla.exam.task6;

import java.util.*;

public class FillTheBackpack {

    private static ArrayList<Item> listOfItem = new ArrayList<>();
    private static int maxValue = 0;
    private static int[][] value;
    private static Backpack pack = new Backpack();

    public static void main(String[] args) {

        System.out.println("Введите вместимость рюкзака:");

        // Устанавливаем размер рюкзака
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                pack.setMaxWeight(sc.nextInt());
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Вы ввели не число!");
            }
        }

        // Определяем предметы для проверки с параметрами название, вес, ценность
        System.out.println("Заполните набор предметов. Для продолжения ввода нажмите Enter, по окончании введите done ");
        while (!(sc.nextLine().equals("done"))) {
            listOfItem.add(fillPack());
        }

        // Сортируем список предметов по возрастанию их веса
        Collections.sort(listOfItem);

        maxValue = (findBestValue(listOfItem));
        System.out.println(maxValue);

        printBestSet(maxValue);

        sc.close();
    }

    // Метод ля создания объектов указанных пользователем предметов
    private static Item fillPack() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название предмета:");
        String name = sc.nextLine();
        int weight;

        while (true) {
            System.out.println("Введите массу предмета:");
            weight = sc.nextInt();
            if (weight > pack.getMaxWeight()) {
                System.out.println("Масса вашего предмета превышает вместимость рюкзака!");
            } else {
                break;
            }
        }

        System.out.println("Введите стоимость предмета:");
        int price = sc.nextInt();

        return new Item(name, weight, price);

    }

    // Применяя динамическое програмированние, строим двухмерный массив предмет/вес предмета
    // для определения наибольшей ценности упакованного рюкзака
    private static int findBestValue(ArrayList<Item> array) {
        ArrayList<Item> arr = new ArrayList<>(array);
        int deg = arr.get(0).getItemWeight();
        int a = arr.size();
        int b = pack.getMaxWeight();
        value = new int[a + 1][b];

        // Заполняем первую строчку таблицы весом предметов с шагом веса наименьшего предмета
        for (int i = 0; i < value[0].length; i++) {
            value[0][i] = deg;
            deg += arr.get(0).getItemWeight();
            if (value[0][i] >= arr.get(0).getItemWeight()) {
                value[1][i] = arr.get(0).getItemPrice();
                maxValue = value[1][i];
            }
        }

        // Заполняем оставшиеся ячейки таблицы наивысшей стоимостью комплектов предметов
        for (int i = 2; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (value[0][j] < arr.get(i - 1).getItemWeight()) {
                    value[i][j] = value[i - 1][j];
                    if (maxValue < value[i][j]) {
                        maxValue = value[i][j];

                    }
                } else if (value[0][j] == arr.get(i - 1).getItemWeight()) {
                    value[i][j] = arr.get(i - 1).getItemPrice();
                    if (maxValue < value[i][j]) {
                        maxValue = value[i][j];

                    }
                } else if (value[0][j] > arr.get(i - 1).getItemWeight()) {
                    value[i][j] = (arr.get(i - 1).getItemPrice()) + value[i - 1][j - arr.get(i - 1).getItemWeight()];
                    if (maxValue < value[i][j]) {
                        maxValue = value[i][j];

                    }
                }
            }
        }

        return maxValue;
    }

    // Восстанавливаем из таблицы комплект предметов, попавших в решение
    private static void printBestSet(int c) {
        for (int k = listOfItem.size(); k > 0; ) {
            if (value[k][value[k].length - 1] == c) {
                System.out.println(listOfItem.get(k - 1).getItemName());
                c = c - listOfItem.get(k - 1).getItemPrice();
                k--;
            } else {
                k--;
            }

        }
    }
}
