package Models.Converter;

import java.util.Map;

import Models.Formatter.DataFormatter;

public abstract class Converter {
	@SuppressWarnings("rawtypes")
	Map<Integer, DataFormatter> formatterPerColumn;

	public abstract void convert() throws Exception;

	@SuppressWarnings("rawtypes")
	public Map<Integer, DataFormatter> getFormatterPerColumn() {
		return formatterPerColumn;
	}

	@SuppressWarnings("rawtypes")
	public void setFormatterPerColumn(Map<Integer, DataFormatter> formatterPerColumn) {
		this.formatterPerColumn = formatterPerColumn;
	}

}
