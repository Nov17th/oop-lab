package hust.soict.cybersec.garbage;

import java.io.*;
import java.nio.file.*;

public class GarbageCreator 
{
	public static void main(String[] args)
	{
		String filename = "src/test.txt";
		byte[] inputBytes = {0};
		long startTime, endTime;
		
		try
		{
			inputBytes = Files.readAllBytes(Paths.get(filename));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		startTime = System.currentTimeMillis();
		String outputString = "";
		for (byte b : inputBytes)
		{
			outputString += (char) b;
		}
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
