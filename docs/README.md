[![Maintainability](https://api.codeclimate.com/v1/badges/c1474fe518ccb398d184/maintainability)](https://codeclimate.com/github/evoingram/webapp-backend/maintainability)

# Transcript Web App Back End Product Overview

## My Role

This was a solo project.

## Project Description

This is the back end for the online port of my company's VB database, which is used for transcript production and workflow management.  The VB database does everything from scheduling to automated shorthand to automated hyperlinking and document formatting, shipping, production, management of company financials, and other business operations, and this back end was designed and created to support a front end that also does such things.  It currently contains fake sample data and still needs certain endpoints added to it, but is fully functional.  Copyright 2020 Erica Ingram.

## Key Features

- Live solo project
- RESTful API with auth services for transcript production system
- 126 endpoints
- CourtListener, Xero, PayPal, & Office API support, tested and documented via Postman

## Tech Stack

Back end deployed to `Heroku` and built using:

- [Node.js](https://github.com/nodejs/node):  a JavaScript runtime.
- [Knex](https://github.com/knex/knex):  a query builder for PostgreSQL, MySQL and SQLite3, designed to be flexible, portable, and fun to use.
- [Express](https://github.com/expressjs/express):  a fast, unopinionated, minimalist web framework for Node.
- [bcrypt](https://github.com/pyca/bcrypt/):  modern(-ish) password hashing for your software and your servers.

## Available Scripts 

### `npm server`
### `npm start`

## API 

- [CourtListener](http://courtlistener.com/):  assists in automation of authority hyperlinking.
- [Office](https://docs.microsoft.com/en-us/previous-versions/office/office-365-api/):  document creation, formatting, and management.
- [PayPal](https://developer.paypal.com/home/):  payment processing and management.
- [Wunderlist](https://developer.wunderlist.com/):  to-do list management.
   
## Testing

- All endpoints have been tested and documented via Postman.

## Documentation

### [DB SCHEMA](https://dbdesigner.page.link/gbEtfTr1XjgwDa2C7)   |   [BASE URL](https://transcript-webapp.herokuapp.com/api)   |   [PRODUCT VISION](https://aquoco-my.sharepoint.com/:w:/g/personal/evoingram_aquoco_onmicrosoft_com/ES9-HPl3otdAjjtMrqpWIrkBMTrLyRDvxVEtYGkOMWLDUQ?e=fXTfhK)   |   [ENDPOINTS](https://github.com/evoingram/webapp-backend/blob/master/docs/endpoints.md)   |   [FRONT END](https://github.com/evoingram/webapp-frontend/) (still in planning stages)
### [POSTMAN DOCUMENTATION](https://documenter.getpostman.com/view/6401823/SzRxWAvu?version=latest)   |   [SAMPLE RESPONSE](sample-response.json)

- Postman Docs were last published on 04/08/2020
- Postman docs contain examples of all get, post, and put endpoint body submissions AND responses.
