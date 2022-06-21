package geometry;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Donut extends Circle {
	

	private int innerRadius;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		setSelected(selected);
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color) { 
		this(center, radius, innerRadius, selected);
		setColor(color);
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color, Color innerColor) { 
		this(center, radius, innerRadius, selected, color);
		setInnerColor(innerColor);
	}
	
	public void draw(Graphics g) {
	
		Graphics2D graphics2d = (Graphics2D)g.create();
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		java.awt.Shape outterElipse = new Ellipse2D.Double(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), this.getRadius()*2, this.getRadius()*2);
		java.awt.Shape innerElipse = new Ellipse2D.Double(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.getInnerRadius()*2);
		
		Area circle = new Area (outterElipse);
		circle.subtract(new Area(innerElipse));
		graphics2d.setColor(this.getInnerColor());
		graphics2d.fill(circle);
		graphics2d.setColor(this.getColor());
		graphics2d.draw(circle);
		
		graphics2d.dispose();
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - this.getRadius() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + this.getRadius() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - this.getRadius() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + this.getRadius() - 3, 6, 6);
		}
	
	
	}
	
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		super.fill(g);
		g.setColor(Color.WHITE);
		g.fillOval(getCenter().getX() - this.innerRadius, getCenter().getY() - this.innerRadius, 
				this.innerRadius * 2, this.innerRadius * 2);
	}
	
	public int compareTo(Object o) {
		if (o instanceof Donut) {
			return (int) (this.area() - ((Donut) o).area());
		}
		return 0;
	}
	
	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}
	
	public boolean contains(int x, int y) {
		double dFromCenter = this.getCenter().distance(x, y);
		return super.contains(x, y) && dFromCenter > innerRadius;
	}
	
	public boolean contains(Point p) {
		double dFromCenter = this.getCenter().distance(p.getX(), p.getY());
		return super.contains(p) && dFromCenter > innerRadius;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut d = (Donut) obj;
			if (this.getCenter().equals(d.getCenter()) &&
					this.getRadius() == d.getRadius() &&
					this.innerRadius == d.getInnerRadius()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public String toString() {
		return "Donut " + "CenterX: " + this.getCenter().getX() + " CenterY: "  + this.getCenter().getY()  + " Radius: " + this.getRadius()
		+ " InnerRadius: " + this.getInnerRadius() + " OutterColor: " + this.getColor().getRGB() + " InnerColor: " + this.getInnerColor().getRGB();
}
	
	public Donut clone () {
		Donut donut = new Donut();
		
		donut.setCenter(new Point(this.getCenter().getX(), this.getCenter().getY()));

		
		donut.setRadius(this.getRadius());
		donut.setInnerRadius(this.getInnerRadius());
		
		donut.setColor(this.getColor());
		donut.setInnerColor(this.getInnerColor());
		
		return donut;	
	}
	
	
}
