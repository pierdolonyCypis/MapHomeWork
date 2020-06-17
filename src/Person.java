import java.util.Objects;

public class Person {
    private Integer age;
    private String name;


    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
    public Person(String name) {
        this.name = name;
    }

    public Person(){}

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String  getName() {
        return name;
    }

    public void setName(String  name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
