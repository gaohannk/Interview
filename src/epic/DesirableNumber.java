package epic;

import java.util.ArrayList;
import java.util.List;

public class DesirableNumber {
     public static List<String> findDesirableNumber(int n){
    	 if(n<=0)
    		 return null;
    	 List<String> res= new ArrayList<String>();
    	 res.add("");
    	 while (n-->0) {
			List<String> list=new ArrayList<String>();
			for(String curStr:res){
				if(curStr.length()==0){
					for(int i=0;i<=9-n;i++)
					list.add(curStr+(char)(i+'0'));
					
				}else{
					char last=curStr.charAt(curStr.length()-1);
					int start=last-'0';
					for(int i=start+1;i<10;i++)
						list.add(curStr+ (char)(i+'0'));
				}
			}
			res=list;
		}
    	 return res;
     }
     public static void main(String[] args) {
 		List<String> list = findDesirableNumber(3);
 		for (int i = 0; i < list.size(); i++) {
 			System.out.println(list.get(i));
 		}
 	}
}
