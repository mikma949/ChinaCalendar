package calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GetUserInputSwing extends JPanel {

	JTextField jyear, jmonth, jday;
	JTextArea jresult;
	int width = 300;
	int height = 30;

	public GetUserInputSwing() {

		initUI();

	}

	public final void initUI() {

		setLayout(new FlowLayout());
		jyear = new JTextField();
		jmonth = new JTextField();
		jday = new JTextField();
		jresult = new JTextArea();

		JLabel yearLable, monthLable, dayLable, resultLable;
		yearLable = new JLabel("Year:");
		monthLable = new JLabel("Month:");
		dayLable = new JLabel("Day:");
		resultLable = new JLabel("Result:");

		jyear.setPreferredSize(new Dimension(width, height));
		jyear.setBorder(BorderFactory.createLineBorder(Color.black));

		jmonth.setPreferredSize(new Dimension(width, height));
		jmonth.setBorder(BorderFactory.createLineBorder(Color.black));

		jday.setPreferredSize(new Dimension(width, height));
		jday.setBorder(BorderFactory.createLineBorder(Color.black));

		jresult.setPreferredSize(new Dimension(width, 3 * height));
		jresult.setBorder(BorderFactory.createLineBorder(Color.black));
		jresult.setEditable(false);

		JButton button = new JButton("Next day");

		add(yearLable);
		add(jyear);
		add(monthLable);
		add(jmonth);
		add(dayLable);
		add(jday);
		add(button);
		// add(resultLable);
		add(jresult);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				getInput();
			}

		});

	}

	private void getInput() {
		// TODO Auto-generated method stub
		MyCalendar cal = new MyCalendar();

		try {

			if (!cal.setYear(Integer.parseInt(jyear.getText()))) {
				jresult.setText("Year has to be between " + cal.getMinYear()
						+ "-" + cal.getMaxYear());
			}
			if (!cal.setMonth(Integer.parseInt(jmonth.getText()))) {
				jresult.setText("Month has to be between 1-12");
			}
			if (!cal.setDay(Integer.parseInt(jday.getText()))) {
				jresult.setText("Day has to be between 1-"
						+ cal.getDaysInMonth());
			}
			if (cal.validate())
				output(cal);
			
		} catch (NullPointerException n) {
			jresult.setText("Date is out of bounds");
		} catch (Exception e) {
			// TODO: handle exception
			jresult.setText("Invalid input");
			System.out.println(e.toString());
		}
	}

	private void output(MyCalendar c) throws Exception {
		int[] date;
		// date = c.getDate();
		
		//If date is out of bounds returns {0,0,0}
		date = c.getNextDate();
		int[] zero = { 0, 0, 0 };
		if (Arrays.equals(date, zero)) {
			throw new NullPointerException();
		}
		Weekday w = new Weekday(c);
		// Skriv till GUI
		jresult.setText("Tomorrow is a " + w.getWeekday() + "\n"
				+ " and the date is: " + c.getYear() + "-" + c.getMonth() + "-"
				+ c.getDay());

		consolePrint(c, w);

	}

	private void consolePrint(MyCalendar c, Weekday w) {
		// TODO Auto-generated method stub
		int[] date;
		date = c.getDate();
		System.out.print(w.getWeekday() + "-");
		for (int j = 0; j < date.length; j++) {

			System.out.print(Integer.toString(date[j]) + "-");
		}
		System.out.println(c.getYear() + "-" + c.getMonth() + "-" + c.getDay());

		// Compare with Java
		String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday",
				"Thursday", "Friday", "Saturday" };
		Calendar calendar = Calendar.getInstance();
		calendar.set(c.getYear(), c.getMonth() - 1, c.getDay());
		int i = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH);
		System.out.println("Java day: " + days[i]);
		System.out.println("------------------------");
	}

	public void createAndShowGUI() {
		// Make sure we have nice window decorations.
		JFrame.setDefaultLookAndFeelDecorated(true);

		// Create and set up the window.
		JFrame frame = new JFrame("GetNextDay");
		frame.setPreferredSize(new Dimension((width + 20), 12 * height));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		JComponent newContentPane = new GetUserInputSwing();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

}