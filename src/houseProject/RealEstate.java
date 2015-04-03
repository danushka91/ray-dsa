package houseProject;

import javax.swing.JOptionPane;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.json.simple.JSONObject;


public class RealEstate extends ApplicationWindow {

	private static Text lotNumber;
	private static Text fName;
	private static Text lName;
	private static Text price;
	private static Text sq_feet;
	private static Text no_of_bed;
	
	private static SortedList list = new SortedList();

	/**
	 * Create the application window.
	 */
	public RealEstate() {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}
	
	private static void iBox(String infoMessage, String titleBar){
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
	}
	
	private static void eBox(String infoMessage, String titleBar){
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.ERROR_MESSAGE);
	}
	
	private static void wBox(String infoMessage, String titleBar){
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.WARNING_MESSAGE);
	}
	
	

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		parent.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent arg0) {
				putOnClose();
			}
		});
		
		
		Composite container = new Composite(parent, SWT.NONE);
		
		Label lblLotNumber = new Label(container, SWT.NONE);
		lblLotNumber.setBounds(10, 10, 84, 15);
		lblLotNumber.setText("Lot Number");
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(10, 43, 68, 15);
		lblNewLabel.setText("First Name");
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setBounds(10, 70, 55, 15);
		lblNewLabel_1.setText("Last Name");
		
		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setBounds(10, 97, 55, 15);
		lblNewLabel_2.setText("Price");
		
		Label lblNewLabel_3 = new Label(container, SWT.NONE);
		lblNewLabel_3.setBounds(10, 124, 78, 15);
		lblNewLabel_3.setText("Square Feet");
		
		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setBounds(10, 151, 55, 15);
		lblNewLabel_4.setText("No Of Bed");
		
		lotNumber = new Text(container, SWT.BORDER);
		lotNumber.setBounds(106, 10, 255, 21);
		
		fName = new Text(container, SWT.BORDER);
		fName.setBounds(106, 40, 255, 21);
		
		lName = new Text(container, SWT.BORDER);
		lName.setBounds(106, 67, 255, 21);
		
		price = new Text(container, SWT.BORDER);
		price.setBounds(106, 94, 255, 21);
		
		sq_feet = new Text(container, SWT.BORDER);
		sq_feet.setBounds(106, 121, 255, 21);
		
		no_of_bed = new Text(container, SWT.BORDER);
		no_of_bed.setBounds(106, 148, 255, 21);
		
		Button btnFind = new Button(container, SWT.NONE);
		btnFind.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				findHouse();
			}
		});
		btnFind.setBounds(116, 175, 75, 25);
		btnFind.setText("Find");
		
		Button btnAdd = new Button(container, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				add();
			}
		});
		btnAdd.setBounds(197, 175, 75, 25);
		btnAdd.setText("Add");
		
		Button btnNext = new Button(container, SWT.NONE);
		btnNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getNext();
			}
		});
		btnNext.setBounds(278, 175, 75, 25);
		btnNext.setText("Next");
		
		Button btnClear = new Button(container, SWT.NONE);
		btnClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clearHouse();
			}
		});
		btnClear.setBounds(116, 206, 75, 25);
		btnClear.setText("Clear");
		
		Button btnDelete = new Button(container, SWT.NONE);
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				delete();
			}
		});
		btnDelete.setBounds(197, 206, 75, 25);
		btnDelete.setText("Delete");
		
		Button btnReset = new Button(container, SWT.NONE);
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				reset();
			}
		});
		btnReset.setBounds(278, 206, 75, 25);
		btnReset.setText("Reset");
		
		getOnOpen();
		getNext();

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Create the menu manager.
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		return menuManager;
	}

	/**
	 * Create the toolbar manager.
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		return toolBarManager;
	}

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			RealEstate window = new RealEstate();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Real Estate Program");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(391, 368);
	}
	

	private static void clearHouse(){
		lotNumber.setText("");
		fName.setText("");
		lName.setText("");
		price.setText("");
		sq_feet.setText("");
		no_of_bed.setText("");
	}
	
	private static void findHouse(){
		int no;
		try {
			no = Integer.parseInt(lotNumber.getText());
			JSONObject houseDetails = new JSONObject();
			
			houseDetails.put("lotNumber", no);
			
			ListHouse house = new ListHouse(houseDetails);
			
			if (list.isOnList(house))
			{
				house = (ListHouse) list.get(house);
				showHouse(house);
				iBox("We got it", "Found");
			}
			else
				eBox("Your House is not found on the list", "Not Found");
			
		} 
		catch(NumberFormatException e){
			eBox("Error while parsing lot number", "Exception");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	private static void delete(){
		try {
			ListHouse house = getHouse();
			
			if(!list.isOnList(house))
				eBox("This lot number is not in List", "We can't remove what is not available");
			else{
				list.remove(house);
				clearHouse();
				list.reset();
				iBox("We removed", "Deleted");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static void add(){
		try {
			ListHouse house = getHouse();
			
			if(list.isOnList(house))
				eBox("This lot number is already used", "We have this house already");
			else{
				list.put(house);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static ListHouse getHouse(){
		JSONObject house = new JSONObject();
		

		
		house.put("lotNumber", Integer.parseInt(lotNumber.getText()));
		house.put("fName", fName.getText());
		house.put("lName", lName.getText());
		
		house.put("price", Integer.parseInt(price.getText()));
		house.put("sq_feet", Integer.parseInt(sq_feet.getText()));
		house.put("no_of_bed", Integer.parseInt(no_of_bed.getText()));
		
		ListHouse rHouse = new ListHouse(house);
		
		return rHouse;
	}
	
	private static void showHouse(ListHouse house){
		JSONObject houseDetails = new JSONObject();
		houseDetails = house.getHouse();
		

		
		lotNumber.setText(houseDetails.get("lotNumber").toString());
		fName.setText( houseDetails.get("fName").toString());
		lName.setText( houseDetails.get("lName").toString());
		price.setText(houseDetails.get("price").toString());
		sq_feet.setText(houseDetails.get("sq_feet").toString());
		no_of_bed.setText(houseDetails.get("no_of_bed").toString());
		
	}
	
	private static void reset(){
		try {
			list.reset();
			if(list.length() == 0)
				clearHouse();
			else{
				ListHouse house = (ListHouse) list.getNextItem();
				showHouse(house);
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static void getNext(){
		try {
			if(list.length() == 0)
				eBox("We have nothing in  the List", "Nothing Found");
			else{
				ListHouse house = (ListHouse) list.getNextItem();
				showHouse(house);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static void putOnClose(){
		try {
			HouseFile.prepareToWrite();
			list.reset();
			for (int i=1; i <= list.length(); i++ ) {
				ListHouse house = (ListHouse) list.getNextItem();
				HouseFile.write(house);
			}
			HouseFile.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static void getOnOpen(){
		try {
			HouseFile.prepareToRead();
			while(true){
				ListHouse house = HouseFile.getNextHouse();
				if(house == null)
					break;
				list.put(house);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
