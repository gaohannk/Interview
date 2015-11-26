package microsoft;

public class DeleteEveryFourNum {
	public static int[] deleteNum(int[] num) {
		int count = 0;
		int res[] = new int[num.length-num.length/4-1];
		for (int i = 0; i < num.length; i++) {
			if (i % 4 == 0)
				continue;
			res[count++] = num[i];
		}
		return res;
	}
	public static void main(String[] args) {
		int[] num= {1,2,3,4,5,6,7,8,9};
		int[] res;
		res=deleteNum(num);
		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
	}
}
