package source;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/31
 * TIME : 8:42
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class SingleNumber {
    Set<Integer> set = new HashSet<Integer>();
    public int singleNumber(int[] A) {
        if(A == null | A.length % 2 == 0) return Integer.MAX_VALUE;
        for(int i = 0; i<A.length;i++)
        {
            if(set.contains(A[i])) set.remove(A[i]);
            else set.add(A[i]);
        }
        return set.iterator().next();
    }
    public int singleNumberII(int[] A)
    {
        if(A == null || A.length % 3 == 0) return Integer.MAX_VALUE;
        if(A.length < 3) return A[0];
        sort(A);
        int j = 1;
        for(int i = 0; i<A.length-1;i++)
        {
          if(A[i] == A[i+1]) ++j;
            else {
              if(j < 3) return A[i];
              else if(j ==3) j=1;
              else return Integer.MAX_VALUE;
          }
        }
        if(j>3) return Integer.MAX_VALUE;
        return A[A.length-1];
    }

    private void sort(int[] a) {
        int temp;
        for(int i = 0; i < a.length;i++)
        {
            for(int j = a.length-1;j>i;j-- )
            {
                if(a[j]<a[j-1])
                {
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }

    public int singleNumberIII(int[] A)
    {
        if(A == null || A.length % 3 == 0) return Integer.MAX_VALUE;
         Map<Integer,Integer> mm = new HashMap<Integer,Integer>();
         Integer temp;
        for(int i = 0;i<A.length;i++)
        {
            temp = mm.get(A[i]);
            if(temp == null) mm.put(A[i],1);
            else if(++temp<3)
            {
                mm.put(A[i],temp);
            }
            else mm.remove(A[i]);
        }
        return mm.keySet().iterator().next();
    }
    public static void main(String[] args) {
        int[] a = {2,1,2,2,2,1,1};
        SingleNumber sg = new SingleNumber();
        System.out.println(sg.singleNumberIII(a));
        sg.sort(a);
        for(int i:a) System.out.print(i + "  ");
    }
}
