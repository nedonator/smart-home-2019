package src.ru.sbt.mipt.oop;

import java.util.Collection;

import static src.ru.sbt.mipt.oop.AlarmConditionType.ALARM_ALERT;

public class AllEventHandlerWithAlarm implements EventHandler {
    Collection<EventHandler> handlers;
    Alarm alarm;
    EventHandler alarmEventHandler;

    public AllEventHandlerWithAlarm(Collection<EventHandler> handlers, Alarm alarm){
        this.handlers = handlers;
        this.alarm = alarm;
        alarmEventHandler = new SmartAlarmEventHandler(alarm);
    }

    public void handle(SensorEvent event){
        alarmEventHandler.handle(event);
        if(alarm.getCondition() != ALARM_ALERT)
            for(EventHandler h : handlers)
                h.handle(event);
    }
}
