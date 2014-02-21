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
		List<HashSet<Integer>> setls = null;
		HashSet<Integer> set = null;
		boolean newSetFlag = true;
		int maxnumber = 1;
		double slope = 0.0;
		Map<Double,List<HashSet<Integer>>> map = new HashMap<Double,List<HashSet<Integer>>>();
		if(points == null||points.length == 0) return 0;
		for(int i = 0;i<points.length-1;i++)
		{
			a = points[i];
			for(int j = i+1;j<points.length;j++)
			{
				b = points[j];
				if(b.x-a.x == 0) 
				{
					if(b.y == a.y) 
					{
						
					}
					else slope = Double.MAX_VALUE;
				}
				else slope = (double)(b.y-a.y)/(double)(b.x-a.x);
				if(slope == 0.0 || slope == -0.0) slope = 0.0;
				//System.out.print(a.x+"  "+b.x+"  "+a.y+"  "+b.y+"  "+slope+"  ");
				if((setls = map.get(slope)) == null)
					setls = new ArrayList<HashSet<Integer>>();
				for(Set<Integer> s:setls)
				{
					if(s.contains(i)) {
						s.add(j);
						newSetFlag = false;
					}
					else if(s.contains(i)){
						s.add(j);
						newSetFlag = false;
					}
					if(s.size()>maxnumber) 
						maxnumber = s.size();
					//System.out.println(s);
				}
				if(newSetFlag) {
					set = new HashSet<Integer>();
					set.add(i);
					set.add(j);
					setls.add(set);
					if(maxnumber<2) maxnumber = 2;
				}
				map.put(slope,setls);
			}
		}
		return maxnumber;
	}
	public static void main(String[] args) {
		final int pointNumber = 3; 
		int maxNumber = 0;
		MaxPoints mp = new MaxPoints();
		Point[] points = new Point[pointNumber];
		Point p1 = new Point(2,3);
		Point p2 = new Point(3,3);
		Point p3 = new Point(-5,3);
//		for(int i = 0;i<pointNumber;i++)
//		{
//			p = new Point((int)(Math.random()*2),(int)(Math.random()*2));
//			points[i] = p;
//		}

		points[0] = p1;
		points[1] = p2;
		points[2] = p3;
		long stime = System.currentTimeMillis();
		maxNumber = mp.maxPoints(points);
		long etime = System.currentTimeMillis();
		System.out.println("共有点 "+pointNumber+" ,直线上最多点数： "+maxNumber+",耗时： "+(etime-stime)+" ms");
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