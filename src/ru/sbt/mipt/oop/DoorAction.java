package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorAction implements Action {
    private String ObjectID;
    private boolean isOpen;

    public DoorAction(String ObjectID, boolean isOpen){
        this.ObjectID = ObjectID;
        this.isOpen = isOpen;
    }

    @Override
    public void execute(Object o, Room room){
        if(o instanceof Door){
            Door door = (Door)o;
            if (door.getId().equals(ObjectID)) {
                if (isOpen) {
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
