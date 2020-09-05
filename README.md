[![Maintainability](https://api.codeclimate.com/v1/badges/c1474fe518ccb398d184/maintainability)](https://codeclimate.com/github/evoingram/webapp-javabe/maintainability)

# Java Transcript Web App Back End Product Overview

## My Role

This is an in-progress solo project.

## Project Description

This is the Java version of the back end for the online port of my company's VB database, which is used for transcript production and workflow management.  The VB database does everything from scheduling to automated shorthand to automated hyperlinking and document formatting, shipping, production, management of company financials, and other business operations, and this back end was designed and created to support a front end that also does such things.  It currently contains fake sample data and still needs certain endpoints added to it, but is fully functional.  Copyright 2020 Erica Ingram.

## Key Features

- Live solo project
- RESTful API with auth services for transcript production system
- 126 endpoints
- CourtListener, Xero, PayPal, Wunderlist, & Office API support
- Tested and documented via Postman & Java
- IN PROGRESS

## Tech Stack

Back end deployed to `Heroku` and built using:

- [Java](https://www.java.com/):  a programming language.
- [Java Spring](https://github.com/spring-projects/spring-framework):  Spring provides everything required beyond the Java programming language for creating enterprise applications for a wide range of scenarios and architectures.
- [SLF4J](http://www.slf4j.org/):  a simple logging facade for Java.
- [OAuth2](https://github.com/pyca/bcrypt/):  industry-standard protocol for authorization
- [Swagger](https://swagger.io/):  simplifies Java API documentation.
- [PostgreSQL](http://postgresql.org/):  open-source relational database supporting both SQL & JSON querying.
- [Maven](https://github.com/):  software project management & comprehension tool.

## API 

- [CourtListener](http://courtlistener.com/):  assists in automation of authority hyperlinking.
- [Office](https://docs.microsoft.com/en-us/previous-versions/office/office-365-api/):  document creation, formatting, and management.
- [PayPal](https://developer.paypal.com/home/):  payment processing and management.
- [Wunderlist](https://developer.wunderlist.com/):  to-do list management.
- [Xero](https://developer.xero.com/) business accounting software online.
   
## Testing

- All endpoints have been tested and documented via Postman.
- The endpoints in the Java back end are also being tested in Java.

## Documentation

### [DB SCHEMA](https://dbdesigner.page.link/gbEtfTr1XjgwDa2C7)   |   [BASE URL](https://transcript-javabe.herokuapp.com/)   |   [PRODUCT VISION](https://aquoco-my.sharepoint.com/:w:/g/personal/evoingram_aquoco_onmicrosoft_com/ES9-HPl3otdAjjtMrqpWIrkBMTrLyRDvxVEtYGkOMWLDUQ?e=fXTfhK)   |   [ENDPOINTS](https://github.com/evoingram/webapp-javabe/blob/master/docs/endpoints.md)   |   [FRONT END](https://github.com/evoingram/webapp-frontend/) (still in planning stages)
### [POSTMAN DOCUMENTATION](https://documenter.getpostman.com/view/6401823/SzRxWAvu?version=latest)   |   [SAMPLE RESPONSE](sample-response.json)
### [CUSTOMER USE CASE DIAGRAM](https://github.com/evoingram/webapp-javabe/blob/master/docs/use%20case.jpg)   |   [MANAGER USE CASE DIAGRAM](https://github.com/evoingram/webapp-javabe/blob/master/docs/manager%20UCD.jpg)

- Postman Docs were last published on 04/08/2020
- Postman docs contain examples of all get, post, and put endpoint body submissions AND responses.
