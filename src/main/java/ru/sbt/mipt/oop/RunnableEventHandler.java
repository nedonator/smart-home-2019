package src.main.java.ru.sbt.mipt.oop;

public class RunnableEventHandler implements Runnable {
    private EventHandler eventHandler;
    private SensorEvent sensorEvent;

    public RunnableEventHandler(EventHandler eventHandler, SensorEvent sensorEvent) {
        this.eventHandler = eventHandler;
        this.sensorEvent = sensorEvent;
    }

    @Override
    public void run() {
        eventHandler.handle(sensorEvent);
    }
}
