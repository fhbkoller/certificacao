package br.com.koller.certification.chapter7;

/**
 * Assertions in Java must not be used in public methods (cause a public method may be called from a code you don't control)
 * except to check for cases that you know are never supposed to happen.
 */
public class Assertions {

    /**
     * <p>Asserts that variable <i>i</i> is greater or equal to zero</p>
     * <p>Will always return true, if assertion is not enabled (it is enabled by default on debugging and testing)</p>
     * <p>Returns {@link AssertionError} if assertions are enabled but asserts to false</p>
     * @param i The number to be asserted
     * @return boolean
     */
    public boolean numberGreaterOrEqualToZero(int i) {
        assert (i >=0);
        return true;
    }

    /**
     * <p>Asserts that variable <i>i</i> is greater or equal to zero</p>
     * <p>Will always return true, if assertion is not enabled (it is enabled by default on debugging and testing)</p>
     * <p>Returns {@link AssertionError} with a message (expression 2) if assertions are enabled but returns false</p>
     * @param i The number to be asserted
     * @return boolean
     */
    public boolean numberGreaterOrEqualToZeroWithMessage(int i) {
        assert (i >=0) : "Number " + i + " smaller than 0";
        return true;
    }
}
