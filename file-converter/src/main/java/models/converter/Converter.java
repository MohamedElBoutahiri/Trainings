package models.converter;

import java.util.Map;

import models.formatter.DataFormatter;

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
