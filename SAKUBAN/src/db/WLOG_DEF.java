package db;


public class WLOG_DEF extends TABLE_DEFINITION {

	private String TABLE_NAME = "WLOG_DEF";

	private static String ID = "_id";
	private static String YEAR = "YEAR";
	private static String MONTH = "MONTH";
	private static String DAY = "DAY";
	private static String S_HOUR = "START_HOUR";
	private static String S_MIN = "START_MIN";
	private static String E_HOUR = "END_HOUR";
	private static String E_MIN = "END_MIN";
	private static String OUTPUT_COUNT = "OUTPUT_COUNT";
	private static String OUTPUT_FORM = "OUTPUT_FORM";
	private static String SAGYO_CODE = "SAGYO_CODE";
	private static String SAGYO_NO = "SAGYO_NO";

	private String CreateQuery = "create table " + TABLE_NAME
			+ " (" + ID + " integer primary key autoincrement,"
			+ YEAR + " integer not null, "
			+ MONTH + " integer not null, "
			+ DAY + " integer not null, "
			+ SAGYO_NO + " integer not null, "
			+ SAGYO_CODE + " integer not null, "
			+ OUTPUT_FORM + " , "
			+ OUTPUT_COUNT + " , "
			+ S_HOUR + " integer not null, "
			+ S_MIN + " integer not null, "
			+ E_HOUR + ", "
			+ E_MIN + ""
			+ " );";

	private String GetMaxId = "select max(" + ID + ") from " + TABLE_NAME +";";

	@Override
	public String getCreateQuery() {
		return CreateQuery;
	}

	public static String getID() {
		return ID;
	}

	public static String getYEAR() {
		return YEAR;
	}

	public static String getMONTH() {
		return MONTH;
	}

	public static String getDAY() {
		return DAY;
	}

	public static String getS_HOUR() {
		return S_HOUR;
	}

	public static String getS_MIN() {
		return S_MIN;
	}

	public static String getE_HOUR() {
		return E_HOUR;
	}

	public static String getE_MIN() {
		return E_MIN;
	}

	public static String getOUTPUT_COUNT() {
		return OUTPUT_COUNT;
	}

	public static String getOUTPUT_FORM() {
		return OUTPUT_FORM;
	}

	public static String getSAGYO_CODE() {
		return SAGYO_CODE;
	}

	public static String getSAGYO_NO() {
		return SAGYO_NO;
	}

	public static void setMONTH(String mONTH) {
		MONTH = mONTH;
	}

}