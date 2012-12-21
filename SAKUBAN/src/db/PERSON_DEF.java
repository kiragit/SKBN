package db;

public class PERSON_DEF  extends TABLE_DEFINITION{

	private String TABLE_NAME = "PERSON_DEF";

	private static String ID = "_id";
	private static String PERSON_ID = "ID";
	private static String PERSON_NAME = "PERSON_NAME";
	private static String MAIL= "MAIL";

	private String CreateQuery = "create table "
			+ TABLE_NAME
			+ " ("
			+ ID + " integer primary key autoincrement,"
			+ PERSON_ID +" integer not null,"
			+ PERSON_NAME +" integer not null,"
			+ MAIL +" integer not null"
			+ " );";

	@Override
	public String getCreateQuery() {
		return CreateQuery;
	}
}
