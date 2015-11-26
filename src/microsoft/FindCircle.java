package microsoft;

public class FindCircle {
      public static void findCircle(int[][] board){
    	  int max=0;
    	  for(int i=0;i<board.length;i++){
    		  int count=0;
    		  for(int j=0;j<board[0].length;j++){
    			  if(board[i][j]==1)
    				  count++;
    		  }
    		  if(count>max){
    			  max=count;
    		  }
    	  }
      }
}
