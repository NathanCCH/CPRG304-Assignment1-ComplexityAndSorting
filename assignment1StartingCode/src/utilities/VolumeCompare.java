package utilities;

/**
 * Created on Mar 01, 2024
 *
 * @author Chia-hsun Hsieh
 * @version 1.0
 */

import java.util.Comparator;
import shapes.Shape;

public class VolumeCompare implements Comparator<Shape>
{
	@Override
	public int compare(Shape o1, Shape o2)
	{
		if (o1 == null && o2 == null) 
		{
            return 0;
        } 
		else if (o1 == null) 
		{
            return -1; // o1 is considered smaller than o2
        } 
		else if (o2 == null) 
        {
            return 1; // o2 is considered smaller than o1
        } 
		else 
		{
            double volume1 = o1.getVolume();
            double volume2 = o2.getVolume();
            return Double.compare(volume1, volume2);
        }
	}

}
