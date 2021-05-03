# TDD Basic Example

This project shows a basic TDD example with some of the most common annotations.

This project used Java and Maven.

We have to declare the maven-surefire-plugin in the pom.xml file and configure the dependencies of this plugin. 

We have to declare the following dependencies:

The junit-platform-surefire-provider dependency allows us to run tests that use either the “old” JUnit (3 or 4) or JUnit 5.

If we want to run tests that use either JUnit 3 or 4, we have to declare the junit-vintage-engine dependency.

If we want to run tests that use JUnit 5, we have to declare the junit-jupiter-engine dependency.

* Junit Jupiter Dependency graph
    - https://junit.org/junit5/docs/current/user-guide/
* JUnit Annotation
    - https://junit.org/junit5/docs/current/user-guide/#writing-tests-annotations

  
## Maven goals
### Run the unit tests
```
mvn clean test
```

### Generate javadoc for the source code
```
mvn javadoc:javadoc
```

### Generate javadoc for the test code
```
mvn javadoc:test-javadoc
```

### Generate Jacoco source code coverage report
```
mvn test jacoco:report
```

### Check if thresholds limits are achieved
```
mvn test jacoco:check
```

### Generates a PIT Mutation coverage report to target/pit-reports/YYYYMMDDHHMI
```
mvn org.pitest:pitest-maven:mutationCoverage
```

### Generates a quicker PIT Mutation coverage report to target/pit-reports/YYYYMMDDHHMI
```
mvn org.pitest:pitest-maven:mutationCoverage -DwithHistory
```

### Complete example

``` 
mvn test jacoco:report org.pitest:pitest-maven:mutationCoverage -DhistoryInputFile=target/fasterPitMutationTesting-history.txt -DhistoryOutputFile=target/fasterPitMutationTesting-history.txt -Dsonar.pitest.mode=reuseReport -Dthreads=4 -DtimestampedReports=false
```
## Jacoco dependencies
* https://github.com/pitest/pitest-junit5-plugin
  - https://mvnrepository.com/artifact/org.pitest/pitest-junit5-plugin
    - required to work with JUnit5

## Test sum method
- [x] add positive to positive number returns positive
- [x] add smaller negative to bigger positive number returns positive
- [x] add zero to positive number returns positive
- [x] add negative to negative number returns negative
- [ ] add zero to negative number returns negative
- [ ] add positive number to zero returns positive
- [ ] add negative number to zero returns negative

## Test subtract method
- [x] subtract bigger positive from smaller positive number returns negative number
- [x] subtract smaller positive from bigger positive number returns positive number
- [x] subtract negative from equal positive number returns positive number
- [x] subtract positive from equal negative number returns negative number
- [ ] subtract 2 equal negative numbers from each other returns zero
- [ ] subtract 2 equal positive numbers from each other returns zero
- [ ] subtract bigger positive from smaller negative number returns negative number
- [ ] subtract smaller positive from bigger negative number returns negative number
- [ ] subtract smaller negative from bigger positive number
- [ ] subtract negative from negative number
- [ ] subtract zero from positive number
- [ ] subtract zero from negative number
- [ ] subtract positive number from zero
- [ ] subtract negative number from zero

## Test divide method
- [x] divide positive by positive number returns positive number
- [x] divide positive by negative number returns negative number
- [x] divide negative by positive number returns negative number
- [x] divide negative by negative number returns positive number
- [ ] divide zero by positive number returns zero
- [ ] divide zero by negative number returns zero
- [x] divide positive number by zero returns exception
- [ ] divide negative number by zero returns exception

## Test multiply method
- [ ] multiply positive with positive number returns positive number
- [x] multiply positive with negative number returns negative number
- [x] multiply negative with positive number returns negative number
- [x] multiply negative with negative number returns positive number
- [x] multiply zero with positive number returns zero [^1]
- [x] multiply zero with negative number returns zero [^1]

[^1] accomplished in a parameterized test

## Test factorial method
- [x] positive number factored returns positive number
- [x] negative number factored returns 1
- [ ] zero factored returns 1