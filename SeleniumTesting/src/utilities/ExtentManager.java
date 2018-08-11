package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports report;
	
	public static ExtentReports createInstance(String sTestName) {
		String dateAndTime=Utils.generateCurrentDatewithTimeStamp();
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\"+sTestName+"-"+dateAndTime+".html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		
		report.setSystemInfo("OS", "Windows7");
		report.setSystemInfo("Host Name", "Sagar");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Sagar Chakilala");
		
		htmlReporter.config().setDocumentTitle(sTestName);
		htmlReporter.config().setReportName(sTestName+" - Extent Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
		return report;
	}

}
