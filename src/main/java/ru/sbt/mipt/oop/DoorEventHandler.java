package src.main.java.ru.sbt.mipt.oop;

import static src.main.java.ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static src.main.java.ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventHandler implements EventHandler {
    private SmartHome smartHome;

    public DoorEventHandler(SmartHome home){
        smartHome = home;
    }

    @Override
    public void handle(SensorEvent event){
        if(event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED)
            smartHome.execute(new DoorAction(event.getObjectId(), event.getType() == DOOR_OPEN));
    }
}
