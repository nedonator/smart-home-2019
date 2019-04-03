package src.main.java.ru.sbt.mipt.oop;

public class DoorAction implements Action {
    private String objectID;
    private boolean isOpen;

    public DoorAction(String objectID, boolean isOpen){
        this.objectID = objectID;
        this.isOpen = isOpen;
    }

    @Override
    public void execute(Object o, Room room){
        if(o instanceof Door){
            Door door = (Door)o;
            if (objectID == null || door.getId().equals(objectID)) {
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
