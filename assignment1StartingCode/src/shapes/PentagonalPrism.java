package shapes;

public class PentagonalPrism extends Shape
{
	private double edgeLength;

    public PentagonalPrism() 
    {
        
    }

    public PentagonalPrism(double height, double edgeLength) 
    {
        super(height);
        this.edgeLength = edgeLength;
    }

    public double getSideLength() 
    {
        return edgeLength;
    }

    public void setSideLength(double sideLength) 
    {
        this.edgeLength = sideLength;
    }

    @Override
    public double getVolume() 
    {
        return getBaseArea() * getHeight();
    }

    @Override
    public double getBaseArea() 
    {
        // The base area of a regular pentagon
        return (5.0 / 4.0) * Math.tan(Math.PI / 5) * Math.pow(edgeLength, 2);
    }
}
