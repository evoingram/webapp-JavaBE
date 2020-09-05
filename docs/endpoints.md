
# Endpoints

## Login / Registration

| Request Method | Endpoint         | Description                          |
| :------------- | :--------------- | :----------------------------------- |
| `POST`         | `/login`         | Logs user in and returns a token     |
| `POST`         | `/register`      | creates a user                       |

## Users

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

## Courtdates (Jobs)

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

## Appearances

| Request Method | Endpoint              | Description                   |
| :------------- | :-------------------- | :---------------------------- |
| `POST`         | `/appearances/`       | creates an appearance         |
| `PUT`          | `/appearances/:appid` | updates an appearance         |
| `DELETE`       | `/appearances/:appid` | deletes an appearance         |
| `GET`          | `/appearances`        | returns list of appearances   |
| `GET`          | `/appearances/:appid` | returns one appearance        |

## Tasks

| Request Method | Endpoint          | Description                       |
| :------------- | :---------------- | :-------------------------------- |
| `POST`         | `/tasks/`         | creates a task                    |
| `PUT`          | `/tasks/:tasksid` | updates a task                    |
| `DELETE`       | `/tasks/:tasksid` | deletes a task                    |
| `GET`          | `/tasks`          | returns list of tasks             |
| `GET`          | `/tasks/:tasksid` | returns one task                  |

## Statuses

| Request Method | Endpoint                | Description                 |
| :------------- | :---------------------- | :-------------------------- |
| `POST`         | `/statuses/`            | creates a status            |
| `PUT`          | `/statuses/:statusesid` | updates a appearance        |
| `DELETE`       | `/statuses/:statusesid` | deletes a appearance        |
| `GET`          | `/statuses`             | returns list of statuses    |
| `GET`          | `/statuses/:statusesid` | returns one status          |

## Expenses

| Request Method | Endpoint         | Description                        |
| :------------- | :--------------- | :--------------------------------- |
| `POST`         | `/expenses/`     | creates an expense                 |
| `PUT`          | `/expenses/:eid` | updates an expense                 |
| `DELETE`       | `/expenses/:eid` | deletes an expense                 |
| `GET`          | `/expenses`      | returns list of expenses           |
| `GET`          | `/expenses/:eid` | returns one expense                |

## Payments

| Request Method | Endpoint         | Description                        |
| :------------- | :--------------- | :--------------------------------- |
| `POST`         | `/payments/`     | creates a payment                  |
| `PUT`          | `/payments/:pid` | updates a payment                  |
| `DELETE`       | `/payments/:pid` | deletes a payment                  |
| `GET`          | `/payments`      | returns list of payments           |
| `GET`          | `/payments/:pid` | returns one payment                |

## Shipping

| Request Method | Endpoint          | Description                        |
| :------------- | :---------------- | :--------------------------------- |
| `POST`         | `/shipping/`      | creates a shipping item            |
| `PUT`          | `/shipping/:soid` | updates a shipping item            |
| `DELETE`       | `/shipping/:soid` | deletes a shipping item            |
| `GET`          | `/shipping`       | returns list of shipping items     |
| `GET`          | `/shipping/:soid` | returns one shipping item          |

## Invoices

| Request Method | Endpoint         | Description                         |
| :------------- | :--------------- | :---------------------------------- |
| `POST`         | `/invoices/`     | creates an invoice                  |
| `PUT`          | `/invoices/:iid` | updates an invoice                  |
| `DELETE`       | `/invoices/:iid` | deletes an invoice                  |
| `GET`          | `/invoices`      | returns list of invoices            |
| `GET`          | `/invoices/:iid` | returns one invoice                 |

## Citations

| Request Method | Endpoint                  | Description                |
| :------------- | :------------------------ | :------------------------- |
| `POST`         | `/citations/`             | creates a citation         |
| `PUT`          | `/citations/:citationsid` | updates a citation         |
| `DELETE`       | `/citations/:citationsid` | deletes a citation         |
| `GET`          | `/citations`              | returns list of citations  |
| `GET`          | `/citations/:citationsid` | returns one citation       |

## Rates

| Request Method | Endpoint          | Description                        |
| :------------- | :---------------- | :--------------------------------- |
| `POST`         | `/rates/`         | creates a rate                     |
| `PUT`          | `/rates/:ratesid` | updates a rate                     |
| `DELETE`       | `/rates/:ratesid` | deletes a rate                     |
| `GET`          | `/rates`          | returns list of rates              |
| `GET`          | `/rates/:ratesid` | returns one rate                   |

## Turnaroundtimes

