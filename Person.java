import java.util.Optional;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, OptionalInt age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, OptionalInt age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age != OptionalInt.empty();
    }

    public boolean hasAddress() {
        return !getAddress().equals("");
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        return this.age;
    }

    public Optional<String> getAddress() {
        return Optional.ofNullable(this.address);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age = OptionalInt.of(this.age.getAsInt() + 1);
    }

    @Override
    public String toString() {
        // Возарст может меняться, адрес тоже.
        return this.name + " " + this.surname + " " + (hasAge() ? getAge().getAsInt() +
                " год" : "") + " " + (hasAddress() ? getAddress().get() : "");
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.surname.hashCode() + this.age.hashCode() + this.getAddress().hashCode();
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder()
                .setSurname(this.surname)
                .setAge(0)
                .setAddress(this.address);

        return child;
    }
}
