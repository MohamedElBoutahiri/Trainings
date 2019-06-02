package Models.Formatter;

import java.util.Map;
import java.util.Map.Entry;

/**
 * This abstract class is used to represent a dataformatter that will be applied to the data to convert.
 * @author Mohamed El Boutahiri
 *
 * @param <T>
 */
public abstract class DataFormatter<T> {

	/**
	 * 
	 * @param object
	 * @return T
	 * @throws Exception
	 */
	public  abstract T applyFormatter(T object) throws Exception;
	
	/**
	 * @param dataFormatter
	 * @param content
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void applyFormatters(Map<Integer,DataFormatter> dataFormatter, String[] content) throws Exception {
		for(Entry<Integer,DataFormatter> formatter : dataFormatter.entrySet()) {
			formatter.getValue().applyFormatter(content[formatter.getKey()]);
		}
	}

}
