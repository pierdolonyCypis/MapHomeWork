import java.util.Objects;

public class Animal {
    private String namePet;
    private String typePet;

    public Animal(String namePet, String typePet) {
        if ((namePet.length() > 10 | namePet.length() < 2 | namePet.contains(" ")) ||
                (typePet.length() > 8 | typePet.length() < 2 | typePet.contains(" "))) {
            throw new RuntimeException();
        } else {
            this.namePet = namePet;
            this.typePet = typePet;
        }
    }

    public Animal(String typePet) {
        this.typePet = typePet;
    }

    public String getNamePet() {
        return namePet;
    }

    public String getTypePet() {
        return typePet;
    }

    @Override
    public String toString() {
        return "ім'я тварини - " + namePet + "; тип тварини - " + typePet;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(namePet, animal.namePet) ||
                Objects.equals(typePet, animal.typePet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePet, typePet);
    }
}
