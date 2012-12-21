package db;

public class OUTPUT_COUNT_DEF extends TABLE_DEFINITION {

	private String TABLE_NAME = "OUTPUT_COUNT_DEF";

	private static String ID = "_id";
	private static String COUNT = "COUNT_NAME";


	private String CreateQuery = "create table "
			+ TABLE_NAME
			+ " ("
			+ ID + " integer primary key autoincrement,"
			+ COUNT +" integer not null"
			+ " );";

	@Override
	public String getCreateQuery() {
		return CreateQuery;
	}

	public static String getCOUNT() {
		return COUNT;
	}

}
