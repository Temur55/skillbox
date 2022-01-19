package cat;

public class Cat
{
    private static int count = 0;

    private final double MIN_WEIGHT = 1000.0;
    private final double MAX_WEIGHT = 9000.0;
    private final double EYE_COUNT = 2;

    private final double originWeight;
    private double weight;
    private double foodWeight;
    private CatStatus status;
    private Color color;

    public Cat()
    {
        this(1500.0 + 3000.0 * Math.random());
    }

    public Cat(Double weight)
    {
        this.originWeight = weight;
        this.weight = weight;
        this.foodWeight = 0;
        this.color = Color.UNKNOWN;
        count += 1;
        checkStatus();
    }

    public Cat copy()
    {
        Cat catCopy = new Cat(weight);
        catCopy.setColor(color);
        return catCopy;
    }

    public void meow()
    {
        if (isNotAlive()){
            return;
        }

        weight = weight - 1;
        System.out.println("Meow");

        checkStatus();
    }

    public void feed(Double amount)
    {
        if (isNotAlive()){
            return;
        }

        weight += amount;
        foodWeight += amount;

        checkStatus();
    }

    public void pee()
    {
        if (!isAlive()){
            return;
        }

        weight -= 1;
        System.out.println("Pee");

        checkStatus();
    }

    public void drink(Double amount)
    {
        if (isNotAlive()){
            return;
        }

        weight += amount;

        checkStatus();
    }

    public Double getWeight()
    {
        return weight;
    }

    public Double getFoodWeight()
    {
        return foodWeight;
    }

    public CatStatus getStatus()
    {
        return status;
    }

    public Integer getCount()
    {
        return count;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    private void checkStatus()
    {
        if(weight < MIN_WEIGHT) {
            status = CatStatus.DEAD;
        }
        else if(weight > MAX_WEIGHT) {
            status = CatStatus.EXPLODED;
        }
        else if(weight > originWeight) {
            status = CatStatus.SLEEPING;
        }
        else {
            status = CatStatus.PLAYING;
        }

        if(isNotAlive()){
            count -= 1;
        }
    }

    public boolean isAlive()
    {
        switch (getStatus()){
            case DEAD:
            case EXPLODED:
                return false;
            default:
                return true;
        }
    }

    public boolean isNotAlive()
    {
        return !isAlive();
    }

    private enum CatStatus
    {
        DEAD, EXPLODED, SLEEPING, PLAYING;
    }
}