package hzk.demo2;

public class Person {
	int age;
	int t;
	String name;

	public Person() {
		
	}

	public Person(int age) {
		this.age = age;
		t = 0;
	}
	
	public String toString(){
		return "{ age="+age+",name="+name+",t="+t+"}";
	}
	
	public static void main(String[] args){
		Stu p1=new Stu(22);
		System.out.println(p1);
	}
}

class Stu extends Person {
	public Stu(int age) {
		super(age);
		t = 3;
	}
}


