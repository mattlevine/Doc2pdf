package com.blueriver.pdf;

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
    public void testApp()
    {
        Doc2pdf doc2pdf1 = new Doc2pdf();  
        doc2pdf1.convert("/Users/matthewlevine/projects/ConvertPdf/src/test/resources/pdf.docx", "/Users/matthewlevine/projects/ConvertPdf/src/test/resources/pdf.pdf");

        Watermark watermark = new Watermark();  
        watermark.create("/Users/matthewlevine/projects/ConvertPdf/src/test/resources/watermark.png", "info@example.com", 800, 200);  

    
    }
}
