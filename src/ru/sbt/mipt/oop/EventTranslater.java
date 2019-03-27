package src.ru.sbt.mipt.oop;
import com.coolcompany.smarthome.events.CCSensorEvent;

public class EventTranslater {
    public static SensorEvent CCtoSBT(CCSensorEvent event){
        SensorEventType type;
        switch(event.getEventType()){
            case "LightIsOn" : type = SensorEventType.LIGHT_ON;
            break;
            case "LightIsOff" : type = SensorEventType.LIGHT_OFF;
            break;
            case "DoorIsOpen" : type = SensorEventType.DOOR_OPEN;
            break;
            case "DoorIsClosed" : type = SensorEventType.DOOR_CLOSED;
            break;
            default : type = null;
        }
        return new SensorEvent(type, event.getObjectId());
    }

    public static CCSensorEvent SBTtoCC(SensorEvent event){
        String type;
        switch(event.getType()){
            case LIGHT_ON: type = "LightIsOn";
            break;
            case LIGHT_OFF: type = "LightIsOff";
            break;
            case DOOR_OPEN: type = "DoorIsOpen";
            break;
            case DOOR_CLOSED: type = "DoorIsClosed";
            break;
            default: type = "";
        }
        return new CCSensorEvent(type, event.getObjectId());
    }
}
