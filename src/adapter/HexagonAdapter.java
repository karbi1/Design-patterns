package adapter;

import java.awt.Color;
import java.awt.Graphics;

import geometry.Point;
import geometry.Shape;
import hexagon.Hexagon;

public class HexagonAdapter extends Shape {
	
	private Hexagon hexagon = new Hexagon(0, 0, 0);
	
	public HexagonAdapter()
	{
		//a
	}
	
	public HexagonAdapter(Point p, int r, Color borderColor, Color areaColor, boolean selected)
	{
		
		hexagon.setX(p.getX());
		hexagon.setY(p.getY());
		hexagon.setR(r);
		hexagon.setAreaColor(areaColor);
		hexagon.setBorderColor(borderColor);
		hexagon.setSelected(selected);
	}
	
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void moveBy(int byX, int byY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}

	@Override
	public void draw(Graphics g) {
		hexagon.paint(g);
		
	}
	
	public String toString() {
		return "Hexagon " + "CenterX: " + this.getHexagon().getX() + " CenterY: " + this.getHexagon().getY() + " Radius: " + this.getHexagon().getR()
				+ " OutterColor: " + this.getHexagon().getBorderColor().getRGB() + " InnerColor: " + this.getHexagon().getAreaColor().getRGB();
		}
	
	public boolean equals(Object obj) {
		if (obj instanceof HexagonAdapter) {
			HexagonAdapter temp = (HexagonAdapter) obj;
			if (this.getHexagon().getR() == temp.getHexagon().getR() && this.getHexagon().getX() == temp.getHexagon().getX() && this.getHexagon().getY() == temp.getHexagon().getY()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public HexagonAdapter clone() {
		
		HexagonAdapter adapter = new HexagonAdapter();
		adapter.hexagon.setX(this.hexagon.getX());
		adapter.hexagon.setY(this.hexagon.getY());
		adapter.hexagon.setR(this.hexagon.getR());
		
		adapter.hexagon.setAreaColor(this.hexagon.getAreaColor());
		adapter.hexagon.setBorderColor(this.hexagon.getBorderColor());
		
		return adapter;	
	}

	public Hexagon getHexagon() {
		return hexagon;
	}

	public void setHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	
	public void setSelected(boolean selected) {
		hexagon.setSelected(selected);
	}
	
	public boolean isSelected() {
		return hexagon.isSelected();
	}

}
