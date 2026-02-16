package base;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;
	private static ExtentTest test;
	
	public static String dateformat() {
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		String timestamp = LocalDateTime.now().format(df);
		return timestamp;
	}
	
	public static void intiReports() {
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\manis\\Documents\\MyselfReume\\api-test_"+ dateformat() +".html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}
	
	public static void createTest(String testname) {
		test = extent.createTest(testname);
	}

	
	public static void flushreport() {
		extent.flush();
	}
}
