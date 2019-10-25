import java.awt.Graphics;
import java.awt.image.BufferedImage;

class Button {
	Rect bounds;
	BufferedImage img;
	int centeringMethod;
	boolean clicked;

	public Button(Rect bounds, BufferedImage img, int centeringMethod) {
		super();
		this.bounds = bounds;
		this.img = img;
		this.centeringMethod = centeringMethod;
	}
	public void update(boolean[] mouse, Point mPos) {
		if(mouse[1] && mPos.inside(bounds)) {
			clicked = true;
		}else {
			clicked = false;
		}
	}
	public void draw(Graphics g) {
		g.drawImage(img, bounds.pos.x, bounds.pos.y, bounds.h, bounds.w, null);
		g.drawRoundRect(bounds.pos.x, bounds.pos.y, bounds.w, bounds.h, 10, 10);
	}

}