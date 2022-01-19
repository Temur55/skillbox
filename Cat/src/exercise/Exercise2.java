package exercise;

import cat.Cat;

public class Exercise2
{

    public static final double FOOD_WEIGHT = 150.0;

    /**
     * Проверка работы методов pee() и feed()
     */
    public static void main(String[] args)
    {
        Cat cat = new Cat();
        cat.feed(FOOD_WEIGHT);
        for (int i = 0; i < 5; i++) {
            cat.pee();
        }

        System.out.println(cat.getFoodWeight());
    }
}
