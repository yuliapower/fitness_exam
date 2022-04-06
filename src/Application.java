import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {
        Fitness fitness1 = new Fitness();
        Owner owner1 = new Owner("Yulia", "Suslova", "1996-05-14");
        Owner owner2 = new Owner("Liza", "Litvinova", "1988-09-05");
        Owner owner3 = new Owner("Sam", "Fox", "1975-08-12");
        Subscription subscription1 = new Subscription(TypeSubscription.DAILY, owner1, "2021-05-14T23:10:00");
        Subscription subscription2 = new Subscription(TypeSubscription.SINGLE, owner2, "2017-05-14T23:10:00");
        Subscription subscription3 = new Subscription(TypeSubscription.FULL, owner3, "2022-03-14T23:10:00");
        subscription1.parseStartDate();
        subscription2.parseStartDate();
        subscription3.parseStartDate();

        fitness1.addSubscriptions(subscription1,Zone.SWIMMING);
        fitness1.addSubscriptions(subscription2,Zone.SWIMMING);
        fitness1.addSubscriptions(subscription3,Zone.GROUP);
        fitness1.addSubscriptions(subscription1,Zone.TRAINING);
        fitness1.infoSubscriptions();



    }
}
