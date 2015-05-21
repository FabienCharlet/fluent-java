package org.fluentjava.utils;

import java.util.Date;


public class UtilObjects {

	public static String prettyPrint(final Object o) {

		String res;

		if (o == null) {

			res = "";
		}
		else if (o instanceof String) {

			res = (String) o;
		}
		else if (o instanceof Double) {

			res = UtilFloats.format((Double) o);
		}
		else if (o instanceof Float) {

			res = UtilFloats.format((Float) o);
		}
		else if (o instanceof Date) {

			res = UtilDates.formatDateWithoutTime((Date) o);
		}
		else {

			res = o.toString();
		}


		return res;
	}
}
