import java.util.Optional;
import java.util.OptionalInt;

public class PersonBuilder {
    protected Optional<String> name = Optional.empty();
    protected Optional<String> surname = Optional.empty();
    protected OptionalInt age = OptionalInt.empty();
    protected Optional<String> address = Optional.empty();

    public PersonBuilder setName(String name) {
        this.name = Optional.ofNullable(name);
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = Optional.ofNullable(surname);
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = Optional.ofNullable(address);
        return this;
    }

    public Person build() {
        StringBuilder string = new StringBuilder();

        if (name.equals(Optional.empty())) {
            string.append("Имя не может быть пустым\n");
        }

        if (surname.equals(Optional.empty())) {
            string.append("Фамилия не может быть пустой\n");
        }

        if (!age.equals(OptionalInt.empty()) && age.getAsInt() < 0) {
            string.append("Возраст не может быть меньше 0");
        }

        if (!string.isEmpty()) {
            throw new IllegalArgumentException(string.toString());
        }

        Person person = new Person(this.name.get(), this.surname.get(), this.age, this.address.get());

        return person;
    }
}
