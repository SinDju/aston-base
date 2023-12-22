package com.iglaz.astonbase.lesson6.exceptions.homework;

/*
1. Объявите ссылочную переменную со значением null. Вызовите метод у этой переменной.
Отловить возникшее исключение c помощью блока try-catch.

2. Написать код, который создаст, а затем отловит ArrayIndexOutOfBoundsException.

3. Создать собственный класс-исключение - наследник класса Exception.
Создать метод, выбрасывающий это исключение. Вызвать этот метод и отловить исключение.
Вывести stack trace в консоль.

4. Бросить одно из существующих в JDK исключений, отловить его и оберните его
в свое кастомное исключение указав в качестве причины отловленное.

5. Создать метод случайным образом выбрасывающий одно из 3-х видов исключений.
Вызвать этот метод в блоке try-catch, отлавливающим любое из 3-х.
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class HomeworkException {
    public static void main(String[] args) {
        // 1
        User user = null;
        try {
            user.say();
        } catch (NullPointerException exp) {
            System.out.println(exp);
        }

        //2
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
            System.out.println(arr[i]);
        }
        try {
            setArrayByNumber(arr, 10);
        } catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println(exp);
        }

        // 3
        User newUser = new User("Olga", 26, "dju@mail.ru");
        ArrayList<User> users = new ArrayList<>();
        try {
            getUser(users, newUser);
        } catch (ObjectNotFoundException e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                System.out.println(stackTraceElement);
            }
            System.out.println(e.getMessage());
        }

        //4
        try {
            getArrayByNumber(arr, 11);
        } catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println(exp);
        }

        //5
        try {
            int number = new Random().nextInt(3);
            randomException(number);
        } catch (Exception exp) {
            System.out.println(exp);
        }

    }

    private static void randomException(int number) throws Exception {
        switch (number) {
            case 0 -> throw new ObjectNotFoundException("ObjectNotFoundException");
            case 1 -> throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException");
            case 2 -> throw new NullPointerException("NullPointerException");
        }
    }

    public static void setArrayByNumber(int[] array, int number) {
        array[number] = 1;
    }

    public static int getArrayByNumber(int[] array, int number) throws ArrayException{
        if (number >= array.length) {
            throw new ArrayException("Превышен размер массива");
        }
        return array[number];
    }

    public static User getUser(ArrayList<User> users, User user) throws ObjectNotFoundException {
        if (!users.contains(user)) {
            throw new ObjectNotFoundException("Пользователь " + user + " не найден");
        }
        return user;
    }
}
