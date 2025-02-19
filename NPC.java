public class NPC  implements IGameEntity{
    private String name;
    private String description;

    public NPC(String name, String description){
        this.name=name;
        this.description=description;
    }
    public String getName(){
        return name;
    }
    @Override
    public void describe(){
        System.out.println("NPS :" + name+ " - " + description);
    }
    //неигровые персонажы
}
