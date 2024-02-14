
*****************************************************PROJECT DESCRIPTION*****************************************************************
 
Problem Statement : GSD

1.Login into Be.cognizant

2.Verify the Username

3.Navigate to GSD and get information based on different random location
 
Detailed description: Main Project
 
 
1.Navigate to becognizant

2.Verify and capture user information

3.Verify if onecognizant if present or not

4.Click on one cognizant

5.Search for gsd

6.Click on live support gsd

7.Verify for successful navigation to gsd module

8.Verify if welcome message id displayed or not

9.Print default selected language

10.Print all languages from drop down

11.Verify default locaiton

12.Print all drop down values

13.Print all information for default country

13.Generate two random numbers, select countries based on that and print all information for them
 
Key  Automation Scope:
 
Capturing the screenshot

Navigation to new page

Printing all the values in console and excel sheet
 
**********************************************************STEPS TO EXECUTE*************************************************************
 
-unzip the folder

-On eclipse, goto file->import->select the maven->click on existing maven project->next->browse the location unzip the folder-> click on finish

-Now go to the testRunner file and run.

-Now the file will Execute and we get the expected output as shown below.
 
*******************************************************FILES DESCRIPTION**************************************************************
 
1. src/test/java: There are five packages in this folder- factory, page object,stepdefinition,testrunner and utilities.

factory contains baseclass which chooses the browser and get the url in this package, pageobject package contains becognizant, oncognizant, GSD and base page in which base page initilize the driver and becognizant, oncognizant, GSD which contains method and functions in it,steppdefinition which contains gsd and hooks, gsd contains stepdefinations which calls the methods in actions class to perform the required conditions then hooks cantains the properties for execution, testrunner contains testRunner class which runs the program in junit and utilities contains readexcel and writexcel classes for reading and writing the data.
 
2.src/test/resources: There are two properties which are config and extent for setting the properties for execution.
 
3.Maven Dependencies: In this File we have all the directory on the local machine, where all the project artifacts are stored. when a Maven build is executed,

Maven automatically downloads all the dependency jars into the local repository. Usually, this directory is named.
 
3.excelsheet: In this folder we have .xlsx files for reading and writing.
 
4.featurefile: In this we have feature file with four scenarios.
 
5.readme: In this we have readme file which is for description.
 
6.screenshots: This folder stores the result screenshot.
 
5. target: In this folder we have cucumber reports.
 
6. test-output: This folder contains sparkreports.
 
7.pom.xml: The pom.xml file contains information of project and configuration information for the maven to build the project such as dependencies,

build directory, source directory, test source directory, plugin, goals etc. Maven reads the pom.xml file, then executes the goal.
 