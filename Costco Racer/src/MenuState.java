import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MenuState extends State{
Point mPos; 
Button b1;
boolean[] keys = new boolean[300];
boolean[] keysToggled = new boolean[300];
boolean[] mouse = new boolean[200];
BufferedImage img;
	@Override
	void update() {
		mPos = CostcoRacerMain.getmPos();
		keys = CostcoRacerMain.getKeys();
		keysToggled = CostcoRacerMain.getKeysToggled();
		mouse = CostcoRacerMain.getMouse();
		b1.update(mouse, mPos);
		
	}

	@Override
	void draw(Graphics g) {
		b1.draw(g);
		
	}

	@Override
	void init() {
		mPos = CostcoRacerMain.getmPos();
		keys = CostcoRacerMain.getKeys();
		keysToggled = CostcoRacerMain.getKeysToggled();
		mouse = CostcoRacerMain.getMouse();
		img = Misc.loadImage("/strawberry.png");
		b1 = new Button(new Rect(500,500,100,100), img,0);
			
	}

}
