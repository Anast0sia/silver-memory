import java.util.OptionalInt;

public class Person {
    protected String name;
    protected String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.address = address;
    }

    public boolean hasAge() {
        return age.isPresent();
    }
    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public OptionalInt getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        if (age.isPresent()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    public static class PersonBuilder {
        protected String name;
        protected String surname;
        protected int age;
        protected String address;

        public PersonBuilder(String surname, String address) {
            this.surname = surname;
            this.address = address;
        }
        public PersonBuilder() {}

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public PersonBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }
        public PersonBuilder setAge(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("Возраст не может быть отрицательным");
            }
            this.age = age;
            return this;
        }
        public PersonBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(name, surname, age, address);
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder(surname, address);
    }

    public String toString() {
        return getName() + " " + getSurname() +
                (hasAge() ? " (" + age.getAsInt() + " лет)" : "") +
                (hasAddress() ? ", адрес: " + getAddress() : "");
    }
}