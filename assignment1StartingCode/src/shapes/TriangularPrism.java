package shapes;

public class TriangularPrism extends Shape
{
	private double edgeLength;

    public TriangularPrism() 
    {
    	
    }

    public TriangularPrism(double height, double edgeLength) 
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
        return (1.0 / 2.0) * getBaseArea() * getHeight();
    }

    @Override
    public double getBaseArea() 
    {
        return (Math.sqrt(3) / 4.0) * Math.pow(edgeLength, 2);
    }
}
