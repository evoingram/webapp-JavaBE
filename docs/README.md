# Transcript Web App

This is the back end, work in progress, for my database online port.
This currently contains fake sample data.  Copyright 2020 Erica Ingram.

## [DB Schema](https://dbdesigner.page.link/gbEtfTr1XjgwDa2C7)

## [BASE URL](https://transcript-webapp.herokuapp.com/api)

## [POSTMAN DOCUMENTATION](https://documenter.getpostman.com/view/6401823/SzRxWAvu?version=latest)

## [PRODUCT VISION](https://aquoco-my.sharepoint.com/:w:/g/personal/evoingram_aquoco_onmicrosoft_com/ES9-HPl3otdAjjtMrqpWIrkBMTrLyRDvxVEtYGkOMWLDUQ?e=fXTfhK)

- Postman Docs were last published on 04/08/2020

- All endpoints have been tested and documented via Postman.
- Postman docs contain examples of all get, post, and put endpoint body submissions AND responses.
- This is still a work in progress.

### Endpoints For Login / Registration

| Request Method | Endpoint         | Description                          |
| :------------- | :--------------- | :----------------------------------- |
| `POST`         | `/login`         | Logs user in and returns a token     |
| `POST`         | `/register`      | creates a user                       |

### Endpoints For Users

| Request Method | Endpoint                           | Description                          |
| :------------- | :--------------------------------- | :----------------------------------- |
| `POST`         | `/customers/`                      | creates a user                       |
| `PUT`          | `/customers/:customersid`          | updates a user                       |
| `DELETE`       | `/customers/:customersid`          | deletes a user                       |
| `GET`          | `/customers`                       | returns list of users                |
| `GET`          | `/customers/:customersid`          | returns a user                       |
| `GET`          | `/customers/:customersid/jobs`     | returns a user's orders              |
| `GET`          | `/customers/:customersid/cases`    | returns a user's cases               |
| `GET`          | `/customers/:customersid/invoices` | returns a user's invoices            |

### Endpoints For Courtdates (Jobs)

| Request Method | Endpoint                                       | Description                                |
| :------------- | :--------------------------------------------- | :----------------------------------------- |
| `POST`         | `/courtdates/`                                 | creates a job                              |
| `PUT`          | `/courtdates/:courtdatesid`                    | updates a job                              |
| `DELETE`       | `/courtdates/:courtdatesid`                    | deletes a job                              |
| `GET`          | `/courtdates`                                  | returns list of jobs                       |
| `GET`          | `/courtdates/:courtdatesid`                    | returns a job                              |
| `GET`          | `/courtdates/:courtdatesid/apps`               | returns apps of a job record               |
| `GET`          | `/courtdates/:courtdatesid/expenses`           | returns expenses of a job record           |
| `GET`          | `/courtdates/:courtdatesid/payments`           | returns payments of a job record           |
| `GET`          | `/courtdates/:courtdatesid/shipping`           | returns shipping of a job record           |
| `GET`          | `/courtdates/:courtdatesid/citations`          | returns citations of a job record          |
| `GET`          | `/courtdates/:courtdatesid/tasks`              | returns tasks of a job record              |
| `GET`          | `/courtdates/:courtdatesid/commhistory`        | returns commhistory of a job record        |
| `GET`          | `/courtdates/:courtdatesid/invoices`           | returns invoices of a job record           |
| `GET`          | `/courtdates/:courtdatesid/statuses`           | returns statuses of a job record           |
| `GET`          | `/courtdates/:courtdatesid/brandingthemes`     | returns brandingthemes of a job record     |
| `GET`          | `/courtdates/:courtdatesid/rates`              | returns rates of a job record              |
| `GET`          | `/courtdates/:courtdatesid/agshortcuts`        | returns agshortcuts of a job record        |
| `GET`          | `/courtdates/:courtdatesid/citationhyperlinks` | returns citationhyperlinks of a job record |
| `GET`          | `/courtdates/:courtdatesid/mailclasses`        | returns mailclasses of a job record        |
| `GET`          | `/courtdates/:courtdatesid/packagetypes`       | returns packagetypes of a job record       |
| `GET`          | `/courtdates/:courtdatesid/ccc`                | returns cccs of a job record               |
| `GET`          | `/courtdates/:courtdatesid/usc`                | returns usc items of a job record          |
| `GET`          | `/courtdates/:courtdatesid/contractors`        | returns contractors of a job record        |

### Endpoints For Appearances

