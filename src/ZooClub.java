import java.lang.reflect.Array;
import java.security.KeyStore;
import java.util.*;

public class ZooClub {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Person, ArrayList<Animal>> map = new LinkedHashMap<>();

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
                case 1:

                    try {
                            Scanner inMember = new Scanner(System.in);
                            System.out.println("Введіть ім'я учасника: ");
                            String name = inMember.nextLine();

                            System.out.println("Введіть вік учасника: ");
                            int age = inMember.nextInt();

                            map.put(new Person(age, name), new ArrayList<>());
                        } catch (Exception e) {
                            e.getStackTrace();
                        }
                    break;

                case 2: {
                    Scanner inAddPet = new Scanner(System.in);
                    System.out.println("Введіть ім'я учасника якому хочете додати тварину: ");
                    String name = inAddPet.nextLine();

                    System.out.println("Введіть тип тварини: ");
                    String typePet = inAddPet.nextLine();

                    System.out.println("Введіть ім'я тварини: ");
                    String namePet = inAddPet.nextLine();
                    Person p = new Person(name);
                    Animal a = new Animal(namePet, typePet);

                    if (map.containsKey(p)) {
                        map.get(p).add(a);
                    }else {
                        System.out.println("Такого учасника немає!");
                    }
                    break;
                }
                case 3: {
                    Scanner inDelPet = new Scanner(System.in);
                  for(ArrayList<Animal> animals: map.values()){
                      System.out.println("В клубі є такі тварини: ");
                      for(Animal animal: animals){
                          System.out.println(animal.getNamePet());
                      }
                  }

                    System.out.println("Введіть ім'я власника тварин");
                    String name = inDelPet.nextLine();

                    System.out.println("Введіть ім'я тварини яку ви хочете видалити");
                    String namePet = inDelPet.nextLine();

                    Person key = new Person(name);


                    if(map.containsKey(key)){
                        Animal animals = new Animal(namePet);
                      //  map.get(key).remove(map.get(key).indexOf(animals));
                    }





//                    if(map.containsKey(key)){
//                        for(ArrayList<Animal> animals: map.values()){
//                            for(Animal animal1: animals){
//                                if(map.get(key).contains(animal)){
//                                    map.get(key).remove(animal1);
//                                }
//                            }
//                        }
//                    }
                    break;
                }
                case 4: {
                    Scanner inDelMember = new Scanner(System.in);
                    System.out.println("Введіть учасника якого ви хочете видалити");
                    String name = inDelMember.nextLine();
                    Person key = new Person(name);
                    if(map.containsKey(key)) {
                        map.remove(key);
                    }else{
                        System.out.println("Такого власника немає!");
                    }
                    break;
                }
                case 5: {
                    Scanner inDelPetAll = new Scanner(System.in);
                    System.out.println("Введіть тип тварини");
                    String typePet = inDelPetAll.nextLine();

                    Animal animal = new Animal(typePet);


                    for(ArrayList<Animal> animals: map.values()) {
                        animals.remove(animal);

                    }
                    break;

                }
                case 6: {
                    int iter = 0;
                    for(Map.Entry<Person, ArrayList<Animal>> all : map.entrySet()){

                        System.out.println(all.getKey());
                        if(all.getValue().isEmpty()){
                            System.out.println("У цього учасника ще немає тварин");
                        }else{
                            System.out.println(all.getValue());
                        }
                        iter++;
                    }
                    System.out.println("\nУ цьому клубі " + iter + " учасників");
                    break;
                }
                case 0: {
                    System.exit(0);
                }
            }
        }
    }
}



