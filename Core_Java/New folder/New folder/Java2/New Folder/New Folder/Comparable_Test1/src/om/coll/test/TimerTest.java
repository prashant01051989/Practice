import java.util.*;
class Reminder{
Timer timer;
public Reminder(int seconds){
timer=new Timer();
//timer.schedule(new ReminderTask(),seconds*1000);
timer.schedule(new ReminderTask(),seconds*1000,2*1000);
}
class ReminderTask extends TimerTask{
public void run(){
System.out.println("Times's up!");
//timer.cancel();
}
}
}

public class TimerTest{
public static void main(String as[]){
System.out.println("About to schedule task.");
new Reminder(3);
System.out.println("Task Scheduled");
}
}