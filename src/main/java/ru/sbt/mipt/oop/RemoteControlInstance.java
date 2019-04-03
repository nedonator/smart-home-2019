package src.main.java.ru.sbt.mipt.oop;

import src.main.java.rc.RemoteControl;

import java.util.Map;

public class RemoteControlInstance implements RemoteControl {
    private Map<String,Runnable> map;

    public RemoteControlInstance(Map<String,Runnable> m){
        map = m;
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId){
        Runnable r = map.get(buttonCode);
        if(r != null)
            r.run();
    }
}
