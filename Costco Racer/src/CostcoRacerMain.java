import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import sun.applet.Main;

public class CostcoRacerMain extends JPanel
		implements ActionListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	private static final long serialVersionUID = 1L;
	int screenWidth = 1000;
	int screenHeight = 1000;
	static boolean[] keys = new boolean[300];
	static boolean[] keysToggled = new boolean[300];
	static boolean[] mouse = new boolean[200];
	static boolean[] mouseReleased = new boolean[20];
	static Point mPos;
	MenuState m = new MenuState();
	SettingsState settings = new SettingsState();
	GameState game = new GameState();
	static Font f = new Font("Press Start", 0, 48);
	static int state = 0;

	// ============== end of settings ==================

	public void paint(Graphics g) {
		super.paintComponent(g);
		if(state == 0) m.draw(g);
		if(state == 1) game.draw(g);
		if(state == 2) settings.draw(g);

	}

	public void update() throws InterruptedException {
		mPos = getMousePos();
		//System.out.println(mPos.toStr());
		if(state == 0) m.update();
		if(state == 1) game.update();
		if(state == 2) settings.update();

		for(boolean b : mouseReleased) {
			if(b) System.out.println(b);
			b = false;
		}
	}

	private void init() {
		GraphicsEnvironment ge = null;
	    try{
	      ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	      ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("prstart.TTF")));
	    } catch(FontFormatException e){} catch (IOException e){}
//		for(String s : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()) {
//			System.out.println(s);
//		}
		m.init();
		settings.init();
		game.init();

	}

	// ==================code above ===========================

	public static boolean[] getKeys() {
		return keys;
	}

	public static boolean[] getKeysToggled() {
		return keysToggled;
	}

	public static boolean[] getMouse() {
		return mouse;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			update();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();
	}

	public static Point getmPos() {
		return mPos;
	}

	public Point getMousePos() {
		try {
			return new Point(this.getMousePosition().x, this.getMousePosition().y);
		} catch (Exception e) {
			return mPos;
		}
	}

	public static void main(String[] arg) {
		@SuppressWarnings("unused")
		CostcoRacerMain d = new CostcoRacerMain();
	}

	public CostcoRacerMain() {
		JFrame f = new JFrame();
		f.setTitle("Costco Racer");
		f.setSize(screenWidth, screenHeight);
		f.setBackground(Color.BLACK);
		f.setResizable(false);
		f.addKeyListener(this);
		f.addMouseMotionListener(this);
		f.addMouseWheelListener(this);
		f.addMouseListener(this);

		f.add(this);

		init();

		t = new Timer(15, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	Timer t;

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;

	}

	@Override
	public void keyReleased(KeyEvent e) {

		keys[e.getKeyCode()] = false;

		if (keysToggled[e.getKeyCode()]) {
			keysToggled[e.getKeyCode()] = false;
		} else {
			keysToggled[e.getKeyCode()] = true;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouse[e.getButton()] = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouse[e.getButton()] = false;
		mouseReleased[e.getButton()] = true;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouse[e.getButton()] = true;

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

}

class Point {
	int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double distanceTo(Point p2) {
		return Math.sqrt((this.x - p2.x) * (this.x - p2.x) + (this.y - p2.y) * (this.y - p2.y));
	}

	public double angleTo(Point p2) {
		try {
			return Math.atan2(this.y - p2.y, this.x - p2.x);
		} catch (Exception e) {

		}
		return 0;
	}

	public boolean inside(Rect r) {
		return (x > r.pos.x && x < r.pos.x + r.w && y > r.pos.y && y < r.pos.y + r.h);
	}

	public String toStr() {
		return ("(" + this.x + ", " + this.y + ")");
	}
}

class Rect {
	Point pos;
	int h, w;

	public Rect(int x, int y, int w, int h) {

		this.pos = new Point(x, y);
		this.h = h;
		this.w = w;

	}

	public boolean intersects(Rect r) {
		return (pos.inside(r) || new Point(pos.x + w, pos.y).inside(r) || new Point(pos.x + w, pos.y + h).inside(r)
				|| new Point(pos.x, pos.y + h).inside(r));
	}
}
