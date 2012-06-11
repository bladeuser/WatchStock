package com.teamziegenbock.android.apis.helfer;

import java.lang.reflect.Field;

public class DAX {

	public static final String ADIDAS = "ADS.DE_58,95€";
	public static final String ALLIANZ = "ALV.DE	71,20€";
	public static final String BASF = "BAS.DE			33,55€";
	public static final String BAYER = "BAYN.DE		";
	public static final String BEIERSDORF = "BEI.DE";
	public static final String BMW = "BMW.DE";
	public static final String COMMERZBANK = "CBK.DE";
	public static final String DAIMLER = "DAI.DE";
	public static final String DEUTSCHE_BOERSE = "DB1.DE";
	public static final String DEUTSCHE_BANK = "DBK.DE";
	public static final String DEUTSCHE_POST = "DPW.DE";
	public static final String DEUTSCHE_TELEKOM = "DTE.DE";
	public static final String EON = "EOAN.DE";
	public static final String FRESENIUS_MED_CARE = "FME.DE";
	public static final String FRESENIUS = "FRE.DE";
	public static final String HEIDELBERGCEMENT = "HEI.DE";
	public static final String HENKEL_VZ = "HEN3.DE";
	public static final String INFINEON_TECHNOLO = "IFX.DE";
	public static final String DT_LUFTHANSA = "LHA.DE";
	public static final String LINDE = "LIN.DE";
	public static final String MAN = "MAN.DE";
	public static final String METRO = "MEO.DE";
	public static final String MERCK = "MRK.DE";
	public static final String MUNICHRE = "MUV2.DE";
	public static final String RWE = "RWE.DE";
	public static final String SAP = "SAP.DE";
	public static final String K_S = "SDF.DE";
	public static final String SIEMENS = "SIE.DE";
	public static final String THYSSENKRUPP = "TKA.DE";
	public static final String VOLKSWAGEN = "VOW3.DE";

	public static final String[] values = new String[] { "ADIDAS				58,92€",
			"ALLIANZ				44,64€", "BASF					72,12€", "BAYER				64,45€",
			"BEIERSDORF				23,98€", "BMW				56,23€", "COMMERZBANK				13,20€",
			"DAIMLER			78,20€", "DEUTSCHE_BOERSE			47,64€",
			"DEUTSCHE_BANK			22,78€", "DEUTSCHE_POST", "DEUTSCHE_TELEKOM",
			"EON", "FRESENIUS_MED_CARE", "FRESENIUS", "HEIDELBERGCEMENT",
			"HENKEL_VZ", "INFINEON_TECHNOLO", "DT_LUFTHANSA", "LINDE", "MAN",
			"METRO", "MERCK", "MUNICHRE", "RWE", "SAP", "K_S", "SIEMENS",
			"THYSSENKRUPP", "VOLKSWAGEN" };

	public static final String[] values2 = new String[] { "Coca-Cola Co.",
			"Mikuni Coca-Cola Bottlg Co.Ltd","Ecolab Inc." };

	public String getSymbol(String stock) {
		Object obj = this;
		Field class_attribute;
		Object field_value;
		String field_value_string = "";
		try {
			class_attribute = obj.getClass().getField(stock);
			field_value = class_attribute.get(obj);
			field_value_string = (field_value != null) ? field_value.toString()
					: "";
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return field_value_string;
	}
}
