package hzk.demo2;
class PP{
	
	int x;
	PPX ppx;
}
class PPX{
	int a,b,c;
	String hh="hhhhh";
}


public class ObjectTraining {
	public static void main(String[] args){
		PP x=new PP();
		x.x=4;
		x.ppx=new PPX();
		PP y=new PP();
		y.x=4;
		y.ppx=new PPX();
		
		
		System.out.printf("x:%d, y:%d\n",x.hashCode(),y.hashCode());
		x.ppx.b=444;
		System.out.printf("x:%d, y:%d\n",x.hashCode(),y.hashCode());
		y.x=55;
		System.out.printf("x:%d, y:%d\n",x.hashCode(),y.hashCode());
		
		
		 
	}
}
