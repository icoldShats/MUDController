public class SciFiMUDFactory implements IMUDAbstractFactory{
    @Override
    public IGameEntity createRoom(){
        return new Room("Space ", "distant planet");

    }
    @Override
    public IGameEntity createNPC(){
        return new NPC("Robot", "helpfuk");
    }
}
