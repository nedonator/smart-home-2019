package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.AlarmConditionType.ALARM_INACTIVE;

public class AlarmInactive extends AlarmCondition {
    @Override
    public AlarmCondition activate(String code) {
        return new AlarmActive(code);
    }

    @Override
    public AlarmCondition deactivate(String code) {
        return this;
    }

    @Override
    public AlarmConditionType getCondition(){
        return ALARM_INACTIVE;
    }
}
