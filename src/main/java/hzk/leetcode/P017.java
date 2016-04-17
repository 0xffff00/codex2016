package hzk.leetcode;

import java.util.*;

@SuppressWarnings("all")
public class P017 {
	
	final static String[] d2s=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	String digits;
	int len;
	char tmp[];
	List<String> ans=new ArrayList(100);
	public void dfs(int x){
		if (x==len){
			ans.add(String.valueOf(tmp, 0, len));
			return;
		}
		char ch=digits.charAt(x);
		String str=d2s[ch-'0'];
		int i;
		for (i=0;i<str.length();i++){
			tmp[x]=str.charAt(i);
			dfs(x+1);
		}
		
	}
	public List<String> letterCombinations(String digits) {
		this.digits=digits;
		len=digits.length();
		tmp=new char[len];
		ans.clear();
		if (len>0) dfs(0);
		return ans;
        
    }

	public void test(String args){
		List ans=letterCombinations(args);
		System.out.printf("%s,",Arrays.toString(ans.toArray()));			
		
	}
	public static void main(String[] args) {
		P017 p=new P017();
		p.test("");
		p.test("7");
		p.test("34");
		p.test("12");
		p.test("5641");

	}

}
