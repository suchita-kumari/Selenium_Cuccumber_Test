# Pre-requisites
- <a href="https://java.com/en/download/manual.jsp" target="_blank">Java</a>
- <a href="https://maven.apache.org/download.cgi" target="_blank">Maven</a>
- <a href="https://www.jetbrains.com/idea/download" target="_blank">IntelliJ IDEA</a>
- <a href="https://github.com/mozilla/geckodriver/releases" target="_blank">geckodriver</a>

  
# Setting up selenium- test
- Install Java and set path.
- Install Maven and set path.
- Download geckodriver and add to path (or download and add to project home folder)
- Download browser specific driver and add it to project_home/webdrivers folder (Create webdrivers folder under project home and place the driver executable)
- Clone respective repository or download zip.
	- maven :  https://github.com/suchita-kumari/Selenium_Cuccumber_Test

# Running features
- Goto project directory.
- Use "mvn test" command to run features.
- Use "mvn test -Dbrowser=browser_name" to run features on specific browser.
- Use mvn test -Dcucumber.options="classpath:features/Login.feature" to run specific feature if you have multiple feature files.
- Use mvn test -Dcucumber.options=""--tags @Login" to run tagged Scenario from the feature files if you have multiple tag defined files.
- Use mvn test -Dcucumber.options="–-plugin html:target/result-html" to generate a HTML report.
- Use mvn test -Dcucumber.options="–-plugin json:target/result-json" to generate a JSON report.

