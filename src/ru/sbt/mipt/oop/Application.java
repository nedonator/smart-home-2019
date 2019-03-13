package src.ru.sbt.mipt.oop;



import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        SensorEventProducer sensorEventProducer = new DummySensorEventProducer();
        SmartHomeReader smartHomeReader = new GsonSmartHomeReader();
        EventHandler handler = new SmartEventHandler();
        CommandSender sender = new StdoutCommandSender();
        // считываем состояние дома из файла
        SmartHome smartHome = smartHomeReader.smartHomeRead();
        // начинаем цикл обработки событий
        SensorEvent event = sensorEventProducer.getNextSensorEvent();
        while (event != null) {
            handler.handle(event, smartHome, sender);
            event = sensorEventProducer.getNextSensorEvent();
        }
    }
}
