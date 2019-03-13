package src.ru.sbt.mipt.oop;

import java.util.Collection;

public class Action {
    private SensorEvent event;
    private Collection<EventHandler> handlers;
    private SmartHome smartHome;
    public Action(SensorEvent event, Collection<EventHandler> handlers, SmartHome smartHome){
        this.event = event;
        this.handlers = handlers;
        this.smartHome = smartHome;
    }
    void Activate(Object o, Room room){
        for(EventHandler h : handlers){
            h.handle(event, o, room, smartHome);
        }
    }
}
