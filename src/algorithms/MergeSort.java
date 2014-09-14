package algorithms;

/**
 * Created by Intellij IEDA.
 * DATE : 2014/9/13
 * TIME : 14:09
 * AUTHOR : Allen.Xue
 * E-MAIL : xuezy90@gmail.com
 */
public class MergeSort {
    public void mergeSort(int[] arr){
        int[] helper = new int[arr.length];
        mergeSort(arr,helper,0,arr.length-1);
    }

    private void mergeSort(int[] arr, int[] helper, int start, int end) {
        if(start < end)
        {
            int middle = (start+end)/2;
            mergeSort(arr,helper,start,middle);
            mergeSort(arr,helper,middle+1,end);
            merge(arr,helper,start,middle,end);
        }
    }

    private void merge(int[] arr, int[] helper, int start, int middle, int end) {
        for(int i = 0;i<arr.length;i++) helper[i] = arr[i];

        int lstart = start;
        int rstart = middle + 1;
        int current = lstart;

        while(lstart <= middle && rstart <= end)
        {
            if(helper[lstart] <= helper[rstart]) {
                arr[current] = helper[lstart];
                lstart++;
            }
            else{
                arr[current] = helper[rstart];
                rstart++;
            }
            current ++;
        }
        while(lstart <= middle){
            arr[current] = helper[lstart];
            current++;
            lstart++;
        }
    }
    public static void main(String[] args) {
        int[] content = {2,8,7,1,3,5,6,4};
        for(int i:content)
            System.out.print(i + "  ");
        System.out.println();
        MergeSort ms = new MergeSort();
        ms.mergeSort(content);
        for(int i:content)
            System.out.print(i + "  ");
        System.out.println();
    }
}
