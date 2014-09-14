package source;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/8/1
 * TIME : 15:27
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class Palindrome {
    public List<List<String>> partition(String s) {
        if(s == null) return null;
        List<List<String>> res = new ArrayList<List<String>>();
        if(s.length() == 1) {
            List<String> oneMethod = new ArrayList<String>();
            oneMethod.add(s);
            res.add(oneMethod);
            return res;
        }
        for(int i = 1;i <= s.length();i++)
        {
            String str = s.substring(0,i);
            if(isPalindrome(str)) {
                List<List<String>> mm = null;
                if((mm = partition(s.substring(i))).size() > 0)
                    for(List<String> tt : mm)
                    {
                        tt.add(0,str);
                        res.add(tt);
                    }
                else  {
                    List<String> ll = new ArrayList<String>();
                    ll.add(str);
                    res.add(ll);
                }
            }
        };
        return res;
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
        String s = "aab";
        Palindrome p = new Palindrome();
        System.out.println(p.partition(s));
    }
}
