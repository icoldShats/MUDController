public class ConcreteMUDGameEntityFactory extends MUDGameEntityFactory{
    @Override
    public IGameEntity createEntity(String type, String param){
        if(type.equalsIgnoreCase("room")){
            return new Room(param, "mysterius room");
        }
        else if(type.equalsIgnoreCase("npc")){
            return new NPC(param, "character whith unknown inventions.");
        }
        else{
            throw new IllegalArgumentException("UNknown entity type: "+ type);
        }
    }
}
