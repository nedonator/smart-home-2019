package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.AlarmConditionType.ALARM_ALERT;

public class AlarmAlert extends AlarmCondition {
    @Override
    public AlarmCondition deactivate(String code) {
        return this;
    }

    @Override
    public AlarmCondition activate(String code) {
        return this;
    }

    @Override
    public AlarmConditionType getCondition(){
        return ALARM_ALERT;
    }
}
