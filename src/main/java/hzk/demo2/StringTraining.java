package hzk.demo2;

public class StringTraining {

	static void app() {
		long t1 = System.currentTimeMillis();
		String s = "";
		for (int i = 0; i < 10000; i++) {
			s += "HAHAHA";

		}
		long t2 = System.currentTimeMillis();
		System.out.printf("len=%d, use time: %d\n", s.length(), t2 - t1);
	}

	static void app2() {
		long t1 = System.currentTimeMillis();
		String s = "";
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < 10000; i++) {
			sb.append("HAHAHA");

		}
		long t2 = System.currentTimeMillis();
		System.out.printf("len=%d, use time: %d\n", sb.length(), t2 - t1);
	}

	static String stringToHex(String string) {
		StringBuilder buf = new StringBuilder(200);
		for (char ch : string.toCharArray()) {
			if (buf.length() > 0)
				buf.append(' ');
			buf.append(String.format("%04x", (int) ch));
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		final char[] a, b, a1;
		// final char a[],a1[],b[];
		a = new char[] { 'a', 'b', 'c' };
		a1 = a;
		a[1] = 'z';
		b = new char[] { 'g', 'h' };

		System.out.println(a);
		System.out.println(b);
		System.out.println(a1);
		System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE);
		System.out.println(Integer.toHexString(43));
		System.out.println(stringToHex("43"));
		System.out.println(stringToHex("叼"));
		
		app();
		app2();
		
		String aa = "hello2";
		String ba = "hello";
		String ca = ba + 2;   
		String da =new String("hello2");
		ca.intern();
		da.intern();
		System.out.println((aa == ca));
		System.out.println((aa == da));
		System.out.println((aa.equals(null)));
		System.out.println(aa.contains(""));
		System.out.println(aa.contains(null));
		System.out.println(aa.contains("3"));
	}
}
