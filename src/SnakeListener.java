import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeListener  implements ActionListener, KeyListener{
	
	private static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

	@Override
	public void actionPerformed(ActionEvent arg0){
		Snake snake = Snake.getSnake();
		snake.getPanel().repaint();
		snake.setTicks(snake.getTicks()+1);
		if (snake.getTicks() % 2 == 0 && snake.getHead() != null && !snake.isOver() && !snake.isPaused())
		{
			snake.setTime(snake.getTime()+1);
			snake.getSnakeParts().add(new Point(snake.getHead().x, snake.getHead().y));
			if (snake.getDirection() == UP){
				if (snake.getHead().y - 1 >= 0 && snake.noTailAt(snake.getHead().x, snake.getHead().y - 1))
					snake.setHead(new Point(snake.getHead().x, snake.getHead().y - 1));
				else
					snake.setOver(true);
			}
			if (snake.getDirection() == DOWN){
				if (snake.getHead().y + 1 < 67 && snake.noTailAt(snake.getHead().x, snake.getHead().y + 1))
					snake.setHead(new Point(snake.getHead().x, snake.getHead().y + 1));
				else
					snake.setOver(true);
			}
			if (snake.getDirection() == LEFT){
				if (snake.getHead().x - 1 >= 0 && snake.noTailAt(snake.getHead().x - 1, snake.getHead().y))
					snake.setHead(new Point(snake.getHead().x - 1, snake.getHead().y));
				else
					snake.setOver(true);
			}
			if (snake.getDirection() == RIGHT){
				if (snake.getHead().x + 1 < 80 && snake.noTailAt(snake.getHead().x + 1, snake.getHead().y))
					snake.setHead(new Point(snake.getHead().x + 1, snake.getHead().y));
				else
					snake.setOver(true);
			}
			if (snake.getSnakeParts().size() > snake.getTailLength())
				snake.getSnakeParts().remove(0);
			if (snake.getCherry() != null){
				if (snake.getHead().equals(snake.getCherry())){
					snake.setScore(snake.getScore()+10);
					snake.setTailLength(snake.getTailLength()+1);
					snake.getCherry().setLocation(snake.getRandom().nextInt(79), snake.getRandom().nextInt(66));
				}
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		Snake snake = Snake.getSnake();
		int i = e.getKeyCode();
		if ((i == KeyEvent.VK_A || i == KeyEvent.VK_LEFT) && snake.getDirection() != RIGHT)
			snake.setDirection(LEFT);
		if ((i == KeyEvent.VK_D || i == KeyEvent.VK_RIGHT) && snake.getDirection() != LEFT)
			snake.setDirection(RIGHT);
		if ((i == KeyEvent.VK_W || i == KeyEvent.VK_UP) && snake.getDirection() != DOWN)
			snake.setDirection(UP);
		if ((i == KeyEvent.VK_S || i == KeyEvent.VK_DOWN) && snake.getDirection() != UP)
			snake.setDirection(DOWN);
		if (i == KeyEvent.VK_SPACE){
			if (snake.isOver())
				snake.startGame();
			else
				snake.setPaused(!snake.isPaused());
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		
	}

	@Override
	public void keyTyped(KeyEvent e){
		
	}
}
