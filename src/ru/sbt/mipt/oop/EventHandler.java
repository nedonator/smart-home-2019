package src.ru.sbt.mipt.oop;

public interface EventHandler {
    void handle(SensorEvent event, SmartHome home, CommandSender sender);
}
