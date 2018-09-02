package beans;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class MyComboBox1 extends JComboBox {
	  public MyComboBox1() {
	    super();
	  }
	  @Override public void updateUI() {
	    super.updateUI();
	    UIManager.put("ComboBox.squareButton", Boolean.FALSE);
	    setUI(new BasicComboBoxUI() {
	      @Override protected JButton createArrowButton() {
	        JButton b = new JButton();
	        b.setBorder(BorderFactory.createEmptyBorder());
	        b.setVisible(false);
	        return b;
	      }
	    });
	    setBorder(BorderFactory.createLineBorder(new Color(105,105,105)));
	  }
}