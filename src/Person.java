public class Person {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;
    protected boolean hasAge;

    public Person(String name, String surname, int age, String address, boolean hasAge) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.hasAge = hasAge;
    }

    public boolean hasAge() {
        return hasAge;
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
    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        if (hasAge) {
            age++;
        }
    }

    public static class PersonBuilder {
        protected String name;
        protected String surname;
        protected int age;
        protected String address;
        protected boolean hasAge;

        public PersonBuilder(String surname, int age, String address) {
            this.surname = surname;
            this.age = age;
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
            this.hasAge = true;
            return this;
        }
        public PersonBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(name, surname, age, address, hasAge);
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder(surname, age, address);
    }

    public String toString() {
        return getName() + " " + getSurname() +
                (hasAge() ? " (" + getAge() + " лет)" : "") +
                (hasAddress() ? ", адрес: " + getAddress() : "");
    }
}