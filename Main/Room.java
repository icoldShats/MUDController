import java.util.*;
class Room implements IGameEntity {
    private String name;
    private String description;
    private Map<String, Room> exits = new HashMap<>();
    private List<String> items = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void addItem(String item) {
        items.add(item);
    }

    public boolean removeItem(String item) {
        return items.remove(item);
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public void describe() {
        System.out.println(name + " - " + description);
        if (!items.isEmpty()) {
            System.out.println("You see: " + items);
        }
        if (!exits.isEmpty()) {
            System.out.println("Exits: " + exits.keySet());
        }
    }
}
