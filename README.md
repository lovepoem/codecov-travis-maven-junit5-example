
Travis CI + Codecov + Junit5 + jacoco + Maven + java8 above  Java Example 
==============================
## 1: Add some code in  pom.xml and .travis.yml
* 1). Add `jacoco-maven-plugin` and  `maven-surefire-plugin` plugin to your pom.xml file, [see here](https://github.com/lovepoem/codecov-travis-maven-junit5-example/blob/master/pom.xml#L52-L93)
* 2). Call `mvn clean package` during your CI tests, [see here](https://github.com/lovepoem/codecov-travis-maven-junit5-example/blob/master/.travis.yml#L11)
* 3). Call `bash <(curl -s https://codecov.io/bash)` at the end of your CI build, [see here](https://github.com/lovepoem/codecov-travis-maven-junit5-example/blob/master/.travis.yml#L13)
 
## 2 : Add repository to travis ci and codev with github account 

  - login https://travis-ci.org/ and add lovepoem/codecov-travis-maven-junit5-example repository to https://travis-ci.org/
  - login https://codecov.io/ and add lovepoem/codecov-travis-maven-junit5-example repository to https://codecov.io/

## 3: Add travis and codecov icon in  README.md
[![Build Status](https://travis-ci.org/lovepoem/codecov-travis-maven-junit5-example.svg?branch=master)](https://travis-ci.org/lovepoem/codecov-travis-maven-junit5-example)
[![codecov](https://codecov.io/gh/lovepoem/codecov-travis-maven-junit5-example/branch/master/graph/badge.svg)](https://codecov.io/gh/lovepoem/codecov-travis-maven-junit5-example)  

## 4: Notice
  Use `jacoco-maven-plugin` plugin `version 0.8.2` to collect test coverage without codecov token ,need jdk version: `java8`+  
  
  **So if you ues a lower jdk version , please see this repo : https://github.com/lovepoem/codecov-travis-maven-junit4-example**  
 
