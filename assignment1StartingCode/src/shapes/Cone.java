package shapes;

public class Cone extends Shape
{
	private double radius;
	
	public Cone()
	{
		
	}
	
	public Cone(double height, double radius)
	{
		super(height);
		this.setRadius(radius);
	}
	 
	public double getRadius()
	{
		return radius;
	}

	public void setRadius(double radius)
	{
		this.radius = radius;
	}

	@Override
	public double getVolume()
	{
		// TODO Auto-generated method stub
		return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * this.height;
	}

	@Override
	public double getBaseArea()
	{
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(radius, 2);
	}

}
