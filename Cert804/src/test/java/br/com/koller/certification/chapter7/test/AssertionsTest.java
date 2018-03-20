package br.com.koller.certification.chapter7.test;

import br.com.koller.certification.chapter7.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AssertionsTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Assertions assertions;

    @Before
    public void init() {
        assertions = new Assertions();
    }

    @Test
    public void assertNumberGreaterThanZero() {
        assertTrue(assertions.numberGreaterOrEqualToZero(1));
        assertTrue(assertions.numberGreaterOrEqualToZeroWithMessage(1));
    }

    @Test
    public void assertNumberEqualToZero() {
        assertTrue(assertions.numberGreaterOrEqualToZero(0));
        assertTrue(assertions.numberGreaterOrEqualToZeroWithMessage(0));
    }

    @Test(expected = AssertionError.class)
    public void assertNumberSmallerThanZeroEqualError() {
        assertions.numberGreaterOrEqualToZero(-1);
    }

    @Test
    public void assertNumberSmallerThanZeroEqualErrorWithMessage() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("Number -1 smaller than 0");
        assertions.numberGreaterOrEqualToZeroWithMessage(-1);
    }
}
