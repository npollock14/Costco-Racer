import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MenuState extends State{
Point mPos; 
Button b1;
boolean[] keys = new boolean[300];
boolean[] keysToggled = new boolean[300];
boolean[] mouse = new boolean[200];
BufferedImage img;
Font f;
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
		g.setFont(f);
		b1.draw(g, 20, 75);
		
	}

	@Override
	void init() {
		mPos = CostcoRacerMain.getmPos();
		keys = CostcoRacerMain.getKeys();
		keysToggled = CostcoRacerMain.getKeysToggled();
		mouse = CostcoRacerMain.getMouse();
		img = Misc.loadImage("/strawberry.png");
		b1 = new Button(new Rect(500,500,260,100), null,0, "Start", f, Color.GREEN);
		f = CostcoRacerMain.f;
			
	}

}
