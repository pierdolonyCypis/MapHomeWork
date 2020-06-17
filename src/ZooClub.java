import javafx.util.converter.PercentageStringConverter;

import java.sql.Array;
import java.util.*;

public class ZooClub {
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
                    removePetToMember();
                    break;
                }
                case 4: {
                    removeMemberToClub();
                    break;
                }
                case 5: {
                    removePetFromAllMember();
                    break;

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


            map.put(new Person(age,name), new ArrayList<>());


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

    public static void removePetToMember(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть ім'я власника тварини");
        String name = in.nextLine();

        Person key = new Person(name);
        System.out.println("Цей власник має таких тварин: ");

            if(map.values().size() == 1){
                if(map.containsKey(key)){
                    map.get(key).remove(0);

                }

            }
        }

    public static void removeMemberToClub(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть учасника якого ви хочете видалити");
        String name = in.nextLine();

        Person key = new Person(name);

        if(map.containsKey(key)){
            map.remove(key);
        }


    }
    public static void removePetFromAllMember(){
        Scanner in = new Scanner(System.in);
        String typePet = in.nextLine();

        Animal animal = new Animal(typePet);
        Person person = new Person();

        if(map.containsKey(person)){
            map.get(person).remove(animal);
        }

    }

    public static void showClub(){

        for(Person p: map.keySet()) {
            System.out.println(p.toString());

            for (ArrayList<Animal> a : map.values()) {
                for (Animal b : a) {
                    System.out.println(b.toString());
                }
            }

            System.out.println(map.values().size());

        }
            }
        }



