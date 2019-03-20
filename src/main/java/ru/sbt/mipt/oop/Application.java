package src.ru.sbt.mipt.oop;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Application {
    public static void main(String[] args) throws IOException {
        SmartHomeGenerator g = new SimpleSmartHomeGenerator();
        SmartHome smartHome = g.smartHomeGenerate();
        Collection<EventHandler> handlers = new ArrayList<>();
        handlers.add(new DoorEventHandler());
        handlers.add(new LightEventHandler());
        handlers.add(new HallDoorEventHandler(smartHome, new StdoutCommandSender()));
        AlarmEventHandler alarm = new SmartAlarmEventHandler();
        SensorEventProducer sensorEventProducer = new DummySensorEventProducer();
        //SmartHomeReader smartHomeReader = new GsonSmartHomeReader();
        // начинаем цикл обработки событий
        SensorEvent event = sensorEventProducer.getNextSensorEvent();
        while (event != null) {
            alarm.handle(event);
            if(!alarm.getCondition().equals("Alert")) {
                for (EventHandler h : handlers) {
                    Action a = h.handle(event);
                    smartHome.execute(a);
                }
            }
            event = sensorEventProducer.getNextSensorEvent();
        }
    }
}
