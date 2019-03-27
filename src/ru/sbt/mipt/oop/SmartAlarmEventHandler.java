package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.AlarmConditionType.ALARM_ACTIVE;
import static src.ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static src.ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;

public class SmartAlarmEventHandler extends AlarmEventHandler {
    public SmartAlarmEventHandler(Alarm alarm){
        super(alarm);
    }

    @Override
    public void handle(SensorEvent event){
        if(alarm.getCondition().equals(ALARM_ACTIVE) && event.getType() != ALARM_ACTIVATE && event.getType() != ALARM_DEACTIVATE) {
            alarm.alert();
            System.out.println("Sending sms");
        }
        else super.handle(event);
    }
}
