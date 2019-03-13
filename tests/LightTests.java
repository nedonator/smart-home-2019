import org.junit.Test;
import src.ru.sbt.mipt.oop.*;

import static src.ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;
import static src.ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;

public class LightTests {
    @Test
    public void test1(){
        SmartHomeGenerator g = new SimpleSmartHomeGenerator();
        SmartHome home = g.smartHomeGenerate();
        EventHandler h = new LightEventHandler();
        SensorEvent e = new SensorEvent(LIGHT_OFF, "3");
        for(Room r : home.getRooms()){
            for(Light d : r.getLights()){
                h.handle(e,d,r,home);
            }
        }
        for(Room r : home.getRooms()){
            for(Light d : r.getLights()){
                assert(!d.getId().equals("3") || !d.isOn());
            }
        }
    }

    @Test
    public void test2(){
        SmartHomeGenerator g = new SimpleSmartHomeGenerator();
        SmartHome home = g.smartHomeGenerate();
        EventHandler h = new LightEventHandler();
        SensorEvent e = new SensorEvent(LIGHT_ON, "1");
        for(Room r : home.getRooms()){
            for(Light d : r.getLights()){
                h.handle(e,d,r,home);
            }
        }
        for(Room r : home.getRooms()){
            for(Light d : r.getLights()){
                assert(!d.getId().equals("1") || d.isOn());
            }
        }
    }
}