| Request Method | Endpoint              | Description                   |
| :------------- | :-------------------- | :---------------------------- |
| `POST`         | `/appearances/`       | creates an appearance         |
| `PUT`          | `/appearances/:appid` | updates an appearance         |
| `DELETE`       | `/appearances/:appid` | deletes an appearance         |
| `GET`          | `/appearances`        | returns list of appearances   |
| `GET`          | `/appearances/:appid` | returns one appearance        |

### Endpoints For Tasks

| Request Method | Endpoint          | Description                       |
| :------------- | :---------------- | :-------------------------------- |
| `POST`         | `/tasks/`         | creates a task                    |
| `PUT`          | `/tasks/:tasksid` | updates a task                    |
| `DELETE`       | `/tasks/:tasksid` | deletes a task                    |
| `GET`          | `/tasks`          | returns list of tasks             |
| `GET`          | `/tasks/:tasksid` | returns one task                  |

### Endpoints For Statuses

| Request Method | Endpoint                | Description                 |
| :------------- | :---------------------- | :-------------------------- |
| `POST`         | `/statuses/`            | creates a status            |
| `PUT`          | `/statuses/:statusesid` | updates a appearance        |
| `DELETE`       | `/statuses/:statusesid` | deletes a appearance        |
| `GET`          | `/statuses`             | returns list of statuses    |
| `GET`          | `/statuses/:statusesid` | returns one status          |

### Endpoints For Expenses

| Request Method | Endpoint         | Description                        |
| :------------- | :--------------- | :--------------------------------- |
| `POST`         | `/expenses/`     | creates an expense                 |
| `PUT`          | `/expenses/:eid` | updates an expense                 |
| `DELETE`       | `/expenses/:eid` | deletes an expense                 |
| `GET`          | `/expenses`      | returns list of expenses           |
| `GET`          | `/expenses/:eid` | returns one expense                |

### Endpoints For Payments

| Request Method | Endpoint         | Description                        |
| :------------- | :--------------- | :--------------------------------- |
| `POST`         | `/payments/`     | creates a payment                  |
| `PUT`          | `/payments/:pid` | updates a payment                  |
| `DELETE`       | `/payments/:pid` | deletes a payment                  |
| `GET`          | `/payments`      | returns list of payments           |
| `GET`          | `/payments/:pid` | returns one payment                |

### Endpoints For Shipping

| Request Method | Endpoint          | Description                        |
| :------------- | :---------------- | :--------------------------------- |
| `POST`         | `/shipping/`      | creates a shipping item            |
| `PUT`          | `/shipping/:soid` | updates a shipping item            |
| `DELETE`       | `/shipping/:soid` | deletes a shipping item            |
| `GET`          | `/shipping`       | returns list of shipping items     |
| `GET`          | `/shipping/:soid` | returns one shipping item          |

### Endpoints For Invoices

| Request Method | Endpoint         | Description                         |
| :------------- | :--------------- | :---------------------------------- |
| `POST`         | `/invoices/`     | creates an invoice                  |
| `PUT`          | `/invoices/:iid` | updates an invoice                  |
| `DELETE`       | `/invoices/:iid` | deletes an invoice                  |
| `GET`          | `/invoices`      | returns list of invoices            |
| `GET`          | `/invoices/:iid` | returns one invoice                 |

### Endpoints For Citations

| Request Method | Endpoint                  | Description                |
| :------------- | :------------------------ | :------------------------- |
| `POST`         | `/citations/`             | creates a citation         |
| `PUT`          | `/citations/:citationsid` | updates a citation         |
| `DELETE`       | `/citations/:citationsid` | deletes a citation         |
| `GET`          | `/citations`              | returns list of citations  |
| `GET`          | `/citations/:citationsid` | returns one citation       |

### Endpoints For Rates

| Request Method | Endpoint          | Description                        |
| :------------- | :---------------- | :--------------------------------- |
| `POST`         | `/rates/`         | creates a rate                     |
| `PUT`          | `/rates/:ratesid` | updates a rate                     |
| `DELETE`       | `/rates/:ratesid` | deletes a rate                     |
| `GET`          | `/rates`          | returns list of rates              |
| `GET`          | `/rates/:ratesid` | returns one rate                   |

### Endpoints For Turnaroundtimes

| Request Method | Endpoint                 | Description                     |
| :------------- | :----------------------- | :------------------------------ |
| `POST`         | `/turnaroundtimes/`      | creates a turnaroundtime        |
| `PUT`          | `/turnaroundtimes/:ttid` | updates a turnaroundtime        |
| `DELETE`       | `/turnaroundtimes/:ttid` | deletes a turnaroundtime        |
| `GET`          | `/turnaroundtimes`       | returns list of turnaroundtimes |
| `GET`          | `/turnaroundtimes/:ttid` | returns one turnaroundtime      |

