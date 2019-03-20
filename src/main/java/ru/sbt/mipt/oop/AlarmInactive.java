package src.ru.sbt.mipt.oop;

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
    public String getCondition(){
        return "Inactive";
    }
}
