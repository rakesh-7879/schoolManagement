package beans;

import java.awt.*;

import javax.swing.*;

public class MyPanel extends JPanel {
	Image i;
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(i!=null) {
			g.drawImage(i, 0, 0, getSize().width, getSize().height, null);
		}else {
        final Graphics2D g2d=(Graphics2D)g.create();
        g2d.setColor(new Color(0,0,0,0));
        g2d.fillRect(0,0,getSize().width,getSize().height);
        g2d.dispose();
		}
	}
	public void setImage(Image x){
       this.i=x;
    }
	
}