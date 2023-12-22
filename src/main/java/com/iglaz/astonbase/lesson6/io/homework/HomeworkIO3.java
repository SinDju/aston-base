package com.iglaz.astonbase.lesson6.io.homework;

/*
1. Задан файл с текстом, найти и вывести в консоль все слова, начинающиеся с гласной буквы.

2. Задан файл с текстом, найти и вывести в консоль все слова,  для которых последняя буква
одного слова совпадает с первой буквой следующего слова

3. Задан файл с текстом. В каждой строке найти и вывести наибольшее число цифр, идущих подряд.

4. Задан файл с java-кодом. Прочитать текст программы из файла и все слова public в объявлении
атрибутов и методов класса заменить на слово private. Результат сохранить в другой заранее
созданный файл.

5. Задан файл с java-кодом. Прочитать текст программы из файла и записать в другой файл в обратном
порядке символы каждой строки.
*/


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class HomeworkIO3 {
    public static void main(String[] args) throws IOException {
        File file = Paths.get("resources", "text3.txt").toFile();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                String[] strings = s.split("/n");
                for (int i = 0; i < strings.length; i++) {
                    char[] chars = strings[i].toCharArray();
                    int maxCount = 0;
                    int count = 0;
                    for (char c : chars) {
                        if (Character.isDigit(c)) {
                            count++;
                        }
                    }
                    if (count > maxCount) {
                        maxCount = count;
                    }
                    System.out.println(maxCount);
                }
            }
        }
    }
}
