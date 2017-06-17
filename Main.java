package modelmap.main;

import java.util.HashMap;

import org.eclipse.swt.widgets.Display;

import modelmap.screens.CanvasScreen;
import modelmap.screens.LoginScreen;
import modelmap.utilities.LoadAuthenticationData;

public class Main {

	private static HashMap<String, String> authMap = null;

	public static void main(String[] args) {

		// Load Files
		if (args.length > 0 && (args[0] != null) && (args[1] != null)) {
			loadFiles(args[0] + LoadAuthenticationData.SEP + args[1]);
		} else {
			loadFiles(LoadAuthenticationData.PATH + LoadAuthenticationData.SEP + LoadAuthenticationData.FILE_NAME);
		}

		// Create Landing Screen
		Display display = new Display();
		LoginScreen loginScreen = new LoginScreen(authMap, display);
		loginScreen.createLoginScreen();

		// System.out.println("Before validating");
		//
		// if(loginScreen.getIsAuthenticated() != null &&
		// loginScreen.getIsAuthenticated())
		// {
		// System.out.println("Before calling shell dispose");
		// loginScreen.getShell().setVisible(false);;
		// System.out.println("After calling shell dispose");
		//
		// }
		//
		// System.out.println("After validating");

		display.dispose();
	}

	public static void loadFiles(String filepath) {

		System.out.println("Loading the Authentication Data from:" + filepath);

		try {

			// Loading Authentication File
			LoadAuthenticationData loadAuthentication = new LoadAuthenticationData();
			loadAuthentication.loadFiles(filepath);
			authMap = loadAuthentication.getAuthMap();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
