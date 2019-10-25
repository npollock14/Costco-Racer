public class Camera {
	int xOff, yOff, screenW, screenH;
	double scale;
	Point center;
	float scaleNotches = 0;
	float targetScale;

	public Camera(int xOff, int yOff, double scale, int screenW, int screenH) {
		super();
		this.xOff = xOff;
		this.yOff = yOff;
		this.scale = scale;
		this.screenW = screenW;
		this.screenH = screenH;
		center = new Point(screenW / 2, screenH / 2);
	}

	public void focus(Point p) {
		xOff = screenW / 2 - p.x;
		yOff = screenH / 2 - p.y;
	}

	public void changeScale(float notches) {
		scaleNotches += notches;
		scale = Math.pow(2, scaleNotches);
	}

	public int toXScreen(int x) {
		int dx = (int) ((x + xOff - center.x) * scale);
		return (center.x + dx);
	}

	public int toYScreen(int y) {
		int dy = (int) ((y + yOff - center.y) * scale);
		return (center.y + dy);
	}

	public int toXMap(int x) {
		return (int) ((x - center.x) / scale) + center.x - xOff;
	}

	public int toYMap(int y) {
		return (int) ((y - center.y) / scale) + center.y - yOff;
	}
}