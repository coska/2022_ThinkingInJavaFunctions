/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex17.optional.functional;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public class Utility {

	public Object halfRoundUp(Object input) {
		return Optional.ofNullable(input)
				.map(value -> Objects.toString(value, null))
				.map(String::trim)
				.map(BigDecimal::new)
				.filter(bigDecimal -> bigDecimal.scale() > 2)
				.map(bigDecimal -> bigDecimal.setScale(2, HALF_UP).toString())
				.map(Object.class::cast)
				.orElse(input);
	}

}
