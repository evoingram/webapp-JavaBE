# Transcript Web App

# Transcript Web App Java Back End Product Overview

## My Role

This was a solo project.

## Project Description

This is the JAVA version of [this back end](https://github.com/evoingram/webapp-backend), still in planning stages, for the online port of my company's VB database, which is used for transcript production and workflow management.  The VB database does everything from scheduling to automated shorthand to automated hyperlinking and document formatting, shipping, production, management of company financials, and other business operations, and this back end was designed and created to support a front end that also does such things.  It currently contains fake sample data and still needs certain endpoints added to it, but is fully functional.  Copyright 2020 Erica Ingram.

## Key Features

- Live solo project
- RESTful API with auth services for transcript production system
- 126 endpoints
- CourtListener, Xero, PayPal, & Office API support, tested and documented via Postman

## Tech Stack

Back end will be deployed to `Heroku` and built using:

- [Java](https://en.wikipedia.org/wiki/Java_%28programming_language%29):  a general-purpose programming language that is class-based, object-oriented, and designed to have as few implementation dependencies as possible.
- [SQL](https://en.wikipedia.org/wiki/SQL):  a domain-specific language used in programming and designed for managing data held in an RDBMS or stream processing in an RDSMS

## Available Scripts 

### `npm server`
### `npm start`

## API 

- [CourtListener](http://courtlistener.com/):  assists in automation of authority hyperlinking.
- [Office](https://docs.microsoft.com/en-us/previous-versions/office/office-365-api/):  document creation, formatting, and management.
- [PayPal](https://developer.paypal.com/home/):  payment processing and management.
- [Wunderlist](https://developer.wunderlist.com/):  to-do list management.
   
## Testing

- All endpoints will have been tested and documented via Postman.

## Documentation

### [DB SCHEMA](https://dbdesigner.page.link/gbEtfTr1XjgwDa2C7)   |   [BASE URL](https://transcript-javabe.herokuapp.com/api)   |   [PRODUCT VISION](https://aquoco-my.sharepoint.com/:w:/g/personal/evoingram_aquoco_onmicrosoft_com/ES9-HPl3otdAjjtMrqpWIrkBMTrLyRDvxVEtYGkOMWLDUQ?e=fXTfhK)   |   [ENDPOINTS](https://github.com/evoingram/webapp-backend/blob/master/docs/endpoints.md)   |   [FRONT END](https://github.com/evoingram/webapp-frontend/) (still in planning stages)
### [POSTMAN DOCUMENTATION](https://documenter.getpostman.com/view/6401823/SzRxWAvu?version=latest)

- Postman Docs were last published on 04/08/2020
- Postman docs contain examples of all get, post, and put endpoint body submissions AND responses.
