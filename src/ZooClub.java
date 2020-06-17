import java.sql.Array;
import java.util.*;

public class ZooClub {
  //  public static  ArrayList<Animal> animals = new ArrayList<>();
    public static Map<Person, ArrayList<Animal>> map = new LinkedHashMap<>();



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        System.out.println("\t\tВас вітає клуб тварин!");
        while (true) {
            System.out.println("-----------------------------------------------------");
            System.out.println("1. Додати учасника клубу");
            System.out.println("2. Додати тваринку до учасника клубу");
            System.out.println("3. Видалити тваринку з учасника клубу");
            System.out.println("4. Видалити учасника з клубу");
            System.out.println("5. Видалити конкретну тваринку зі всіх власників");
            System.out.println("6. Вивести на екран зооклуб");
            System.out.println("0. Вийти з програми");
            System.out.println("-----------------------------------------------------");
            int input = in.nextInt();
            switch (input) {
                case 1: {
                    addMemberToClub();
                    break;
                }
                case 2: {
                     addPetToMember();
                    break;
                }
                case 3: {

                }
                case 4: {

                }
                case 5: {

                }
                case 6: {
                     showClub();
                    break;
                }
                case 0: {

                }
            }
        }
    }

    public static void addMemberToClub(){

        Scanner in = new Scanner(System.in);

        System.out.println("Введіть ім'я учасника: ");
        String name = in.nextLine();

        System.out.println("Введіть вік учасника: ");
        int age = in.nextInt();

        map.put(new Person(age,name),new ArrayList<Animal>());

    }
    public static void addPetToMember() {
        Scanner in = new Scanner(System.in);

        System.out.println("Введіть ім'я учасника якому хочете додати тварину: ");
        String name = in.nextLine();

        System.out.println("Введіть тип тварини: ");
        String typePet = in.nextLine();

        System.out.println("Введіть ім'я тварини: ");
        String namePet = in.nextLine();

        Person p = new Person(name);
        Animal a = new Animal(namePet, typePet);

        if (map.containsKey(p)) {
           map.get(p).add(a);
        }
    }

    public static void removePetToMember(){}
    public static void removeMemberToClub(){}
    public static void removePetFromAllMember(){}
    public static void showClub(){
        for(Person p: map.keySet()){
            System.out.println(p.toString());
        }
        System.out.println(map.values().size());

        for(ArrayList<Animal> a: map.values()) {
            for(Animal b: a)
            System.out.println(b.toString());
        }



    }

}
