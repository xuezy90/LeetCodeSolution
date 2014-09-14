package source;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/7/31
 * TIME : 19:18
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class Candy {
    /*
    Find descend sequence,each element value equals distance between start value and it,
     if length bigger than start value then every Element add 1
     */
    public int candy(int[] ratings) {
        if(ratings == null) return Integer.MAX_VALUE;
        if(ratings.length == 1) return 1;
        int start = 1;//descend sequence start value
        int former = start;//Former element value
        int total = 1;
        int counter = 0;//the serial number of descend sequence
        for(int i = 1;i<ratings.length;i++)
        {
            if(ratings[i] < ratings[i-1])
            {
                counter++;
               if(--start > 0) {
                   total += counter;
//                   counter = 0;
               }
                else
               {
                   total += counter+1;
               }
                former = 1;
            }
            else if(ratings[i] == ratings[i-1])
            {
               start = 1;
                total +=start;
                counter = 0;
                former = start;
            }
            else
            {
                ++former;
                total += former;
                start = former;
                counter = 0;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Candy c = new Candy();
        int[] a = {58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89};
        int[] b = {1,2,5,4,1};
        System.out.println(c.candy(b));
    }
}
