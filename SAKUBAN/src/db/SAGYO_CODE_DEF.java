package db;

public class SAGYO_CODE_DEF  extends TABLE_DEFINITION{

	private String TABLE_NAME = "SAGYO_CODE_DEF";

	private static String ID = "_id";
	private static String ROOT_ID = "ROO_ID";
	private static String SAGYO_CODE = "SAGYO_CODE";
	private static String SAGYO_CODE_NAME = "SAGYO_CODE_NAME";

	private String CreateQuery = "create table "
			+ TABLE_NAME
			+ " ("
			+ ID + " integer primary key autoincrement,"
			+ ROOT_ID +" integer not null,"
			+ SAGYO_CODE +" integer not null,"
			+ SAGYO_CODE_NAME +" integer not null"
			+ " );";

	@Override
	public String getCreateQuery() {
		return CreateQuery;
	}

	public static String getROOT_ID() {
		return ROOT_ID;
	}

	public static String getSAGYO_CODE() {
		return SAGYO_CODE;
	}

	public static String getSAGYO_CODE_NAME() {
		return SAGYO_CODE_NAME;
	}

}
