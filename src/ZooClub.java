import java.util.*;

public class ZooClub {
    Map<Person, List<Animal>> map;

    public ZooClub(Map<Person, List<Animal>> map) {
        this.map = map;
    }

    void addMember() {
        try {
            Scanner inMember = new Scanner(System.in);
            System.out.println("Введіть ім'я учасника: ");
            String name = inMember.nextLine();
            System.out.println("Введіть вік учасника: ");
            int age = inMember.nextInt();
            Person key = new Person(age, name);
            if (map.containsKey(key)) {
                System.out.println("Ви не можете добавити двох учасників з одинаковим іменем та віком!");
            } else {
                map.put(key, new ArrayList<>());
                System.out.println("Учасник успішно доданий.");
            }
        } catch (Exception e) {
            System.err.println("Неправильні дані! Спробуйте ще раз.");
        }
    } // 1 завдання

    void addPetInMember() {
        if (map.isEmpty()) {
            System.out.println("Учасників немає.");
        } else {
            Scanner inAddPetString = new Scanner(System.in);
            Scanner inAddPetInt = new Scanner(System.in);
            System.out.println("Введіть ім'я учасника якому хочете додати тварину: ");
            try {
                String name = inAddPetString.nextLine();
                System.out.println("Введіть вік учасника якому хочете додати тварину: ");
                int age = inAddPetInt.nextInt();
                System.out.println("Введіть тип тварини: ");
                String typePet = inAddPetString.nextLine();
                System.out.println("Введіть ім'я тварини: ");
                String namePet = inAddPetString.nextLine();
                Person p = new Person(age, name);
                Animal a = new Animal(namePet, typePet);
                if (map.containsKey(p)) {
                    map.get(p).add(a);
                    System.out.println("Ви додали тварину: " + a.toString() + " учаснику " + p.toString());
                } else {
                    System.out.println("Такого учасника немає!");
                }
            } catch (Exception e) {
                System.err.println("Неправильні дані! Спробуйте ще раз.");
            }
        }
    }// 2 завдання

    void removePetInMember() {
        Scanner inDelPetString = new Scanner(System.in);
        Scanner inDelPetInt = new Scanner(System.in);
        try {
            try {
                if (map.keySet().isEmpty()) {
                    System.out.println("Учасників немає!");
                } else {
                    System.out.println("Введіть ім'я власника тварини:");
                    String name = inDelPetString.nextLine();

                    System.out.println("Введіть вік власника тварини:");
                    int age = inDelPetInt.nextInt();
                    Person key = new Person(age, name);
                    if (map.containsKey(key)) {
                        if (map.get(key).isEmpty()) {
                            throw new IndexOutOfBoundsException();
                        } else {
                            System.out.println("Власник має таких тварин:");
                            System.out.println(map.get(key));
                        }
                        System.out.println("Введіть ім'я тварини яку ви хочете видалити");
                        String namePet = inDelPetString.nextLine();
                        System.out.println("Введіть тип тварини яку ви хочете видалити");
                        String typePet = inDelPetString.nextLine();
                        Animal a = new Animal(namePet, typePet);

                        if (map.get(key).contains(a)) {
                            map.get(key).removeIf(pet -> pet.getNamePet().equals(namePet) & pet.getTypePet().equals(typePet));
                            System.out.println("Ви видалили тварину: " + namePet + " виду " + typePet + " в учасника " + key);
                        } else {
                            System.out.println("Такої тваринки не існує!");
                        }

                    } else {
                        System.out.println("Такого учасника не існує!");
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("В учасника відсутні тварини!");
            }
        } catch (RuntimeException e) {
            System.err.println("Неправильні дані! Спробуйте ще раз.");
        }
    } // 3 завдання

    void removeMember() {
        Scanner inDelMemberString = new Scanner(System.in);
        Scanner inDelMemberInt = new Scanner(System.in);
        if (map.isEmpty()) {
            System.out.println("Учасників немає!");
        } else {
            for (Person p : map.keySet()) {
                System.out.println("Учасник: " + p);
            }
            System.out.println("Введіть ім'я учасника якого ви хочете видалити:");
            String name = inDelMemberString.nextLine();
            System.out.println("Введіть вік учасника якого ви хочете видалити:");
            int age = inDelMemberInt.nextInt();
            Person key = new Person(age, name);
            if (map.containsKey(key)) {
                map.remove(key);
                System.out.println("Ви видалили учасника " + key.toString());
            } else {
                System.out.println("Такого учасника немає!");
            }
        }

    } // 4 завдання

    void removeAllPet() {
        Scanner inAddPet = new Scanner(System.in);
        if (map.keySet().isEmpty()) {
            System.out.println("Учасники відсутні!");
        } else {
            System.out.println("Введіть  вид тварини");
            String typePet = inAddPet.next();
            Animal animal = new Animal(typePet);

            for (Person key : map.keySet()) {
                if ((map.get(key).contains(animal))) {
                    map.get(key).removeIf(pet -> pet.getTypePet().equals(typePet)); // IDEA сама запропонувала через лямдбу)
                } else {
                    System.out.println("Такої тварини не існує!");
                }
            }
        }
    } // 5 завдання

    void showClub() {
        for (Map.Entry<Person, List<Animal>> all : map.entrySet()) {
            System.out.println(all.getKey());
            if (all.getValue().isEmpty()) {
                System.out.println("У цього учасника ще немає тварин");
            } else {
                System.out.println(all.getValue());
            }
        }
        System.out.println("\nУ цьому клубі " + map.size() + " учасників");
    } // 6 завдання

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ZooClub zooClub = new ZooClub(new LinkedHashMap<>());
        System.out.println("\n\t\tВас вітає клуб тварин!");
        while (true) {
            System.out.println("\n-----------------------------------------------------");
            System.out.println("1. Додати учасника клубу");
            System.out.println("2. Додати тваринку до учасника клубу");
            System.out.println("3. Видалити тваринку з учасника клубу");
            System.out.println("4. Видалити учасника з клубу");
            System.out.println("5. Видалити конкретну тваринку зі всіх власників");
            System.out.println("6. Вивести на екран зооклуб");
            System.out.println("0. Вийти з програми");
            System.out.println("-----------------------------------------------------\n");
            int input = 0;
            try {
                input = in.nextInt();
            } catch (RuntimeException e) {
                System.err.println("Неправильні дані!");
            }

            switch (input) {
                case 1: {
                    zooClub.addMember();
                    break;
                }
                case 2: {
                    zooClub.addPetInMember();
                    break;
                }
                case 3: {
                    zooClub.removePetInMember();
                    break;
                }
                case 4: {
                    zooClub.removeMember();
                    break;
                }
                case 5: {
                    zooClub.removeAllPet();
                    break;
                }
                case 6: {
                    zooClub.showClub();
                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.err.println("Неправильні дані!");
                    break;
                }
            }
        }
    }
}




