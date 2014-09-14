package algorithms;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/9/11
 * TIME : 23:45
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class QuickSort {

    public int partition(int[] src,int st,int et)
    {
       int left = st;
       int right = et;
       int pivot = src[(st + et)/2];
       while(left<=right)
       {
           while(src[left]<pivot) left++;
           while(src[right]>pivot) right--;
           if(left <= right)
           {
               if(left != right)
                swap(src,left,right);
               left++;
               right--;
           }
       }
       return left;
    }
    public void quickSort(int[] arr,int left,int right)
    {
        int index = partition(arr,left,right);
        System.out.print("pivot = "+index+" : ");
        for(int i:arr)
            System.out.print(i+"  ");
        System.out.println("\n******************");
        if(left < index - 1) quickSort(arr,left,index-1);
        if(right > index) quickSort(arr,index,right);
    }

    private void swap(int[] src, int left, int right) {
        int temp = src[left];
        src[left] = src[right];
        src[right] = temp;
    }

    public void quickSort1(int[] arr,int left,int right)
    {
        if(left<right)
        {
            int index = partition1(arr, left, right);
            quickSort1(arr, left, index - 1);
            quickSort1(arr, index + 1, right);
        }
    }

    private int partition1(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for(int j = left;j<right;j++)
        {
            if(arr[j]<= pivot)
            {
                swap(arr,++i,j);
            }
        }
        swap(arr,++i,right);
        return i;
    }

    public static void main(String[] args) {
        int[] content = {2,8,7,1,3,5,6,4};
        for(int i:content)
            System.out.print(i + "  ");
        System.out.println();
        QuickSort qs = new QuickSort();
        qs.quickSort1(content, 0, content.length - 1);
        for(int i:content)
            System.out.print(i + "  ");
        System.out.println();
    }
}
