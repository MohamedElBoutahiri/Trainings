package app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import models.file.File;
import models.formatter.DataFormatter;
import models.formatter.DateTimetoTimeStampFormatter;
import models.sql.DbParameters;
import models.sql.SQLOperations;
import utils.FileUtils;
import models.converter.Converter;
import models.converter.SQLConverter;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		String csvPath = null;
		@SuppressWarnings("rawtypes")
		Map<Integer, DataFormatter> dataFormatter = new HashMap<>();
		dataFormatter.put(0, new DateTimetoTimeStampFormatter("yyyy-MM-dd'T'HH:mm:ss.SSS", "Europe/Paris"));
		try {
			File file = FileUtils.createFile(csvPath, ",",
					null,
					"\"", dataFormatter, new int[] { 0, 1 });
			String dbName = null;
			String schemaNAme = null;
			Converter sqlConverter = new SQLConverter(file, new DbParameters(dbName, schemaNAme), SQLOperations.INSERT,
					null);
			sqlConverter.convert();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
