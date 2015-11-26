package amazon;

public class DeleteVowels {
	public static String deleteVowels(String str){
		String vowels="aeiou";
		StringBuilder res= new StringBuilder();
		for(int i=0;i<str.length();i++){
			if(vowels.indexOf(str.charAt(i))==-1)
				res.append(str.charAt(i));
		}
		return res.toString();
	}
	
	
	public static void main(String[] args) {
		String test="Philidoph";
		System.out.print(deleteVowels(test));
	}
}
