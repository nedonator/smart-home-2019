package src.ru.sbt.mipt.oop;

public class AlarmActive extends AlarmCondition {
    public AlarmActive(String code){
        this.code = code;
    }

    @Override
    public AlarmCondition activate(String code) {
        return this;
    }

    @Override
    public AlarmCondition deactivate(String code) {
        if(this.code.equals(code))
            return new AlarmInactive();
        else
            return new AlarmAlert();
    }

    @Override
    public String getCondition() {
        return "Active";
    }
}
