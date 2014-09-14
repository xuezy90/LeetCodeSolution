package source;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/8/1
 * TIME : 10:50
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class CanCompleteCircuit {
    /*
    if current station can not be crossed,you have to decide start at former station.Or the next
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int begin = 0;
        int end = 0;
        int i = 0;
        int sum = 0;
        int length = gas.length;
        int temp = length;
        while(temp-- > 0)
        {
            sum += gas[i] - cost[i];
            if(sum < 0)
            {
                if(--begin < 0) begin = length-1;
                i = begin;
            }
            else
            {
                if(++end >length-1) end = 0;
                i = end ;
            }
        }
//        sum += gas[i] - cost[i];
        if(sum < 0) return -1;
        else return begin;
    }

    public static void main(String[] args) {
        int[] a = {1,3,1,2,5};
        int[] b = {1,2,1,7,1};
        CanCompleteCircuit ccc = new CanCompleteCircuit();
        System.out.println(ccc.canCompleteCircuit(a,b));
    }
}
