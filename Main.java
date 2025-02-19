import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MUDGameEntityFactory factory = new ConcreteMUDGameEntityFactory();

        System.out.println("Enter entity type (room or npc): ");
        String type = scanner.nextLine();

        System.out.println("Enter name for " + type + ": ");
        String name = scanner.nextLine();

        IGameEntity entity = factory.createEntity(type, name);

        System.out.println("\nCreated entity:");
        entity.describe();

        scanner.close();
    }
}