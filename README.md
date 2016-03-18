**cuc_jav_webdriver** is a Maven template for a Cucumber-jvm, JAVA, Selenium WebDriver and JUnit project. 

This template implements the [PageObject/PageFactory](http://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html) framework.

Create a copy of this project in a directory on your machine. The root directory should be a project name of your choosing.

##Modify pom.xml##

Modify the pom.xml file.  Use [this](https://maven.apache.org/pom.html) as a guide.

At a minimum you should supply new values for **groupId** (unique within your organization) and **artifactId** (generally your project name). Changes must be reflected in the folder names of your project. For example, your project won't likely be called cuc_jav_webdriver; neither should your project root folder.

It is a good practice to match your groupId to your package (high level directory) structure.

##Use Latest versions##

I recommend updating the dependencies in pom.xml to the latest versions in Maven.  In a command prompt, cd to your project's root folder and:

    mvn versions:use-latest-versions -DallowSnapshots=true -DexcludeReactor=false

This will update the dependency versions in the parent POM.

**Important** 

As of this writing, Maven has a bug with package xml-apis. Back in 2002 it was mistakenly updated to version 2.0.2.  The latest version as of this writting is 1.4.01 which you can check [here](http://mvnrepository.com/artifact/xml-apis/xml-apis).
Open pom.xml and search for xml-apis

If it looks like this:

    <dependency>
	    <groupId>xml-apis</groupId>
	    <artifactId>xml-apis</artifactId>
	    <version>2.0.2</version>
    </dependency>

Then change it to this (or the latest 1.x.x version):

    <dependency>
      	<groupId>xml-apis</groupId>
    	<artifactId>xml-apis</artifactId>
    	<version>1.4.01</version>
    </dependency>

This has been broken for quite a while (since 2002).  I am surprised that nobody has fixed it. 2.0.2 is ancient.

If you don't fix this in your pom.xml then Cucumber will not be able to follow your @CucumberOptions(glue) path and your steps will not be found.

##Eclipse##

If using Eclipse, do "Import > Maven > Existing project into workspace..." and select your pom.xml.

M2e will automatically manage your dependencies and download them as required.

IntelliJ is an alternative to Eclipse.

##Hello World##

This project contains a Hello World example that searches Google.

To execute the test, using Eclipse, navigate to src/test/java/runsupport then right-click on RunCukesTest.java.
In the menu click on **Run As** then select **JUnit Test**.

The last two steps are pending and are left as an exercise.

##Explore##

Read this [eBook](https://git-scm.com/book/en/v2) to learn more.




