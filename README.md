**_Overview_**

 * tests for the famous Swagger Petstore. https://petstore3.swagger.io
 
 **_Prequisites_**
 
 * Java 8
 * Maven 3
 * Configured environment variables for the above (`JAVA_HOME`, `M2_HOME` and `MAVEN_HOME`)
 
 --  In order to check if your installation was succesful, in command terminal type `java -version` and check for the following output:  

`java version "1.8.0_241"
 Java(TM) SE Runtime Environment (build 1.8.0_241-b07)
 Java HotSpot(TM) 64-Bit Server VM (build 25.241-b07, mixed mode)` 
 
 and if you type `mvn -version` you should have the following output (with the platform and OS differencies)
 
`Apache Maven 3.5.0 (ff8f5e7444045639af65f6095c62210b5713f426; 2017-04-03T22:39:06+03:00)
 Maven home: C:\maven\bin\..
 Java version: 1.8.0_241, vendor: Oracle Corporation
 Java home: C:\Program Files\Java\jdk1.8.0_241\jre
 Default locale: en_US, platform encoding: Cp1252
 OS name: "windows 8.1", version: "6.3", arch: "amd64", family: "windows"`

**_Run tests_**

* In order to run your tests you need to setup the API petstore and run it locally

_`API petstore setup`_
*  Clone the API repo from here `https://github.com/swagger-api/swagger-petstore`
*  In order to run the server locally run this task: `mvn package jetty:run`
*  Check http://localhost:8080 to see if works 
*  You can then run tests using the following command `mvn clean test`

**_Test suites defined by testng.xml_**

* You can find specific test cases in their corresponding testng.xml, as for now I've only created a sanity test suite under `sanity.xml`.
 
 _**View reports**_
 
 * All reports can be found in `target/surefire-reports/html/index.html`
 
 _**When adding new tests**_
 
 * avoid brittle asserts in tests (try to assert entire response from the service)
 * use suggestive names for test methods and variables
 * format your code before commit
 * keep clean project object model, in pom.xml add only used dependencies
 
 