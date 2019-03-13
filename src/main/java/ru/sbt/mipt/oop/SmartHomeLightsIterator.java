package src.ru.sbt.mipt.oop;

import java.util.Collection;
import java.util.Iterator;

public class SmartHomeLightsIterator {
    private Iterator<Room> roomIterator;
    private Iterator<Light> lightIterator;
    private void initializeLights(){
        if(roomIterator.hasNext()) {
            lightIterator = roomIterator.next().getLights().iterator();
        }
        else{
            lightIterator = null;
        }
    }
    public SmartHomeLightsIterator(SmartHome home){
        Collection<Room> rooms = home.getRooms();
        roomIterator = rooms.iterator();
        initializeLights();
    }

    public boolean hasNext(){
        return lightIterator != null && lightIterator.hasNext();
    }

    Light next(){
        Light l = lightIterator.next();
        if(!lightIterator.hasNext()) initializeLights();
        return l;
    }
}
