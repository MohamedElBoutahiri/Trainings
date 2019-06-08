package models.formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.TimeZone;

public class DateTimetoTimeStampFormatter extends DataFormatter<String> {

	private String dateTimeFormatter;
	private String zone;

	public DateTimetoTimeStampFormatter(String dateTimeFormatter, String zone) {
		super();
		this.dateTimeFormatter = dateTimeFormatter;
		this.zone = zone;
	}

	@Override
	public String applyFormatter(String time) throws ParseException {

		DateFormat format = new SimpleDateFormat(dateTimeFormatter);
		format.setTimeZone(TimeZone.getTimeZone(ZoneId.of(zone)));
		return String.valueOf(format.parse(time).getTime());
	}

}
