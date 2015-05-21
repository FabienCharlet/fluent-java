package org.fluentjava.utils;

import java.security.MessageDigest;

public class UtilPasswords {

    private static final String SALT = "%oj-_4-K#_QWe_h<5z_X|vU0/3<-A,";

	public static String toSHA1(final String text) {
        try {
            final String str = SALT + text;

            final MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] sha1hash = new byte[40];

            md.update(str.getBytes("iso-8859-1"), 0, str.length());

            sha1hash = md.digest();

            return convertToHex(sha1hash);

        } catch (final Exception e) {

            throw new RuntimeException(e);
        }
    }

	public static String convertToHex(final byte[] data) {
        final StringBuilder buf = new StringBuilder(15);
        for (final byte element : data) {
            int halfbyte = (element >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = element & 0x0F;
                two_halfs++;
            } while (two_halfs < 2);
        }
        return buf.toString();
    }
}
