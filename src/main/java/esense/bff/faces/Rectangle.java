package esense.bff.faces;

public record Rectangle (int x, int y, int w, int h) {

	@Override
	public String toString() {
		return "Rectangle [x=" + x + ", y=" + y + ", w=" + w + ", h=" + h + "]";
	}

}

