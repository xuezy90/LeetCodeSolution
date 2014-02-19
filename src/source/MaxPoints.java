package source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class MaxPoints {
	
	public int maxPoints(Point[] points)
	{
		Point a = null;
		Point b = null;
		List<HashSet<String>> setls = null;
		int maxnumber = 0;
		Map<Integer,List<HashSet<String>>> map = new HashMap<Integer,List<HashSet<String>>>();
		for(int i = 0;i<points.length-1;i++)
		{
			a = points[i];
			for(int j = i+1;j<points.length;j++)
			{
				b = points[j];
				if(b.x-a.x == 0) 
				{
					if((setls = map.get(Integer.MAX_VALUE)) == null)
						setls = new ArrayList<HashSet<String>>();
					for( )
					
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
class Point
{
	int x;
	int y;
	Point()
	{
		x = 0;
		y = 0;
	}
	Point(int a , int b)
	{
		x = a;
		y = b;
	}
}