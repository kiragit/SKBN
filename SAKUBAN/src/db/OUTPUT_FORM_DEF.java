package db;

public class OUTPUT_FORM_DEF  extends TABLE_DEFINITION{

	private String TABLE_NAME = "OUTPUT_FORM_DEF";

	private static String ID = "_id";
	private static String FORM = "FORM_NAME";

	private String CreateQuery = "create table "
			+ TABLE_NAME
			+ " ("
			+ ID + " integer primary key autoincrement,"
			+ FORM +" integer not null"
			+ " );";

	@Override
	public String getCreateQuery() {
		return CreateQuery;
	}

	public static String getFORM() {
		return FORM;
	}

}
