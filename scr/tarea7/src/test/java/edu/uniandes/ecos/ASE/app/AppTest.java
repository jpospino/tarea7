package edu.uniandes.ecos.ASE.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp1()
    {
        String[] argumentos = new String[3];
        argumentos[0] = "[{ \"programID\": 1, \"estimatedProxySize\": 130, \"planAddedModifiedSize\": 163, \"actualAddedModifiedSize\": 186, \"actualDevelopmentTime\": 15.000000 },{ \"programID\": 2, \"estimatedProxySize\": 650, \"planAddedModifiedSize\": 765, \"actualAddedModifiedSize\": 699, \"actualDevelopmentTime\": 69.900000 },{ \"programID\": 3, \"estimatedProxySize\": 99, \"planAddedModifiedSize\": 141, \"actualAddedModifiedSize\": 132, \"actualDevelopmentTime\": 6.500000 },{ \"programID\": 4, \"estimatedProxySize\": 150, \"planAddedModifiedSize\": 166, \"actualAddedModifiedSize\": 272, \"actualDevelopmentTime\": 22.400000 },{ \"programID\": 5, \"estimatedProxySize\": 128, \"planAddedModifiedSize\": 137, \"actualAddedModifiedSize\": 291, \"actualDevelopmentTime\": 28.400000 }," 
                          + "{ \"programID\": 6, \"estimatedProxySize\": 302, \"planAddedModifiedSize\": 35, \"actualAddedModifiedSize\": 331, \"actualDevelopmentTime\": 65.900000 },{ \"programID\": 7, \"estimatedProxySize\": 95, \"planAddedModifiedSize\": 136, \"actualAddedModifiedSize\": 199, \"actualDevelopmentTime\": 19.400000 },{ \"programID\": 8, \"estimatedProxySize\": 945, \"planAddedModifiedSize\": 1206, \"actualAddedModifiedSize\": 1890, \"actualDevelopmentTime\": 198.700000 },{ \"programID\": 9, \"estimatedProxySize\": 368, \"planAddedModifiedSize\": 433, \"actualAddedModifiedSize\": 788, \"actualDevelopmentTime\": 38.800000 },{ \"programID\": 10, \"estimatedProxySize\": 961, \"planAddedModifiedSize\": 1130, \"actualAddedModifiedSize\": 1601, \"actualDevelopmentTime\": 138.200000 }]";
        
        argumentos[1] = "EPSAAM";
        argumentos[2] = "386";
        
        App.main(argumentos);
        assertTrue(true);
    }
    
    public void testApp2()
    {
        String[] argumentos = new String[3];
        argumentos[0] = "[{ \"programID\": 1, \"estimatedProxySize\": 130, \"planAddedModifiedSize\": 163, \"actualAddedModifiedSize\": 186, \"actualDevelopmentTime\": 15.000000 },{ \"programID\": 2, \"estimatedProxySize\": 650, \"planAddedModifiedSize\": 765, \"actualAddedModifiedSize\": 699, \"actualDevelopmentTime\": 69.900000 },{ \"programID\": 3, \"estimatedProxySize\": 99, \"planAddedModifiedSize\": 141, \"actualAddedModifiedSize\": 132, \"actualDevelopmentTime\": 6.500000 },{ \"programID\": 4, \"estimatedProxySize\": 150, \"planAddedModifiedSize\": 166, \"actualAddedModifiedSize\": 272, \"actualDevelopmentTime\": 22.400000 },{ \"programID\": 5, \"estimatedProxySize\": 128, \"planAddedModifiedSize\": 137, \"actualAddedModifiedSize\": 291, \"actualDevelopmentTime\": 28.400000 }," 
                          + "{ \"programID\": 6, \"estimatedProxySize\": 302, \"planAddedModifiedSize\": 35, \"actualAddedModifiedSize\": 331, \"actualDevelopmentTime\": 65.900000 },{ \"programID\": 7, \"estimatedProxySize\": 95, \"planAddedModifiedSize\": 136, \"actualAddedModifiedSize\": 199, \"actualDevelopmentTime\": 19.400000 },{ \"programID\": 8, \"estimatedProxySize\": 945, \"planAddedModifiedSize\": 1206, \"actualAddedModifiedSize\": 1890, \"actualDevelopmentTime\": 198.700000 },{ \"programID\": 9, \"estimatedProxySize\": 368, \"planAddedModifiedSize\": 433, \"actualAddedModifiedSize\": 788, \"actualDevelopmentTime\": 38.800000 },{ \"programID\": 10, \"estimatedProxySize\": 961, \"planAddedModifiedSize\": 1130, \"actualAddedModifiedSize\": 1601, \"actualDevelopmentTime\": 138.200000 }]";
        
        argumentos[1] = "EPSADT";
        argumentos[2] ="386";
        
        App.main(argumentos);
        assertTrue(true);
    }
    
    public void testApp3()
    {
        String[] argumentos = new String[3];
        argumentos[0] = "[{ programID: 1, estimatedProxySize:177, actualAddedModifiedSize:124, actualDevelopmentTime:382.0}" +
                            ",{ programID: 2, estimatedProxySize:241, actualAddedModifiedSize:247, actualDevelopmentTime:877.0}" +
                            ",{ programID: 3, estimatedProxySize:65, actualAddedModifiedSize:144, actualDevelopmentTime:203.0}" +
                            ",{ programID: 4, estimatedProxySize:86, actualAddedModifiedSize:130, actualDevelopmentTime:373.0}" +
                            ",{ programID: 5, estimatedProxySize:12, actualAddedModifiedSize:16, actualDevelopmentTime:147.0}]";
        
        argumentos[1] = "EPSADT";
        argumentos[2] ="386";
        
        App.main(argumentos);
        
        assertTrue(true);
    }
    
    public void testApp4()
    {
        String[] argumentos = new String[3];
        argumentos[0] = "[{ programID: 1, estimatedProxySize:177, actualAddedModifiedSize:124, actualDevelopmentTime:382.0}" +
                            ",{ programID: 2, estimatedProxySize:241, actualAddedModifiedSize:247, actualDevelopmentTime:877.0}" +
                            ",{ programID: 3, estimatedProxySize:65, actualAddedModifiedSize:144, actualDevelopmentTime:203.0}" +
                            ",{ programID: 4, estimatedProxySize:86, actualAddedModifiedSize:130, actualDevelopmentTime:373.0}" +
                            ",{ programID: 5, estimatedProxySize:12, actualAddedModifiedSize:16, actualDevelopmentTime:147.0}]";
        
        argumentos[1] = "EPSADT";
        argumentos[2] ="386";
        
        App.main(argumentos);
        
        assertTrue(true);
    }
}
