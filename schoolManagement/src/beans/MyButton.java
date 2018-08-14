package beans;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JButton;

public class MyButton extends JButton{
	Image i;
	int x;
	int y;
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(i!=null) {
			g.drawImage(i, 0, 0, x, y, null);
		}else {
        final Graphics2D g2d=(Graphics2D)g.create();
        g2d.setColor(new Color(0,0,0,0));
        g2d.fillRect(0,0,getSize().width,getSize().height);
        g2d.dispose();
		}
	}
	
	public void setImage(Image img,int x,int y){
       this.i=img;
       this.x=x;
       this.y=y;
    }
	
}