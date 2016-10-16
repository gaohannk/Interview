package twitter;

/**
 * 一个数组[1, 1, 3, 4] ary 和 一个长度K 5，

 问： 你最长的连续子元素L，使得 L的长度总和 <= K，

 答案：例子里结果应该是 3
 */
public class ConsectiveElementLessThanK {
    public static  int getMaximumConsectiveElementLessThanK(int[] nums, int K){
        int max =0;
        int count=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum<=K){
                max= max>count?max:count;
                sum+=nums[i];
                count++;
            }else{
                sum+=nums[i];
                sum-=nums[i-count];
            }
        }
        return max;
    }
    public static void main(String[] args){
        int nums[] = {3,1,1,3,0,0,0,1,1,1,4};
        int K=5;
        System.out.println(getMaximumConsectiveElementLessThanK(nums,K));
    }
}
