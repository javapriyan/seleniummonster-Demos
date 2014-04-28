/**
 * 
 */
package main.test.org.seleniummonster.com.demo;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.Zip;

/**
 * @author Karthikeyan Annamalai
 *
 */
public class ZippingDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Zip zipFolder=new Zip();
		File sourceFile=new File("D:\\testFolder");
		File destinationFile=new File("D:\\testFolder\\ExecutionReport.zip");
		File unzipLocation=new File("D:\\Unzipped");

		try {

			if(destinationFile.isFile())
				destinationFile.delete();

			//Zipp
			zipFolder.zip(sourceFile,destinationFile);
			
			// unzip
			zipFolder.unzip(destinationFile, unzipLocation);
			
			// rest of the methods will be updated soon 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
