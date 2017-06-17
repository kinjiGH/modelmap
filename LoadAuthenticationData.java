package modelmap.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner;

public class LoadAuthenticationData {

	public final static String PATH = "C://Kinjal//ModelMap//Authentication";
	public final static String FILE_NAME = "modelmap.txt";
	public final static String SEP = "//";
	private final Charset ENCODING = StandardCharsets.UTF_8;
	private HashMap<String, String> authMap = null;

	public HashMap<String, String> getAuthMap() {
		return authMap;
	}

	public void setAuthMap(HashMap<String, String> authMap) {
		this.authMap = authMap;
	}

	private final String SEP_1 = ":";

	public void loadFiles(String totalPath) throws FileNotFoundException {

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(totalPath), ENCODING.name());

			String lineData = null;
			this.authMap = new HashMap<String, String>();
			// Reading Lines
			while (scanner.hasNextLine()) {
				lineData = scanner.nextLine();
				System.out.println(lineData);

				// To Remove this line
				System.out.println("Line Data = " + lineData);
				authMap.put(lineData.substring(0, lineData.indexOf(SEP_1)),
						lineData.substring(lineData.indexOf(SEP_1) + 1));

			}

			System.out.println("In LoadAuthenticationData File =" + authMap);
		} finally {
			scanner.close();
		}
	}

}
