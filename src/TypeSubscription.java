import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

//Разовый (на один день). По разовому абонементу клиенты могут посещать бассейн и тренажерный зал с 8 до 22 часов.
//Дневной (срок действия может быть любым). По данному абонементу клиенты могут посещать тренажерный зал
// и групповые занятия (но не бассейн) с 8 до 16 часов.
//Полный (срок действия может быть любым). По данному абонементу клиенты могут посещать тренажерный зал,
// бассейн и групповые занятия с 8 до 22 часов.
//Каждый абонемент хранит дату регистрации (текущая дата) и дату окончания регистрации.
// Каждый абонемент хранит информацию о владельце.
public enum TypeSubscription {
    SINGLE(1, ChronoUnit.DAYS),DAILY(12, ChronoUnit.MONTHS),FULL(12, ChronoUnit.MONTHS);

    TypeSubscription(int expire, TemporalUnit value) {

        this.expire = expire;
        this.value = value;
    }

    private int expire;
    private TemporalUnit value;

    public int getExpire() {
        return expire;
    }

    public TemporalUnit getValue() {
        return value;
    }
}
