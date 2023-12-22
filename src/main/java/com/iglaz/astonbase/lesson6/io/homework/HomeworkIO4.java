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


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HomeworkIO4 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/java/com/iglaz/astonbase/lesson6/io/homework/UserDemo.java");
        List<String> stringsInput = Files.readAllLines(path);
        List<String> stringsOutput = new ArrayList<>();
        for (String string : stringsInput) {
            if (string.contains("class") | !string.contains("public")) {
                stringsOutput.add(string);
            } else {
                stringsOutput.add(string.replace("public", "private"));
            }
        }
        FileWriter writer = new FileWriter("resources/UserDemo.java.txt");
        for (String str : stringsOutput) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
        System.out.println("Копирование в файл и замена выполнены");
    }
}
