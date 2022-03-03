package it.gestionetelevisore.utility;

public class UtilityNumber {
	public static Integer parseFromStringToInt(String daConvertire) {
		try {
			return Integer.parseInt(daConvertire);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
