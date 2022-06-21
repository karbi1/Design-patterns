package geometry;

import java.awt.Color;	
import java.awt.Graphics;

public class Circle extends SurfaceShape {

	private Point center;
	private int radius;
	
	public Circle() {

	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		setSelected(selected);
	}
	
	public Circle(Point center, int radius, boolean selected, Color color) {
		this(center, radius, selected);
		setColor(color);
	}
	
	public Circle(Point center, int radius, boolean selected, Color color, Color innerColor) {
		this(center, radius, selected, color);
		setInnerColor(innerColor);
	}
	
	@Override
	public int compareTo(Object o) {
		if (o instanceof Circle) {
			return this.radius - ((Circle)o).radius;
		}
		return 0;
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		this.center.moveBy(byX, byY);
	}

	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillOval(this.center.getX() - radius + 1, this.center.getY() - radius + 1, radius * 2 - 2, radius * 2 - 2);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(this.center.getX() - radius, this.center.getY() - radius, radius * 2, radius * 2);
		this.fill(g);

		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.center.getX() - 3, this.center.getY() - 3, 6, 6);
			g.drawRect(this.center.getX() - radius - 3, this.center.getY() - 3, 6, 6);
			g.drawRect(this.center.getX() + radius - 3, this.center.getY() - 3, 6, 6);
			g.drawRect(this.center.getX() - 3, this.center.getY() - radius - 3, 6, 6);
			g.drawRect(this.center.getX() - 3, this.center.getY() + radius - 3, 6, 6);
		}
	}

	
	public double area() {
		return radius * radius * Math.PI;
	}
	
	public boolean contains(int x, int y) {
		return this.center.distance(x, y) <= radius;
	}
	
	public boolean contains(Point p) {
		return this.center.distance(p.getX(), p.getY()) <= radius;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle prosledjen = (Circle)obj;
			if (this.center.equals(prosledjen.getCenter()) && this.radius == prosledjen.getRadius()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public String toString() {
		return "Circle " + "CenterX: " + this.getCenter().getX() + " CenterY: "  + this.getCenter().getY()  + " Radius: " + this.getRadius()
		+" OutterColor: " + this.getColor().getRGB() + " InnerColor: " + this.getInnerColor().getRGB();
	}
	
	@Override
	public Circle clone () {
		Circle circle = new Circle();
		
		circle.setCenter(new Point(this.getCenter().getX(), this.getCenter().getY()));
		
		circle.setRadius(this.getRadius());
		
		circle.setColor(this.getColor());
		circle.setInnerColor(this.getInnerColor());
		
		return circle;
	}



	
}
