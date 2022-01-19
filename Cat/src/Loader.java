import cat.Cat;

public class Loader
{
    public static void main(String[] args)
    {
        Cat cat = new Cat();

        System.out.println(cat.getStatus());
    }

    public static Cat getKitten(){
        return new Cat(1100.0);
    }
}