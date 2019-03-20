package src.ru.sbt.mipt.oop;

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
    public String getCondition(){
        return "Alert";
    }
}
