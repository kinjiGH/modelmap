package modelmap.events;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import modelmap.screens.CanvasScreen;
import modelmap.screens.LoginScreen;

public class LoginScreenEvent implements Listener {

	private LoginScreen screen = null;

	public LoginScreenEvent(LoginScreen screen) {
		this.screen = screen;
	}

	public void handleEvent(Event event) {

		String userName = screen.getUsername().getText();
		String password = screen.getPassword().getText();

		System.out.println(this.screen.getAuthMap());
		System.out.println(this.screen.getAuthMap().get(userName));

		if (this.screen.getAuthMap() != null && password != null
				&& password.equalsIgnoreCase(this.screen.getAuthMap().get(userName))) {
			System.out.println("Authenticated for " + userName);
			this.screen.setIsAuthenticated(true);
			this.screen.getShell().setVisible(false);
			CanvasScreen canvasScreen = new CanvasScreen(this.screen.getDisplay());
			canvasScreen.createCanvasScreen();
		}

		System.out.println("UserName=" + userName + "password=" + password);

	}

}
