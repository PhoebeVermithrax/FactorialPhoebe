/*
 * Created by: Phoebe Vermithrax
 * Created on: 28-March-2018
 * Created for: ICS4U
 * Daily Assignment – Day #25
 * This program uses recursion to output the factorial of the number the user inputed.
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Factorial {

	protected Shell shell;
	private Text txtNumber;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Factorial window = new Factorial();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	//Create the recursion function.
	//Used with: https://www.youtube.com/watch?v=3dCvrZB1-zo
	public int FactorialRecursion(int number)
	{
		//If the number is equal to one, return 1.
		if (number == 1)
		{
			return 1;
		}
		//If it's greater than one,
		else
		{
			//have the number be multiplied by the function, one less than itself. Ex: 5*4*3*2*1
			return number * (FactorialRecursion(number - 1));
		}
	}
	
	//Create the function that will populate the listbox.
	public void PopulateList(List tmpList, int number)
	{
		//create a for loop to populate the listbox.
		for (int counter = 1; counter <= number; counter ++)
		{
			tmpList.add("" + counter);
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Factorial");
		
		Label lblEnterInA = new Label(shell, SWT.NONE);
		lblEnterInA.setBounds(10, 10, 205, 15);
		lblEnterInA.setText("Enter in a number to see the factorial:");
		
		txtNumber = new Text(shell, SWT.BORDER);
		txtNumber.setBounds(221, 10, 177, 21);
		
		List lstFactorial = new List(shell, SWT.BORDER);
		lstFactorial.setBounds(10, 40, 205, 199);
		
		Label lblTheAnswer = new Label(shell, SWT.NONE);
		lblTheAnswer.setBounds(256, 88, 94, 15);
		lblTheAnswer.setText("New Label");
		//Set to invisible.
		lblTheAnswer.setVisible(false);
		
		Button btnStart = new Button(shell, SWT.NONE);
		btnStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//State variables.
				int userFactorial;
				int answer;
				
				//Clear the listbox.
				lstFactorial.removeAll();
				
				//get the information from the textbox and convert it into an int.
				userFactorial = Integer.parseInt(txtNumber.getText());
				
				//Pass the number and list to FactorialRecursion and PopulateList.
				answer = FactorialRecursion(userFactorial);
				PopulateList(lstFactorial, userFactorial);
				
				//Input the answer into a label.
				lblTheAnswer.setVisible(true);
				lblTheAnswer.setText("" + userFactorial + "! " + answer);
			}
		});
		btnStart.setBounds(268, 40, 75, 25);
		btnStart.setText("Start");

	}
}
