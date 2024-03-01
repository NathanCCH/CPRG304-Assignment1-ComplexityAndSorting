package shapes;

public class Cylinder  extends Shape
{
	private double radius;

    public Cylinder() 
    {

    }

    public Cylinder(double height, double radius) 
    {
        super(height);
        this.radius = radius;
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
        return Math.PI * Math.pow(radius, 2) * getHeight();
    }

    @Override
    public double getBaseArea() 
    {
        return Math.PI * Math.pow(radius, 2);
    }
}
