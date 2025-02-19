import java.util.*;
class Player {
    private String name;
    private Room currentRoom;
    private List<String> inventory = new ArrayList<>();

    public Player(String name, Room startRoom) {
        this.name = name;
        this.currentRoom = startRoom;
    }

    public void move(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("You moved " + direction + ".");
            currentRoom.describe();
        } else {
            System.out.println("You can't go that way.");
        }
    }

    public void look() {
        currentRoom.describe();
    }

    public void pickUp(String item) {
        if (currentRoom.removeItem(item)) {
            inventory.add(item);
            System.out.println("You picked up: " + item);
        } else {
            System.out.println("There is no " + item + " here.");
        }
    }

    public void inventory() {
        System.out.println("You are carrying: " + (inventory.isEmpty() ? "nothing" : inventory));
    }
}
