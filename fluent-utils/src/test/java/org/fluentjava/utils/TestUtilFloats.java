package org.fluentjava.utils;

import org.fest.assertions.Assertions;
import org.junit.Test;


public class TestUtilFloats {


	@Test
	public void equalsCloseNumbers() {

		final double d1 = 1.000000;
		final double d2 = 1.000111;

		Assertions.assertThat(UtilFloats.equals(d1, d2, 0.1)).isTrue();
		Assertions.assertThat(UtilFloats.equals(d1, d2, 0.01)).isTrue();
		Assertions.assertThat(UtilFloats.equals(d1, d2, 0.001)).isTrue();
		Assertions.assertThat(UtilFloats.equals(d1, d2, 0.0001)).isFalse();
	}
}
