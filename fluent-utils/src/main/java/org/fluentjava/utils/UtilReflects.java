package org.fluentjava.utils;

import java.lang.reflect.Method;


public class UtilReflects {

	public static Object getField(final String field, final Object object) throws Exception {

		Object res = null;

		 Method getter;

         try {
             getter = object.getClass().getDeclaredMethod("get" + UtilStrings.capitalize(field));
         }
         catch (final Exception e) {

         	try {
         		getter = object.getClass().getSuperclass().getDeclaredMethod("get" + UtilStrings.capitalize(field));
         	}
         	catch (final Exception e1) {

         		getter = object.getClass().getDeclaredMethod("is" + UtilStrings.capitalize(field));
         	}
         }

         res = getter.invoke(object);

		return res;
	}



	public static void setField(final String field, final Object object, final Object value) throws Exception {

		Method setter;

        try {
            setter = object.getClass().getDeclaredMethod("set" + UtilStrings.capitalize(field), value.getClass());
        }
        catch (final Exception e) {

        	setter = object.getClass().getSuperclass().getDeclaredMethod("set" + UtilStrings.capitalize(field), value.getClass());
        }

        setter.invoke(object, value);
	}
}
