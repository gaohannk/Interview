package amazon;

import java.util.Arrays;

public class MissingNumber2 {
	public int missingNumber(int[] nums,int x) {
		if(nums==null||nums.length==0)
			return 0;
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++){
			if(nums[i]+1!=nums[i+1])
				return nums[i]+1;
		}
		if(nums[0]==x)
			return x+nums.length;
		else	
			return x;
	}

}
