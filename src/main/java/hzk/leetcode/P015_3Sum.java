package hzk.leetcode;

import java.util.*;

@SuppressWarnings("all")
public class P015_3Sum {

	public List<List<Integer>> threeSum(int[] nums) {
		
		Arrays.sort(nums);
		int len=nums.length;
		int lo,hi,i,j,k=0,a,b,c;
		a=Integer.MIN_VALUE;
		List ans=new ArrayList();
		while(k<len-2){
			lo=k+1;
			hi=len-1;			
			a=nums[k];
			b=Integer.MIN_VALUE;
			while(lo<hi){
				b=nums[lo];
				c=nums[hi];
				if (a+b+c==0){
					ans.add(Arrays.asList(a,b,c));
				}
				if (a+b+c<=0){
					lo++;while (lo<len && b==nums[lo]) lo++;
				}
				if (a+b+c>=0){
					hi--;while (hi>0 && c==nums[hi]) hi--;
				}
			}
			k++;while (k<len-2 && a==nums[k]) k++;
		}
		return ans;
	}

	public void test(int... args){
		List<List<Integer>> ans=threeSum(args);
		for (List an:ans){
			System.out.printf("%s,",Arrays.toString(an.toArray()));			
		}
		System.out.println("...");
	}
	public static void main(String[] args) {
		P015_3Sum p=new P015_3Sum();
		p.test(-1,0,1,2,-1,-4);
		p.test(-4,-2,-1,-1,0,0,1,3);

	}

}
