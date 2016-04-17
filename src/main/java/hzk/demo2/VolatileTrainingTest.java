package hzk.demo2;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTrainingTest {
    public volatile int x = 0;
    public int y=0;
    public  synchronized void y_inc() {
       
        y++;
    }
    public   void z_inc() {
       z.incrementAndGet();
    }
     
    AtomicInteger z=new AtomicInteger(0);
    public void startTestY(){
    	
    	long t1=System.currentTimeMillis();
    	 for(int i=0;i<1000;i++){
             new Thread(){
                 public void run() {
                     for(int j=0;j<10000;j++)
                    	 y_inc();
                 };
             }.start();
         }
    	 while(Thread.activeCount()>1)  //保证前面的线程都执行完
             Thread.yield();
    	 long t2=System.currentTimeMillis();
    	 System.out.printf("x=%d use time: %d\n", y,t2-t1);
        
    }
public void startTestZ(){
    	
    	long t1=System.currentTimeMillis();
    	 for(int i=0;i<1000;i++){
             new Thread(){
                 public void run() {
                     for(int j=0;j<10000;j++)
                    	 z_inc();
                 };
             }.start();
         }
    	 while(Thread.activeCount()>1)  //保证前面的线程都执行完
             Thread.yield();
    	 long t2=System.currentTimeMillis();
    	 System.out.printf("z=%d, use time: %d\n", z.get(),t2-t1);
        
    }
    public static void main(String[] args) {
        final VolatileTrainingTest test = new VolatileTrainingTest();
       
        test.startTestY();
        test.startTestZ();
        
    }
}