| Request Method | Endpoint                 | Description                     |
| :------------- | :----------------------- | :------------------------------ |
| `POST`         | `/turnaroundtimes/`      | creates a turnaroundtime        |
| `PUT`          | `/turnaroundtimes/:ttid` | updates a turnaroundtime        |
| `DELETE`       | `/turnaroundtimes/:ttid` | deletes a turnaroundtime        |
| `GET`          | `/turnaroundtimes`       | returns list of turnaroundtimes |
| `GET`          | `/turnaroundtimes/:ttid` | returns one turnaroundtime      |

## Courtdatescasescustomers

| Request Method | Endpoint       | Description                              |
| :------------- | :------------- | :--------------------------------------- |
| `POST`         | `/ccc/`        | creates a courtdatecasecustomer          |
| `PUT`          | `/ccc/:cdccid` | updates a courtdatecasecustomer          |
| `DELETE`       | `/ccc/:cdccid` | deletes a courtdatecasecustomer          |
| `GET`          | `/ccc`         | returns list of courtdatescasescustomers |
| `GET`          | `/ccc/:cdccid` | returns one courtdatecasecustomer        |

## CommHistory

| Request Method | Endpoint             | Description                       |
| :------------- | :------------------- | :-------------------------------- |
| `POST`         | `/commhistory/`      | creates a commhistory item        |
| `PUT`          | `/commhistory/:chid` | updates a commhistory item        |
| `DELETE`       | `/commhistory/:chid` | deletes a commhistory item        |
| `GET`          | `/commhistory`       | returns list of commhistory items |
| `GET`          | `/commhistory/:chid` | returns one commhistory item      |

## AGShortcuts

| Request Method | Endpoint              | Description                      |
| :------------- | :-------------------- | :------------------------------- |
| `POST`         | `/agshortcuts/`       | creates an agshortcut list       |
| `PUT`          | `/agshortcuts/:agsid` | updates an agshortcut list       |
| `DELETE`       | `/agshortcuts/:agsid` | deletes an agshortcut list       |
| `GET`          | `/agshortcuts`        | returns list of agshortcut lists |
| `GET`          | `/agshortcuts/:agsid` | returns one agshortcut list      |

## MailClasses

| Request Method | Endpoint             | Description                    |
| :------------- | :------------------- | :----------------------------- |
| `POST`         | `/mailclasses/`      | creates a mailclass            |
| `PUT`          | `/mailclasses/:mcid` | updates a mailclass            |
| `DELETE`       | `/mailclasses/:mcid` | deletes a mailclass            |
| `GET`          | `/mailclasses`       | returns list of mailclasses    |
| `GET`          | `/mailclasses/:mcid` | returns one mailclass          |

## PackageTypes

| Request Method | Endpoint              | Description                   |
| :------------- | :-------------------- | :---------------------------- |
| `POST`         | `/packagetypes/`      | creates a packagetype         |
| `PUT`          | `/packagetypes/:ptid` | updates a packagetype         |
| `DELETE`       | `/packagetypes/:ptid` | deletes a packagetype         |
| `GET`          | `/packagetypes`       | returns list of packagetypes  |
| `GET`          | `/packagetypes/:ptid` | returns one packagetype       |

## BrandingThemes

| Request Method | Endpoint                | Description                    |
| :------------- | :---------------------- | :----------------------------- |
| `POST`         | `/brandingthemes/`      | creates a brandingtheme        |
| `PUT`          | `/brandingthemes/:btid` | updates a brandingtheme        |
| `DELETE`       | `/brandingthemes/:btid` | deletes a brandingtheme        |
| `GET`          | `/brandingthemes`       | returns list of brandingthemes |
| `GET`          | `/brandingthemes/:btid` | returns one brandingtheme      |

## USC Items

| Request Method | Endpoint      | Description                   |
| :------------- | :------------ | :---------------------------- |
| `POST`         | `/usc/`       | creates a usc item            |
| `PUT`          | `/usc/:uscid` | updates a usc item            |
| `DELETE`       | `/usc/:uscid` | deletes a usc item            |
| `GET`          | `/usc`        | returns list of usc items     |
| `GET`          | `/usc/:uscid` | returns one usc item          |

## ExamTypes

| Request Method | Endpoint           | Description                 |
| :------------- | :----------------- | :-------------------------- |
| `POST`         | `/examtypes/`      | creates an examtype         |
| `PUT`          | `/examtypes/:etid` | updates an examtype         |
| `DELETE`       | `/examtypes/:etid` | deletes an examtype         |
| `GET`          | `/examtypes`       | returns list of examtypes   |
| `GET`          | `/examtypes/:etid` | returns one examtype        |

## Styles

| Request Method | Endpoint       | Description                     |
| :------------- | :------------- | :------------------------------ |
| `POST`         | `/styles/`     | creates a style                 |
| `PUT`          | `/styles/:sid` | updates a style                 |
| `DELETE`       | `/styles/:sid` | deletes a style                 |
| `GET`          | `/styles`      | returns list of styles          |
| `GET`          | `/styles/:sid` | returns one style               |
