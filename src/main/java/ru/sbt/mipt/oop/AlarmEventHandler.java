package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static src.ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;

public class AlarmEventHandler extends Alarm implements EventHandler {
    @Override
    public Action handle(SensorEvent event){
        if(event.getType() == ALARM_ACTIVATE)
            activate(event.getObjectId());
        else if(event.getType() == ALARM_DEACTIVATE)
            deactivate(event.getObjectId());
        return null;
    }
}
