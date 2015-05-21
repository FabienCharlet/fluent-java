package org.fluentjava.utils;

public class UtilIntegers {

	public static int getNumberOfDigits(final int n) {

		if (n < 100_000)
		{
			// 5 or less
			if (n < 100)
			{
				// 1 or 2
				if (n < 10) {
					return 1;
				}
				return 2;
			}
			// 3 or 4 or 5
			if (n < 1_000) {
				return 3;
			}
			// 4 or 5
			if (n < 10000) {
				return 4;
			}
			return 5;
		}
		// 6 or more
		if (n < 10_000_000)
		{
			// 6 or 7
			if (n < 1_000_000) {
				return 6;
			}
			return 7;
		}
		// 8 to 10
		if (n < 100_000_000) {
			return 8;
		}
		// 9 or 10
		if (n < 1_000_000_000) {
			return 9;
		}
		return 10;
	}
}
