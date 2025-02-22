import java.util.Scanner;

public class MUDController {
    private Player player;
    private boolean running;

    public MUDController(Player player) {
        this.player = player;
        this.running = true;
    }

    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("MUD game started! Type 'help' to see commands.");

        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            handleInput(input);
        }

        System.out.println("Game over!");
        scanner.close();
    }

    private void handleInput(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String argument = parts.length > 1 ? parts[1] : "";

        switch (command) {
            case "look":
                lookAround();
                break;
            case "move":
                move(argument);
                break;
            case "pick":
                pickUp(argument);
                break;
            case "inventory":
                checkInventory();
                break;
            case "help":
                showHelp();
                break;
            case "quit":
            case "exit":
                running = false;
                break;
            default:
                System.out.println("Unknown command! Use 'help' to see commands.");
        }
    }

    private void move(String direction) {
        Room nextRoom = player.getCurrentRoom().getConnectedRoom(direction);
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.println("You moved " + direction + ".");
            lookAround();
        } else {
            System.out.println("No path in that direction!");
        }
    }

    private void pickUp(String itemName) {
        Room currentRoom = player.getCurrentRoom();
        Item item = currentRoom.getItem(itemName);

        if (item != null) {
            player.addItemToInventory(item);
            currentRoom.removeItem(item);
            System.out.println("You picked up " + itemName + ".");
        } else {
            System.out.println("No " + itemName + " here!");
        }
    }

    private void checkInventory() {
        if (player.getInventory().isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You have: " + player.getInventory());
        }
    }

    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("look - Describe the room");
        System.out.println("move <direction> - Move to another room");
        System.out.println("pick <item> - Pick up an item");
        System.out.println("inventory - View your inventory");
        System.out.println("help - Show command list");
        System.out.println("quit/exit - End the game");
    }
}
