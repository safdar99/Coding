import java.io.*;

class InputBridge {
	static String filename = "input.txt";
	public static FileInputStream getFileInputStream() {
		try {
			return new FileInputStream(filename);
		} catch(FileNotFoundException e) {
			System.out.println("Error " + filename + " not found");
			System.exit(1);
			return null;
		}
	}

	public static PrintStream getOutputStream() {
			return System.out;
	}
}