package hzk.demo2;

/**
 * http://www.cnblogs.com/DreamSea/archive/2011/11/20/2256396.html
 * 
 * @author DreamSea 2011-11-19
 */
public class IntegerTest {
	public static void main(String[] args) {
		objPoolTest();
	}

	public static void objPoolTest() {
		Integer i1 = 40;
		Integer i2 = 40;
		Integer i3 = 0;
		Integer i4 = new Integer(40);
		Integer i5 = new Integer(40);
		Integer i6 = new Integer(0);
		
		
		System.out.println("i1=i2\t" + (i1 == i2));
		System.out.println("i1=i2+i3\t" + (i1 == i2 + i3));
		System.out.println("i4=i5\t" + (i4 == i5));
		System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));

		Integer x1=200;
		Integer x2=200;
		System.out.println(x1==x2);
		System.out.println(x1.equals(x2));
		System.out.println(x1==x2+0);
	}
}