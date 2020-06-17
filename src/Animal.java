public class Animal {
    private String namePet;
    private String typePet;

    public Animal(String namePet, String typePet) {
        this.namePet = namePet;
        this.typePet = typePet;
    }

    public Animal(String typePet) {
        this.typePet = typePet;
    }

    public Animal(){}

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public String getTypePet() {
        return typePet;
    }

    public void setTypePet(String typePet) {
        this.typePet = typePet;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "namePet='" + namePet + '\'' +
                ", typePet='" + typePet + '\'' +
                '}';
    }
}
