package zenefits;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*We have a list of N nodes with each node pointing to one of the N nodes. 
 * It could even be pointing to itself. We call a node ‘good’, 
 * if it satisfies one of the following properties: 
 * It is the tail node (marked as node 1) 
 * It is pointing to the tail node (node 1) 
 * It is pointing to a good node 
 * You can change the pointers of some nodes in order to make them all ‘good’. 
 * You are given the description of the nodes. 
 * You have to find out what is minimum number of nodes that you have to change in order to make all the nodes good. 
 * Input: 
 * The first line of input contains an integer number N which is the number of nodes. 
 * The next N lines contains N numbers, all between 1 and N. 
 * The first number, is the number of the node pointed to by Node 1; 
 * the second number is the number of the node pointed to by Node 2; 
 * the third number is the number of the node pointed to by Node 3 and so on. 
 * N is no larger than 1000. 
 * Output: Print a single integer which is the answer to the problem 
 * Sample Input 1: 
 * 5 
 * 1 
 * 2 
 * 3
 * 4 
 * 5 
 * Sample output 1: 
 * 4 
 * Explanation: 
 * We have to change pointers for four nodes (node #2 to node #5) to point to node #1. 
 * Thus 4 changes are required 
 * Sample input 2: 
 * 5 
 * 5 
 * 5 
 * 5 
 * 5 
 * 5 
 * Sample output 2: 
 * 1 
 * Explanation: 
 * We have to just change node #5 to point to node #1 (tail node) which will make node #5 good. 
 * Since all the other nodes point to a good node (node #5), every node becomes a good node.
 */
public class GoodNodes {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[] num = new int[len];
		int k = 0;
		while (len-- > 0) {
			String str = br.readLine();
			num[k] = Integer.parseInt(str) - 1;
			k++;
		}
		System.out.println(FindChanges(num));
	}

	public static int FindChanges(int[] num) {
		int[] visit = new int[num.length];
		for (int i = 0; i < visit.length; i++)
			visit[i] = -1;
		int ncomponents = 1, npass = 1;
		visit[0] = 0;
		for (int i = 1; i < num.length; i++) {
			if (isNewComponent(num, visit, i, npass++))
				ncomponents++;
		}
		return ncomponents-1;
	}

	public static Boolean isNewComponent(int[] num, int[] visit, int i, int cur_pass) {
		
		if (i == 0)
			return false;
		if (visit[i] > 0 && visit[i] != cur_pass)
			return false;
		if (visit[i] == cur_pass)
			return true;
		visit[i] = cur_pass;
		return isNewComponent(num, visit, num[i], cur_pass);
	}
}
