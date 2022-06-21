package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.AbstractButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import adapter.HexagonAdapter;
import command.AddShapeCmd;
import command.BringToBackCmd;
import command.BringToFrontCmd;
import command.Command;
import command.ModifyCircleCmd;
import command.ModifyDonutCmd;
import command.ModifyHexagonCmd;
import command.ModifyLineCmd;
import command.ModifyPointCmd;
import command.ModifyRectangleCmd;
import command.RemoveShapeCmd;
import command.ToBackCmd;
import command.ToFrontCmd;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import observer.SelectList;
import observer.SelectListObserver;
import strategy.SaveDrawing;
import strategy.SaveLog;
import strategy.SaveManager;

import java.awt.Color;

import dialogDrawing.DlgCircle;
import dialogDrawing.DlgDonut;
import dialogDrawing.DlgHexagon;
import dialogDrawing.DlgRectangle;
import dialogModification.DlgCircleModification;
import dialogModification.DlgDonutModification;
import dialogModification.DlgHexagonModification;
import dialogModification.DlgLineModification;
import dialogModification.DlgPointModification;
import dialogModification.DlgRectangleModification;

public class DrawingController {
	private DrawingModel model;
	private DrawingFrame frame;

	private Color edgeColor = Color.BLACK;
	private Color innerColor = Color.BLACK;
	private Point pointer;
	private int counter = 0;
	private int index = 0;

	private Stack<Command> undoStack = new Stack<Command>();
	private Stack<Command> redoStack = new Stack<Command>();

	private Shape selected;
	private ArrayList<Shape> select = new ArrayList<Shape>();

	private SelectListObserver observer;
	private SelectList observable = new SelectList();

	// Command
	private AddShapeCmd addShapeCommand;
	private RemoveShapeCmd removeShapeCommand;

	private SaveLog saveLog;
	private SaveDrawing saveDrawing;
	private SaveManager save;

