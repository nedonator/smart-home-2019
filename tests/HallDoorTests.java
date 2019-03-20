import org.junit.Test;
import src.ru.sbt.mipt.oop.*;

import static src.ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static src.ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

import org.junit.Test;
import src.ru.sbt.mipt.oop.*;

import static src.ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static src.ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class HallDoorTests {
    @Test
    public void test1(){
        SmartHomeGenerator g = new SimpleSmartHomeGenerator();
        SmartHome home = g.smartHomeGenerate();
        EventHandler h = new HallDoorEventHandler(home, new StdoutCommandSender());
        SensorEvent e = new SensorEvent(DOOR_CLOSED, "4");
        Action a = h.handle(e);
        home.execute(a);
        for(Room r : home.getRooms()){
            for(Light d : r.getLights()){
                assert(!d.isOn());
            }
        }
    }

    @Test
    public void test2(){
        SmartHomeGenerator g = new SimpleSmartHomeGenerator();
        SmartHome home = g.smartHomeGenerate();
        EventHandler h = new HallDoorEventHandler(home, new StdoutCommandSender());
        SensorEvent e = new SensorEvent(DOOR_OPEN, "4");
        Action a = h.handle(e);
        home.execute(a);
        for(Room r : home.getRooms()){
            for(Light d : r.getLights()){
                assert(!d.getId().equals("2") || d.isOn());
            }
        }
    }
}
