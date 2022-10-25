# Automated test project with web, api and mobile tests for [Airbnb](https://www.airbnb.ru/) service

![0_NChTo-XqLOxLabIW](https://user-images.githubusercontent.com/36373593/184724462-cd7a9969-cb47-41c1-84f0-15942c9832ae.png)

| Airbnb, Inc. is an American company that operates an online marketplace for lodging, primarily homestays for vacation rentals, and tourism activities

# <a name="Technology">Tools and technologies</a>
<p  align="center">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="IntelliJ IDEA" src="images/logo/IntelliJIDEA.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="RestAssured" src="images/logo/RestAssured.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure.svg">
<img width="6%" title="Allure TestOps" src="images/logo/Allure_TO.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Browserstack" src="images/logo/Browserstack.svg">
<img width="6%" title="Appium" src="images/logo/Appium.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">

## :page_facing_up: Test cases
- #### Web
<p align="center">
<img title="WEB" src="images/screen/Web.png">
</p>

- #### API
<p align="center">
<img title="API" src="images/screen/API.png">
</p>

- #### Mobile
<p align="center">
<img title="Mobile" src="images/screen/Mobile.png">
</p>

## <a name="RunInJenkins"> <img width="4%" src="images/logo/Jenkins.svg"> Run in [Jenkins](https://jenkins.autotests.cloud/job/airbnb_test_project/)
<p align="center">
<img src="images/screen/Jenkins.png">
</p>

### <a name="Running tests with parameters"></a> Running tests with parameters
<p align="center">
<img src="images/screen/JenkinsParam.png">
</p>

#### Gradle command
To run locally and in Jenkins the following command is used:
```bash
gradle clean test -Dtag=<tag>
```
`tag` - type of tests for execution:
>- *API*
>- *WEB*
>- *Android*

Additional parameters:
> `-Dbrowser` - Browser type: chrome, yandex, safari\
> `-DbrowserSize` - Browser size:
1920x1080
1366x768
1024x768\
> `-DbaseUrl` url to run tests
> `-DwebHost` host to run web tests
> `-DdeviceHost` device to run mobile tests
```bash
clean
test
-Dtag=${tag}
-Dbrowser=${browser}
-DbrowserSize=${browserSize}
-DbaseUrl=${baseUrl}
-DwebHost=${webHost}
-DdeviceHost=${deviceHost}
```

## <a name="Allure Report"></a><img width="4%" src="images/logo/Allure.svg"> Allure [Report](https://jenkins.autotests.cloud/job/airbnb_test_project/14/allure/)
### Overview
<p align="center">
<img src="images/screen/AllureReport.png">
</p>

### Test suites
The report contains a list of tests, with detailed steps, screenshots and videos of the results
<p align="center">
<img src="images/screen/AllureSteps.png">
</p>

## <a name="Allure TestOps"></a><img width="4%" src="images/logo/Allure_TO.svg"> [Allure TestOps](https://allure.autotests.cloud/project/1501/) integration 

### Dashboards
<p align="center">
<img src="images/screen/AllureTO_Dashboard.png">
</p>

### Test cases
<p align="center">
<img src="images/screen/AllureTO_Tests.png">
</p>

### Launches
<p align="center">
<img src="images/screen/AllureTO_Launches.png">
</p>

## <img width="4%" src="images/logo/Telegram.svg"> Telegram notifications
<p align="center">
<img src="images/screen/Telegram.png">
</p>

## <a name="Video"></a> :vhs: Video examples
### Web test
<p align="left">
<img src="images/gif/WebTest.gif" alt="video" width="700">
</p>

### Mobile tests
<p align="left">
<img src="images/gif/MobileTests1.gif" alt="video" width="500">
</p>