### Endpoints For Courtdatescasescustomers

| Request Method | Endpoint       | Description                              |
| :------------- | :------------- | :--------------------------------------- |
| `POST`         | `/ccc/`        | creates a courtdatecasecustomer          |
| `PUT`          | `/ccc/:cdccid` | updates a courtdatecasecustomer          |
| `DELETE`       | `/ccc/:cdccid` | deletes a courtdatecasecustomer          |
| `GET`          | `/ccc`         | returns list of courtdatescasescustomers |
| `GET`          | `/ccc/:cdccid` | returns one courtdatecasecustomer        |

### Endpoints For CommHistory

| Request Method | Endpoint             | Description                       |
| :------------- | :------------------- | :-------------------------------- |
| `POST`         | `/commhistory/`      | creates a commhistory item        |
| `PUT`          | `/commhistory/:chid` | updates a commhistory item        |
| `DELETE`       | `/commhistory/:chid` | deletes a commhistory item        |
| `GET`          | `/commhistory`       | returns list of commhistory items |
| `GET`          | `/commhistory/:chid` | returns one commhistory item      |

### Endpoints For AGShortcuts

| Request Method | Endpoint              | Description                      |
| :------------- | :-------------------- | :------------------------------- |
| `POST`         | `/agshortcuts/`       | creates an agshortcut list       |
| `PUT`          | `/agshortcuts/:agsid` | updates an agshortcut list       |
| `DELETE`       | `/agshortcuts/:agsid` | deletes an agshortcut list       |
| `GET`          | `/agshortcuts`        | returns list of agshortcut lists |
| `GET`          | `/agshortcuts/:agsid` | returns one agshortcut list      |

### Endpoints For MailClasses

| Request Method | Endpoint             | Description                    |
| :------------- | :------------------- | :----------------------------- |
| `POST`         | `/mailclasses/`      | creates a mailclass            |
| `PUT`          | `/mailclasses/:mcid` | updates a mailclass            |
| `DELETE`       | `/mailclasses/:mcid` | deletes a mailclass            |
| `GET`          | `/mailclasses`       | returns list of mailclasses    |
| `GET`          | `/mailclasses/:mcid` | returns one mailclass          |

### Endpoints For PackageTypes

| Request Method | Endpoint              | Description                   |
| :------------- | :-------------------- | :---------------------------- |
| `POST`         | `/packagetypes/`      | creates a packagetype         |
| `PUT`          | `/packagetypes/:ptid` | updates a packagetype         |
| `DELETE`       | `/packagetypes/:ptid` | deletes a packagetype         |
| `GET`          | `/packagetypes`       | returns list of packagetypes  |
| `GET`          | `/packagetypes/:ptid` | returns one packagetype       |

### Endpoints For BrandingThemes

| Request Method | Endpoint                | Description                    |
| :------------- | :---------------------- | :----------------------------- |
| `POST`         | `/brandingthemes/`      | creates a brandingtheme        |
| `PUT`          | `/brandingthemes/:btid` | updates a brandingtheme        |
| `DELETE`       | `/brandingthemes/:btid` | deletes a brandingtheme        |
| `GET`          | `/brandingthemes`       | returns list of brandingthemes |
| `GET`          | `/brandingthemes/:btid` | returns one brandingtheme      |

### Endpoints For USC Items

| Request Method | Endpoint      | Description                   |
| :------------- | :------------ | :---------------------------- |
| `POST`         | `/usc/`       | creates a usc item            |
| `PUT`          | `/usc/:uscid` | updates a usc item            |
| `DELETE`       | `/usc/:uscid` | deletes a usc item            |
| `GET`          | `/usc`        | returns list of usc items     |
| `GET`          | `/usc/:uscid` | returns one usc item          |

### Endpoints For ExamTypes

| Request Method | Endpoint           | Description                 |
| :------------- | :----------------- | :-------------------------- |
| `POST`         | `/examtypes/`      | creates an examtype         |
| `PUT`          | `/examtypes/:etid` | updates an examtype         |
| `DELETE`       | `/examtypes/:etid` | deletes an examtype         |
| `GET`          | `/examtypes`       | returns list of examtypes   |
| `GET`          | `/examtypes/:etid` | returns one examtype        |

### Endpoints For Styles

| Request Method | Endpoint       | Description                     |
| :------------- | :------------- | :------------------------------ |
| `POST`         | `/styles/`     | creates a style                 |
| `PUT`          | `/styles/:sid` | updates a style                 |
| `DELETE`       | `/styles/:sid` | deletes a style                 |
| `GET`          | `/styles`      | returns list of styles          |
| `GET`          | `/styles/:sid` | returns one style               |
