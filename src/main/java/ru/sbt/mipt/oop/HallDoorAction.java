package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class HallDoorAction implements Action {
    private String objectID;
    private SmartHome smartHome;
    CommandSender sender;

    public HallDoorAction(String objectID, SmartHome smartHome, CommandSender sender){
        this.objectID = objectID;
        this.smartHome = smartHome;
        this.sender = sender;
    }

    @Override
    public void execute(Object o, Room room){
        if(o instanceof Door){
            Door door = (Door)o;
            if (door.getId().equals(objectID) && room.getName().equals("hall")) {
                for(Room r : smartHome.getRooms())
                    for(Light light : r.getLights()){
                        light.setOn(false);
                        SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                        sender.sendCommand(command);
                    }
            }
        }
    }
}
