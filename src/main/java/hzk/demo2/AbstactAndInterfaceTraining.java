package hzk.demo2;
interface I{
	static String s="";
	String toS();
	void xxxx();
	int c=3;	//auto to be final and static
	static int cc=4;
	int to();
}

class A implements I{

	public String toS() {
		// TODO Auto-generated method stub
		return null;
	}

	public void xxxx() {
		// TODO Auto-generated method stub
		
	}

	public int to() {
		//  this.c
		return 0;
	}
	
}
public class AbstactAndInterfaceTraining {

}
