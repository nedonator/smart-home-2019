package src.main.java.ru.sbt.mipt.oop;

import src.main.java.rc.RemoteControl;

import java.util.HashMap;
import java.util.Map;
import static src.main.java.ru.sbt.mipt.oop.SensorEventType.*;

public class RemoteControlBuilder {
    private String[] buttons = {"A","B","C","D","1","2","3","4"};
    private SmartHome smartHome;
    private Alarm alarm;
    private String alarmCode;

    public RemoteControlBuilder(SmartHome smartHome, Alarm alarm, String alarmCode){
        this.smartHome = smartHome;
        this.alarm = alarm;
        this.alarmCode = alarmCode;
    }

    //gets int[8] array, each array element is responsible for a button
    //buttons is ordered from "A" to "D" and then from "1" to "4"
    //set the value 1 to turn off all lights, 2 to close hall door,
    //3 to turn on hall lights, 4 to activate an alarm, 5 to trigger alert
    //6 to turn on all lights, smth else to do nothing
    public RemoteControl create(int[] commands){
        Map<String,Runnable> map = new HashMap<>();
        for(int i = 0; i < 8; i++){
            Runnable command = null;
            switch(commands[i]) {
                case 1:
                    command = new RunnableAction(smartHome, new LightAction(null, false));
                    break;
                case 2:
                    command = new RunnableAction(smartHome, new HallDoorAction(null, smartHome, new StdoutCommandSender()));
                    break;
                case 3:
                    command = new RunnableAction(smartHome, new HallLightAction(null, false));
                    break;
                case 4:
                    command = new RunnableEventHandler(new AlarmEventHandler(alarm), new SensorEvent(SensorEventType.ALARM_ACTIVATE, alarmCode));
                    break;
                case 5:
                    command = new RunnableEventHandler(new AlarmEventHandler(alarm), new SensorEvent(ALARM_ALERT, null));
                    break;
                case 6:
                    command = new RunnableAction(smartHome, new LightAction(null, true));
                    break;
            }
            map.put(buttons[i], command);
        }
        return new RemoteControlInstance(map);
    }
}
