package db;

public class SAGYO_NO_DEF  extends TABLE_DEFINITION{

	private String TABLE_NAME = "SAGYO_NO_DEF";

	private static String ID = "_id";
	private static String ROOT_ID = "ROOT_ID";
	private static String SAGYO_NO = "SAGYO_NO";
	private static String SAGYO_NO_NAME = "SAGYO_NO_NAME";

	private String CreateQuery = "create table "
			+ TABLE_NAME
			+ " ("
			+ ID + " integer primary key autoincrement,"
			+ ROOT_ID +" integer not null,"
			+ SAGYO_NO +" integer not null,"
			+ SAGYO_NO_NAME +" integer not null"
			+ " );";

	@Override
	public String getCreateQuery() {
		return CreateQuery;
	}

	public static String getROOT_ID() {
		return ROOT_ID;
	}

	public static String getSAGYO_NO() {
		return SAGYO_NO;
	}

	public static String getSAGYO_NO_NAME() {
		return SAGYO_NO_NAME;
	}

	public void setCreateQuery(String createQuery) {
		CreateQuery = createQuery;
	}

}

