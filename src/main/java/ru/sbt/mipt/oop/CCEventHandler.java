package src.main.java.ru.sbt.mipt.oop;

import src.main.java.com.coolcompany.smarthome.events.CCSensorEvent;

public class CCEventHandler implements src.main.java.com.coolcompany.smarthome.events.EventHandler {
    private EventHandler handler;

    public CCEventHandler(EventHandler handler){
        this.handler = handler;
    }

    @Override
    public void handleEvent(CCSensorEvent event){
        handler.handle(EventTranslater.CCtoSBT(event));
    }
}
