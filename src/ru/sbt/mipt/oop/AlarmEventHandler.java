package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static src.ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;

public class AlarmEventHandler implements EventHandler {
    protected Alarm alarm;

    public AlarmEventHandler(Alarm alarm){
        this.alarm = alarm;
    }

    @Override
    public void handle(SensorEvent event){
        if(event.getType() == ALARM_ACTIVATE)
            alarm.activate(event.getObjectId());
        else if(event.getType() == ALARM_DEACTIVATE)
            alarm.deactivate(event.getObjectId());
    }
}
