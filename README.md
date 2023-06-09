# jcstress workshop

## Preparation.

1. Setup maven to work from the cmdline or IDE. 
2. Setup JDK to work from cmdline or IDE.
3. Create jcstress basic maven project:
   ```shell
    mvn archetype:generate 
    "-DinteractiveMode=false" 
    "-DarchetypeGroupId=org.openjdk.jcstress"
    "-DarchetypeArtifactId=jcstress-java-test-archetype"
    "-DgroupId=org.example" 
    "-DartifactId=jcstress-workshop" 
    "-Dversion=1.0"
   
   ```
4. Check everything by running:
   ```shell
   mvn clean verify
   java -jar target/jcstress.jar
   ```
   This should run a default created test.

## Labs
### Lab 1. Basic tests.
#### Lab 1.1 Outcome annotations  

Jcstress is experimental framework. To create test experiment you need 
to describe experiment outcomes. Outcome annotation is used for that: 
```java
@Outcome(id = "0, 0", expect = Expect.ACCEPTABLE, desc = "Default outcome.")
```
There is 3 types of expectations: 
 * ACCEPTABLE
 * FORBIDDEN, if any test result match this test will marked as failed
 * INTERESTING, will mark this test result in report, but will not throw error

---

#### Lab 1.2 (optional) Run-configuration for one click test run.

IntelliJ don't have automatic creation of runConfigurations for jcstress.
To fix this we need to create a special runConfiguration by hand. 
1. Create a java runConfiguration that will run mainClass: `org.openjdk.jcstress.Main`
2. Add maven task to before launch sequence `clean verify`
3. Add program arguments `-t Lab1` 

--- 
### Lab 2.  
#### Lab 2.0. Using arbiter to check final result
#### Lab 2.1. Nesting tests

### Lab 3. Fix multimap.
