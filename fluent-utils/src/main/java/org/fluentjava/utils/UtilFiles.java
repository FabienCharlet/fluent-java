package org.fluentjava.utils;

import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;


public class UtilFiles {

	 public static String getSHA1(final InputStream is) {

			try {
				final MessageDigest md = MessageDigest.getInstance("SHA-1");

		        final DigestInputStream dis = new DigestInputStream(is, md);

		        dis.on(true);

		        while (dis.read() != -1) {
		           // nothing to do here
		        }
		        final byte[] bytes = md.digest();

		        final StringBuilder res = new StringBuilder(bytes.length * 2);
		        for (final byte b : bytes) {
		            if (b <= 0x0F && b >= 0x00) {
		                res.append('0');
		            }
		            res.append(String.format("%x", b));
		        }

		        return res.toString();
			}
			catch (final Exception e) {

				throw new RuntimeException("Unexpected error", e);
			}
	    }
}
