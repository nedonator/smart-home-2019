package src.ru.sbt.mipt.oop;

import java.io.IOException;

interface SmartHomeReader{
    SmartHome smartHomeRead() throws IOException;
}