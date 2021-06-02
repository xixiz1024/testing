// 97. Interleaving String Medium
// Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

// An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

// s = s1 + s2 + ... + sn
// t = t1 + t2 + ... + tm
// |n - m| <= 1
// The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
// Note: a + b is the concatenation of strings a and b.

 


//------------------------
// Memory DP


// helper function:
//  1. the 4th 'if': 
//      - before '||' -> current s1 i, s3 k match, continue try s1 i+1, s3 k+1
//      - after  '||' -> current s2 j, s3 k match, continue try s2 j+1, s3 k+1
//  ** if 1st cond failed, then try 2nd
//  ** if both failed, memo[i][j] mark 1: fails, "no possible ans from this point to the end"
//  ** memo[i][j] = 2: current path has ans, and will continuing return true
//  2. the 3nd 'if':
//      - if memo[i][j] was visited, if ==1 : all possible path can NOT reach the end,
//          break, and return final ans, false 
//------------------------



class Solution {
    
    public boolean is_Interleave(String s1, int i, String s2, int j, String s3, int k, int[][] memo){
        if(i==s1.length()) 
            return s2.substring(j).equals(s3.substring(k));
        if(j==s2.length()) 
            return s1.substring(i).equals(s3.substring(k));
        if(memo[i][j]>=1)
            return memo[i][j]==2;
        boolean ans=false;
        if(s1.charAt(i)==s3.charAt(k) && is_Interleave(s1, i+1, s2,j,s3,k+1,memo) || s2.charAt(j)==s3.charAt(k) && is_Interleave(s1,i,s2,j+1,s3,k+1,memo))
            ans=true;
        memo[i][j]=ans?2:1;
        return ans;
        
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        int[][] memo = new int[s1.length()][s2.length()];
        
        return is_Interleave(s1, 0,s2,0,s3,0,memo);
    }
}