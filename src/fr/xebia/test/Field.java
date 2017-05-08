package fr.xebia.test;

/**
 * Class modeling a field (Singleton)
 * 
 * @author aouesguesmi
 *
 */
public class Field {

	private int rowSize;
	private int colSize;

	private static Field instance = new Field();

	public static Field getInstance() {
		return instance;
	}

	public final int getRowSize() {
		return rowSize;
	}

	public final void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public final int getColSize() {
		return colSize;
	}

	public final void setColSize(int colSize) {
		this.colSize = colSize;
	}

	@Override
	public String toString() {
		return "Field [rowSize=" + rowSize + ", colSize=" + colSize + "]";
	}
}
