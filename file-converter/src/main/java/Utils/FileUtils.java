package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import Models.File.File;
import Models.File.Header;
import Models.File.Line;
import Models.Formatter.DataFormatter;

/**
 * This class has the main goel to facilitate the File creation.
 * @author Mohamed El Boutahiri
 *
 */
public class FileUtils {

	/**
	 * This method creates the File to be converted.
	 * @param path The file's path.
	 * @param separator The separator of the source file.
	 * @param dbColumnNames The column names that will be used in the converted file
	 * @param charToReplace The file may contains some characteres that would like to replace
	 * @param dataFormatter Dataformatter that will be applied for some data
	 * @param keyIndexes They keys that will define a unique line in the set.
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static File createFile(String path, String separator, String[] dbColumnNames, String charToReplace,
			Map<Integer, DataFormatter> dataFormatter, int[] keyIndexes) throws Exception {
		
		String headerLine = null;
		String line = null;
		Header header = null;
		String[] content;
		Collection<Line> lines = new HashSet<Line>();
		Line.setKeyIndexes(keyIndexes);

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			headerLine = br.readLine();
			header = Header.createHeaderWithColumnNames(headerLine.split(separator), dbColumnNames);

			while ((line = br.readLine()) != null) {
				content = line.replace(charToReplace, "").split(separator);
				if (content.length > 1) {
					DataFormatter.applyFormatters(dataFormatter, content);
					lines.add(new Line(content));
				}
			}

			return new File(header, lines, dataFormatter);

		}
	}

}
