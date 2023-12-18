package com.iglaz.astonbase.lesson5.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println); // - 1
        List<Trader> traders = transactions.stream().map(transaction -> transaction.getTrader()).collect(Collectors.toList());
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).collect(Collectors.toSet())
                .stream().forEach(System.out::println); // 2
        traders.stream().filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println); // 3
        traders.stream().map(trader -> trader.getName()).sorted().forEach(System.out::println); // 4
        Boolean traderMilan = traders.stream().anyMatch(trader -> trader.getCity().equals("Milan")); // 5
        if (!traderMilan) {
            System.out.println("Трейдера мз Милана нет");
        }
        System.out.println("Трейдер мз Милана существует");
        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getValue()).forEach(System.out::println); // 6
        int maxValue = transactions.stream().mapToInt(Transaction::getValue).max().getAsInt(); // 7
        System.out.println("Сумма максимальной транзакции равна = " + maxValue);
        int minValue = transactions.stream().mapToInt(Transaction::getValue).min().getAsInt(); // 8
        System.out.println("Сумма минимальной транзакции равна = " + minValue);


    }
}
