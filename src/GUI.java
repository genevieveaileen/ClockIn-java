import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class GUI extends JFrame implements ActionListener {
	//gui design
	
	//variables
	private JFrame frame;
	
	private JPanel pn1;
	private JLabel timerlbl;
	
	private JPanel pn2;
	private Button inBtn;
	private Button outBtn;
	
	private JPanel pn3;
	private JTextArea outputlbl;
	
	private LocalTime timeIN;
	private LocalTime timeOUT;
	//private long timeINconversion;
	//private long timeOUTconversion;
	//private long totalTime;
	//private LocalTime totalTime;
	private int hour;
	private int minute;
	private int second;
	
	//constructors
	public GUI()
	{
		frame = new JFrame("ClockIn Test");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//stuff in panel 1
		pn1 = new JPanel();
		timerlbl = new JLabel("00:00:00");
		pn1.add(timerlbl);
		
		//stuff in panel 2
		pn2 = new JPanel();
		inBtn = new Button("Clock In");
		outBtn = new Button("Clock Out");
		inBtn.addActionListener(this);
		outBtn.addActionListener(this);
		pn2.add(inBtn);
		pn2.add(outBtn);
		
		//stuff in panel 3
		pn3 = new JPanel();
		outputlbl = new JTextArea(10, 22);
		pn3.add(outputlbl);
		
		frame.getContentPane().add(pn1, BorderLayout.NORTH);
		frame.getContentPane().add(pn2, BorderLayout.SOUTH);
		frame.getContentPane().add(pn3, BorderLayout.CENTER);
		frame.pack();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == inBtn)
		{
			timerlbl.setText("Clocked in.");
			timeIN = LocalTime.now();
			System.out.println(timeIN);
		}
		else if (e.getSource() == outBtn)
		{
			timerlbl.setText("Clocked out.");
			timeOUT = LocalTime.now();
			System.out.println(timeOUT);
			
			//totalTime = timeOUT.
			hour = timeOUT.getHour() - timeIN.getHour();
			minute = timeOUT.getMinute() - timeIN.getMinute();
			second = timeOUT.getSecond() - timeIN.getSecond();
			
			outputlbl.append("Date: " + LocalDate.now());
			outputlbl.append("\nStart Time: " + timeIN
					+ "\nEnd Time: " + timeOUT + "\n");
			outputlbl.append("Total Time: " + hour + " hours " + minute + " minute " 
					+ second + " seconds\n\n");
		}
	}
	
	
	
	
	
}
