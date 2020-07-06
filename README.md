# SELENIUM-JAVA-FOR-STUDIES

> Repository with examples of automation using selenium + java

> Selenium is a portable software-testing framework for web applications. Selenium provides a playback tool for authoring tests without the need to learn a test scripting language.

---

## Table of Contents

> Índice `README`.

- [Prerequisites](#prerequisites)
- [Configuration](#configuration)
- [Installation](#installation)
- [Features](#features)
- [How to run the tests](#how-to-run-the-tests)
- [Report](#report)
- [Support](#support)

---

## Prerequisites

- [JDK install +8](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Eclipse IDE install](http://www.eclipse.org/downloads/)
- [Maven install](https://maven.apache.org/install.html)
- [Cucumber plugin install](http://toolsqa.com/cucumber/install-cucumber-eclipse-plugin/)
- [Allure install](https://docs.qameta.io/allure/#_installing_a_commandline)


## Configuration
> environment variables and bash_profile

###Java
- Mac:
`export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home`

- Windows:
https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html

###Maven
- Mac:
`export PATH=/opt/apache-maven-3.5.3/bin:$PATH`

- Windows:
https://www.mkyong.com/maven/how-to-install-maven-in-windows/

## Installation

> Clone
- Clone this repo to your local machine using `https://github.com/uLucasFraga/selenium_java_for_studies.git`

- Install all dependencies (pom.xml)
`mvn install`

![Maven install example](http://g.recordit.co/vCNaZgadVu.gif)

> Tips

- Use pom.xml to install the project dependencies


## How to run the tests

> run all tests with maven

```shell
$ mvn clean test
```

> run all tests with cucumber

```shell
$ mvn clean -Dtest=CucumberRunnerTest test
```

> run all tests choosing browser and operational system (ex: Chrome for Linux)

```shell
$ mvn clean test -Dbrowsers=CHROME_LINUX
```

> run all tests with cucumber and a tag (ex: tag @example)

```shell
$ mvn test -DCucumber.options="--tags '@example'"
```


> run all tests with IntelliJ (or another IDE)

Right click on class _src.test.java.br.com.studies/runner/CucumberRunnerTest > Run 'CucumberRunnerTest'_

---

## Features
- file example `.feature`

```gherkin
#language: en

@example
Feature: Access github
  As a QA
  I want to learn how to use selenium
  To be able to automate applications like the github website

  Scenario: Validate access on github website
    Given he accesses the page
    Then he checks the text on the initial page: "Why GitHub?"
```

## Report

> run all tests and to generate an allure report

```shell
$ mvn allure:serve
```

---

## Support

- Twitter at <a href="https://twitter.com/uLucasFraga" target="_blank">`@ulucasfraga`</a>
- Facebook at <a href="https://www.facebook.com/lucass.fragaa" target="_blank">`Facebook: Lucas Fraga`</a>
- Linkedin at <a href="https://www.linkedin.com/in/ulucasfraga" target="_blank">`Linkedin: Lucas Fraga`</a>

- E-mail: `lucass.fragaa@gmail.com`
- Skype: `live:lucass.fragaa`

---

## License

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
- Copyright 2018 © <a href="https://www.linkedin.com/in/ulucasfraga" target="_blank">Lucas Fraga</a>.
