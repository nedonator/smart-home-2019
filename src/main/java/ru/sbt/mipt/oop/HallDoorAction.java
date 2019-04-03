package src.main.java.ru.sbt.mipt.oop;

public class HallDoorAction implements Action {
    private String objectID;
    private SmartHome smartHome;
    private CommandSender sender;

    public HallDoorAction(String objectID, SmartHome smartHome, CommandSender sender){
        this.objectID = objectID;
        this.smartHome = smartHome;
        this.sender = sender;
    }

    @Override
    public void execute(Object o, Room room){
        if(o instanceof Door){
            Door door = (Door)o;
            if ((objectID == null || door.getId().equals(objectID)) && room.getName().equals("hall")) {
                door.setOpen(false);
                turnOffLights();
            }
        }
    }

    private void turnOffLights(){
        for(Room r : smartHome.getRooms())
            for(Light l : r.getLights()) {
                l.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, l.getId());
                sender.sendCommand(command);
            }
    }
}
