# SonarWallet

An extension based crypto wallet for Ethereum and other non evm blockchains. 

## Getting Started

The below instructions will help you get a copy of the project up and running on your local machine for executing automation test cases.

### Prerequisites

To run Selenium with Java in Eclipse, you will need to have the following prerequisites:

* Eclipse: Eclipse is a widely-used integrated development environment (IDE) for Java programming. You can download Eclipse from its official website.
* Java Development Kit (JDK): The JDK is a software development kit used to develop Java applications. You can download the latest version of the JDK from Oracle's official website.
* Selenium WebDriver: Selenium WebDriver is a tool used to automate web browsers. You can download Selenium WebDriver from its official website.

### Installing

For installation of this suite locally, follow the below steps:

* First of all clone this repository.
* Open this project in Eclipse IDE.
* Create a configuration file named as config.properties under \src\main\java\com\sonarwallet\qa\config\ this folder.
* Your config file should contains all the attributes that are shown in the exampleConfig.properties file under \src\main\java\com\sonarwallet\qa\config\ directory.
* Change the path for file input stream from test base class located under this directory \src\main\java\com\sonarwallet\qa\base\
* Note: add complete path from your own local file system where you have created the config.properties file.

## Running the tests

* You can run the individual test case by going to any test file or run in a bulk using testng.xml file located under this directory \src\main\resources\
* For more detail on running test cases, check testng tutorials or documentation.

### Code Style

This project follows the Page Object Model (POM) framework for wrting test cases. Kindly, follow the POM while adding any new test cases.

### Issues and Bug Reports

If you find any issues or bugs, please submit or open an issue in this repository.

## Built With

* [Selenium WebDriver](https://www.selenium.dev/documentation/en/webdriver/) - Web testing framework
* [TestNG](https://testng.org/doc/) - Testing framework for Java
* [Maven](https://maven.apache.org/) - Build automation tool
* [Log4j](https://logging.apache.org/log4j/2.x/) - Logging utility

## Authors

* **Raja Hassan** - [Github Profile](https://github.com/RajaHassanX36)
* **Aqib Mehmood** - [Github Profile](https://github.com/aqib-mehmood/)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


