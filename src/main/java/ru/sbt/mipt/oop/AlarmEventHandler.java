package src.main.java.ru.sbt.mipt.oop;

public class AlarmEventHandler implements EventHandler {
    protected Alarm alarm;

    public AlarmEventHandler(Alarm alarm){
        this.alarm = alarm;
    }

    @Override
    public void handle(SensorEvent event){
        switch(event.getType()){
            case ALARM_ACTIVATE:
                alarm.activate(event.getObjectId());
                break;
            case ALARM_DEACTIVATE:
                alarm.deactivate(event.getObjectId());
                break;
            case ALARM_ALERT:
                alarm.alert();
                break;
        }
    }
}
