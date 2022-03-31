import java.time.LocalDateTime;
import java.time.LocalDate;

//Данные о владельце: имя, фамилия, год рождения.
public class Owner {
    private String name;
    private String surname;
    private String dateOfBirth;

    public Owner(String name, String surname, String dateOfBirth) {
        setName(name);
        setSurname(surname);
        setDateOfBirth(dateOfBirth);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Вы ввели пустое значение");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null) {
            throw new IllegalArgumentException("Вы ввели пустое значение");
        }
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        LocalDate parseDate = LocalDate.parse(dateOfBirth);
        if (parseDate.getYear() > 3000 || parseDate.getYear() < 1900) {
            throw new IllegalArgumentException("Год рождения не может быть больше 2022 года-слишком мал для спортзала и меньше 1900-слишком стар для спортзала");
        }
        this.dateOfBirth = dateOfBirth;
    }



    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
