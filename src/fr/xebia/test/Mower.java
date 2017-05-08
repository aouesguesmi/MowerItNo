package fr.xebia.test;

/**
 * Class modeling a mower
 * 
 * @author aouesguesmi
 *
 */
public class Mower {
	private int col;
	private int row;
	private char orientation;
	private String commands;

	public Mower(int col, int row, char orientation) {
		this.col = col;
		this.row = row;
		this.orientation = orientation;
	}

	public final int getCol() {
		return col;
	}

	public final void setCol(int col) {
		this.col = col;
	}

	public final int getRow() {
		return row;
	}

	public final void setRow(int row) {
		this.row = row;
	}

	public final char getOrientation() {
		return orientation;
	}

	public final void setOrientation(char orientation) {
		this.orientation = orientation;
	}

	public final String getCommands() {
		return commands;
	}

	public final void setCommands(String commands) {
		this.commands = commands;
	}

	@Override
	public String toString() {
		return "Mower [col=" + col + ", row=" + row + ", orientation=" + orientation + ", commands=" + commands + "]";
	}

	/**
	 * Circulate the mower inside the field
	 * 
	 * @param colNbr
	 * @param rowNbr
	 * @return the new coordinates of the mower
	 */
	public String circulate(int colNbr, int rowNbr) {
		String itCommands = this.commands;
		StringBuilder mowerNewCoords = new StringBuilder();
		if (itCommands != null && itCommands.length() > 0) {
			for (int i = 0; i < itCommands.length(); i++) {
				char itCommand = itCommands.charAt(i);
				switch (itCommand) {
				case 'A':
					if (this.orientation == 'N' || this.orientation == 'S') {
						this.row = this.moveVertical(rowNbr);
					}
					if (this.orientation == 'E' || this.orientation == 'W') {
						this.col = this.moveHorizontal(colNbr);
					}
					break;
				case 'D':
					this.orientation = this.switchOrientation(true);
					break;
				case 'G':
					this.orientation = this.switchOrientation(false);
					break;
				default:
					break;
				}
			}
		}
		mowerNewCoords.append(this.col).append(" ").append(this.row).append(" ").append(this.orientation).append(System.getProperty("line.separator"));
		return mowerNewCoords.toString();
	}

	/**
	 * Switch the orientation of the mower
	 * 
	 * @param forward
	 * @return
	 */
	public char switchOrientation(boolean forward) {
		switch (this.orientation) {
		case 'N':
			return forward ? 'E' : 'W';
		case 'E':
			return forward ? 'S' : 'N';
		case 'S':
			return forward ? 'W' : 'E';
		case 'W':
			return forward ? 'N' : 'S';
		default:
			return this.orientation;
		}
	}

	/**
	 * Move the mower in the vertical direction
	 * 
	 * @param rowNbr
	 * @return
	 */
	public int moveVertical(int rowNbr) {
		if (this.orientation == 'N') {
			return this.row + 1 > rowNbr ? this.row : this.row + 1;
		}
		if (this.orientation == 'S') {
			return this.row - 1 < 0 ? this.row : this.row - 1;
		}
		return this.row;
	}

	/**
	 * Move the mower in the horizontal direction
	 * 
	 * @param colNbr
	 * @return
	 */
	public int moveHorizontal(int colNbr) {
		if (this.orientation == 'E') {
			return this.col + 1 > colNbr ? this.col : this.col + 1;
		}
		if (this.orientation == 'W') {
			return this.col - 1 < 0 ? this.col : this.col - 1;
		}
		return this.col;
	}
}
