
public class Loader
{
    public static void main(String[] args)
    {
        int N=7; //Число генерируемых кошек

        Cat cats[] = new Cat[N];
        System.out.println("cat №"+"\t"+"Weight"+"\t\t\t\t " + "Status");
        for (int i=0;i<N; i++){
            cats[i] = new Cat();
            System.out.println("    "+(i+1)+"\t"+cats[i].getWeight()+"\t "+cats[i].getStatus());
        }


        System.out.println("\nTesting feeding (cat1)");
        Cat cat1 = cats[0];
        System.out.println("Before small feeding: "+cat1.getWeight());
        cat1.feed(1.0);
        System.out.println("After small feeding:  "+cat1.getWeight());
        while (cat1.getStatus()!="Exploded"){
            System.out.print("+ ");
            cat1.feed(100.0);
        }
        System.out.println("\nAfter serie feeding: " + cat1.getWeight() + ". Cat1 exploded.");

        System.out.println("\nTesting meowing (cat2)");
        Cat cat2 = cats[1];
        System.out.println("Initial weight "+cat2.getWeight());

        while (cat2.getStatus()!="Dead"){
            cat2.meow();
        }
        System.out.println("After last meow: " + cat2.getWeight()+". Cat2 dead");

        System.out.println("\nTesting property theWholeFoodEaten (dead cat1)");
        System.out.println("Cat1 had eaten " + cat1.getTheWholeFoodEaten()+ " before explosion");

        //poop
        System.out.println("\nTesting pooping (cat3)");
        Cat cat3 = cats[2];
        System.out.println("Initial weight: "+cat3.getWeight());
        cat3.poop();
        System.out.println("Weight after pooping: "+cat3.getWeight());

        System.out.println("\nTesting static field count");
        System.out.println("Cat count: " + Cat.getCount());
    }
}