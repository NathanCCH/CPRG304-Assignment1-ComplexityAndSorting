package appDomain;

/**
 * Created on Mar 01, 2024
 *
 * @author Team-Purah
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

import utilities.SortAlgorithm;
import utilities.BaseAreaCompare;
import utilities.VolumeCompare;
import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shape;
import shapes.SquarePrism;
import shapes.TriangularPrism;

public class AppDriver
{
	/**
	 * Method to launch application.
	 * 
	 * @param args
	 */
	public static void main( String[] args )
	{
		
		String tempFileName = null;
		String tempType = null;
		String tempSortAlgrm = null;
		
		// Check if any argument is missing.
		if (args.length < 3) 
		{
			System.out.println("Invalid command line arguments.");
			System.exit(1);
		}
	
		//Examine the command line arguments.
		for (int i = 0; i < args.length; i++)
		{
			String arg = args[i].toLowerCase();
			if (arg.startsWith("-f"))
			{
				tempFileName = arg;
			}
			else if (arg.startsWith("-t"))
			{
				tempType = arg;
			}
			else if (arg.startsWith("-s"))
			{
				tempSortAlgrm = arg;
			}
			else
			{
				System.out.println("Invalid command line arguments.");
				System.exit(1);
			}
;		}
		
		//Check if there is any invalid input.
		if (tempFileName == null || tempType == null || !tempType.matches("-t[vha]") 
				|| tempSortAlgrm == null || !tempSortAlgrm.matches("-s[bismqh]"))
		{
            System.out.println("Invalid command line arguments.");
            System.exit(1);
        }
		
		//Extract the actual values by removing the prefixes
		String filePath = tempFileName.substring(2);
        char type = tempType.charAt(2);
        char sortAlgrm = tempSortAlgrm.charAt(2);
        
        //Input handler
        if (filePath.startsWith("shape"))
        {
        	filePath = "assignment1StartingCode/res/" + filePath;
        }
        
        //Read text file and add the content to an array.
        Shape[] shapeArr = null;
        try 
        {
        	shapeArr = readShapeFile(filePath);
        	
        }
        catch (IOException e) 
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        //Start time. 	
        long startTime = System.currentTimeMillis();
        
        Comparator<Shape> comparator = null;
        
        System.out.println("Selected type: " +type);
        System.out.println("Selected sorting algorithm: " +sortAlgrm);
        
        switch (type) 
        {
            case 'h':
                switch (sortAlgrm) //Use compareTo method without comparator.
                {
                    case 'b':
                        SortAlgorithm.bubbleSort(shapeArr);
                        break;
                    case 'i':
                        SortAlgorithm.insertionSort(shapeArr);
                        break;
                    case 's':
                        SortAlgorithm.selectionSort(shapeArr);
                        break;
                    case 'm':
                        SortAlgorithm.mergeSort(shapeArr);
                        break;
                    case 'q':
                        SortAlgorithm.quickSort(shapeArr);
                        break;
                    case 'h':
                        SortAlgorithm.heapSort(shapeArr);
                        break;
                    default:
                        System.out.println("Invalid sorting algorithm");
                        return;
                }
                break;
            case 'v':
                comparator = new VolumeCompare();
                break;
            case 'a':
                comparator = new BaseAreaCompare();
                break;
            default:
                System.out.println("Invalid type");
                return;
        }
        //Sorting using comparator.
        if (comparator != null) 
        {
            switch (sortAlgrm) 
            {
                case 'b':
                    SortAlgorithm.bubbleSort(shapeArr, comparator);
                    break;
                case 'i':
                    SortAlgorithm.insertionSort(shapeArr, comparator);
                    break;
                case 's':
                    SortAlgorithm.selectionSort(shapeArr, comparator);
                    break;
                case 'm':
                    SortAlgorithm.mergeSort(shapeArr, comparator);
                    break;
                case 'q':
                    SortAlgorithm.quickSort(shapeArr, comparator);
                    break;
                case 'h':
                    SortAlgorithm.heapSort(shapeArr, comparator);
                    break;
                default:
                    System.out.println("Invalid sorting algorithm");
                    return;
            }
        }
        //Calculate and print processing time.
        long endTime = System.currentTimeMillis();
        System.out.println("Processing time: " + (endTime - startTime) + " ms");
        
        //Reverse the sorted array.
        Shape[] reversedArr = new Shape[shapeArr.length];
        for (int i = 0; i < shapeArr.length; i++) 
        {
            reversedArr[i] = shapeArr[shapeArr.length - 1 - i];
        }
        
        //Print first sorted value
        if (reversedArr.length > 0) 
        {
            System.out.println("\nFirst sorted value:");
            printFunction(reversedArr[0]);
        }
        
        //Print last sorted value
        if (reversedArr.length > 0) 
        {
            System.out.println("\nLast sorted value:");
            printFunction(reversedArr[reversedArr.length - 1]);
        }
        
        // Print every thousandth value in between
        if (reversedArr.length >= 1000) 
        {
        	System.out.println("\nThousandth value in between");
            for (int i = 999; i < reversedArr.length; i += 1000) 
            {
            	printFunction(reversedArr[i]);
            }
        }
	}
	
	//Read shape data from the file and store in an array
	private static Shape[] readShapeFile(String filePath) throws IOException
    {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
		{
			//Read the first line as the number of lines
            int numLines = Integer.parseInt(reader.readLine()); 
            Shape[] shapeData = new Shape[numLines];
            for (int i = 0; i < numLines; i++) 
            {
                String line = reader.readLine();
                String[] parts = line.split(" ");
                if (parts.length == 3) 
                {
                    String shapeType = parts[0];
                    double value1 = Double.parseDouble(parts[1]);
                    double value2 = Double.parseDouble(parts[2]);
                    
                 // Create specific shape instances based on shapeType
                    if ("cone".equalsIgnoreCase(shapeType)) 
                    {
                        shapeData[i] = new Cone(value1, value2);
                    } 
                    else if ("pyramid".equalsIgnoreCase(shapeType)) 
                    {
                        shapeData[i] = new Pyramid(value1, value2);
                    } 
                    else if ("cylinder".equalsIgnoreCase(shapeType)) 
                    {
                        shapeData[i] = new Cylinder(value1, value2);
                    }
                    else if ("octagonalPrism".equalsIgnoreCase(shapeType)) 
                    {
                        shapeData[i] = new OctagonalPrism(value1, value2);
                    }
                    else if ("pentagonalPrism".equalsIgnoreCase(shapeType)) 
                    {
                        shapeData[i] = new PentagonalPrism(value1, value2);
                    }
                    else if ("squarePrism".equalsIgnoreCase(shapeType)) 
                    {
                        shapeData[i] = new SquarePrism(value1, value2);
                    }
                    else if ("triangularPrism".equalsIgnoreCase(shapeType)) 
                    {
                        shapeData[i] = new TriangularPrism(value1, value2);
                    }
                    else
                    {
                    	System.out.println("Wrong shape type.");
                    }
                }
            }
            return shapeData;
		}
    }
	
	// Printing format according to the shape.
	private static void printFunction(Shape s) 
	{
		if (s instanceof Cone) {
            Cone cone = (Cone) s;
            System.out.println("Cone - Height: " + cone.getHeight() + ", Base area: " + cone.getBaseArea() + ", Volume: " + cone.getVolume());
        } else if (s instanceof Pyramid) {
            Pyramid pyramid = (Pyramid) s;
            System.out.println("Pyramid - Height: " + pyramid.getHeight() + ", Base area: " + pyramid.getBaseArea() + ", Volume: " + pyramid.getVolume());
        } else if (s instanceof Cylinder) {
            Cylinder cylinder = (Cylinder) s;
            System.out.println("Cylinder - Height: " + cylinder.getHeight() + ", Base area: " + cylinder.getBaseArea() + ", Volume: " + cylinder.getVolume());
        } else if (s instanceof OctagonalPrism) {
            OctagonalPrism octagonalPrism = (OctagonalPrism) s;
            System.out.println("Octagonal Prism - Height: " + octagonalPrism.getHeight() + ", Base area: " + octagonalPrism.getBaseArea() + ", Volume: " + octagonalPrism.getVolume());
        } else if (s instanceof PentagonalPrism) {
            PentagonalPrism pentagonalPrism = (PentagonalPrism) s;
            System.out.println("Pentagonal Prism - Height: " + pentagonalPrism.getHeight() + ", Base area: " + pentagonalPrism.getBaseArea() + ", Volume: " + pentagonalPrism.getVolume());
        } else if (s instanceof SquarePrism) {
            SquarePrism squarePrism = (SquarePrism) s;
            System.out.println("Square Prism - Height: " + squarePrism.getHeight() + ", Base area: " + squarePrism.getBaseArea() + ", Volume: " + squarePrism.getVolume());
        } else if (s instanceof TriangularPrism) {
            TriangularPrism triangularPrism = (TriangularPrism) s;
            System.out.println("Triangular Prism - Height: " + triangularPrism.getHeight() + ", Base area: " + triangularPrism.getBaseArea() + ", Volume: " + triangularPrism.getVolume());
        }
	}
}
