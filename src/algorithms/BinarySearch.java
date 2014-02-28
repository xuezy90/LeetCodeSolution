package algorithms;

public class BinarySearch {
	public int binarySearch(int[] a,int key)
	{
		int left = 0;
		int right = a.length - 1;
		int middle = 0;
		while(left <= right)
		{
			middle = (left + right)/2;
			if(key == a[middle]) return middle;
			else if(key>a[middle]) left = middle + 1;
			else right = middle - 1;
		}
		return -1;
	}
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] source = {1,2,3,4,5,6,7,8,9};
		System.out.println(bs.binarySearch(source, 6));
	}

}
