package exercise;

import cat.Cat;

public class Exercise1
{
    private static final int CAT_COUNT = 7;
    private static final String CAT_CHECK_WEIGHT_MSG = "Вес кошки под номером %d - %.2f %n";
    private static final String CAT_FEED_MSG = "Вес кошки до кормёшки - %.2f, после - %.2f %n";
    private static final String CAT_STATS_MSG = "Статус кошки под номером %d - %s %n";

    public static void main(String[] args)
    {
        Cat[] catArray = new Cat[CAT_COUNT];
        for (int i = 0; i < CAT_COUNT; i++){
            catArray[i] = new Cat();
            System.out.printf(CAT_CHECK_WEIGHT_MSG, i + 1, catArray[i].getWeight());
        }

        // Кормим первую и вторую кошку
        feedAndPrintWeight(catArray[0]);
        feedAndPrintWeight(catArray[1]);

        // Перекормим третью кошку
        overfeed(catArray[2]);
        System.out.printf(CAT_STATS_MSG, 3, catArray[2].getStatus());

        // Перемяукаем четвёртую кошку
        overmeow(catArray[3]);
        System.out.printf(CAT_STATS_MSG, 4, catArray[3].getStatus());
    }

    /**
     * Кормим и выводим веса
     */
    private static void feedAndPrintWeight(Cat cat)
    {
        double foodWeight = Math.random() * 1000;

        double weightBefore = cat.getWeight();
        cat.feed(foodWeight);
        double weightAfter = cat.getWeight();

        System.out.printf(CAT_FEED_MSG, weightBefore, weightAfter);
    }

    /**
     * Перекармливаем кошку
     */
    private static void overfeed(Cat cat)
    {
        while (cat.isAlive()) {
            cat.feed(1000.0);
        }
    }

    /**
     * Перемяукиваем кошку
     */
    private static void overmeow(Cat cat)
    {
        while (cat.isAlive()) {
            cat.meow();
        }
    }
}
