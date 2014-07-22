package source;

public class ReverseWords {
	/**
	 * note
	 * 1.any space on the head or tail trim()
	 * 2.muilt space between two words "\\s+"
	 * 3.only spaces split(" ").length == 0
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
        if(s == null) return null;
        if((s = s.trim()).equals("")) return s;
		String[] str = s.split("\\s+");
		if(str.length == 1) return s;
    	String temp;
        if(str.length % 2 == 0)
        {
        	int i = str.length/2 -1;
        	int j = str.length/2;
        	while(i>=0)
        	{
        		temp = str[i];
        		str[i] = str[j];
        		str[j] = temp;
        		--i;
        		++j;
        	}
        }
        else
        {
        	int middle = str.length/2;
        	int k = middle;
        	for(int i = 1;i<=k;i++)
        	{
        		temp = str[middle - i];
        		str[middle - i] = str[middle + i];
        		str[middle + i] = temp;
        	}
        }
        String ss = str[0];
        for(int i = 1;i<str.length;i++)
        {
        	ss +=" "+str[i];
        }
		return ss;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWords rw = new ReverseWords();
		String s = "   1   2";
		System.out.println(s.split(" ").length);
		System.out.println(rw.reverseWords(s)+"---");
	}

}
