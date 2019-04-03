import org.junit.Test;
import src.main.java.rc.RemoteControl;
import src.main.java.ru.sbt.mipt.oop.*;

public class RemoteControlTests {
    @Test
    public void test1(){
        SmartHome smartHome = new SimpleSmartHomeGenerator().smartHomeGenerate();
        RemoteControlBuilder builder = new RemoteControlBuilder(smartHome, null, null);
        RemoteControl c = builder.create(new int[]{1, 2, 3, 4, 5, 6, 1, 2});
        c.onButtonPressed("2", null);
        for (Room r : smartHome.getRooms())
            for (Light l : r.getLights())
                assert l.isOn();
    }

    @Test
    public void test2(){
        SmartHome smartHome = new SimpleSmartHomeGenerator().smartHomeGenerate();
        RemoteControlBuilder builder = new RemoteControlBuilder(smartHome, null, null);
        RemoteControl c = builder.create(new int[]{1, 2, 3, 4, 5, 6, -1, 100});
        c.onButtonPressed("3", null);
        c.onButtonPressed("4", null);
    }

    @Test
    public void test3() {
        SmartHome smartHome = new SimpleSmartHomeGenerator().smartHomeGenerate();
        Alarm a = new Alarm();
        RemoteControlBuilder builder = new RemoteControlBuilder(smartHome, a, "1234");
        RemoteControl c = builder.create(new int[]{1, 2, 3, 4, 5, 6, 1, 2});
        c.onButtonPressed("1", null);
        assert a.getCondition() == AlarmConditionType.ALARM_ALERT;
    }
}
