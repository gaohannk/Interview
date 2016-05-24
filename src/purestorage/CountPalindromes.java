package purestorage;
/*
Count Palindromes
A string S is called palindome if it reads same way if spelled backwards, for example: “nolemonnomelon”, “ASANtaLivedAsAdeviLatNASA”.
Any non-empty string has substrings that are palindromes. For example, in the string S=”hellolle”, there are many of such
“subparlindromes”:
1) ellolle
2)11, II - note that these are two distinct substrings that only happen to be equal
3) lol and Iloll
4) And, of course, each letter can be considered a palindrome - all 8 of them.
Write a function that, given a string S (that only consists of lowercase English letters), counts how many different ways are there to pick a palindrome substring from S.
Examples:
1. Input: hellolle
output: 1 3 (the above example)
2. Input: wowpurerocks
output: 14 (each letter + “wow” + “rer”)
*/
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
