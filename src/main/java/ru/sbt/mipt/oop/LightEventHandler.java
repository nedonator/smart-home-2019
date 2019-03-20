package src.ru.sbt.mipt.oop;

import static src.ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static src.ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventHandler implements EventHandler {
    @Override
    public Action handle(SensorEvent event){
        if(event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF)
            return new LightAction(event.getObjectId(), event.getType()==LIGHT_ON);
        else
            return null;
    }
}
