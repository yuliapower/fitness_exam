import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {
        Owner owner1 = new Owner("Yulia", "Suslova", "1996-05-14");
        Owner owner2 = new Owner("Liza", "Litvinova", "1988-09-05");
        Subscription subscription1 = new Subscription(TypeSubscription.DAILY, owner1, "2021-05-14T23:10:00");
        Subscription subscription2 = new Subscription(TypeSubscription.SINGLE, owner2, "2017-05-14T23:10:00");
        subscription1.parseStartDate();
        subscription2.parseStartDate();
        Fitness fitness1 = new Fitness(Zone.SWIMMING);
        fitness1.addToSwimming(subscription1);
        fitness1.addToSwimming(subscription2);
        System.out.println(fitness1);

        Fitness fitness2 = new Fitness(Zone.TRAINING);
        fitness2.addSubscription(subscription1);
        fitness2.addSubscription(subscription2);
        System.out.println(fitness2);

        Fitness fitness3 = new Fitness(Zone.GROUP);
        fitness3.addToGroup(subscription1);
        fitness3.addToGroup(subscription2);
        //  fitness3.closeFitness();
        System.out.println(fitness3);
        //   LocalDateTime current1 = LocalDateTime.now();
        // System.out.println("текущая дата и время " + current1);


    }
}
