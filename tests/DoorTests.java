import org.junit.Test;
import src.ru.sbt.mipt.oop.*;

import static src.ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static src.ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorTests {
    @Test
    public void test1(){
        SmartHomeGenerator g = new SimpleSmartHomeGenerator();
        SmartHome home = g.smartHomeGenerate();
        EventHandler h = new DoorEventHandler();
        SensorEvent e = new SensorEvent(DOOR_CLOSED, "3");
        Action a = h.handle(e);
        home.execute(a);
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
        EventHandler h = new DoorEventHandler();
        SensorEvent e = new SensorEvent(DOOR_OPEN, "1");
        Action a = h.handle(e);
        home.execute(a);
        for(Room r : home.getRooms()){
            for(Door d : r.getDoors()){
                assert(!d.getId().equals("1") || d.isOpen());
            }
        }
    }
}
