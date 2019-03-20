package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class HallDoorEventHandler implements EventHandler {
    private CommandSender sender;
    private SmartHome smartHome;
    public HallDoorEventHandler(SmartHome smartHome, CommandSender sender){
        this.sender = sender;
        this.smartHome = smartHome;
    }

    @Override
    public Action handle(SensorEvent event){
        if(event.getType() == DOOR_CLOSED)
            return new HallDoorAction(event.getObjectId(),smartHome,sender);
        else
            return null;
    }
}
