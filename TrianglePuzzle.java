import java.io.*;

public class TrianglePuzzle
{
	public static void main(String[] args)
	{
		String fileName = args[0];
		int currentLastLineNumber = linesCount(fileName);

		int[] testArray = readLastLine(fileName, currentLastLineNumber);
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
}