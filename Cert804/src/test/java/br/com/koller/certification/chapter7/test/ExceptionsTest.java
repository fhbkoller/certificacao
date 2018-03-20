package br.com.koller.certification.chapter7.test;

import br.com.koller.certification.chapter7.ExceptionHandling;
import br.com.koller.certification.util.exception.CertificationException;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.sql.SQLException;

public class ExceptionsTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ExceptionHandling exceptionHandling;

    @Before
    public void init() {
        exceptionHandling = new ExceptionHandling();
    }

    @Test
    public void exceptionMultiCatchMustThrowCertificationException() throws Exception {
        expectedException.expect(CertificationException.class);
        expectedException.expectCause(Matchers.<Throwable>instanceOf(SQLException.class));
        exceptionHandling.throwExceptionMultiCatch(1);
    }

    @Test
    public void exceptionRethrowMustThrowSameException() throws Exception {
        expectedException.expect(IOException.class);
        exceptionHandling.throwExceptionRethrow(2);
    }
}
