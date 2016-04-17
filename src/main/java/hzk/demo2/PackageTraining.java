package hzk.demo2;
class M{
	 int x;
	protected int y;
	private int z;
}

class N extends M{
	void ss(){
		y=x=1;
	}
}
class K{
	void ss(){
		M m=new M();
		m.y=3;
	}
}
interface CanEat{
 static int s=0;
	
}

abstract class AFF{
	
}

class AFFK extends AFF{
	
}
public class PackageTraining {
	public static void main(){
		AFF aff=new AFFK();
	}
	
}
