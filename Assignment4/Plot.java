/*
 * Class: CMSC203 23118
 * Instructor: Huseyin Aygun
 * Description: A plot class for both property class and management company class.
 * Due: 10/27/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Natdanai Boonyaleephan
*/

public class Plot {
	// Initialize position and size of the plot.
	private int x, y, width, depth;
	
	// Constructor for the plot.
	// Empty Constructor
	Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	// Constructor with plot object assigned.
	Plot(int X, int Y, int W, int D) {
		x = X;
		y = Y;
		width = W;
		depth = D;
	}
	
	// Constructor for copying another plot object.
	Plot(Plot another) {
		x = another.x;
		y = another.y;
		width = another.width;
		depth = another.depth;
	}
	
	// Setter & Getter functions for the plot.
	public int getX() {return x;}
	public int getY() {return y;}
	public int getWidth() {return width;}
	public int getDepth() {return depth;}
	
	public void setX(int value) {x = value;}
	public void setY(int value) {y = value;}
	public void setWidth(int value) {width = value;}
	public void setDepth(int value) {depth = value;}
	
	// Check if another plot is overlapping on this current plot.
	public boolean overlaps(Plot another) {
		// Check if right side of current plot is to the right of left side of another plot.
		boolean isRightSideIn = x+width > another.x;
		// Check if left side of current plot is to the left of right side of another plot.
		boolean isLeftSideIn = x < another.x+another.width;
		// Check if down side of current plot is below the up side of another plot.
		boolean isDownSideIn = y+depth > another.y;
		// Check if up side of current plot is above the down side of another plot.
		boolean isUpSideIn = y < another.y+another.depth;
		
		// Return True if another plot is overlapping on the current plot, else False.
		return (isRightSideIn && isLeftSideIn && isDownSideIn && isUpSideIn);
	}
	
	// Check if another plot is fully inside this current plot.
	public boolean encompasses(Plot another) {
		// Check if right side of another plot is to the left or within the right side of current plot.
		boolean isRightSideIn = another.x+another.width <= x+width;
		// Check if left side of another plot is to the right or within the left side of current plot.
		boolean isLeftSideIn = another.x >= x;
		// Check if down side of another plot is above or within the down side of current plot.
		boolean isDownSideIn = another.y+another.depth <= y+depth;
		// Check if up side of another plot is below or within the up side of current plot.
		boolean isUpSideIn = another.y >= y;
		
		// Return True if another plot is fully inside the current plot, else False.
		return (isRightSideIn && isLeftSideIn && isDownSideIn && isUpSideIn);
	}
	
	// Output the information in string format.
	public String toString() {
		return String.format("%s,%s,%s,%s", x, y, width, depth);
	}
}
