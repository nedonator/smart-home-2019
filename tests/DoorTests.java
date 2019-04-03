import org.junit.Test;
import src.main.java.ru.sbt.mipt.oop.*;

import static src.main.java.ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static src.main.java.ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorTests {
    @Test
    public void test1(){
        SmartHomeGenerator g = new SimpleSmartHomeGenerator();
        SmartHome home = g.smartHomeGenerate();
        EventHandler h = new DoorEventHandler(home);
        SensorEvent e = new SensorEvent(DOOR_CLOSED, "3");
        h.handle(e);
        for(Room r : home.getRooms()){
            for(Door d : r.getDoors()){
                assert(!d.isOpen());
            }
        }
    }

    @Test
    public void test2(){
        SmartHomeGenerator g = new SimpleSmartHomeGenerator();
        SmartHome home = g.smartHomeGenerate();
        EventHandler h = new DoorEventHandler(home);
        SensorEvent e = new SensorEvent(DOOR_OPEN, "1");
        h.handle(e);
        for(Room r : home.getRooms()){
            for(Door d : r.getDoors()){
                assert(!d.getId().equals("1") || d.isOpen());
            }
        }
    }
}
