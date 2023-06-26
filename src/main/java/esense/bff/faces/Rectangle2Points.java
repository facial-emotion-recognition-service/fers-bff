package esense.bff.faces;

public class Rectangle2Points {

	private final int top;
	private final int right;
	private final int bottom;
	private final int left;

	public Rectangle2Points(int top, int right, int bottom, int left) {
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.left = left;
	}

	public int getTop() {
		return top;
	}

	public int getRight() {
		return right;
	}

	public int getBottom() {
		return bottom;
	}

	public int getLeft() {
		return left;
	}

	@Override
	public String toString() {
		return "Rectangle2Points [top=" + top + ", right=" + right + ", bottom=" + bottom + ", left=" + left + "]";
	}

}
