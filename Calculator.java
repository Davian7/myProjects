import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Calculator implements ActionListener {
	JFrame frame;
	JPanel panel1, panel2, panel3;
	
	// declaring buttons globally to gain access later on.
	private JButton jbtNum1, jbtNum2, jbtNum3, jbtNum4, jbtNum5, jbtNum6,  jbtNum7, jbtNum8, 
					jbtNum9, jbtNum0, jbtEqual, jbtMultiply, jbtAdd, jbtSubtract, jbtDivide, jbtClear;
	    
	private JTextField jtfResult; // declared textfield 
	private String operator = "";
	private String display = ""; //operator of select buttons
	double num1 = 0, result = 0, calc = 0;
	 
	public Calculator() { // constructor for initializing the instance variables
		frame = new JFrame("Davian's Kalc");
			panel1 = new JPanel(); //first Jpanel to populate the button from 1 -9 and 0 and c
				panel1.setLayout(new GridLayout(4,1));
				panel1.add(jbtNum1 = new JButton("1"));
				panel1.add(jbtNum2 = new JButton("2"));
				panel1.add(jbtNum3 = new JButton("3"));
				panel1.add(jbtNum4 = new JButton("4"));
				panel1.add(jbtNum5 = new JButton("5"));
				panel1.add(jbtNum6 = new JButton("6"));
				panel1.add(jbtNum7 = new JButton("7"));
				panel1.add(jbtNum8 = new JButton("8"));
				panel1.add(jbtNum9 = new JButton("9"));
				panel1.add(jbtNum0 = new JButton("0"));
				panel1.add(jbtClear = new JButton("C"));
				panel1.setBackground(Color.GREEN); 		
	            
			panel2 = new JPanel(); // second panel to hold the text input to showcase the numbers and to get the answer
        		panel2.setLayout(new FlowLayout()); // layout of how the textfield should look
        		panel2.add(jtfResult = new JTextField(20)); 
        		panel2.setBackground(Color.yellow);		
		       
        	panel3 = new JPanel(); // third panel is to hold the operators sign for later calculation
        		panel3.setLayout(new FlowLayout());
        		panel3.add(jbtAdd = new JButton("+"));
        		panel3.add(jbtSubtract = new JButton("-"));
        		panel3.add(jbtMultiply = new JButton("*"));
        		panel3.add(jbtDivide = new JButton("/"));
        		panel3.add(jbtEqual = new JButton("="));
        		panel3.setBackground(Color.ORANGE);		
		        
        		// this shows what button is clickable 
        		jbtNum1.addActionListener(this);
        		jbtNum2.addActionListener(this);
        		jbtNum3.addActionListener(this);
        		jbtNum4.addActionListener(this);
        		jbtNum5.addActionListener(this);
        		jbtNum6.addActionListener(this);
        		jbtNum7.addActionListener(this);
        		jbtNum8.addActionListener(this);
        		jbtNum9.addActionListener(this);
        		jbtNum0.addActionListener(this);

        		jbtAdd.addActionListener(this);
        		jbtSubtract.addActionListener(this);
        		jbtMultiply.addActionListener(this);
        		jbtDivide.addActionListener(this);
        		jbtEqual.addActionListener(this);
        		jbtClear.addActionListener(this);       
		
	     frame.add(panel1, BorderLayout.SOUTH);
	     frame.add(panel2, BorderLayout.NORTH);
	     frame.add(panel3, BorderLayout.EAST);
	     
		 frame.setSize(400, 210); // size of the Jframe
	     frame.setLocationRelativeTo(null); // set the location of the frame in the center
		 frame.setVisible(true);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 

	@Override
	public void actionPerformed(ActionEvent e) {
		 JButton btnClicked = (JButton) e.getSource();
		 	if(btnClicked == jbtNum1){
		 		display = jtfResult.getText();
		        jtfResult.setText(display + "1");
		 	}
		
		 	else if(btnClicked == jbtNum2){
		 		display = jtfResult.getText();
		        jtfResult.setText(display + "2");
		 	}
		 	else if(btnClicked == jbtNum3){
		 		display = jtfResult.getText();
		        jtfResult.setText(display + "3");
		 	}
		 	else if(btnClicked == jbtNum4){
		 		display = jtfResult.getText();
		        jtfResult.setText(display + "4");
		 	}
		 	else if(btnClicked == jbtNum5){
		 		display = jtfResult.getText();
		        jtfResult.setText(display + "5");
		 	}
		 	else if(btnClicked == jbtNum6){
		 		display = jtfResult.getText();
		        jtfResult.setText(display + "6");
		 	}
		 	else if(btnClicked == jbtNum7){
		 		display = jtfResult.getText();
		        jtfResult.setText(display + "7");
		 	}
		 	else if(btnClicked == jbtNum8){
		 		display = jtfResult.getText();
		        jtfResult.setText(display + "8");
		 	}
		 	else if(btnClicked == jbtNum9){
		 		display = jtfResult.getText();
		        jtfResult.setText(display + "9");
		 	}
		 	else if(btnClicked == jbtNum0){
		 		display = jtfResult.getText();
		        jtfResult.setText(display + "0");
		 	}
	     
		 	else if(btnClicked == jbtClear){
		 		jtfResult.setText("");
		 	}
		 	
		 	else if(btnClicked == jbtAdd){
		 		calc = Integer.parseInt(jtfResult.getText());
		 		operator = "+";
		 		jtfResult.setText("");
		 	}
			 
		 	else if(btnClicked == jbtSubtract){
		 		calc = Integer.parseInt(jtfResult.getText());
		 		operator = "-";
		 		jtfResult.setText("");
		 	}
		 	else if(btnClicked == jbtMultiply){
		 		calc = Integer.parseInt(jtfResult.getText());
		 		operator = "*";
		 		jtfResult.setText("");
		 	}
		 	else if(btnClicked == jbtDivide){
		 		calc = Integer.parseInt(jtfResult.getText());
		 		operator = "/";
		 		jtfResult.setText("");
		 	}
		 	else if(btnClicked == jbtEqual){
		 		num1 = Integer.parseInt(jtfResult.getText());
		 		if(operator == "+")
		 			result = calc + num1;
		 			
		 		else if(operator == "-")
		 			result = calc - num1;
		 		
		 		else if(operator == "*")
		 			result = calc * num1;
		 		
		 		else if(operator == "/") {
		 			result = calc / num1;
		 			if(num1 == 0)
		 				result = 0;
		 		}
		 		jtfResult.setText (result + " ");
		 	}
	}	
		 	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new Calculator();
			}
		});
	}
} 




















