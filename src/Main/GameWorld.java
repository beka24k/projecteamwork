package Main;

import Database.dbConnect;
import Factory.CharacterFactory;
import Factory.MageFactory;
import Factory.WarriorFactory;
import Factory.PriestFactory;
import Factory.BarbarianFactory;
import java.util.Scanner;

public class GameWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать персонажа");
            System.out.println("2. Показать состояние персонажа");
            System.out.println("3. Выйти");

            int choice = scanner.nextInt();

            if (choice == 1) {
                createCharacter();
            } else if (choice == 2) {
                showCharacterState();
            } else if (choice == 3) {
                System.out.println("Выход.");
                break;
            } else {
                System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
            }
        }
    }

    public static void createCharacter() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя персонажа: ");
        String name = scanner.nextLine();

        System.out.println("Выберите тип персонажа:");
        System.out.println("1. Воин");
        System.out.println("2. Маг");
        System.out.println("3. Варвар");
        System.out.println("4. Жрец");

        int characterType = scanner.nextInt();

        CharacterFactory characterFactory = null;
        String character = "";
        String ability = "";

        if (characterType == 1) {
            characterFactory = new WarriorFactory();
            character = "Воин";
            ability = "SwordAttack";
        } else if (characterType == 2) {
            characterFactory = new MageFactory();
            character = "Маг";
            ability = "Fireball";
        } else if (characterType == 3) {
            characterFactory = new BarbarianFactory();
            character = "Варвар";
            ability = "SwordAttack";
        } else if (characterType == 4) {
            characterFactory = new PriestFactory();
            character = "Жрец";
            ability = "FireBall";
        }
        if (characterFactory != null) {
            Character character1 = characterFactory.createCharacter(name);
            System.out.println("Персонаж " + character1.getName() + " создан.");
            dbConnect db = new dbConnect();
            db.createCharacterTable();
            db.insertCharacter(character1.getName(), character, "alive", ability);
        }
    }

    private static void showCharacterState() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя персонажа: ");
        String name = scanner.nextLine();

        dbConnect db = new dbConnect();
        String state = db.getCharacterState(name);

        if (state != null) {
            System.out.println("Состояние персонажа " + name + ": " + state);
        } else {
            System.out.println("Персонаж с именем " + name + " не найден.");
        }
    }
}
