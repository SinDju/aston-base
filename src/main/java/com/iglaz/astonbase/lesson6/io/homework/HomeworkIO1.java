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

public class HomeworkIO1 {
    public static void main(String[] args) throws IOException {
        File file = Paths.get("resources", "text.txt").toFile();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                String[] lines = s.split("\\s*(\\s|,|!|\\.)\\s*");
                for (int i = 0; i < lines.length; i++) {

                    char aChar = lines[i].charAt(0);
                    if ((aChar == 'а' || aChar == 'А' || aChar == 'у' || aChar == 'У' || aChar == 'о' || aChar == 'О'
                            || aChar == 'и' || aChar == 'И' || aChar == 'э' || aChar == 'Э'
                            || aChar == 'я' || aChar == 'Я' || aChar == 'ю' || aChar == 'Ю'
                            || aChar == 'ё' || aChar == 'Ё' || aChar == 'е' || aChar == 'Е'
                            || aChar == 'ы' || aChar == 'Ы') && lines[i].length() > 1) {
                        System.out.println(lines[i]); // 1
                    }
                }
            }
        }
    }
}
