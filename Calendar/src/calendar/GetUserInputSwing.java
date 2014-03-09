package calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GetUserInputSwing extends JPanel {

	JTextField year, month, day, result;

	public GetUserInputSwing() {

		initUI();

	}

	public final void initUI() {

		setLayout(new FlowLayout());
		year = new JTextField();
		month = new JTextField();
		day = new JTextField();
		result = new JTextField();

		JLabel yearLable, monthLable, dayLable, resultLable;
		yearLable = new JLabel("Year:");
		monthLable = new JLabel("Month:");
		dayLable = new JLabel("Day:");
		resultLable = new JLabel("Result:");

		year.setPreferredSize(new Dimension(150, 30));
		year.setBorder(BorderFactory.createLineBorder(Color.black));

		month.setPreferredSize(new Dimension(150, 30));
		month.setBorder(BorderFactory.createLineBorder(Color.black));

		day.setPreferredSize(new Dimension(150, 30));
		day.setBorder(BorderFactory.createLineBorder(Color.black));

		result.setPreferredSize(new Dimension(150, 30));
		result.setBorder(BorderFactory.createLineBorder(Color.black));
		result.setEditable(false);

		JButton button = new JButton("get day");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String yearRes = year.getText();
					String monthRes = month.getText();
					String dayRes = day.getText();
					
					result.setText("Input is: " + dayRes + "/" + monthRes + "/" + yearRes);
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});

		add(yearLable);
		add(year);
		add(monthLable);
		add(month);
		add(dayLable);
		add(day);
		add(button);
		add(resultLable);
		add(result);

	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		// Make sure we have nice window decorations.
		JFrame.setDefaultLookAndFeelDecorated(true);

		// Create and set up the window.
		JFrame frame = new JFrame("GetNextDay");
		frame.setPreferredSize(new Dimension(190, 300));
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