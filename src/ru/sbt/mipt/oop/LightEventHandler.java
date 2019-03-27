package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static src.ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventHandler implements EventHandler {
    private SmartHome smartHome;

    public LightEventHandler(SmartHome home){
        smartHome = home;
    }

    @Override
    public void handle(SensorEvent event){
        if(event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF)
            smartHome.execute(new LightAction(event.getObjectId(), event.getType()==LIGHT_ON));
    }
}
