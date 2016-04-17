package hzk.demo2;
import static hzk.demo2.Utils.printf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class T implements Runnable{

	public T(){
		printf("t[%d] ~\t",id);
	}
	
	static int cnt=0;
	final int id=cnt++;
	public void run() {
		double s=0;
		double x=0.00001;
		for (int i=0;i<10;i++){
			for (int j=0;j<100000;j++){
				s+=x;
			}
			System.out.printf("t[%d]:%2.0f\t",id,s);
		//	Thread.yield();
//			try {
//				Thread.sleep((long) (100));
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		System.out.printf("\nt[%d]:$\t",id);
		//Thread.yield();
		
	}
	
}
public class ThreadsTraining {

	public static void test1(){
		int i;
		for (i=0;i<5;i++){
			T t=new T();
			t.run();
		}
		
	}
	public static void test2(){
		int i;
		for (i=0;i<5;i++){
			new Thread(new T()).start();
		}
		
	}
	
	
	public static void test3(){
		ExecutorService es;
		//es=Executors.newCachedThreadPool();
		es=Executors.newFixedThreadPool(2);
		for (int i=0;i<5;i++){
			es.execute(new T());
		}
		es.shutdown();
	}
	
	public static void test4(){
		class A{
			public synchronized void ww(){
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		final A a=new A();
		final Thread t1=new Thread(new Runnable(){
		 
			public synchronized void ww() throws InterruptedException{
				this.wait();
			}
			public void run() {
				
				printf("1,");
				a.ww();
				printf("2,");
				
			}
			
		});
		
		final Thread t2=new Thread(new Runnable(){
			 
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized(a){
					a.notifyAll();
				}
				
				
			}
			
		});
		t1.start();
		t2.start();
	}
	
	
	
	public static void main(String[] args){
		test4();
	}
}
