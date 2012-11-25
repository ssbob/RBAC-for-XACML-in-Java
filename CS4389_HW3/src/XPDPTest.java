import org.junit.Test;

/**
 * This is a jUnit test class to test the XPDP class.
 * XPDP() takes 2 arguments:
 *
 * arg0: Resource
 * arg1: User
 *
 * It uses information loaded into the PolicyBuilder class
 * to check the resource and user and verify if the user is
 * authorized to access the resource or not. This class will
 * output a *Response.xml file for each check that indicates
 * if the request was approved or denied.
 *
 * The test cases below are a few samples of possible values:
 *
 * Test case 1: A valid resource and a valid user that is authorized
 * to access the resource in question. Results in an Approve response.
 *
 * Test case 2: A valid resource and a valid user, that is NOT authorized
 * to access the resource. Results in a Deny response.
 *
 * Test case 3: A valid resource but an invalid user, this results in no decision
 * being made, or at least as far as I can tell, as there is no response file for this
 * case.
 *
 * Test case 4: A non-valid resource, and a valid user. This did not work as there does not
 * seem to be any way to use a non-valid resource, since there would not be an xml file for
 * the resource. I have since removed this test case.
 */

public class XPDPTest {
    @Test
    public void testMain() throws Exception {

        // Case with valid user and valid resource
        String[] input0 = new String[] {"File1", "John"};
        XPDP.main(input0);

        // Case with invalid user and valid resource
        String[] input1 = new String[] {"File5", "John"};
        XPDP.main(input1);

        // Case with non-existent user and valid resource
        // NOTE: no response file created for non-existent user "Administrator"!
        // Possible bug?
        String[] input2 = new String[] {"File2", "Administrator"};
        XPDP.main(input2);
    }
}
