package Models.SQL;

/**
 * DbParameters contains basic features of a database, like the name and the schema.
 * 
 * @author Mohamed El Boutahiri
 *
 */
public class DbParameters {
	private String dbName;
	private String schemaName;

	public DbParameters(String dbName, String schemaNAme) {
		super();
		this.dbName = dbName;
		this.schemaName = schemaNAme;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

}
