/**
 * 
 */
package main.test.org.seleniummonster.com.demo;

import org.openqa.selenium.os.CommandLine;

/**
 * @author Karthikeyan Annamalai
 *
 */
public class ByChainedExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		
		String[] cmds={"date","dir"};
		CommandLine cl=new CommandLine(cmds);
		cl.execute();
		System.out.println("The out put is "+cl.getStdOut());
		
		
	}

}




