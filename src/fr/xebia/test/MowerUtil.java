package fr.xebia.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class for static methods
 * 
 * @author aouesguesmi
 *
 */
public class MowerUtil {

	/**
	 * Reads from console input
	 * 
	 * @return
	 */
	public static StringBuilder readInput() {
		BufferedReader buffReader = null;
		StringBuilder consoleInput = new StringBuilder();
		try {
			// read content from console input
			buffReader = new BufferedReader(new InputStreamReader(System.in));
			String currentLine = null;
			while ((currentLine = buffReader.readLine()) != null && !currentLine.toUpperCase().equals("")) {
				consoleInput.append(currentLine).append(System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (buffReader != null) {
				try {
					buffReader.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return consoleInput;
	}

	/**
	 * Retrieves the content of the file read or simply the input if it's not a
	 * single line containing a file path
	 * 
	 * @param inputContent
	 *            The content read from the console
	 * @return
	 */
	public static String retrieveContent(StringBuilder inputContent) {
		String[] lines = inputContent.toString().split(System.getProperty("line.separator"));
		String dataContent = null;
		if (lines.length > 0 && lines.length == 1) {
			try {
				Scanner scanner = new Scanner(new File(inputContent.toString().trim()));
				dataContent = scanner.useDelimiter("\\Z").next();
				scanner.close();
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
		} else {
			dataContent = inputContent.toString();
		}

		return dataContent;
	}

	/**
	 * Constructs the mowers list from content of the input
	 * 
	 * @param dataContent
	 * @return
	 */
	public static List<Mower> constructMowerList(String dataContent) {

		List<Mower> mowerList = new ArrayList<Mower>();
		String[] dataArray = dataContent.split(System.getProperty("line.separator"));

		// First line, reads ground size coordinates
		String[] groundCoords = dataArray[0].split("\\s+");
		int colNbr = Integer.parseInt(groundCoords[0]);
		int rowNbr = Integer.parseInt(groundCoords[1]);
		MowItNow.field.setColSize(colNbr);
		MowItNow.field.setRowSize(rowNbr);

		// Other lines, reads the mowers' initial coordinates and
		// orientation
		if (dataArray != null && dataArray.length > 1 && dataArray.length % 2 == 1) {
			for (int i = 1; i < dataArray.length; i += 2) {
				String currentLine = dataArray[i];
				String[] mowerAttr = currentLine.split("\\s+");
				Mower mower = new Mower(Integer.parseInt(mowerAttr[0]), Integer.parseInt(mowerAttr[1]), mowerAttr[2].charAt(0));
				if ((currentLine = dataArray[i + 1]) != null) {
					mower.setCommands(currentLine);
				}
				mowerList.add(mower);
			}
		}
		return mowerList;
	}
}
