package src.main.java.ru.sbt.mipt.oop;



import src.main.java.com.coolcompany.smarthome.events.SensorEventsManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Application {
    public static void main(String[] args) throws IOException {
        SmartHomeGenerator g = new SimpleSmartHomeGenerator();
        SmartHome smartHome = g.smartHomeGenerate();
        Collection<EventHandler> handlers = new ArrayList<>();
        handlers.add(new DoorEventHandler(smartHome));
        handlers.add(new LightEventHandler(smartHome));
        handlers.add(new HallDoorEventHandler(smartHome, new StdoutCommandSender()));
        Alarm alarm = new Alarm();
        AllEventHandlerWithAlarm handler = new AllEventHandlerWithAlarm(handlers, alarm);
        /*SensorEventProducer sensorEventProducer = new DummySensorEventProducer();
        // начинаем цикл обработки событий
        SensorEvent event = sensorEventProducer.getNextSensorEvent();
        while (event != null) {
            handler.handle(event);
            event = sensorEventProducer.getNextSensorEvent();
        }*/
        SensorEventsManager manager = new SensorEventsManager();
        manager.registerEventHandler(new CCEventHandler(handler));
        manager.start();
        /*AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
        sensorEventsManager.start();*/

    }
}
