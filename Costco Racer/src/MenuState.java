import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MenuState extends State{
Point mPos; 
Button b1;
Slider s1;
boolean[] keys = new boolean[300];
boolean[] keysToggled = new boolean[300];
boolean[] mouse = new boolean[200];
BufferedImage img;
BufferedImage titleImage;
BufferedImage titleImage2;
Font f;
	@Override
	void update() {
		mPos = CostcoRacerMain.getmPos();
		keys = CostcoRacerMain.getKeys();
		keysToggled = CostcoRacerMain.getKeysToggled();
		mouse = CostcoRacerMain.getMouse();
		b1.update(mouse, mPos);
		s1.update(mouse, mPos);
		
	}

	@Override
	void draw(Graphics g) {
		g.setFont(f);
		//g.setColor(new Color((int)(s1.value*255), (int)(s1.value*255), (int)(s1.value*255)));
		//g.fillRect(0, 0, 1000, 1000);
		b1.draw(g, 20, 75);
		s1.draw(g);
		
		g.drawImage(titleImage2, 30, 50, (int)(titleImage.getWidth()/.75), (int) (titleImage.getHeight()/1), null);
		g.drawImage(titleImage, 75, 200, titleImage.getWidth()/2, titleImage.getHeight()/2, null);
		
		
	}

	@Override
	void init() {
		mPos = CostcoRacerMain.getmPos();
		keys = CostcoRacerMain.getKeys();
		keysToggled = CostcoRacerMain.getKeysToggled();
		mouse = CostcoRacerMain.getMouse();
		img = Misc.loadImage("/strawberry.png");
		titleImage = Misc.loadImage("/ShopperRunning.png");
		titleImage2 = Misc.loadImage("/costcoRacerPic.png");
		f = CostcoRacerMain.f;
		b1 = new Button(new Rect(500,500,260,100), null,0, "Start", f, Color.GREEN);
		s1 = new Slider(new Point(100,50),200,Color.green,15,30, 0);
		
			
	}

}