	public DrawingController() {

	}

	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
		this.observer = new SelectListObserver(frame);
		this.observable = new SelectList();
		this.observable.addPropertyChangeListener(observer);
	}

	public void draw(String s, MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());

		System.out.println(s);
		model.add(p);

		frame.repaint();
		undoCheck();
		redoCheck();
	}

	public void clear() {
		if (model.getShapes().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Panel is empty!", "Error", JOptionPane.ERROR_MESSAGE, null);

		} else {
			model.getShapes().clear();
			frame.repaint();
			undoCheck();
			redoCheck();
		}
	}

	public void mouseClicked(MouseEvent e) {
		Point click = new Point(e.getX(), e.getY());
		List<AbstractButton> shapes = Collections.list(frame.getShapes().getElements());
		List<AbstractButton> drawSelect = Collections.list(frame.getDrawSelect().getElements());
		String shape = "none";
		String action = "none";
		for (AbstractButton button : shapes) {
			if (button.isSelected()) {
				shape = ((JToggleButton) button).getText().toString();
			}
		}
		for (AbstractButton button : drawSelect) {
			if (button.isSelected()) {
				action = ((JToggleButton) button).getText().toString();
			}
		}
		switch (action) {
		case "Draw":
			if (shape == "Point") {
				Point p = new Point(e.getX(), e.getY(), false, Color.black);
				addShapeCommand = new AddShapeCmd(model, p);
				addShapeCommand.execute();
				frame.dlm.addElement("Add " + p.toString());
				this.undoStack.push(addShapeCommand);
			} else if (shape == "Circle") {
				DlgCircle dlgCir = new DlgCircle();
				dlgCir.setVisible(true);
				if (dlgCir.isOk()) {
					Circle circle = new Circle(click, Integer.parseInt(dlgCir.getTxtRadius().getText()));
					circle.setColor(edgeColor);
					circle.setInnerColor(innerColor);
					addShapeCommand = new AddShapeCmd(model, circle);
					addShapeCommand.execute();
					frame.dlm.addElement("Add " + circle.toString());
					this.undoStack.push(addShapeCommand);
				}
			} else if (shape == "Rectangle") {
				DlgRectangle dlgRec = new DlgRectangle();
				dlgRec.setVisible(true);
				if (dlgRec.isOk()) {
					Rectangle r1 = new Rectangle(click, Integer.parseInt(dlgRec.getTxtHeight().getText()),
							Integer.parseInt(dlgRec.getTxtWidth().getText()));
					r1.setColor(edgeColor);
					r1.setInnerColor(innerColor);
					addShapeCommand = new AddShapeCmd(model, r1);
					addShapeCommand.execute();
					frame.dlm.addElement("Add " + r1.toString());
					this.undoStack.push(addShapeCommand);
				}
			} else if (shape == "Line") {
				if (pointer == null) {
					pointer = new Point(e.getX(), e.getY());
					return;
				}
				Point pointer2 = new Point(e.getX(), e.getY());
				Line line = new Line(pointer, pointer2, false, edgeColor);
				addShapeCommand = new AddShapeCmd(model, line);
				addShapeCommand.execute();
				this.undoStack.push(addShapeCommand);
				frame.dlm.addElement("Add " + line.toString());
				pointer = null;
			} else if (shape == "Donut") {
				DlgDonut dlgDon = new DlgDonut();
				dlgDon.setVisible(true);
				if (dlgDon.isOk()) {
					Donut donut = new Donut(click, Integer.parseInt(dlgDon.getTxtRadius().getText()),
							Integer.parseInt(dlgDon.getTxtInnerRadius().getText()), false, edgeColor, innerColor);
					addShapeCommand = new AddShapeCmd(model, donut);
					addShapeCommand.execute();
					this.undoStack.push(addShapeCommand);
					frame.dlm.addElement("Add " + donut.toString());
				}
			} else if (shape == "Hexagon") {
				DlgHexagon dlgHex = new DlgHexagon();
				dlgHex.setVisible(true);
				if (dlgHex.isOk()) {
					HexagonAdapter hexagon = new HexagonAdapter(click,
							Integer.parseInt(dlgHex.getTxtRadius().getText()), edgeColor, innerColor, false);
					addShapeCommand = new AddShapeCmd(model, hexagon);
					addShapeCommand.execute();
					this.undoStack.push(addShapeCommand);
					frame.dlm.addElement("Add " + hexagon.toString());
				}
			}
			redoStack.clear();
			break;
		case "Select":
			selected = null;
			Iterator<Shape> it = model.getShapes().iterator();

			while (it.hasNext()) {
				Shape s2 = it.next();

				if (s2.contains(e.getX(), e.getY())) {
					selected = s2;
				}
			}

			if (selected != null) {

				if (selected.isSelected()) {
					selected.setSelected(false);
					frame.dlm.addElement("Deselected " + selected.toString());
					select.remove(selected);
					observable.setListSize(select.size());
				} else {
					selected.setSelected(true);
					frame.dlm.addElement("Selected " + selected.toString());
					select.add(selected);
					observable.setListSize(select.size());
				}

			}
		}
		undoCheck();
		redoCheck();
		frame.repaint();

	}

	public void undoCheck() {
		if (this.undoStack.isEmpty()) {
			frame.getBtnUndo().setEnabled(false);
		} else {
			frame.getBtnUndo().setEnabled(true);
		}
	}

	public void redoCheck() {
		if (this.redoStack.isEmpty()) {
			frame.getBtnRedo().setEnabled(false);
		} else {
			frame.getBtnRedo().setEnabled(true);
		}
	}

	public void undo() {
		if (frame.getBtnUndo().isEnabled()) {
			Command undoCommand = undoStack.pop();
			undoCommand.unexecute();
			frame.dlm.addElement("Undo");
			redoStack.push(undoCommand);
			observable.setListSize(select.size());
			frame.repaint();
			undoCheck();
			redoCheck();
		}
	}

	public void redo() {
		if (frame.getBtnRedo().isEnabled()) {
			Command redoCommand = this.redoStack.pop();
			redoCommand.execute();
			undoStack.push(redoCommand);
			frame.dlm.addElement("Redo");
			observable.setListSize(select.size());
			frame.repaint();
			undoCheck();
			redoCheck();
		}
	}

	public void innerC(ActionEvent e) {
		innerColor = JColorChooser.showDialog(null, "Inner Color", innerColor);
		if (innerColor == null) {
			innerColor = Color.black;
		} else {
			frame.getBtnInnerColor().setBackground(innerColor);
		}
	}

	public void edgeC(ActionEvent e) {
		edgeColor = JColorChooser.showDialog(null, "Edge Color", edgeColor);
		if (edgeColor == null) {
			edgeColor = Color.black;
		} else {
			frame.getBtnEdgeColor().setBackground(edgeColor);
		}
	}

	public void delete(MouseEvent e) {
		if (selected != null) {
			int option = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete", JOptionPane.YES_NO_OPTION);
			if (option == 0) {
				RemoveShapeCmd removeShape = new RemoveShapeCmd(model, select);
				frame.dlm.addElement("Delete " + select.toString());
				removeShape.execute();
				undoStack.push(removeShape);
				observable.setListSize(select.size());
				redoStack.clear();
				frame.getBtnUndo().setEnabled(true);
				frame.getBtnRedo().setEnabled(false);
			} else {

			}
			frame.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "You must select object first!");
		}
	}

	protected void saveDrawing() {
		saveDrawing = new SaveDrawing();
		save = new SaveManager(saveDrawing);
		save.save(model.getShapes());
	}

	protected void loadDrawing() {
		JFileChooser fc = new JFileChooser();
		if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				FileInputStream fis = new FileInputStream(fc.getSelectedFile());
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object obj = ois.readObject();

				model.getShapes().addAll((ArrayList<Shape>) obj);
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}

		}
		undoCheck();
		redoCheck();
		frame.repaint();

	}
	
	protected void saveLog() {
		saveLog = new SaveLog();
		save = new SaveManager(saveLog);
		save.save(frame.dlm);
	}

	protected void loadLog() {
		JFileChooser fc = new JFileChooser();
		if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				int i = 0;
				Scanner scan = new Scanner(fc.getSelectedFile());
				while (scan.hasNext()) {
					frame.dlm.add(i, scan.nextLine());
					i++;
				}
				frame.getBtnLoadNext().setEnabled(true);
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void loadNext() {
		Command cmd = null;
		Shape shape = null;
		counter++;
		frame.getList().setSelectedIndex(counter - 1);
		frame.getList().ensureIndexIsVisible(counter);

		if (index < frame.dlm.getSize()) {
			frame.getBtnLoadNext().setEnabled(true);
			String line = frame.dlm.get(index);
			String[] words = line.split(" ");

			if (words[0].equals("Add")) {
				shape = this.check(words);
				cmd = new AddShapeCmd(model, shape);
			}
			if (words[0].equals("Delete")) {
				cmd = new RemoveShapeCmd(model, select);
			}
			if (words[0].equals("Modify")) {
				Shape oldShape = select.get(0);
				Shape newShape = this.check(words);
				if (oldShape instanceof Point) {
					cmd = new ModifyPointCmd((Point) oldShape, (Point) newShape);
				} else if (oldShape instanceof Line) {
					cmd = new ModifyLineCmd((Line) oldShape, (Line) newShape);
				} else if (oldShape instanceof Circle) {
					cmd = new ModifyCircleCmd((Circle) oldShape, (Circle) newShape);
				} else if (oldShape instanceof Rectangle) {
					cmd = new ModifyRectangleCmd((Rectangle) oldShape, (Rectangle) newShape);
				} else if (oldShape instanceof Donut) {
					cmd = new ModifyDonutCmd((Donut) oldShape, (Donut) newShape);
				} else if (oldShape instanceof HexagonAdapter) {
					cmd = new ModifyHexagonCmd((HexagonAdapter) oldShape, (HexagonAdapter) newShape);
				}
			}
			if (words[0].equals("Selected")) {
				Shape selectedShape = this.check(words);
				int index = model.getShapes().indexOf(selectedShape);
				shape = model.get(index);
				shape.setSelected(true);
				select.add(shape);
			}
			if (words[0].equals("Deselected")) {
				Shape selectedShape = this.check(words);
				int index = model.getShapes().indexOf(selectedShape);
				shape = model.get(index);
				shape.setSelected(false);
				select.remove(shape);
			}
			if (words[0].equals("ToFront")) {
				shape = select.get(0);
				cmd = new ToFrontCmd(model, shape);
			}
			if (words[0].equals("ToBack")) {
				shape = select.get(0);
				cmd = new ToBackCmd(model, shape);
			}
			if (words[0].equals("BringToFront")) {
				shape = select.get(0);
				cmd = new BringToFrontCmd(model, shape);
			}
			if (words[0].equals("BringToBack")) {
				shape = select.get(0);
				cmd = new BringToBackCmd(model, shape);
			}
			if (cmd != null) {
				cmd.execute();
				undoStack.push(cmd);
			}
			if (words[0].equals("Undo")) {
				Command undoCmd = undoStack.pop();
				undoCmd.unexecute();
				undoStack.push(undoCmd);
			}
			if (words[0].equals("Redo")) {
				Command redoCmd = redoStack.pop();
				redoCmd.execute();
				redoStack.push(redoCmd);
			}
			index++;
			frame.repaint();
//			undoCheck();
//			redoCheck();
		} else {
			frame.getBtnLoadNext().setEnabled(false);
		}
		if (counter == frame.dlm.getSize()) {
			frame.getBtnLoadNext().setEnabled(false);
		}
	}

	public Shape check(String[] words) {

		if (words[1].equals("Point")) {
			return new Point(Integer.parseInt(words[3]), Integer.parseInt(words[5]), false,
					new Color(Integer.parseInt(words[7])));

		} else if (words[1].equals("Line")) {

			Point startPoint = new Point(Integer.parseInt(words[3]), Integer.parseInt(words[5]));
			Point endPoint = new Point(Integer.parseInt(words[7]), Integer.parseInt(words[9]));
			return new Line(startPoint, endPoint, false, new Color(Integer.parseInt(words[11])));

		} else if (words[1].equals("Rectangle")) {
			Point upperLeftPoint = new Point(Integer.parseInt(words[3]), Integer.parseInt(words[5]));
			return new Rectangle(upperLeftPoint, Integer.parseInt(words[9]), Integer.parseInt(words[7]), false,
					new Color(Integer.parseInt(words[11])), new Color(Integer.parseInt(words[13])));
		} else if (words[1].equals("Circle")) {
			Point center = new Point(Integer.parseInt(words[3]), Integer.parseInt(words[5]));
			return new Circle(center, Integer.parseInt(words[7]), false, new Color(Integer.parseInt(words[9])),
					new Color(Integer.parseInt(words[11])));
		} else if (words[1].equals("Donut")) {
			Point center = new Point(Integer.parseInt(words[3]), Integer.parseInt(words[5]));
			return new Donut(center, Integer.parseInt(words[7]), Integer.parseInt(words[9]), false,
					new Color(Integer.parseInt(words[11])), new Color(Integer.parseInt(words[13])));
		} else if (words[1].equals("Hexagon")) {
			Point center = new Point(Integer.parseInt(words[3]), Integer.parseInt(words[5]));
			return new HexagonAdapter(center, Integer.parseInt(words[7]), new Color(Integer.parseInt(words[9])),
					new Color(Integer.parseInt(words[11])), false);
		}
		return null;
	}

	public void modify(MouseEvent e) {
		if (selected == null) {

			JOptionPane.showMessageDialog(null, "Please select object!", "Error", JOptionPane.ERROR_MESSAGE, null);
			return;
		}

		if (selected instanceof Point) {
			Point oldState = (Point) selected;

			DlgPointModification pointMod = new DlgPointModification();
			pointMod.fillFields((Point) selected);
			pointMod.setVisible(true);

			if (pointMod.isOk()) {
				Point newState = new Point();
				newState.setColor(pointMod.getColor());
				newState.setX(pointMod.getX());
				newState.setY(pointMod.getY());

				ModifyPointCmd cmd = new ModifyPointCmd(oldState, newState);
				cmd.execute();
				undoStack.push(cmd);
				redoStack.clear();
			} 
		} else if (selected instanceof Line) {
			Line oldState = (Line) selected;

			DlgLineModification lineMod = new DlgLineModification();
			lineMod.fillFields((Line) selected);
			lineMod.setVisible(true);

			if (lineMod.isOk()) {
				Line newState = new Line();
				newState.setColor(lineMod.getEdgeColor());
				newState.setStartPoint(new Point(lineMod.getStartX(), lineMod.getStartY()));
				newState.setEndPoint(new Point(lineMod.getEndX(), lineMod.getEndY()));

				ModifyLineCmd cmd = new ModifyLineCmd(oldState, newState);
				cmd.execute();

				undoStack.push(cmd);
				redoStack.clear();
			} 
		} else if (selected instanceof Donut) {
			Donut oldState = (Donut) selected;

			DlgDonutModification donutMod = new DlgDonutModification();
			donutMod.fillFields((Donut) selected);
			donutMod.setVisible(true);

			if (donutMod.isOk()) {
				Donut newState = new Donut();
				newState.setCenter(new Point(donutMod.getX(), donutMod.getY()));
				newState.setColor(donutMod.getEdgeColor());
				newState.setInnerColor(donutMod.getInnerColor());
				newState.setInnerRadius(donutMod.getInnerRadius());
				newState.setRadius(donutMod.getRadius());

				ModifyDonutCmd cmd = new ModifyDonutCmd(oldState, newState);
				cmd.execute();

				undoStack.push(cmd);
				redoStack.clear();
			} 
		} else if (selected instanceof Circle) {
			Circle oldState = (Circle) selected;

			DlgCircleModification circleMod = new DlgCircleModification();
			circleMod.fillFields((Circle) selected);
			circleMod.setVisible(true);

			if (circleMod.isOk()) {
				Circle newState = new Circle();
				newState.setCenter(new Point(circleMod.getX(), circleMod.getY()));
				newState.setColor(circleMod.getEdgeColor());
				newState.setInnerColor(circleMod.getInnerColor());
				newState.setRadius(circleMod.getRadius());

				ModifyCircleCmd cmd = new ModifyCircleCmd(oldState, newState);
				cmd.execute();

				undoStack.push(cmd);
				redoStack.clear();
			}

		} else if (selected instanceof Rectangle) {
			Rectangle oldState = (Rectangle) selected;

			DlgRectangleModification rectangleMod = new DlgRectangleModification();
			rectangleMod.fillFields((Rectangle) selected);
			rectangleMod.setVisible(true);

			if (rectangleMod.isOk()) {
				Rectangle newState = new Rectangle();
				newState.setHeight(rectangleMod.getHeightI());
				newState.setWidth(rectangleMod.getWidthI());
				newState.setUpperLeftPoint(new Point(rectangleMod.getX(), rectangleMod.getY()));
				newState.setColor(rectangleMod.getEdgeColor());
				newState.setInnerColor(rectangleMod.getInnerColor());

				ModifyRectangleCmd cmd = new ModifyRectangleCmd(oldState, newState);
				cmd.execute();

				undoStack.push(cmd);
				redoStack.clear();
			} 

		} else if (selected instanceof HexagonAdapter) {
			HexagonAdapter oldState = (HexagonAdapter) selected;

			DlgHexagonModification hexMod = new DlgHexagonModification();
			hexMod.fillFields((HexagonAdapter) selected);
			hexMod.setVisible(true);

			if (hexMod.isOk()) {
				HexagonAdapter newState = new HexagonAdapter();
				newState.getHexagon().setBorderColor(hexMod.getEdgeColor());
				newState.getHexagon().setAreaColor(hexMod.getInnerColor());
				newState.getHexagon().setR(hexMod.getRadius());
				newState.getHexagon().setX(hexMod.getX());
				newState.getHexagon().setY(hexMod.getY());

				ModifyHexagonCmd cmd = new ModifyHexagonCmd(oldState, newState);
				cmd.execute();

				undoStack.push(cmd);
				redoStack.clear();
			}

		}
		frame.dlm.addElement("Modify " + selected.toString());
		frame.repaint();
		undoCheck();
		redoCheck();
	}

	public void toFront() {

		if (selected != null) {
			ToFrontCmd toFront = new ToFrontCmd(model, selected);
			toFront.execute();
			frame.dlm.addElement("ToFront " + selected.toString());
			frame.repaint();
			undoStack.push(toFront);
			frame.getBtnUndo().setEnabled(true);
			frame.getBtnRedo().setEnabled(false);
			redoStack.clear();
		}
	}

	public void toBack() {

		if (selected != null) {
			ToBackCmd toBack = new ToBackCmd(model, selected);
			toBack.execute();
			frame.dlm.addElement("ToBack " + selected.toString());
			frame.repaint();
			undoStack.push(toBack);
			frame.getBtnUndo().setVisible(true);
			frame.getBtnRedo().setVisible(false);
			redoStack.clear();
		}
	}

	public void bringToFront() {
		BringToFrontCmd bringToFront = new BringToFrontCmd(model, selected);
		bringToFront.execute();
		frame.dlm.addElement("BringToFront " + selected.toString());
		frame.repaint();
		undoStack.push(bringToFront);
		frame.getBtnUndo().setEnabled(true);
		frame.getBtnRedo().setEnabled(false);
		redoStack.clear();
	}

	public void bringToBack() {

		BringToBackCmd bringToBack = new BringToBackCmd(model, selected);
		bringToBack.execute();
		frame.dlm.addElement("BringToBack " + selected.toString());
		frame.repaint();
		undoStack.push(bringToBack);
		frame.getBtnUndo().setEnabled(true);
		frame.getBtnRedo().setEnabled(false);
		redoStack.clear();
	}

}
