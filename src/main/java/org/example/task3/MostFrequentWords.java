package org.example.task3;

import java.io.*;
import java.util.*;

/**
 * 3. Пошук найбільш повторюваних слів: Створіть програму, яка приймає великий текстовий файл.
 * Прочитайте текстовий файл та визначте 10 найбільш повторюваних слів у тексті.
 * Використовуйте HashMap або TreeMap для підрахунку кількості входжень кожного слова.
 */
public class MostFrequentWords {
    public static void main(String[] args) {
        String filePath = "file.txt";
        int topWordsCount = 10;

        Map<String, Integer> wordCountMap = new HashMap<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String word;
            while ((word = bufferedReader.readLine()) != null) {
                word = word.toLowerCase().replaceAll("[^a-zA-Z0-9а-яА-Я\\s]", "");
                String[] arrayFromWord = word.toLowerCase().split(" ");
                for (String string: arrayFromWord) {
                    if (wordCountMap.containsKey(string)) {
                        wordCountMap.put(string, (wordCountMap.get(string) + 1));
                    } else {
                        wordCountMap.put(string, 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("");

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCountMap.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println("Найбільш повторювані слова:");
        for (int i = 0; i < topWordsCount; i++) {
            Map.Entry<String, Integer> entry = entries.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
