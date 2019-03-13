package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static src.ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class HallDoorEventHandler implements EventHandler {
    private CommandSender sender;
    public HallDoorEventHandler(CommandSender sender){
        this.sender = sender;
    }
    @Override
    public void handle(SensorEvent event, Object o, Room room, SmartHome smartHome){
        if(o instanceof Door){
            Door door = (Door)o;
            if (door.getId().equals(event.getObjectId()) && event.getType() == DOOR_CLOSED && room.getName().equals("hall")) {
                SmartHomeLightsIterator it = new SmartHomeLightsIterator(smartHome);
                while(it.hasNext()) {
                    Light light = it.next();
                    light.setOn(false);
                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                    sender.sendCommand(command);
                }
            }
        }
    }
}
