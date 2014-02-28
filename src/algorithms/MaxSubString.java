package algorithms;

public class MaxSubString {
	
	public DataItem maxSubString(int[] source,int left,int right)
	{
		DataItem sum = new DataItem(0, left, right);
		if(source.length == 0||source == null||left>right) return null;
		else if(left == right) 
		{
			sum.sum = source[left] > 0 ? source[left]:0;
			sum.besti = left;
			sum.bestj = left;
		}
		else{
			int s1 = 0;
			int lefts = 0;
			int s2 = 0;
			int rights = 0;
			int besti = 0;
			int bestj =	0;

			DataItem leftsum = new DataItem(0,left,right);
			DataItem rightsum = new DataItem(0,left,right);
			
			int middle = (right+left)/2;
			leftsum = this.maxSubString(source,left,middle);
			rightsum = this.maxSubString(source, middle+1, right);
			for(int i = middle;i>=left;i--) 
			{
				s1 += source[i];
				if(s1>lefts) 
				{
					lefts = s1;
					besti = i;
				}
			}
			for(int i = middle+1;i<=right;i++) 
			{
				s2 += source[i];
				if(s2>rights) rights = s2;
				bestj = i;
			}
			sum.sum = lefts+rights;
			sum.besti = besti;
			sum.bestj = bestj;
			if(sum.sum <= leftsum.sum) sum = leftsum;
			if(sum.sum <= rightsum.sum) sum = rightsum;
		}
		System.out.println(sum.sum+"  "+sum.besti+"  "+sum.bestj);
		return sum;
	}
	public static void main(String[] args) {
		
		MaxSubString mss = new MaxSubString();
		int[] source = {-1,2,3,-4,0,7,2,-2,3};
		DataItem di = mss.maxSubString(source, 0, source.length-1);
		System.out.println(di.sum+"  "+di.besti+"  "+di.bestj);
	}

}
class DataItem 
{
	int sum = 0;
	int besti = 0;
	int bestj = 0;
	public DataItem(int s,int i,int j)
	{
		this.sum = s;
		this.besti = i;
		this.bestj = j;
	}
}
