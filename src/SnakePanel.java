import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class SnakePanel extends JPanel{

	public static final Color GREEN = new Color(34,139,34);
	private static final int SCALE = 10;
	
	@Override
	protected void paintComponent(Graphics g)	{
		super.paintComponent(g);		
		Snake snake = Snake.getSnake();
		g.setColor(GREEN);
		g.fillRect(0, 0, 800, 700);
		
		//Drawing snake
		g.setColor(Color.BLUE);
		for (Point point : snake.getSnakeParts())
			g.fillRect(point.x * SCALE, point.y * SCALE, SCALE, SCALE);
		g.fillRect(snake.getHead().x * SCALE, snake.getHead().y * SCALE, SCALE, SCALE);
		
		//Cherry
		g.setColor(Color.RED);
		g.fillRect(snake.getCherry().x * SCALE, snake.getCherry().y * SCALE, SCALE, SCALE);
		
		//Drawing text
		String string = "Score: " + snake.getScore() + ", Length: " + snake.getTailLength() + ", Time: " + snake.getTime() / 20;
		g.setColor(Color.white);
		g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), 10);
		string = "WASD to move, Space to pause and restart";
		g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), getHeight() - 20);
		string = "Game Over!";
		if (snake.isOver())
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.getDim().getHeight() / 4);
		string = "Paused!";
		if (snake.isPaused() && !snake.isOver())
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.getDim().getHeight() / 4);
		
	}
}