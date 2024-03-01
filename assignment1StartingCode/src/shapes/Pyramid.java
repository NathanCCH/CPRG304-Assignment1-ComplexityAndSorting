package shapes;

public class Pyramid extends Shape
{
	private double edgeLength;

    public Pyramid() 
    {
        
    }

    public Pyramid(double height, double edgeLength) 
    {
        super(height);
        this.edgeLength = edgeLength;
    }

    public double getBaseSideLength() 
    {
        return edgeLength;
    }

    public void setBaseSideLength(double edgeLength) 
    {
        this.edgeLength = edgeLength;
    }

    @Override
    public double getVolume() 
    {
        return (1.0 / 3.0) * getBaseArea() * getHeight();
    }

    @Override
    public double getBaseArea() 
    {
        return Math.pow(edgeLength, 2);
    }
}
