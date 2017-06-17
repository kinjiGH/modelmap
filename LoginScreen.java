package modelmap.screens;

import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import modelmap.events.LoginScreenEvent;

public class LoginScreen {

	private HashMap<String, String> authMap = null;
	private Display display = null;

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	private Boolean isAuthenticated = null;
	private Shell shell = null;

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public Boolean getIsAuthenticated() {
		return isAuthenticated;
	}

	public void setIsAuthenticated(Boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	public HashMap<String, String> getAuthMap() {
		return authMap;
	}

	public void setAuthMap(HashMap<String, String> authMap) {
		this.authMap = authMap;
	}

	public LoginScreen(HashMap<String, String> authMap, Display display) {
		this.authMap = authMap;
		this.display = display;
	}

	Label userNameLabel = null;
	Label passwordLabel = null;
	Label imageLabel = null;
	private Text username = null;

	public Text getUsername() {
		return username;
	}

	public void setUsername(Text username) {
		this.username = username;
	}

	public Text getPassword() {
		return password;
	}

	public void setPassword(Text password) {
		this.password = password;
	}

	private Text password = null;
	private LoginScreenEvent loginScreenEvent = new LoginScreenEvent(this);

	public void createLoginScreen() {

		shell = new Shell(this.display);

		shell.setLayout(new GridLayout(2, false));
		shell.setText("Model Map Login");
		shell.setMinimumSize(1000, 800);
		shell.setLocation(0, 0);

		Image image = new Image(display, "C:\\Kinjal\\ModelMap\\images\\modelMap.png");

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		shell.setLayout(gridLayout);

		// Image alignment
		imageLabel = new Label(shell, SWT.NULL);
		imageLabel.setImage(image);

		GridData imageGridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		imageGridData.horizontalSpan = 4;
		imageLabel.setLayoutData(imageGridData);

		//
		userNameLabel = new Label(shell, SWT.NULL);
		userNameLabel.setText("User Name: ");

		GridData userNameLabelGridData = new GridData(GridData.END, GridData.CENTER, true, false);
		// userNameLabelGridData.horizontalIndent = 1;
		userNameLabelGridData.horizontalSpan = 3;
		userNameLabel.setLayoutData(userNameLabelGridData);

		username = new Text(shell, SWT.SINGLE | SWT.BORDER);
		username.setText("");
		// username.setTextLimit(30);

		GridData userNameGridData = new GridData(GridData.BEGINNING, GridData.CENTER, true, false);
		// userNameLabelGridData.horizontalIndent = 1;
		userNameGridData.horizontalSpan = 1;
		// userNameGridData.
		username.setLayoutData(userNameGridData);

		passwordLabel = new Label(shell, SWT.NULL);
		passwordLabel.setText("Password: ");

		GridData passwordLabelGridData = new GridData(GridData.END, GridData.CENTER, true, false);
		// userNameLabelGridData.horizontalIndent = 1;
		passwordLabelGridData.horizontalSpan = 3;
		passwordLabel.setLayoutData(passwordLabelGridData);

		password = new Text(shell, SWT.SINGLE | SWT.BORDER);

		GridData passwordGridData = new GridData(GridData.BEGINNING, GridData.CENTER, true, false);
		// userNameLabelGridData.horizontalIndent = 1;
		passwordGridData.horizontalSpan = 1;
		// userNameGridData.
		password.setLayoutData(passwordGridData);

		System.out.println(password.getEchoChar());

		password.setEchoChar('*');
		// password.setTextLimit(30);

		Button button = new Button(shell, SWT.PUSH);
		button.setText("Submit");

		GridData buttonGridData = new GridData(GridData.END, GridData.CENTER, true, false);
		// userNameLabelGridData.horizontalIndent = 1;
		buttonGridData.horizontalSpan = 4;
		button.setLayoutData(buttonGridData);

		button.addListener(SWT.Selection, loginScreenEvent);

		username.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		password.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		shell.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {

			}
		}

	}

}
