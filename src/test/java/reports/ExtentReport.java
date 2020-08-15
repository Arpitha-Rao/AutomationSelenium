package reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReport {
	ExtentReports reportexe;
	
	@BeforeTest
	public void config() {
		
		//Extent Report Generation
		// ExtentReports, ExtentSparkReporter class , These two helps to generate report
		String location=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(location);
		//Setting report name
		reporter.config().setReportName("Web Automation Report");
		//Set document title
		reporter.config().setDocumentTitle("Xoriant Results");
		
		//To drive the execution of report . Its a main class
		 reportexe= new ExtentReports();
		reportexe.attachReporter(reporter);
		reportexe.setSystemInfo("Tester", "Arpitha Rao");
		
	}
	
	@Test
	public void initialDemo() {
		
		//creating testcase
		ExtentTest test=reportexe.createTest("Initial Demo");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rao_ar\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https:/rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Result do not catch");
		
		//It will update the status pass/fail
		reportexe.flush();
	}

}
