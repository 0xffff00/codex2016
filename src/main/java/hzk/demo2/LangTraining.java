package hzk.demo2;

public class LangTraining {
	public static void main(String[] args){
		Number x=34l;
		Number y=34;
		Long z=34l;
		Integer t=34;
		
		System.out.println(4==4l);
		System.out.println(t==x);
		System.out.println(x==y);
		System.out.println(x==z);
		System.out.println(z==x);
		System.out.printf("%b", 5);
	}
}
