import java.util.Objects;

public class Person {
    private Integer age;
    private String name;

    public Person(Integer age, String name) {
        if (age > 89 | age < 1) {
            throw new RuntimeException();
        } else {
            this.age = age;
        }
        if (name.length() > 15 | name.length() < 2 | name.contains(" ")) {
            throw new RuntimeException();
        } else {
            this.name = name;
        }
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ім'я - " + name + "; вік - " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(age, person.age) &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
