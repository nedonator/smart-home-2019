package src.ru.sbt.mipt.oop;

public interface EventHandler {
    void handle(SensorEvent event, Object o, Room room, SmartHome smartHome);
}
