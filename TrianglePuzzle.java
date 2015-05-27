import java.io.*;
import java.util.*;

public class TrianglePuzzle
{
	public static void main(String[] args)
	{
		String fileName = args[0];
		System.out.println(triangleSum(fileName));
	}

	public static int linesCount(String fileName)
	{
		BufferedReader inputReader = null;
		try 
		{
			inputReader = new BufferedReader(new FileReader(fileName));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The triangle input file was not found");
		}

		int linesCount = 0;
		String currentLine = "";
		// find out the number of lines in the triangle
		try 
		{
			while ((currentLine = inputReader.readLine()) != null) 
			{
				linesCount++;
			}
		}
		catch (IOException e) { e.printStackTrace(); }

		try 
		{
			if (inputReader != null)
				inputReader.close();
		} 
		catch (IOException ex) { ex.printStackTrace(); }

		return linesCount;
	}

	public static int[] readLastLine(String fileName, int lineNumber)
	{
		BufferedReader inputReader = null;
		try 
		{
			inputReader = new BufferedReader(new FileReader(fileName));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The triangle input file was not found");
		}

		String currentLine = "";
		try 
		{
			for (int i = 0; i < lineNumber; i++)
			{
				currentLine = inputReader.readLine();
			}
		}
		catch (IOException e) { e.printStackTrace(); }

		try 
		{
			if (inputReader != null)
				inputReader.close();
		} 
		catch (IOException ex) { ex.printStackTrace(); }

		// parse lastLine into a usable array of integers
		String[] stringArray = currentLine.split(" ");
		int[] intArray = new int[stringArray.length];
		int count = 0;
		for (String x : stringArray)
		{
			intArray[count] = Integer.parseInt(x);
			count++;
		}

		return intArray;
	}

	public static int triangleSum(String fileName)
	{
		// set the currentLine as the last line in the file
		int currentLastLineNumber = linesCount(fileName);
		int[] sumArray = readLastLine(fileName, currentLastLineNumber);
		currentLastLineNumber--;

		for (; currentLastLineNumber >= 1; currentLastLineNumber--)
		{
			int[] currentArray = readLastLine(fileName, currentLastLineNumber);
			for (int x = 0; x < currentArray.length; x++)
			{
				sumArray[x] = currentArray[x] + Math.max(sumArray[x], sumArray[x+1]);
			}
		}

		return sumArray[0];
	}
}