import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SettingsState extends State{
Point mPos; 
Button bMenu;
boolean[] keys = new boolean[300];
boolean[] keysToggled = new boolean[300];
boolean[] mouse = new boolean[200];
boolean[] mouseReleased = new boolean[200];
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
		bMenu.update(mouse, mPos, mouseReleased);
		
		if(bMenu.clicked) CostcoRacerMain.state = 0;
		
	}

	@Override
	void draw(Graphics g) {
		g.setFont(f);
		//g.setColor(new Color((int)(s1.value*255), (int)(s1.value*255), (int)(s1.value*255)));
		//g.fillRect(0, 0, 1000, 1000);
		bMenu.draw(g, 20, 75);
		
	}

	@Override
	void init() {
		mPos = CostcoRacerMain.getmPos();
		keys = CostcoRacerMain.getKeys();
		keysToggled = CostcoRacerMain.getKeysToggled();
		mouse = CostcoRacerMain.getMouse();
		f = CostcoRacerMain.f;
		bMenu = new Button(new Rect(10,10,260,100), null,0, "Back", f, Color.GREEN, true);		
			
	}

}
