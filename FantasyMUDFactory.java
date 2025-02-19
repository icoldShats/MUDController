public class FantasyMUDFactory implements IMUDAbstractFactory{
    @Override
    public IGameEntity createRoom(){
        return new Room("Fantasy Room", "Mystical place");

    }
    @Override
    public IGameEntity createNPC(){
        return new NPC("Elf", "wise elf");
    }
}
