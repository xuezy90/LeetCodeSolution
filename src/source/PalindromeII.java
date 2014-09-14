package source;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/8/2
 * TIME : 13:17
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class PalindromeII {
    public int minCut(String s) {
        if(s == null) return -1;
        if(isPalindrome(s)) return 0;
        int min = Integer.MAX_VALUE;
        int temp;
        for(int i = 1; i<= s.length(); i++){
            String temp1 = s.substring(0,i);
            if(isPalindrome(temp1)){
//                if(isPalindrome(s.substring(i))) return 1;
                  min = min > (1 + (temp = minCut(s.substring(i)))) ?  temp : min ;
            }
        }
        return min;
    }

    public int minCutII(String s){
        if(s == null || s.length() <= 1) return 0;
        int[][] c = new int[s.length()][s.length()];
        int min = 0;
        for(int i = 1;i<s.length();i++)
            for(int j = i; j >=0;j--)
            {
                if(s.charAt(i) == s.charAt(j))
                {
                    c[j][i] = 1;
                }
            }
        return 1;
    }


    Map<Integer,Integer> pMap(String s)
    {
        Map<Integer,Integer> mm = new HashMap<Integer, Integer>();
        for(int i = 0;i<s.length();i++)
        {
            for(int j = i;j<s.length();j++)
            {
                if(isPalindrome(s.substring(i, j))) mm.put(i,j);
            }
        }
        System.out.println(mm.size());
        return mm;
    }
    boolean isPalindrome(String s)
    {
        boolean flag = true;
        char[] carray = s.toCharArray();
        int i = 0;
        int j = carray.length - 1;
        while(i<j)
        {
            if(carray[i] == carray[j]) {
                i++;
                j--;
                continue;
            }
            else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        PalindromeII pii = new PalindromeII();
        System.out.println(pii.pMap("aacbcaab")+"  "+pii.minCut("aacbcaab"));
    }
}
