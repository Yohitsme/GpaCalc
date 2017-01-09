package package1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class General implements ActionListener{
	
	public Scanner reader = new Scanner(System.in);
	public static JFrame frame = new JFrame("GPA Calculator");
	public boolean run = true;
	public int count = 0;
	public static String number;
	JLabel imageLabel = new JLabel();
	JTextField textField = new JTextField(10);
	JLabel label = new JLabel("Number of courses: ");
	JLabel label2 = new JLabel("GPA: ");
	JButton button1 = new JButton("SUBMIT");
	JButton button2 = new JButton("Calculate");
	ArrayList<JTextField> buttonArray = new ArrayList<>();
	JPanel bars = new JPanel();
	JPanel info = new JPanel();
	JPanel last = new JPanel();
	
	
	public General(){
		frame.setVisible(true);
		frame.setSize(400, 100);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label.setFont(new Font("Verdana",1,20));
		label2.setFont(new Font("Verdana",1,20));

		
		info.add(label);
		info.add(textField);
		frame.add(button1, BorderLayout.CENTER);
		frame.add(info, BorderLayout.PAGE_START);
		button1.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		if (name == "SUBMIT"){
			number = textField.getText();
			frame.setSize(350, 350);
			frame.setResizable(true);

			frame.remove(button1);
			info.remove(textField);
			frame.add(bars, BorderLayout.CENTER);
			frame.add(last, BorderLayout.PAGE_END);
			last.add(button2, new FlowLayout());
			last.add(label2, new FlowLayout());
			button2.addActionListener(this);
			label.setText(number + " courses");
			for (int i = 0; i < Integer.valueOf(number); i++){
				buttonArray.add(new JTextField(5));
			}
			for (JTextField item: buttonArray){
				bars.add(item);
			}
		}
		if (name == "Calculate"){
			Calculator.conversion(evaluate());
			label2.setText("GPA: " + Calculator.calculate());
		}
	}
	
	public ArrayList<Integer> evaluate(){
		ArrayList<Integer> markList = new ArrayList<>();
		markList.clear();
		for (JTextField items : buttonArray){
			markList.add(Integer.valueOf(items.getText()));
		}
		System.out.println(markList);
		return markList;
	}
	
	public static void main(String args[]){
		General general = new General();
		
	}

}