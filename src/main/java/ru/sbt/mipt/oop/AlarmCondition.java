package src.main.java.ru.sbt.mipt.oop;

public abstract class AlarmCondition {
    protected String code;
    public abstract AlarmCondition activate(String code);
    public abstract AlarmCondition deactivate(String code);
    public AlarmCondition alert(){
        return new AlarmAlert();
    }
    public abstract AlarmConditionType getCondition();
}
