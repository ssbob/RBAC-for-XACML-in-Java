import java.io.IOException;

/**
 * Class to implement two classes used for RBAC in the XACML Scheme
 * This simple test class implements two input files:
 *
 * 1. roletousermap.txt -- This file contains Group user1 user2 ...
 * 2. resourcetorolemap.txt -- This file contains Resource group
 *
 * LoadDataXML() is used to read in the roletousermap.txt file, parse it
 * and create the group objects, and the groups.xml file.
 *
 * PolicyBuilderLoader() is used to create the policies for the Resources
 * (in this case File1 - File5).
 */
public class PolicyAuthor {

    static final String ROLE2USERMAPFILE = "../roletousermap.txt";
    static final String RESOURCE2ROLEMAPFILE = "../resourcetorolemap.txt";

    public static void main(String[] args) {

        /*
         * Loading in the txt file, and calls XMLCreator to create an xml file
         * representing the input file.
         */
        String[] input1 = new String[] {ROLE2USERMAPFILE};
        try {
            LoadDataXML.main(input1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * Creating a policy using PolicyBuilder
         */
        String[] input2 = new String[] {RESOURCE2ROLEMAPFILE};
        try {
            PolicyBuilderLoader.main(input2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
