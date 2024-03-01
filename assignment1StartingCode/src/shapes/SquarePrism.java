package shapes;

public class SquarePrism extends Shape
{
	private double edgeLength;

    public SquarePrism() 
    {
        
    }

    public SquarePrism(double height, double edgeLength) 
    {
        super(height);
        this.edgeLength = edgeLength;
    }

    public double getEdgeLength() 
    {
        return edgeLength;
    }

    public void setEdgeLength(double edgeLength) 
    {
        this.edgeLength = edgeLength;
    }

    @Override
    public double getVolume() 
    {
        return getBaseArea() * getHeight();
    }

    @Override
    public double getBaseArea() 
    {
        return Math.pow(edgeLength, 2);
    }
}
