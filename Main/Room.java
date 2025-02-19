public class Room implements IGameEntity{
    private String name;
    private String description;

    public Room(String name, String description){
        this.name=name;
        this.description=description;
    }
    public String getName(){
        return name;
    }
    @Override
    public void describe(){
        System.out.println("Room :" + name+ " - " + description);
    }
}
