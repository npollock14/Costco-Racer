import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MenuState extends State{
Point mPos; 
Button b1;
Button b2;
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
		b2.update(mouse, mPos);
		
	}

	@Override
	void draw(Graphics g) {
		g.setFont(f);
		//g.setColor(new Color((int)(s1.value*255), (int)(s1.value*255), (int)(s1.value*255)));
		//g.fillRect(0, 0, 1000, 1000);
		b1.draw(g, 20, 75);
		b2.draw(g, 20, 75);
		
		g.drawImage(titleImage2, 30, 10, (int)(titleImage.getWidth()/.75), (int) (titleImage.getHeight()/1), null);
		g.drawImage(titleImage, 30, 450, titleImage.getWidth()/2, titleImage.getHeight()/2, null);
		
		
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
		b1 = new Button(new Rect(470,500,260,100), null,0, "Start", f, Color.GREEN, true);
		b2 = new Button(new Rect(400,640,410,100), null,0, "Settings", f, Color.GREEN, true);
		
			
	}

}
