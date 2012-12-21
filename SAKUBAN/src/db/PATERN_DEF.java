package db;

public class PATERN_DEF  extends TABLE_DEFINITION{

	private String TABLE_NAME = "PATERN_DEF";

	private static String ID = "_id";
	private static String FORM_ID = "FORM_ID";
	private static String COUNT_ID = "COUNT_ID";

	private String CreateQuery = "create table "
			+ TABLE_NAME
			+ " ("
			+ ID + " integer primary key autoincrement,"
			+ FORM_ID +" integer not null,"
			+ COUNT_ID +" integer not null"
			+ " );";

	@Override
	public String getCreateQuery() {
		return CreateQuery;
	}

}
