##About##

**cuc_jav_webdriver** is a template for a [Cucumber-jvm](https://github.com/cucumber/cucumber-jvm), JAVA, [Selenium WebDriver](http://www.seleniumhq.org/projects/webdriver/) (supports UI testing), [rest-assured](https://github.com/jayway/rest-assured) (supports API testing) and [JUnit](http://junit.org/) project. 

This template implements the [Selenium Page Object](http://www.seleniumhq.org/docs/06_test_design_considerations.jsp#page-object-design-pattern) design pattern.  This template also supports server endpoint testing using the [rest-assured](http://www.jayway.com/2013/11/29/rest-assured-2-0-testing-your-rest-services-is-easier-than-ever/) framework. Endpoint testing bypasses the browser UI and directly tests the server. Rest-assured supports both JSON (e.g RESTfull) and XML (e.g. SOAP) based protocols.

The purpose of this template is to provide a quick start to new software test automation projects. 

To get started, create a copy of this project in a directory on your machine (e.g. download the zip or better [fork the repository](http://blog.scottlowe.org/2015/01/27/using-fork-branch-git-workflow/) which allows you to **git pull** updates). The root directory should be a project name of your choosing.

##Modify pom.xml##

Modify the pom.xml file.  Use [this](https://maven.apache.org/pom.html) as a guide.

At a minimum you should supply new values for **groupId** (unique within your organization) and **artifactId** (generally your project name). Changes must be reflected in the folder names of your project. For example, your project won't likely be called cuc_jav_webdriver; neither should your project's root folder.

It is a good practice to match your groupId to your package (high level directory) structure.

##Use Latest versions##

I recommend updating the dependencies in pom.xml to the latest versions in [Maven](https://maven.apache.org/install.html).  In a command prompt, cd to your project's root folder and:

    mvn versions:use-latest-versions -DallowSnapshots=true -DexcludeReactor=false

This will update the dependency versions in the parent POM.

##Installations##

For Java 1.8 see the Oracle [download](http://www.oracle.com/technetwork/java/javase/downloads/index.html) page.  Be sure to install the **JDK**, *not* Java SE.

For Eclipse see the Eclipse [download](http://www.eclipse.org/downloads/) page. Recommendation is to install **Eclipse IDE for Java Developers**.

See the Caveats section for Google chromedriver installation (not required).

Maven dependencies are installed via the pom.xml file. This is discussed next.

##Eclipse##

The Eclipse IDE is recommended.  Make sure that the Maven [M2e](http://www.eclipse.org/m2e/) plugin is installed.  Then "Import > Maven > Existing project into workspace..." and select your pom.xml.

M2e will automatically manage your dependencies and download them as required.

[IntelliJ](https://www.jetbrains.com/idea/) is an alternative to Eclipse. Details are not covered here.

##Hello World##

This project contains a Hello World example that searches Google.

To execute the test, using Eclipse, navigate to **src/test/java/runsupport** and edit **RunCukesTest.java** to verify that **@CucumberOptions** specifies **Tags = @search**. Right-click on **RunCukesTest.java**.
In the menu click on **Run As** then select **JUnit Test**.

The last two Gherkin steps are pending and are left as an exercise.

There is a second demo used to demonstrate the wait for page load support (see below) and the elapsed time services.  To run it replace the **@search** tag in **src/test/java/runsupport/RunCukesTest.java** with **@hobbes** then right-click on **runsupport/RunCukesTest.java** > **Run As** > **JUnit Test**.  

A third demo has been added to show support for the [jayway rest-assured Java DSL](https://github.com/jayway/rest-assured/wiki). Rest-assured provides a simplified way to test both [REST](http://rest.elkstein.org/2008/02/what-is-rest.html) compliant and XML based endpoints.  To execute the rest-assured demo navigate to **src/test/java/runsupport/RunCukesTest.java**, replace the tag with **@api** then right-click on **RunCukesTest.java**. In the menu click on **Run As** then select **JUnit Test**. Tagging scenarios with **@api** causes the scenario @Before hook to bypass Selenium browser initialization.

A fourth demo was added to demonstrate how data tables defined in feature files can be converted to List, Map and even custom objects that you define. Use the tag **@datatab**. Hat tip to Thomas Sundberg at Think Code AB.

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

##Overriding @CucumberOptions##

The JUnit runner (RunCukesTest.java in package runsupport) has the annotation

    @CucumberOptions(

followed by a bunch of cucumber runtime options (e.g. which tags to execute).  The problem is that annotations are set in stone at compile time.  To change which tags to execute you need to edit the file.  This is time consuming and it confuses git with unnecessary changes.  There is a better way.

In Eclipse you can use the java command-line **-Dcucumber.options** command to completely override the **@CucumberOptions** annotation.  However, the two do not directly translate so some care must be taken.  The @CucumberOptions annotation converts the specified parameters to a format that cucumber-jvm expects.  It is this internal format that you must specify in 


    -Dcucumber.options  

Here is an example:

    @RunWith(Cucumber.class)
    @CucumberOptions(
            monochrome = true,
            features = "classpath:features",
            plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"},
            glue = { "classpath:steps", "classpath:runsupport" },
            tags = {"@search"}
            )
    public class RunCukesTest{
    
    }

The command-line system property version is:

    mvn clean test -Dcucumber.options="--tags @search --monochrome --plugin pretty:STDOUT --plugin html:target/cucumber-html-report --plugin json:target/cucumber.json --glue steps --glue runsupport classpath:features"

Note the double dash characters before keywords.  Also notice that since there are two glue paths that there are two --glue clauses.  Also note that only the package name of the two -glue paths were specified.

Further note that STDOUT needed to be specified on --plugin pretty:STDOUT.

Finally note that the **features** keyword was dropped completely. The path specified at the end (without a keyword) tells cucumber-jvm where to find the feature files.

Be warned, if you get any of this wrong then cucumber-jvm gives you cryptic error messages. The usage is explained [here](https://github.com/cucumber/cucumber-jvm/blob/0aecc4d3e4c15fc34b63f848043deba2c230e35f/core/src/main/resources/cucumber/api/cli/USAGE.txt).

###More on tags###

The tags are the things most likely to change from run to run so here are some more rules.  To execute @tag1 or @tag2

    --tags @tag1,@tag2

To execute @tag1 and @tag2

    --tags @tag1 --tags @tag2

To execute (@tag1 or @tag2) and not @tag3

    --tags @tag1,@tag2 --tags ~@tag3

###Running -Dcucumber.options from Eclipse###

To run using **-Dcucumber.options** inside Eclipse use the Maven Build configuration type.  To get a Maven Build configuration click on **Run > Run Configurations...**. On the left pane double-click **Maven Build**. A default Maven Build configuration is created. Give it a good name and on the **Goals** line type 

    clean test -Dcucumber.options(your options here)

Note that **mvn** is assumed so omit it.  Remember that **-Dcucumber.options** completely overrides the **@CucumberOptions** line in your RunCukesTest (or whatever you named it) class. Eclipse saves the new Maven Build run configuration so it is easy to use it again.

###To run from a command line (or say in Jenkins)###

    cd <your projects root directory, the one containing your pom.xml file>
    mvn clean test -Dcucumber.options(your options here)

##Tag conventions##

Tag **@api** causes API tests to execute.  All API tests should specify this tag in their feature file.  By convention, tag **@ui** causes all Selenium based browser tests to execute.  You should add tag **@ui** to all selenium based tests in their feature file.

To run all tests specify **Tags = @ui,@api** in *@CucumberOptions* or **--tags @ui,@api** in *-Dcucumber.options*.

##Caveats##

<ol>
<li>The pom.xml places the project root folder in the default classpath.  If you move the **log4j.properties** file you must [add the new location](https://maven.apache.org/surefire/maven-surefire-plugin/examples/configuring-classpath.html) to the default classpath.  

<li>To use the <b>chromedriver</b> you first have to [download it](https://sites.google.com/a/chromium.org/chromedriver/downloads) and then create a system environment variable named <b>CHROMEDRIVER</b> which you set to the chromedriver's download location.  Let's say that you down-loaded chromedriver.exe to <b>c:\WebDriver\chromedriver.exe</b>.   Then you would set system environment variable 

    CHROMEDRIVER="c:\WebDriver\chromedriver.exe" 
      
To create an environment variable:
<ul>
<li>On windows System > Advanced System Settings > Environment Variables.. > (under System variables) New
<li>Linux it varies, on Ubuntu Place in file /etc/environment
<li>This framework requires that you have <b>Java 1.8</b> installed and available.  This framework uses Java functionality that is not available in previous versions.
</ul>

Edit <b>src/config.properties</b> and set:

    browser=chrome
    
<li>The <b>@api</b> tag tells the cucumber @Before and @After hooks to <i>not</i> instantiate a selenium browser.  <b>@api</b> tags should be applied to every <b>rest-assured</b> scenario.  Failure to do so will unnecessarily open a browser instance during scenario execution, lengthening the test duration.  Execution speed is an important consideration for API level tests.  The cumulative penalty across many API tests can be substantial.
<li>Do not mix API and UI step definitions in the same file.  UI step definition files inherit from class DriverFactory.  API step definition files <b>do not</b>.
</ol>

##Explore##

Read this [eBook](https://www.gitbook.com/book/sukesh15/cucumber-jvm-test-framework-/details) to learn more about cucumber-jvm frameworks.

##Legal stuff##

This code is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This code is provided in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

A copy of the license is provided at the following URL: http://www.gnu.org/licenses/gpl-3.0.html





