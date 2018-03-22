package com.luizalabs.tdd;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTest {

	@Test
	public void emptyStringShouldReturnZero() {
		assertThat(Calculator.calculate(""), equalTo(0L));
	}
	
	@Test
	public void nullStringShouldReturnZero() {
		assertThat(Calculator.calculate(null), equalTo(0L));
	}
	
	@Test
	public void singleNumberShouldReturnGivenNumber() {
		assertThat(Calculator.calculate("1"), equalTo(1L));
	}
	
	@Test
	public void twoNumbersCommaSeparatedShouldReturnSum() {
		assertThat(Calculator.calculate("1,2"), equalTo(3L));
	}
	
	@Test
	public void twoNumbersNewLineSeparatedShouldReturnSum() {
		assertThat(Calculator.calculate("3\n6"), equalTo(9L));
	}
	
	@Test
	public void threeNumbersDelimitedEitherWayShouldReturnSum() {
		assertThat(Calculator.calculate("1,2,3\n4"), equalTo(10L));
	}
	
	@Test(expected=RuntimeException.class)
	public void negativeNumberShouldReturnException() {
		Calculator.calculate("1,2,-3");
	}
	
	@Test
	public void numbersGt1000MustBeIgnored() {
		assertThat(Calculator.calculate("1,2,3,1000,1001"), equalTo(1006L));
	}
	
}
