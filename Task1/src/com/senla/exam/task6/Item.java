package com.senla.exam.task6;


    class Item implements Comparable<Item> {
    private String itemName;
    private int itemWeight;
    private int itemPrice;

    Item(String itemName, int itemWeight, int itemPrice) {
        this.itemName = itemName;
        this.itemWeight = itemWeight;
        this.itemPrice = itemPrice;
    }

    String getItemName() {
        return itemName;
    }


    int getItemWeight() {
        return itemWeight;
    }

    int getItemPrice() {
        return itemPrice;
    }

    // Создаем компаратор для сортировки объектов по параметру веса
    public int compareTo(Item item) {
        return (itemWeight - item.itemWeight);
    }
}
