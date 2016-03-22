##About##

**cuc_jav_webdriver** is a template for a [Cucumber-jvm](https://github.com/cucumber/cucumber-jvm), JAVA, [Selenium WebDriver](http://www.seleniumhq.org/projects/webdriver/) and [JUnit](http://junit.org/) project. 

This template implements the [Page Object](http://www.seleniumhq.org/docs/06_test_design_considerations.jsp#page-object-design-pattern) design pattern.  This template also supports REST endpoint testing using the [rest-assured](http://www.jayway.com/2013/11/29/rest-assured-2-0-testing-your-rest-services-is-easier-than-ever/) framework. REST endpoint testing bypasses the browser UI and directly tests the server.

The purpose of this template is to provide a quick start to new software test automation projects. 

To get started, create a copy of this project in a directory on your machine (e.g. download the zip). The root directory should be a project name of your choosing.

##Modify pom.xml##

Modify the pom.xml file.  Use [this](https://maven.apache.org/pom.html) as a guide.

At a minimum you should supply new values for **groupId** (unique within your organization) and **artifactId** (generally your project name). Changes must be reflected in the folder names of your project. For example, your project won't likely be called cuc_jav_webdriver; neither should your project's root folder.

It is a good practice to match your groupId to your package (high level directory) structure.

##Use Latest versions##

I recommend updating the dependencies in pom.xml to the latest versions in [Maven](https://maven.apache.org/install.html).  In a command prompt, cd to your project's root folder and:

    mvn versions:use-latest-versions -DallowSnapshots=true -DexcludeReactor=false

This will update the dependency versions in the parent POM.

##Eclipse##

If using Eclipse, make sure that the Maven [M2e](http://www.eclipse.org/m2e/) plugin is installed.  Then "Import > Maven > Existing project into workspace..." and select your pom.xml.

M2e will automatically manage your dependencies and download them as required.

[IntelliJ](https://www.jetbrains.com/idea/) is an alternative to Eclipse.

##Hello World##

This project contains a Hello World example that searches Google.

To execute the test, using Eclipse, navigate to **src/test/java/runsupport** then right-click on **RunCukesTest.java**.
In the menu click on **Run As** then select **JUnit Test**. You may need to add the log4j.properties to the Eclipse classpath before running.  Instructions are in the **Caveats** section below.

The last two Gherkin steps are pending and are left as an exercise.

There is a second demo used to demonstrate the wait for page load support (see below) and the elapsed time services.  To run it replace the **@search** tag in **src/test/java/runsupport/RunCukesTest.java** with **@hobbes** then right-click on **runsupport/RunCukesTest.java** > **Run As** > **JUnit Test**.  

A third demo has been added to show support for the [jayway rest-assured Java DSL](https://github.com/jayway/rest-assured/wiki). Rest-assured provides a simplified way to test [REST](http://rest.elkstein.org/2008/02/what-is-rest.html) endpoints.  To execute the rest-assured demo navigate to **src/test/java/runsupport/RunCukesTest.java**, replace the tag with @rest then right-click on **RunCukesTest.java**. In the menu click on **Run As** then select **JUnit Test**.

##Advanced Cucumber Reporting##

This template includes support for an advanced cucumber reporting solution described by [Nickolay Kolesnik](http://mkolisnyk.blogspot.com/2015/05/cucumber-jvm-advanced-reporting.html).   To use it simply repeat Hello World but this time navigate to **src/test/java/runsupport** then right-click on **RunExtendedReportingCukeTests.java** > **Run As** > **JUnit Test**.

The **Overview Chart** can be found in file **target/cucumber-results-feature-overview.html**.

The **Usage Report** can be found in file **target/cucumber-usage-report.html**.

Note. Depending on how you have setup Eclipse, you may need to right-click on the **target** folder and click **source** > **format** to see the html files.

Nickolay has extended his framework as described [here](http://mkolisnyk.blogspot.com/2015/06/cucumber-jvm-advanced-reporting-2.html) and [here](http://mkolisnyk.blogspot.com/2015/10/cucumber-jvm-advanced-reporting-3.html). The downloaded jar contains support for all this but these advanced features are left as an exercise for the reader.

##Wait for Page Load##

Helper class **HelpWithJavascriptLibraries** contains sophisticated methods that wait for page loads to complete.  The **jquery**, **angular**, and **prototype** frameworks are supported.  Jquery support includes wait for loading spinner which has been customized for the tag @hobbes demo.  You will need to analyze how your loading spinner was implemented and make corresponding adjustments to the code. E.g. development may have used By.className=("spinner").

##Log4j##

Log4j is configured to send INFO and above to the console and ERROR and above to the log file. Both the **log4j.properties** and the **messages.log** files are in the project's root folder.

##Caveats##

**Important**.  Do the following to add log4j.properties to the Eclipse classpath.  Click on: Run -> Run Configuration -> [classpath tab] -> click on User Entries -> Advanced -> Select Add Folder -> select the location of your log4j.properties (your project root folder /) file and then -> OK -> Run

To use the **chromedriver** you first have to [download it](https://sites.google.com/a/chromium.org/chromedriver/downloads) and then create a system environment variable named **CHROMEDRIVER** which you set to the chromedriver's download location.  Lets say that you downloaded chromedriver.exe to **c:\WebDriver\chromedriver.exe**.   Then you would set system environment variable 

    CHROMEDRIVER="c:\WebDriver\chromedriver.exe" 
      
To create an environment variable:
<ul>
<li>On windows System > Advanced System Settings > Environment Variables.. > (under System variables) New
<li>Linux it varies, on Ubuntu Place in file /etc/environment
</ul>

Edit **src/config.properties** and set:

    browser=chrome
    

##Explore##

Read this [eBook](https://www.gitbook.com/book/sukesh15/cucumber-jvm-test-framework-/details) to learn more about cucumber-jvm frameworks.





