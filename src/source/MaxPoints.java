package source;

import java.util.HashMap;
import java.util.Map;
public class MaxPoints {
	
	public int maxPoints(Point[] points)
	{
//		List<HashSet<Integer>> setls = null;
//		HashSet<Integer> set = null;
		
		int kcounter = 0;
		int duplicate = 0;		
		int maxnumber = 2;
		double slope = 0.0;
		
		Map<Double,Integer> map = new HashMap<Double,Integer>();
		if(points == null||points.length == 0) return 0;
		else if(points.length == 1) return 1;
		
		for(int i = 0;i<points.length-1;i++)
		{
			map.clear();
			duplicate = 1;
			for(int j = i+1;j<points.length;j++)
			{
//				if(i == j) continue;
				if(points[j].x-points[i].x == 0) 
				{
					if(points[j].y == points[i].y)
					{
						duplicate++;
						map.put(Double.MIN_VALUE, 0);
						continue;
					}
					else slope = Double.MAX_VALUE;
				}
				else slope = (double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x);
				if(slope == 0.0 || slope == -0.0) slope = 0.0;
				if(map.get(slope) == null) map.put(slope, 1);
				else{
					kcounter = map.get(slope);
					kcounter++;
					map.put(slope, kcounter);
				}
			}
			for(double d:map.keySet())
			{
				if((map.get(d)+duplicate)>maxnumber) maxnumber = map.get(d) + duplicate;
			}
		}
		return maxnumber;
	}
	public static void main(String[] args) {
		final int pointNumber = 10000; 
		int maxNumber = 0;
		MaxPoints mp = new MaxPoints();
		Point[] points = new Point[pointNumber];
		Point p = null;
//		Point p1 = new Point(0,0);
//		Point p2 = new Point(0,0);
//		Point p3 = new Point(3,4);
//		Point p4 = new Point(3,4);
//		Point p5 = new Point(4,4);
//		Point p6 = new Point(4,4);
//		Point p7 = new Point(5,5);
//		Point p8 = new Point(6,6);
//		Point p9 = new Point(5,5);
//		Point p10 = new Point(7,8);
		for(int i = 0;i<pointNumber;i++)
		{
			p = new Point((int)(Math.random()*10),(int)(Math.random()*10));
			points[i] = p;
		}

//		points[0] = p1;
//		points[1] = p2;
//		points[2] = p3;
//		points[3] = p4;
//		points[4] = p5;
//		points[5] = p6;
//		points[6] = p7;
//		points[7] = p8;
//		points[8] = p9;
//		points[9] = p10;

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