package outLookpkg;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DownloadPDF {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		
		System.out.println("opening connection");
	    URL url = new URL("https://ebooksecurepdf.s3.ap-south-1.amazonaws.com/ebooks/9e182952-b97f-47a9-a314-de6f306554c7.pdf");
	    InputStream in = url.openStream();
	    FileOutputStream fos = new FileOutputStream("/Users/HIDDEN/Desktop/fullreport.pdf");

	    System.out.println("reading file...");
	    int length = -1;
	    byte[] buffer = new byte[1024];// buffer for portion of data from
	    // connection
	    while ((length = in.read(buffer)) > -1) {
	        fos.write(buffer, 0, length);
	    }
	    fos.close();
	    in.close();
	    System.out.println("file was downloaded");
	    }
		
		
		
		
		
		
		

}


