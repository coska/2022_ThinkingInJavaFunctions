/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex02.foreach.functional;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class ForEachProblem {

	//입력된 사람들의 생일에 따라 나이를 계산해서 age 필드를 업데이트 한 후, 결과 리스트를 리턴함

	public List<Person> populateAge(List<Person> people) {
		final LocalDate now = LocalDate.now();

		//Q. Iterable.forEach() -> what's the problem of the use here?
		//what if there's multi-thread issue, what if the input collection is immutable?

		final List<Person> result = new ArrayList<>();
		people.forEach(
				person -> person.setAge(getAge(now, person.getBirthDate()))
		);
		return result;
	}

	private int getAge(LocalDate now, LocalDate birthDate) {
		return Period.between(birthDate, now).getYears();
	}
}
