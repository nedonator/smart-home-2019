package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.SensorEventType.ALARM_ACTIVATE;
import static src.ru.sbt.mipt.oop.SensorEventType.ALARM_DEACTIVATE;

public class SmartAlarmEventHandler extends AlarmEventHandler {
    @Override
    public Action handle(SensorEvent event){
        if(getCondition().equals("Active") && event.getType() != ALARM_ACTIVATE && event.getType() != ALARM_DEACTIVATE) {
            alert();
            System.out.println("Sending sms");
        }
        else super.handle(event);
        return null;
    }
}
