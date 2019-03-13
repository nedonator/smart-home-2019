package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventHandler implements EventHandler {
    @Override
    public void handle(SensorEvent event, Object o, Room room, SmartHome smartHome){
        if(o instanceof Light){
            Light light = (Light)o;
            if (light.getId().equals(event.getObjectId())) {
                if (event.getType() == LIGHT_ON) {
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
