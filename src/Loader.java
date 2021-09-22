/*Домашняя работа
        Урок 2. Понятие класса и объекта
        Создать 5–7 кошек и вызвать у них различные методы:
        посмотреть, какой у них вес;
        попробовать их покормить и посмотреть, что будет с весом;
        попробовать перекормить кошку, чтобы она взорвалась;
        "замяукать" кошку до смерти.

        Урок 3. Метод, параметры, return
        1. Создать в классе Cat метод, который будет возвращать массу съеденной еды.
        2. Создать в классе Cat метод “сходить в туалет”, который будет уменьшать вес кошки и что-нибудь печатать.

        Урок 4. Статические методы и переменные
        Создать у класса Cat статическую переменную count, которая будет увеличиваться, если кошку создали, и убывать,
        если кошка взорвалась или умерла, и статический метод getCount(), который будет возвращать количество кошек.

        Урок 5. Создание объектов и конструктор
        Создать в классе Cat еще один конструктор так, чтобы массу кошки можно было задавать при ее создании,
        и создать в главном классе метод генерации кошки, как описано в видеоуроке.

        Урок 6. Копирование объектов
        Создать у кошки метод создания ее 'глубокой' копии.

        Урок 7. Внешние библиотеки классов
        1. Повторить действия, выполненные в видео: создать новый проект, подключить к нему библиотеку
        telegramapibridgev2.jar, добиться выполнения программы проверки номера телефона, который задаётся в консоли.
        2. Реализовать программу, которая будет авторизовываться на сервере Telegram и печатать имя пользователя,
        под которым произошла авторизация. Номер телефона и код подтверждения должны вводиться из консоли.
        Результат приложить в виде zip-архива папки с проектом.

        3. В проекте необходимо установить кодировку UTF8: в меню Settings &gt; Editor &gt; File Encodings,
        в пунктах “IDE Encoding” и “Project Encoding” вверху и в пункте “Default encoding for properties files”
        выбрать “UTF8”, нажать “OK”.

        Урок 8. Создание JARфайлов
        Упаковать в JAR-файл приложение, разработанное в первом модуле, которое открывает окно размером 800*600
        по центру экрана. Научиться запускать этот JAR-файл не только кликом мыши, но и через командную строку.*/

public class Loader
{
    private static Cat getNextCat()
    {
        return new Cat(Math.random() * (1000) + 2000.0);
    }

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

        System.out.println("\nTesting additional constructor");
        Cat cat4 = new Cat(3456);
        System.out.println("Initial weight: "+cat4.getWeight());

        System.out.println("\nTesting getNextCat() method");
        Cat cat5 = Loader.getNextCat();
        System.out.println("Initial weight: "+cat5.getWeight());



    }
}