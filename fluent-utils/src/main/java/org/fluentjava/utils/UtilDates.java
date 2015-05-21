package org.fluentjava.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.google.common.base.Strings;

public class UtilDates {

	public static final DateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
	public static final DateFormat DEFAULT_PRETTY_DATE_FORMAT = new SimpleDateFormat("EEE MM/dd/yyyy");
	public static final DateFormat DEFAULT_DATETIME_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	public static final DateFormat DEFAULT_TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
	public static final DateFormat DEFAULT_HOUR_FORMAT = new SimpleDateFormat("HH:mm");

	private static final GregorianCalendar CALENDAR_1 = new GregorianCalendar();

	private static final GregorianCalendar CALENDAR_2 = new GregorianCalendar();

	public static Date parseDateWithoutTime(final String date) {

		return parseDateWithoutTime(date, false);
	}

	public static String formatDateWithoutTime(final Date date) {

		return DEFAULT_DATE_FORMAT.format(date);
	}

	public static String formatDateTime(final Date date) {

		return DEFAULT_DATETIME_FORMAT.format(date);
	}

	public static String formatPrettyDate(final Date date) {

		return DEFAULT_PRETTY_DATE_FORMAT.format(date);
	}

	public static String formatTime(final Date date) {

		return DEFAULT_TIME_FORMAT.format(date);
	}

	public static String formatHour(final Date date) {

		return DEFAULT_HOUR_FORMAT.format(date);
	}

	public static Date parseDateWithoutTime(final String date, final boolean permissive) {

		final Date res = null;

		if ( ! permissive || ! Strings.isNullOrEmpty(date)) {

	        try {

				return DEFAULT_DATE_FORMAT.parse(date);
			}
	        catch (final ParseException e) {

	        	if ( ! permissive) {

					throw new RuntimeException("Error when parsing date : " + date, e);
				}
			}
		}

		return res;
    }


	  public static boolean areDatesTheSameDay(final Date date1, final Date date2) {

	    boolean result = false;

	    synchronized (CALENDAR_1) {
	      final Calendar cal1 = CALENDAR_1;
	      final Calendar cal2 = CALENDAR_2;

	      cal1.setTime(date1);
	      cal2.setTime(date2);

	      if ((cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH))
	          && (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH))
	          && (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR))) {

	        result = true;
	      }
	    }

	    return result;
	  }

	  public static boolean areDatesTheSameHour(final Date date1, final Date date2) {

		    boolean result = false;

		    if ((date1 != null) && (date2 != null)) {

		      synchronized (CALENDAR_1) {
		        final Calendar cal1 = CALENDAR_1;
		        final Calendar cal2 = CALENDAR_2;

		        cal1.setTime(date1);
		        cal2.setTime(date2);

		        if (   (cal1.get(Calendar.HOUR_OF_DAY) == cal2.get(Calendar.HOUR_OF_DAY))
		            && (cal1.get(Calendar.MINUTE) == cal2.get(Calendar.MINUTE)))
		        {

		          result = true;
		        }
		      }
		    }
		    return result;
		  }

	public static Date getDateWithoutHours(final Date date) {

		if (date == null) {
			return null;
		}

		synchronized (CALENDAR_1) {
			final Calendar dateWithoutHours = CALENDAR_1;

			dateWithoutHours.setTime(date);

			dateWithoutHours.set(Calendar.HOUR_OF_DAY, 0);
			dateWithoutHours.set(Calendar.MINUTE, 0);
			dateWithoutHours.set(Calendar.SECOND, 0);
			dateWithoutHours.set(Calendar.MILLISECOND, 0);

			return dateWithoutHours.getTime();
		}
	}
}
