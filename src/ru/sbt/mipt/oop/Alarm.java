package src.ru.sbt.mipt.oop;

public class Alarm {
    private AlarmCondition alarm;

    public Alarm(){
        alarm = new AlarmInactive();
    }

    public void activate(String code){
        alarm = alarm.activate(code);
    }

    public void deactivate(String code){
        alarm = alarm.deactivate(code);
    }

    public void alert(){
        alarm = alarm.alert();
    }

    public AlarmConditionType getCondition(){
        return alarm.getCondition();
    }
}
