package shapes;

public class OctagonalPrism extends Shape
{
	private double edgeLength;
	
	public OctagonalPrism()
	{
		
	}
	
	public OctagonalPrism(double height, double edgeLength)
	{
		super(height);
		this.setEdgeLength(edgeLength);
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
		return 2 * Math.pow(edgeLength, 2) * Math.tan(Math.PI / 8);
	}

}
