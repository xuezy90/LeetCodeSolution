package algorithms;

public class LCSLength {
	public int lcsLength(String[] a,String[] b)
	{
		int lcslength = 0;
		int p = 0;
		int q = 0;
		int k = 0;
		String[] res = new String[a.length+b.length];
		int[][] m = new int[a.length+1][b.length+1];
 		for(int i = 0;i<a.length;i++) m[i][0] = 0;
		for(int j = 0;j<b.length;j++) m[0][j] = 0;
		for(int i = 0;i<a.length;i++)
		{
			p = i+1;
			for(int j = 0;j<b.length;j++)
			{
				q = j+1;
				if(a[i] == b[j]) 
				{
					res[k] = a[i];
					k++;
					m[p][q] = m[p-1][q-1] + 1;
				}
				else m[p][q] = this.max(m[p-1][q],m[p][q-1]);
				if(m[p][q] > lcslength) lcslength = m[p][q];
				System.out.print(m[p][q]+"  ");
			}
			System.out.println();
		}
		for(String s:res)
		System.out.print(s+"  ");
		return lcslength;
	}
	private int max(int i, int j) {
		// TODO Auto-generated method stub
		if(i > j) return i;
		else return j;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCSLength ll = new LCSLength();
		String[] a = {"A","B","C","B","D","A","B"};
		String[] b = {"B","D","C","A","B","A"};
		System.out.println(ll.lcsLength(a, b));
	}

}
