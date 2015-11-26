package epic;
/*
 * You are given a telephone keyboard 
 * 0-0, 1-1, 2-ABC2, 3-DEF3, 4-GHI4, 5-JKL5, 6-MNO6,7-PQRS7, 8-TUV8, 9-WXYZ9, *-space, #-char separater
 * if you type "2", you will get 'A', that is "2"-'A', "22"-'B' ,"222"-'C', "2222"-'D'.
 * However, the digits can repeated many times
 * "22222"-you get 'A' again 
 * You can use "#" to separate characters, for example
 * "2#22", you get "AB"
 * However, you may also have consecutive different digits without separator:"23"-'AD'. From 1point 3acres bbs
 * If you type "*", it means space.
 * You a given a sequence of digits, translate it into a text message
 */
import java.util.HashMap;

public class SMS {
	public static String sms(String mes){
		HashMap<Character, char[]> map=new HashMap<Character,char[]>();
		map.put('2', new char[]{'2','a','b','c'});
		map.put('3', new char[]{'3','d','e','f'});
		map.put('4', new char[]{'4','g','h','i'});
		map.put('5', new char[]{'5','j','k','l'});
		map.put('6', new char[]{'6','m','n','o'});
		map.put('7', new char[]{'7','p','q','r','s'});
		map.put('8', new char[]{'8','t','u','v'});
		map.put('9', new char[]{'9','w','x','y','z'});
		StringBuffer sb=new StringBuffer();
		int i,j;
		for(i=0;i<mes.length();++i){
			int count=1;
			for(j=i+1;j<mes.length();++j){
				if(mes.charAt(i)==mes.charAt(j)){
					count++;
				}
				else break;
			}
				char t;
				if(mes.charAt(i)!='#'){
					int length=map.get(mes.charAt(i)).length;
					t=map.get(mes.charAt(i))[count%length];
					sb.append(t);
				}
				i=j-1;
		}
		return sb.toString();
	}
	public static void main(String[] args){
		System.out.println(sms("2222233#33"));
	}
}
