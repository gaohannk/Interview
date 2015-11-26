package facebook;
/* 给两个数组，[a1, a2, a3, a4, .....] 和 [b1, b2, b3, b4, .....] 求a1 * b1 + a2 * b2 + a3 * b3 + ...... + an * bn;
 * 
 */
public class Vectordotproduct {
    public static int product(int[] a, int[] b){
    	int res=0;
    	for(int i=0;i<a.length;i++){
    		res+=a[i]*b[i];
    	}
    	return res;
    }
}
