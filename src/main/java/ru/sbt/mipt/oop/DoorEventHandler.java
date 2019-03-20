package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static src.ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventHandler implements EventHandler {
    @Override
    public Action handle(SensorEvent event){
        if(event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED)
            return new DoorAction(event.getObjectId(), event.getType() == DOOR_OPEN);
        else
            return null;
    }
}
