package src.main.java.ru.sbt.mipt.oop;

public class RunnableAction implements Runnable {
    private SmartHome smartHome;
    private Action action;

    public RunnableAction(SmartHome smartHome, Action action) {
        this.smartHome = smartHome;
        this.action = action;
    }

    @Override
    public void run(){
        smartHome.execute(action);
    }
}
