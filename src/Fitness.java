import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Fitness {
    private final Subscription[] subscriptions = new Subscription[20];
    private Zone zone;
    LocalDateTime currentDate;
    Owner owner;

    public Fitness(Zone zone) {
        this.zone = zone;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Owner getOwner() {
        return owner;
    }

    // метод добавления абонементов в тренажерный зал
    public void addSubscription(Subscription subscription) {
        if (subscriptions.length > 20) {
            System.out.println("Набор закрыт");
            return;
        }
        currentDate = LocalDateTime.now();//currentDate > subscription.getEndDate()
        boolean after = currentDate.isAfter(subscription.getEndDate());
        if (after) {
            System.out.println("Ваш абонемент просрочен");
            return;
        }
        if (subscription.getTypeSubscription() == TypeSubscription.DAILY && currentDate.getHour() < 8 || currentDate.getHour() > 16) {
            System.out.println("По дневному абонементу посещать фитнес клуб раньше 8 и позже 16 часов не имеет возможности");
        }
        if (subscription.getTypeSubscription() == TypeSubscription.FULL || subscription.getTypeSubscription() == TypeSubscription.SINGLE &&
                currentDate.getHour() < 8 || currentDate.getHour() > 22) {
            System.out.println("По полному и разовому абонементу посещать фитнес клуб раньше 8 и позже 22 часов не имеет возможности");
        }
        for (int i = 0; i < subscriptions.length; i++) {
            if (subscriptions[i] == null) {
                subscriptions[i] = subscription;
                info(subscription);
                return;
            }
        }
    }

    // метод добавления абонементов в бассейн
    public void addToSwimming(Subscription subscription) {
        if (subscription.getTypeSubscription() == TypeSubscription.DAILY) {
            System.out.println("По дневному абонементу посещать бассейн не имеет возможности");
        }
        if (subscription.getTypeSubscription() != TypeSubscription.DAILY) {
            addSubscription(subscription);
        }
    }

    // метод добавления абонементов на групповые занятия
    public void addToGroup(Subscription subscription) {
        if (subscription.getTypeSubscription() == TypeSubscription.SINGLE) {
            System.out.println("По разовому абонементу посещать групповые занятия не имеет возможности");
        }
        if (subscription.getTypeSubscription() != TypeSubscription.SINGLE) {
            addSubscription(subscription);
        }
    }

    // метод закрытия фитнеса
    public void closeFitness() {
        Arrays.fill(subscriptions, null);
        System.out.println("Фитнес клуб закрыт");
    }

    //метод вывода информации о клиенте при регистрации и в кокую зону
    //Фамилия Имя Посещаемая зона (бассейн/тренажерный зал/групповые занятия)
    //Дата и время посещения
    public void info(Subscription subscription) {
        System.out.println("Абонемент " + subscription.getOwner().getName() + " " + subscription.getOwner().getSurname() + " зарегестрирован в зоне " + zone.name());
        System.out.println("Дата и время посещения " + currentDate);
    }

    @Override
    public String toString() {
        return "Fitness{" +
                "subscriptionsTraining=" + Arrays.toString(subscriptions) +
                '}';
    }
}
