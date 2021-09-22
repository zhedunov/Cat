
public class Cat
{
    private Double originWeight;
    private Double weight;
    private Double theWholeFoodEaten;

    private Double minWeight;
    private Double maxWeight;

    private static int count = 0;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        theWholeFoodEaten = 0.0;
        count = count + 1;
    }

    public void meow()
    {
        weight = weight - 1;
        //System.out.println("Meow"); //-включить обратно!!
        if ((getStatus() == "Dead") || (getStatus() == "Exploded")) {
            count = count - 1;
        }

    }

    public void poop() //"Сходить в туалет"
    {
        if (weight>minWeight) {
            weight = weight - 10;
            System.out.println("\"Po-opsss... Excuse me!)\"");
        } else {
            System.out.println("Dead cat can not poop.");
        }
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
        theWholeFoodEaten = theWholeFoodEaten + amount;
        if ((getStatus() == "Dead")||(getStatus() == "Exploded")){
            count = count - 1;
        }
    }

    public void drink(Double amount) {
        weight = weight + amount;
        if ((getStatus() == "Dead") || (getStatus() == "Exploded")) {
            count = count - 1;
        }
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    public Double getTheWholeFoodEaten(){
        return theWholeFoodEaten;
    }

    public static int getCount(){
        return Cat.count;
    }
}