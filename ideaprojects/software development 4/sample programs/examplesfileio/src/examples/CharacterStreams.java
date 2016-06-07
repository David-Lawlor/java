package examples;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//http://java.about.com/od/InputOutput/ss/Character-Stream-Example-Code.htm

public class CharacterStreams {

	private static final String ORIGINAL_FILENAME = "Software Development 4/Sample programs/ExamplesFileIO/files/source.txt";
	private static final String COPY_FILENAME = "Software Development 4/Sample programs/ExamplesFileIO/files/destination.txt";

	public static void main(String[] args) throws IOException {

		FileReader fileInput = null;
		FileWriter fileOutput = null;

		try {
			fileInput = new FileReader(ORIGINAL_FILENAME);
			fileOutput = new FileWriter(COPY_FILENAME);
			int data;

			while ((data = fileInput.read()) != -1) {
				fileOutput.write(data);
			}
		} catch (IOException e) {

			System.out.println("Error message: " + e.getMessage());
		} finally {
			if (fileInput != null) {
				fileInput.close();
			}
			if (fileOutput != null) {
				fileOutput.close();
			}
		}

	}
}

