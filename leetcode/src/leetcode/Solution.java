package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
	public void longestPalindrome(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
        	 if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+ 1);
             }else
             {
            	 map.put(s.charAt(i), 1);
             }
            
        }
        System.out.println(map);
//		return 0;
    }
    public static void main(String[] args) {
    	Solution solution=new Solution();
    String s="abccccdd";
//    	int k=
    			solution.longestPalindrome(s);
//    	System.out.println(k);
        
    }
}