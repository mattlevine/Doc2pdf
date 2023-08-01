package com.mattlevine.pdf;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;

import java.io.*;

public class Doc2pdf 
{

	 public void convert( String docPath, String pdfPath )
    {
    		try {
    		InputStream docFile = new FileInputStream(new File(docPath));
    		XWPFDocument doc = new XWPFDocument(docFile);
    		PdfOptions pdfOptions = PdfOptions.create();
    		OutputStream out = new FileOutputStream(new File(pdfPath));
    		PdfConverter.getInstance().convert(doc, out, pdfOptions);
    		doc.close();
    		out.close();
    	
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}