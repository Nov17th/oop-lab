package hust.soict.cybersec.garbage;

import java.util.*;

public class ConcatenationInLoops 
{

	public static void main(String[] args) 
	{
		// Using + operator
		Random r = new Random(123);
		long start = System.currentTimeMillis();
		String s = "";
		for (int i = 0; i < 65536; ++i)
		{
			s += r.nextInt();
		}
		System.out.println(System.currentTimeMillis() - start);
		
		// Using StringBuilder
		r = new Random(123);
		start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 65536; ++i)
		{
			sb.append(r.nextInt(2));
		}
		s = sb.toString();
		System.out.println(System.currentTimeMillis() - start);
		
		// Using StringBuffer
		r = new Random(123);
		start = System.currentTimeMillis();
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < 65536; ++i)
		{
			sbf.append(r.nextInt(2));
		}
		s = sbf.toString();
		System.out.println(System.currentTimeMillis() - start);
	}

}
