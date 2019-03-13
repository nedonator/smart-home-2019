package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventHander implements EventHandler {
    @Override
    public void handle(SensorEvent event, Object o, Room room, SmartHome smartHome){
        if(o instanceof Door){
            Door door = (Door)o;
            if (door.getId().equals(event.getObjectId())) {
                if (event.getType() == DOOR_OPEN) {
                    door.setOpen(true);
                    System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                }
                else {
                    door.setOpen(false);
                    System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                }
            }
        }
    }
}
