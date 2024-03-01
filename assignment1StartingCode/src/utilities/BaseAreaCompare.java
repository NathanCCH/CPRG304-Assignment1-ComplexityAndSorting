package utilities;

/**
 * Created on Mar 01, 2024
 *
 * @author Chia-hsun Hsieh
 * @version 1.0
 */

import java.util.Comparator;
import shapes.Shape;

public class BaseAreaCompare implements Comparator<Shape>
{
	@Override
	public int compare(Shape o1, Shape o2)
	{
		if(o1.getBaseArea() > o2.getBaseArea()) 
		{
			return 1;
		}
		else if(o1.getBaseArea() < o2.getBaseArea())
		{
			return -1;
		} 
		else
		{
			return 0;
		}
	}
	
}
