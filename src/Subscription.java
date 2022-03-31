import java.time.LocalDateTime;

public class Subscription {
    private TypeSubscription typeSubscription;
    private Owner owner;
    private String startDate;
    private LocalDateTime endDate;
    //  private LocalDateTime finishData;


    //конструктор

    public Subscription(TypeSubscription typeSubscription, Owner owner, String startDate) {
        this.typeSubscription = typeSubscription;
        this.owner = owner;
        this.startDate = startDate;
    }

    //сеттер и геттер для строчки даты регистрации абонимента

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public TypeSubscription getTypeSubscription() {
        return typeSubscription;
    }

    public void setTypeSubscription(TypeSubscription typeSubscription) {
        this.typeSubscription = typeSubscription;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Owner getOwner() {
        return owner;
    }

    // методполучения даты начала абонимента из строки и окончания действия абонимента
    public void parseStartDate() {
        //this.startDate = startDate;
        LocalDateTime parseDate = LocalDateTime.parse(startDate);
        System.out.println("Дата регистрации абонимента " + parseDate);
        if (typeSubscription == TypeSubscription.SINGLE) {
            System.out.println("Дата окончания абонимента " + parseDate.plusDays(1));
            endDate = parseDate.plusDays(1);
        }
        if (typeSubscription == TypeSubscription.DAILY || typeSubscription == TypeSubscription.FULL) {
            System.out.println("Дата окончания абонимента " + parseDate.plusMonths(12));
            endDate = parseDate.plusMonths(12);
        }
    }


    @Override
    public String toString() {
        return "Subscription{" +
                "typeSubscription=" + typeSubscription +
                ", owner=" + owner +
                ", startDate='" + startDate + '\'' +
                '}';
    }
}
