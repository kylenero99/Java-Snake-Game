import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Snake{

	private static Snake snake;
	private JFrame jframe;
	private static SnakeListener s = new SnakeListener();
	private SnakePanel panel;
	private Timer timer = new Timer(20, s);
	private ArrayList<Point> snakeParts = new ArrayList<Point>();
	private static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, SCALE = 10;
	private int ticks = 0, direction = DOWN, score, tailLength = 10, time;
	private Point head, cherry;
	private Random random;
	private boolean over = false, paused;
	private Dimension dim;
	
	public Snake(){
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		jframe = new JFrame("Snake");
		jframe.setVisible(true);
		jframe.setSize(805, 700);
		jframe.setResizable(false);
		jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
		jframe.add(panel = new SnakePanel());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.addKeyListener(s);
		startGame();
	}

	public void startGame(){
		over = false;
		paused = false;
		time = 0;
		score = 0;
		tailLength = 14;
		ticks = 0;
		direction = DOWN;
		head = new Point(0, -1);
		random = new Random();
		snakeParts.clear();
		cherry = new Point(random.nextInt(79), random.nextInt(66));
		timer.start();
	}
	
	public boolean noTailAt(int x, int y){
		for (Point point : snakeParts)
			if (point.equals(new Point(x, y)))
				return false;
		return true;
	}

	public static void main(String[] args){
		snake = new Snake();
	}

	public static Snake getSnake() {
		return snake;
	}

	public static void setSnake(Snake snake) {
		Snake.snake = snake;
	}

	public JFrame getJframe() {
		return jframe;
	}

	public void setJframe(JFrame jframe) {
		this.jframe = jframe;
	}

	public SnakePanel getPanel() {
		return panel;
	}

	public void setPanel(SnakePanel panel) {
		this.panel = panel;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public ArrayList<Point> getSnakeParts() {
		return snakeParts;
	}

	public void setSnakeParts(ArrayList<Point> snakeParts) {
		this.snakeParts = snakeParts;
	}

	public int getTicks() {
		return ticks;
	}

	public void setTicks(int ticks) {
		this.ticks = ticks;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTailLength() {
		return tailLength;
	}

	public void setTailLength(int tailLength) {
		this.tailLength = tailLength;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Point getHead() {
		return head;
	}

	public void setHead(Point head) {
		this.head = head;
	}

	public Point getCherry() {
		return cherry;
	}

	public void setCherry(Point cherry) {
		this.cherry = cherry;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public boolean isOver() {
		return over;
	}

	public void setOver(boolean over) {
		this.over = over;
	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public Dimension getDim() {
		return dim;
	}

	public void setDim(Dimension dim) {
		this.dim = dim;
	}

	public static int getScale() {
		return SCALE;
	}
}