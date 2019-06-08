package models.converter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import models.file.File;
import models.file.Line;
import models.sql.DbParameters;
import models.sql.SQLOperations;

public class SQLConverter extends Converter {

	private File file;
	private DbParameters dbParameters;
	private SQLOperations operation;
	private String outPutPath;

	public SQLConverter(File file, DbParameters dbParameters, SQLOperations operation, String outPutPath) {
		super();
		this.file = file;
		this.dbParameters = dbParameters;
		this.operation = operation;
		this.outPutPath = outPutPath;
	}

	@Override
	public void convert()  {

		String sqlStatement = createSqlStatement();
		Collection<Line> content = file.getContent();
		StringBuilder contentConverted = new StringBuilder();
		try (BufferedWriter br = new BufferedWriter(new FileWriter(this.outPutPath))) {

			for (Line line : content) {
				contentConverted.append(sqlStatement);
				contentConverted.append("VALUES (");
				for (String lineContent : line.getContent()) {
					contentConverted.append(lineContent);
				}
				contentConverted.append(");\n");
				br.append(contentConverted);
				contentConverted.setLength(0);

			}
			System.out.println("fin");
		} catch (IOException e) {
			System.out.println("fallo");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String createSqlStatement() {

		Map<String, String> headerColumnsWithDbColumns = file.getHeader().getHeaderNamesAndMappedNames();
		StringBuilder sqlStatement = new StringBuilder();
		sqlStatement.append(operation + " INTO " + dbParameters.getDbName() + "." + dbParameters.getSchemaName() + "(");

		for (Entry<String, String> column : headerColumnsWithDbColumns.entrySet()) {

			sqlStatement.append(column.getValue());
			sqlStatement.append(",");
		}
		sqlStatement.append(")");
		return sqlStatement.toString();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public DbParameters getDbParameters() {
		return dbParameters;
	}

	public void setDbParameters(DbParameters dbParameters) {
		this.dbParameters = dbParameters;
	}

	public SQLOperations getOperation() {
		return operation;
	}

	public void setOperation(SQLOperations operation) {
		this.operation = operation;
	}

	public String getOutPutPath() {
		return outPutPath;
	}

	public void setOutPutPath(String outPutPath) {
		this.outPutPath = outPutPath;
	}

}
