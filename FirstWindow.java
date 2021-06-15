import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FirstWindow extends JFrame{
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 90;
	
	public FirstWindow(String name)
	{
		super(name);
		super.setSize(WIDTH, HEIGHT);
		JLabel myLabel1 = new JLabel("There is no data that corresponds to input data in the data_base(text.txt).");
		JLabel myLabel2 = new JLabel("So program will be terminated!");
		getContentPane().add(myLabel1);
		getContentPane().add(myLabel2);
		getContentPane().setLayout(new FlowLayout());
		setSize(WIDTH, HEIGHT);
		WindowDestroyer listener = new WindowDestroyer();
		addWindowListener(listener);
	}
	
	

}
