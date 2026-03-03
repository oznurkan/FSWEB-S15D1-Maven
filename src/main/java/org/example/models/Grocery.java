package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery(){

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("\n           Alışveriş Sepeti");

        while (running){

            System.out.println("\nSeçenekler :");
            System.out.println("0 - Çıkış ");
            System.out.println("1 - Ürün ekle");
            System.out.println("2 - Ürün sil");

            System.out.print("\nSeçenek girininiz (0/1/2): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "0":
                    System.out.println("Çıkış yapıldı");
                    System.out.println("Ürün sepeti :");
                    printSorted();
                    running = false;
                    break;

                case "1":
                    System.out.print("\nEklenmesini istediğiniz elemanları giriniz: ");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    printSorted();
                    break;

                case "2":
                    if( groceryList.isEmpty()){
                        System.out.println("Sepetiniz boş ürün çıkaramazsınız");
                    }else{
                        System.out.print("\nÇıkarılmasını istediğiniz elemanları giriniz: ");
                        String itemsToRemove = scanner.nextLine();
                        removeItems(itemsToRemove);
                        printSorted();

                    }
                    break;

                default:
                    System.out.println("Geçerli bir seçenek giriniz (0/1/2)");
                    break;
            }
        }

        scanner.close();

    }

    public static void addItems(String input){
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Herhangi bir ürün yazılmadı");
            return;
        }

        String[] items = input.split(",");
        int addedCount = 0;

        for (String item : items) {
            String trimmedItem = item.trim().toLowerCase();

            if (trimmedItem.isEmpty()) {
                continue;
            }

            if (checkItemIsInList(trimmedItem)) {
                System.out.println("!'" + trimmedItem + "' Ürün zaten sepetinizde var ");
            } else {
                groceryList.add(trimmedItem);
                addedCount++;
                System.out.println(" '" + trimmedItem + "' Ürün sepete eklendi");
            }
        }

        if (addedCount > 0) {
            Collections.sort(groceryList);
            System.out.println("\n✓ " + addedCount + " tane ürün sepetinizde var!");
        } else {
            System.out.println("\n Yeni ürün sepete eklenmedi");
        }
    }


    public static void removeItems(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Silmek istediğiniz ürün sepetinizde yok");
            return;
        }

        String[] items = input.split(",");
        int removedCount = 0;

        for (String item : items) {
            String trimmedItem = item.trim().toLowerCase();

            if (trimmedItem.isEmpty()) {
                continue;
            }

            if (checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
                removedCount++;
                System.out.println("✓ '" + trimmedItem + "' ürün sepetten silindi");
            } else {
                System.out.println(" '" + trimmedItem + "' ürün sepette bulununamadı");
            }
        }

        if (removedCount > 0) {
            Collections.sort(groceryList);
            System.out.println("\n✓ " + removedCount + " tane ürün sepetinizden silindi");
        } else {
            System.out.println("\nSilmek için ürün yok");
        }
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.trim().toLowerCase());
    }

    public static void printSorted() {
        if (groceryList.isEmpty()) {
            System.out.println("\n Alışveriş sepetiniz boş");
            return;
        }

        Collections.sort(groceryList);

        System.out.println("\n Sıralanmış Alışveriş Sepetiniz");
        System.out.println("─".repeat(45));

        for (int i = 0; i < groceryList.size(); i++) {
            System.out.printf("%2d. %s%n", (i + 1), groceryList.get(i));
        }

        System.out.println("─".repeat(45));
        System.out.println("Toplam ürün : " + groceryList.size());
    }



}
