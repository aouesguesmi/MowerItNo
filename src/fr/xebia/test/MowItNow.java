package fr.xebia.test;

import java.util.List;

/**
 * Main class operating mowers into a field
 * 
 * @author aouesguesmi
 *
 */
public class MowItNow {

	public static Field field;

	public static void main(String[] args) {

		// Construct a field
		field = Field.getInstance();

		// Read the input console
		StringBuilder inputContent = MowerUtil.readInput();

		// Retrieve content from the input/file
		String dataContent = MowerUtil.retrieveContent(inputContent);

		// Construct the mowers list from the data content
		List<Mower> mowerList = MowerUtil.constructMowerList(dataContent);

		// Circulate the mowers within the field
		StringBuilder result = new StringBuilder();
		if (mowerList != null) {
			for (Mower itMower : mowerList) {
				result.append(itMower.circulate(field.getColSize(), field.getRowSize()).toString());
			}
		}
		System.out.print(result.toString().trim());
	}
}