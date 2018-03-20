package br.com.koller.certification.chapter7;

import br.com.koller.certification.util.exception.CertificationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionHandling {

    private static final Logger LOG = Logger.getLogger(ExceptionHandling.class.getName());

    public void throwExceptionMultiCatch(int type) throws CertificationException {
        try {
            switchThrowException(type);
        } catch (SQLException | IOException e) {
            throw new CertificationException(e);
        }
    }

    private void switchThrowException(int type) throws SQLException, IOException {
        switch (type) {
            case 1: throw new SQLException();
            case 2: throw new IOException();
            default: throw new IllegalArgumentException();
        }
    }

    /**
     * <p>In Java 7 and beyond, you can either use a multi-catch or catch an {@link Exception} in catch block
     * to make sure this compiles, the method signature must declare not less than all exceptions thrown by
     * called methods inside try block. Either way, exception variable <i>e</i> cannot be assigned to a new exception</p>
     * @param i Indicates witch exception must be thrown
     * @throws IOException Exception number 2
     * @throws SQLException Exception number 1
     */
    public void throwExceptionRethrow(int i) throws IOException, SQLException {
        try {
            switchThrowException (i);
        } catch (SQLException | IOException e) {
        /* } catch (Exception e){ */
            //Considered bad practice to log and rethrow an exception
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }

    /**
     * <p>Resource in try-with-resources must be a subclass of {@link AutoCloseable}
     * in order to be closed after method completion or after an exception.</p>
     * <p>{@link AutoCloseable} may throw any exception, while {@link java.io.Closeable} is restricted to
     * {@link IOException} and {@link RuntimeException}, although Oracle recommends throwing the narrowest exception
     * that will compile.</p>
     * <p>The order of execution is: try block, resources block (resources are closed backwards, cause they can depend on each other),
     * catch block and finally block</p>
     * <p>If an exception is thrown by the <i>close</i> method, it will be suppressed if another exception was thrown by the
     * try block, if none exception was thrown, it can be caught at the catch block.</p>
     * @throws IOException Exception thrown in case of file reading failure
     */
    public void tryWithResourcesExample() throws IOException {
        try (FileReader reader = new FileReader(new File("temp/file.txt"))){
            System.out.print(reader.read());
            /* reader.close(); Calling a close method on an AutoCloseable subclass will not result in any
             * unpredicted behavior, same cannot be said about Closeable subclasses
             */
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw e;
        }
    }
}
