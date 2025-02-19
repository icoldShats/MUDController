import java.util.*;
public class MUDGame {
    public static void main(String[] args) {
        Room start = new Room("Starting Room", "A dimly lit room with stone walls.");
        Room corridor = new Room("Dark Corridor", "A long hallway with flickering torches.");
        Room treasureRoom = new Room("Treasure Chamber", "A room glittering with gold.");

        start.setExit("north", corridor);
        corridor.setExit("south", start);
        corridor.setExit("east", treasureRoom);
        treasureRoom.setExit("west", corridor);

        start.addItem("rusty key");
        treasureRoom.addItem("gold coin");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName, start);

        System.out.println("Welcome, " + playerName + "! Type 'help' for commands.");
        player.look();

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().trim().toLowerCase();
            if (command.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            } else if (command.equals("look")) {
                player.look();
            } else if (command.startsWith("go ")) {
                player.move(command.substring(3));
            } else if (command.startsWith("pick up ")) {
                player.pickUp(command.substring(8));
            } else if (command.equals("inventory")) {
                player.inventory();
            } else if (command.equals("help")) {
                System.out.println("Commands: look, go <direction>, pick up <item>, inventory, exit");
            } else {
                System.out.println("Unknown command.");
            }
        }
        scanner.close();
    }
}
