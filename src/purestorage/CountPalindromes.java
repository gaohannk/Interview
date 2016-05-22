package purestorage;

public class CountPalindromes {

    static int count_palindromes(String S) {
        int res=S.length(); 
        for(int i=2;i<S.length();i++){
            for(int j=0;j<S.length()-i;j++){
             if(isPar(S.substring(j,j+i)))
                 res++;
            }
        }
        return res;
    }
    static boolean isPar(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
