import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
	JFrame frame;
	JPanel pane;
	static String sign = " "; //operator of select buttons
	static 	double num1 = 0, answer = 0;
	static double calc = 0; //to parse strings to doubles
	private JTextField text; //creating JTextField for display
	private JButton  btnAdd,btnSub, btnMult, btnDiv, btnEqual, btnB1, btnB2, btnB3, btnB4,
	btnB5,btnB6, btnB7, btnB8, btnB9, btnB0, btnClr;
	public Calculator(){
	
		frame = new JFrame("Peter's Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane = new JPanel(new GridLayout(4,4));
		text = new JTextField(10);
		btnAdd = new JButton("+");
		btnSub = new JButton("-");
		btnMult = new JButton("*");
		btnDiv = new JButton("/");
		btnClr = new JButton("Clr");
		btnEqual = new JButton("=");
		btnB1 = new JButton("1");
		btnB2 = new JButton("2");
		btnB3 = new JButton("3");
		btnB4 = new JButton("4");
		btnB5 = new JButton("5");
		btnB6 = new JButton("6");
		btnB7 = new JButton("7");
		btnB8 = new JButton("8");
		btnB9 = new JButton("9");
		btnB0 = new JButton("0");

		btnAdd.addActionListener(this);
		btnSub.addActionListener(this);
		btnMult.addActionListener(this);
		btnDiv.addActionListener(this);
		btnClr.addActionListener(this);
		btnEqual.addActionListener(this);
		btnB1.addActionListener(this);
		btnB2.addActionListener(this);
		btnB3.addActionListener(this);
		btnB4.addActionListener(this);
		btnB5.addActionListener(this);
		btnB6.addActionListener(this);
		btnB7.addActionListener(this);
		btnB8.addActionListener(this);
		btnB9.addActionListener(this);
		btnB0.addActionListener(this);
		
		pane.add(btnB9);
		pane.add(btnB8);
		pane.add(btnB7);
		pane.add(btnB6);
		pane.add(btnB5);
		pane.add(btnB4);
		pane.add(btnB3);
		pane.add(btnB2);
		pane.add(btnB1);
		pane.add(btnB0);
		pane.add(btnClr);
		pane.add(btnEqual);
		pane.add(btnAdd);
		pane.add(btnSub);
		pane.add(btnDiv);
		pane.add(btnMult);
		pane.add(text);

		frame.add(pane);
		frame.setLocationRelativeTo(null); //set JPanel to the center of the JFrame
		frame.setVisible(true);
		
	}
	/*logic: 
	 * numbers get appended to the string 
	 */
	//getSource - returns the object that triggered the action event
	//getText returns text with the appended numerical String
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnB1){
			text.setText(text.getText().concat("1"));
		}
		else if(e.getSource()==btnB2){
			text.setText(text.getText().concat("2"));
		}
		else if(e.getSource()==btnB3){
			text.setText(text.getText().concat("3"));
		}
		else if(e.getSource()==btnB4){
			text.setText(text.getText().concat("4"));
		}
		else if(e.getSource()==btnB5){
			text.setText(text.getText().concat("5"));
		}
		else if(e.getSource()==btnB6){
			text.setText(text.getText().concat("6"));
		}
		else if(e.getSource()==btnB7){
			text.setText(text.getText().concat("7"));
		}
		else if(e.getSource()==btnB8){
			text.setText(text.getText().concat("8"));
		}
		else if(e.getSource()==btnB9){
			text.setText(text.getText().concat("9"));
		}
		else if(e.getSource()==btnB0){
			text.setText(text.getText().concat("0"));
		}
		else if(e.getSource() == btnClr){
			text.setText("");
		}
		else if(e.getSource()==btnAdd){
			calc = Double.parseDouble(text.getText());
			sign = "+";
			text.setText("");

		}
		else if(e.getSource()==btnSub){
			calc = Double.parseDouble(text.getText());
			sign = "-";
			text.setText("");

		}
		else if(e.getSource()==btnMult){
			calc = Double.parseDouble(text.getText());
			sign = "*";
			text.setText("");

		}
		else if(e.getSource() == btnDiv){
			calc = Double.parseDouble(text.getText());
			sign = "/";
			text.setText("");

		}
		else if(e.getSource()==btnEqual){
			num1 = Double.parseDouble(text.getText());
			switch(sign){
			case "+":
				answer = calc + num1;
				break;
			
			case "-":
				answer =  calc - num1;
				break;
			case "*":
				answer= calc * num1;
				break;
			case "/" :
				answer = calc / num1;
				if(num1 == 0){
					answer = 0;
				}
				break;
			default : 
				answer = 0;
			}
			text.setText("" + answer);

		}

	
	}
	public static void main(String [] args){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				  new Calculator();
			}
		});
	}
	
		
		
	

}
