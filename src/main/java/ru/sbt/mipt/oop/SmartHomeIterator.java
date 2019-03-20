package src.ru.sbt.mipt.oop;

import src.ru.sbt.mipt.oop.Room;

import java.util.Collection;
import java.util.Iterator;

interface SmartHomeIterator{
    boolean hasNext();
    Actionable next();
}
