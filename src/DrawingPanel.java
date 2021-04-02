import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawingPanel extends JPanel {

	private Rectangle rectangle;
	private Timer timer;
	int xDirection = 1;
	int yDirection = 1;

	public DrawingPanel(){
		super();
		this.setSize(1000,900);
		this.setPreferredSize(new Dimension(1000,900));
		this.setBackground(Color.white);
		rectangle = new Rectangle();
		rectangle.setLocation(10, 100);
		timer = new Timer(5, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{	
				if(rectangle.getXLocation()+rectangle.getWidth() >= getWidth())
				{
					xDirection = -1;
					changeColor();
				}
				else if(rectangle.getXLocation() == 0)
				{
					xDirection = 1;
					changeColor();
				}
				else if(rectangle.getYLocation()+rectangle.getHeight() >= getHeight())
				{
					yDirection = -1;
					changeColor();
				}
				else if((rectangle.getYLocation() == 0))
				{
					yDirection = 1;
					changeColor();
				}
				
				move(2,2, xDirection, yDirection);
				repaint();
			}
		});
		timer.start();
	}
	
	public void move(int dx, int dy, int xDirection, int yDirection)
	{
		rectangle.setLocation(rectangle.getXLocation() + dx*xDirection, rectangle.getYLocation() + dy*yDirection);
	}
	
	public void changeColor()
	{
		Color randomColor = new Color((int)(Math.random() * 0x1000000));
		rectangle.setColor(randomColor);
	}


	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D brush = (Graphics2D) g; //local variable of type Grahics2D
		rectangle.paint(brush);
	}
}
