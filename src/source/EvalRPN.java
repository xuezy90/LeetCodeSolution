package source;

import java.util.regex.Pattern;

public class EvalRPN {
	public int evalRPN(String[] tokens)
	{
		int a = 0;
		int b = 0;
		int inn_top = 0;
		Pattern mer = Pattern.compile("^[+-]?[0-9]+$");
		Integer[] inn = new Integer[100];
		for(String s:tokens)
		{
			if(mer.matcher(s).find())
			{
				inn[inn_top] = Integer.parseInt(s);
				inn_top++;
			}
			else
			{
				if((inn_top-1)>0)
				{
					inn_top--;
					b = inn[inn_top];
					inn_top--;
					a = inn[inn_top];
				}
				else return Integer.MAX_VALUE;
				if(s.equals("*")) 
				{
					inn[inn_top] = a*b;
					inn_top++;
				}
				else if(s.equals("/")){
					inn[inn_top] = a/b;
					inn_top++;
				}
				else if(s.equals("+")){
					inn[inn_top] = a+b;
					inn_top++;
				}
				else if(s.equals("-")){
					inn[inn_top] = a-b;
					inn_top++;
				}
				else return Integer.MAX_VALUE;
			}
		}
		if(--inn_top == 0)
			return inn[inn_top];
		else return Integer.MAX_VALUE;
		
	}
	public static void main(String[] args) {
		EvalRPN ep = new EvalRPN();
		String[] tokens = {"12","54","544","85","+","-"};
		if(ep.evalRPN(tokens) == Integer.MAX_VALUE)
			System.out.println("error!");
		else System.out.println(ep.evalRPN(tokens));

	}

}
