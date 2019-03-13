package src.ru.sbt.mipt.oop;

import java.util.Collection;
import java.util.Iterator;

public class SmartHomeDoorsIterator {
    private Iterator<Room> roomIterator;
    private Iterator<Door> doorIterator;
    private void initializeLights(){
        if(roomIterator.hasNext()) {
            doorIterator = roomIterator.next().getDoors().iterator();
        }
        else{
            doorIterator = null;
        }
    }

    public SmartHomeDoorsIterator(SmartHome home){
        Collection<Room> rooms = home.getRooms();
        roomIterator = rooms.iterator();
        initializeLights();
    }

    public boolean hasNext(){
        return doorIterator != null && doorIterator.hasNext();
    }

    Door next(){
        Door d = doorIterator.next();
        if(!doorIterator.hasNext()) initializeLights();
        return d;
    }
}
