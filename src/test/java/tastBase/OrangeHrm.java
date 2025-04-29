package tastBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class OrangeHrm {

	public WebDriver driver;
	public Properties p;

	@BeforeClass(groups = { "sanity", "regression", "master" })
	@Parameters({ "browser", "os" })
	public void setUp(/* @Optional("chrome") */String br, String os) throws IOException {
		FileReader fr = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(fr);
		String property = p.getProperty("execution_env");

		if (property.equals("local")) {
			if (br.equals("chrome"))
				driver = new ChromeDriver();
			else if (br.equals("edge"))
				driver = new EdgeDriver();
		} else if (property.equals("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			if (os.equals("windows"))
				cap.setPlatform(Platform.WIN11);
			else if (os.equals("mac"))
				cap.setPlatform(Platform.MAC);
			else if (os.equals("linux"))
				cap.setPlatform(Platform.LINUX);
			else {
				System.out.println("no matching os");
				return;
			}
			if (br.equals("chrome"))
				cap.setBrowserName("chrome");
			else if (br.equals("edge"))
				cap.setBrowserName("MicrosoftEdge");
			else if (br.equals("firefox"))
				cap.setBrowserName("firefox");

			driver = new RemoteWebDriver(new URL("http://192.168.1.35:4444"), cap);
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void timeGap() throws InterruptedException {
		Thread.sleep(5000);
	}

	@AfterClass(groups = { "sanity", "regression", "master" })
	public void tearEnd() {
		driver.quit();
	}
}
