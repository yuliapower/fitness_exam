import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Fitness {

    private final Subscription[] gym = new Subscription[20];
    private final Subscription[] pool = new Subscription[20];
    private final Subscription[] group = new Subscription[20];
    LocalDateTime currentDate = LocalDateTime.now();

    public Fitness() {
    }

    // метод добавления абонементов в желаемые зоны
    public void addSubscriptions(Subscription subscription, Zone zone) {
        boolean after = currentDate.isAfter(subscription.getEndDate());
        if (after) {
            System.out.println("Ваш абонемент просрочен");
            return;
        }
        if ((subscription.getTypeSubscription() == TypeSubscription.DAILY) && (currentDate.getHour() < 8 || currentDate.getHour() > 16)) {
            System.out.println("По дневному абонементу посещать фитнес клуб раньше 8 и позже 16 часов не имеет возможности");
            return;
        }
        if ((subscription.getTypeSubscription() == TypeSubscription.FULL || subscription.getTypeSubscription() == TypeSubscription.SINGLE) &&
                (currentDate.getHour() < 8 || currentDate.getHour() > 22)) {
            System.out.println("По полному и разовому абонементу посещать фитнес клуб раньше 8 и позже 22 часов не имеет возможности");
            return;
        }
        if (zone.equals(Zone.TRAINING)) {
            if (gym.length > 20) {
                System.out.println("Набор в тренажерный зал закрыт");
                return;
            }
          addTo(Zone.TRAINING,subscription,gym);
        }
        if (zone.equals(Zone.SWIMMING)) {
            if (subscription.getTypeSubscription() == TypeSubscription.DAILY) {
                System.out.println("По дневному абонементу посещать бассейн не имеет возможности");
            }
            if (pool.length > 20) {
                System.out.println("Набор в бассейн закрыт");
                return;
            }
            if (subscription.getTypeSubscription() != TypeSubscription.DAILY) {
               addTo(Zone.SWIMMING,subscription,pool);
            }
        }
        if (zone.equals(Zone.GROUP)) {
            if (subscription.getTypeSubscription() == TypeSubscription.SINGLE) {
                System.out.println("По разовому абонементу посещать групповые занятия не имеет возможности");
            }
            if (group.length > 20) {
                System.out.println("Набор на групповые занятия закрыт");
                return;
            }
            if (subscription.getTypeSubscription() != TypeSubscription.SINGLE) {
                addTo(Zone.GROUP,subscription,group);
                }
            }
        }

    private void addTo(Zone zone,Subscription subscription,Subscription[] subscriptions){
        for (int i = 0; i < subscriptions.length; i++) {
            if (subscriptions[i] == null) {
                subscriptions[i] = subscription;
                info(subscription, zone);
                return;
            }
        }
    }

    // метод закрытия фитнеса
    public void closeFitness() {
        Arrays.fill(pool, null);
        Arrays.fill(gym, null);
        Arrays.fill(group, null);
        System.out.println("Фитнес клуб закрыт");
    }

    //метод вывода информации о клиенте при регистрации и в кокую зону
    public void info(Subscription subscription, Zone zone) {
        System.out.println("Абонемент " + subscription.getOwner().getName() + " " + subscription.getOwner().getSurname() + " зарегестрирован в зоне " + zone.name());
        System.out.println("Дата и время посещения " + currentDate);
    }

    // метод вывода информации о посетителях
    public void infoSubscriptions() {
        System.out.println("Посетители " + Zone.TRAINING.name() + Arrays.toString(gym));
        System.out.println("Посетители " + Zone.SWIMMING.name() + Arrays.toString(pool));
        System.out.println("Посетители " + Zone.GROUP.name() + Arrays.toString(group));
    }

    @Override
    public String toString() {
        return "Fitness{" +
                "gym=" + Arrays.toString(gym) +
                ", pool=" + Arrays.toString(pool) +
                ", group=" + Arrays.toString(group) +
                ", currentDate=" + currentDate +
                '}';
    }
}
