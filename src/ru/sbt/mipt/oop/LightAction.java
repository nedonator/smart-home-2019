package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightAction implements Action {
    private String objectID;
    private boolean setOn;

    public LightAction(String ObjectID, boolean setOn){
        this.objectID = ObjectID;
        this.setOn = setOn;
    }

    @Override
    public void execute(Object o, Room room){
        if(o instanceof Light){
            Light light = (Light)o;
            if (light.getId().equals(objectID)) {
                if (setOn) {
                    light.setOn(true);
                    System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                } else {
                    light.setOn(false);
                    System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                }
            }
        }
    }
}
