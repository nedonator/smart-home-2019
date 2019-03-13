package src.ru.sbt.mipt.oop;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Application {
    public static void main(String[] args) throws IOException {
        Collection<EventHandler> handlers = new ArrayList<>();
        handlers.add(new DoorEventHander());
        handlers.add(new LightEventHandler());
        handlers.add(new HallDoorEventHandler(new StdoutCommandSender()));
        SensorEventProducer sensorEventProducer = new DummySensorEventProducer();
        SmartHomeReader smartHomeReader = new GsonSmartHomeReader();
        // считываем состояние дома из файла
        SmartHome smartHome = smartHomeReader.smartHomeRead();
        // начинаем цикл обработки событий
        SensorEvent event = sensorEventProducer.getNextSensorEvent();
        while (event != null) {
            Action action = new Action(event, handlers, smartHome);
            smartHome.execute(action);
            event = sensorEventProducer.getNextSensorEvent();
        }
    }
}
