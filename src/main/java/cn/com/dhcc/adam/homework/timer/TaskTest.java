package cn.com.dhcc.adam.homework.timer;

import java.util.Timer;
import java.util.TimerTask;
public class TaskTest{
	public static void main(String[] args){
		new TaskTest().test();
	}
	public void test(){
		Timer timer = new Timer("test", true);
		CeDoTimerTask cedoTask = new CeDoTimerTask();
		System.out.println(System.currentTimeMillis());
		timer.schedule(cedoTask, 1000);
		int c = 0;
		while(true){
			try{
				Thread.sleep(1000);
				if(c++>10){
					break;
				}
			}catch(InterruptedException e){
				
			}
		}
	}
}
class CeDoTimerTask extends TimerTask{
	@Override
	public void run(){
		System.out.println("task with timer");
		System.out.println(System.currentTimeMillis());
	}
}