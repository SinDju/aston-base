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

public class HomeworkIO2 {
    public static void main(String[] args) throws IOException {
        File file = Paths.get("resources", "text.txt").toFile();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                String[] lines2 = s.split("\\s*(\\s|,|!|\\.)\\s*");
                for (int i = 0; i < lines2.length - 1; i++) {

                    char aChar1 = lines2[i].charAt(lines2[i].length() - 1);
                    char aChar2 = lines2[i + 1].charAt(0);
                    if (aChar1 == aChar2) {
                        System.out.println(lines2[i] + " " + lines2[i + 1]);
                    }
                }
            }
        }
    }
}
