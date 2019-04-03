package src.main.java.ru.sbt.mipt.oop;

public class HallLightAction implements Action {
    private String objectID;
    private boolean setOn;

    public HallLightAction(String objectID, boolean setOn) {
        this.objectID = objectID;
        this.setOn = setOn;
    }

    @Override
    public void execute(Object object, Room room){
        if(room.getName().equals("hall")){
            new LightAction(objectID, setOn).execute(object, room);
        }
    }
}
