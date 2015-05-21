/**
 *
 */
package org.fluentjava.utils;

import java.text.DecimalFormat;

public class UtilFloats {

	public static final DecimalFormat	DEFAULT_FORMAT	= new DecimalFormat("#.####");

	public static final double DEFAULT_COMPARISON_PRECISION = 0.001;

	public static boolean equals(final Float value1, final Float value2) {

		return equals(value1, value2, DEFAULT_COMPARISON_PRECISION);
	}

	public static boolean equals(final Float value1, final Float value2, final double epsilon) {

		boolean res = false;

		if (value1 == null && value2 == null) {

			res = true;
		}
		else if (value1 == null && value2 != null) {

			res = false;
		}
		else if (value1 != null && value2 == null) {

			res = false;
		}
		else if (value1 != null && value2 != null) {

			res = (value1 > (value2 - epsilon)) && (value1 < (value2 + epsilon));
		}

		return res;
	}



	public static boolean equals(final Double value1, final Double value2) {

		return equals(value1, value2, DEFAULT_COMPARISON_PRECISION);
	}

	public static boolean equals(final Double value1, final Double value2, final double epsilon) {

		boolean res = false;

		if (value1 == null && value2 == null) {

			res = true;
		}
		else if (value1 == null && value2 != null) {

			res = false;
		}
		else if (value1 != null && value2 == null) {

			res = false;
		}
		else if (value1 != null && value2 != null) {

			res = (value1 > (value2 - epsilon)) && (value1 < (value2 + epsilon));
		}

		return res;
	}

	public static String format(final float number) {

		return DEFAULT_FORMAT.format(number);
	}

	public static String format(final double number) {

		return DEFAULT_FORMAT.format(number);
	}

	public static float parseFloat(final String number) {

		try {

			return DEFAULT_FORMAT.parse(number.replace('.', ',')).floatValue();

		}
		catch (final Exception e) {

			return 0;
		}
	}

	public static double parseDouble(final String number, final boolean strict) {

		try {

			return DEFAULT_FORMAT.parse(number.replace(',', '.')).doubleValue();

		}
		catch (final Exception e) {

			if (strict) {

				throw new InvalidDataException(e);
			}

			return 0;
		}
	}
}
