
Travis CI + [Codecov][0] + Junit5 + jacoco + Maven Java Example
===============================
## 1: Add some code in  pom.xml and .travis.yml
* 1). Add `jacoco-maven-plugin` and  `maven-surefire-plugin` plugin to your pom.xml file, [see here](https://github.com/lovepoem/codecov-travis-maven-junit5-example/blob/master/pom.xml#L39-L50)
* 2). Call `mvn clean package` during your CI tests, [see here](https://github.com/lovepoem/codecov-travis-maven-junit5-example/blob/master/.travis.yml#L4)
* 3). Call `bash <(curl -s https://codecov.io/bash)` at the end of your CI build, [see here](https://github.com/lovepoem/codecov-travis-maven-junit5-example/blob/master/.travis.yml#L7)
  - Using Travis CI, CircleCI or AppVeyor **AND** the repository is public? **You're done!** No token needed.
  - Otherwise, please add your [repository token token][5].

> Other Examples
> - [Java JaCoCo Example][1]
> - [Android Example][3]
> - [Gradle Example][2]


[0]: https://codecov.io/
[1]: https://github.com/codecov/example-java
[2]: https://github.com/codecov/example-gradle
[3]: https://github.com/codecov/example-android
[5]: http://docs.codecov.io/docs/about-the-codecov-bash-uploader#section-upload-token

## 2 : Add repository to travis ci and codev with github account 

  - login https://travis-ci.org/ and add lovepoem/codecov-travis-maven-junit5-example repository to https://travis-ci.org/
  - login https://codecov.io/ and add lovepoem/codecov-travis-maven-junit5-example repository to https://codecov.io/

## 3: Add travis and codecov icon in  README.md
[![Build Status](https://travis-ci.org/lovepoem/codecov-travis-maven-junit5-example.svg?branch=master)](https://travis-ci.org/lovepoem/codecov-travis-maven-junit5-example)
[![codecov](https://codecov.io/gh/lovepoem/codecov-travis-maven-junit5-example/branch/master/graph/badge.svg)](https://codecov.io/gh/lovepoem/codecov-travis-maven-junit5-example)

## 4: Notice

   But it is always not success:
   After CI success , jacoco should push the report to the codecov . but at first time jacoco cannot do it . It seems that there is a door ,but you cannot enter
   I thick it's a bug of jacoco, now I have a hack method to " Open the door ":
   
* 1. Add denpendency of `cobertura-maven-plugin` in the `build` tag of  pom.xml
   ```xml
       <plugin>
           <groupId>org.codehaus.mojo</groupId>
           <artifactId>cobertura-maven-plugin</artifactId>
           <version>2.7</version>
           <configuration>
               <formats>
                   <format>html</format>
                   <format>xml</format>
               </formats>
               <check />
           </configuration>
       </plugin>
   ```
* 2. Set the script in the .travis.yml
   
   ```shell
   script:
     - mvn cobertura:cobertura
   ```
   Then push th code ,you will find that the door is open . the codecov report is uploaded
   
* 3. Use `jacoco` instead of  `cobertura` ,because cobertura is out of maintain for several years
   modify the config
            
   ```shell
   script:
     - mvn clean package
   ```
   
   remove the `cobertura-maven-plugin` plugin
   
   and add
   
   ```xml
           <plugin>
               <groupId>org.jacoco</groupId>
               <artifactId>jacoco-maven-plugin</artifactId>
               <version>${maven-jacoco.version}</version>
               <executions>
                   <execution>
                       <id>jacoco-initialize</id>
                       <goals>
                           <goal>prepare-agent</goal>
                       </goals>
                       <configuration>
                           <propertyName>jacocoArgLine</propertyName>
                       </configuration>
                   </execution>
                   <execution>
                       <id>report-aggregate</id>
                       <phase>verify</phase>
                       <goals>
                           <goal>report-aggregate</goal>
                       </goals>
                   </execution>
               </executions>
           </plugin>
           <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-surefire-plugin</artifactId>
               <version>${maven-surefire.version}</version>
               <configuration>
                   <useSystemClassLoader>true</useSystemClassLoader>
                   <forkMode>once</forkMode>
                   <argLine>${argline} ${jacocoArgLine}</argLine>
                   <systemProperties>
                       <!-- common shared -->
                   </systemProperties>
               </configuration>
           </plugin>
   ```
   Then the new config can also upload the report now   
   