package calendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final GetUserInputSwing startGUI = new GetUserInputSwing();

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				startGUI.createAndShowGUI();
			}
		});

	}

}
