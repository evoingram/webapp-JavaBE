/*


SELECT [Statuses].[ID], [Statuses].[CourtDatesID]
FROM Statuses;

SELECT [MailClass].[ID], [MailClass].[MailClass], [MailClass].[Description1]
FROM MailClass
ORDER BY [ID];

SELECT [PackageType].[ID], [PackageType].[PackageType], [PackageType].[Description1]
FROM PackageType
ORDER BY [ID];

PARAMETERS __InvoiceNo Value;
SELECT DISTINCTROW *
FROM QInfobyInvoiceNumber AS [INV-SBFM-InvoiceEstmPriceQuote]
WHERE ([__InvoiceNo] = InvoiceNo);


PARAMETERS __InvoiceNo Value;
SELECT DISTINCTROW *
FROM QInfobyInvoiceNumber AS [INV-SBFM-ViewInvoice]
WHERE ([__InvoiceNo] = InvoiceNo);

SELECT Employees.ID, Employees.[Last Name]
FROM Employees;

PARAMETERS [__Order ID] Value;
SELECT DISTINCTROW *
FROM [Order Details Extended] AS Orders
WHERE ([__Order ID] = [Order ID]);

SELECT [ID], [Company]
FROM [Shippers Extended]
ORDER BY [Company];

SELECT [Rates].[ID], [Rates].[Code], [Rates].[List Price], [Rates].[ProductName]
FROM Rates
ORDER BY [Code], [ProductName], [List Price];

SELECT DISTINCTROW *
FROM BrandingThemes;


PARAMETERS __Forms!NewMainMenu!ProcessJobSubformNMM.Form!JobNumberField Value;
SELECT DISTINCTROW *
FROM ViewJobFormAppearancesQ AS PJOrderingInfoForm
WHERE ([__Forms]!NewMainMenu!ProcessJobSubformNMM.Form!JobNumberField = CourtDates.ID);

PARAMETERS __Forms!NewMainMenu!ProcessJobSubformNMM.Form!JobNumberField Value;
SELECT DISTINCTROW *
FROM TempTasksDay1 AS PJStatusChecklist
WHERE ([__Forms]!NewMainMenu!ProcessJobSubformNMM.Form!JobNumberField = CourtDates.ID);

PARAMETERS __Forms!NewMainMenu!ProcessJobSubformNMM.Form!JobNumberField Value;
SELECT DISTINCTROW *
FROM SBFMCaseInfoQ AS PJStatusChecklist
WHERE ([__Forms]!NewMainMenu!ProcessJobSubformNMM.Form!JobNumberField = SBFMCourtDates.ID);

PARAMETERS __Forms!NewMainMenu!ProcessJobSubformNMM.Form!JobNumberField Value;
SELECT DISTINCTROW *
FROM [TR-Court-Q] AS PJViewJobForm
WHERE ([__Forms]!NewMainMenu!ProcessJobSubformNMM.Form!JobNumberField = CourtDatesID);

PARAMETERS __Forms!NewMainMenu!ProcessJobSubformNMM.Form!JobNumberField Value;
SELECT DISTINCTROW *
FROM CustomerAddressA0O1 AS PJViewJobForm
WHERE ([__Forms]!NewMainMenu!ProcessJobSubformNMM.Form!JobNumberField = CourtDates.ID);

SELECT [ShippingOptions].[ID], [ShippingOptions].[CourtDatesID], [ShippingOptions].[ToName]
FROM ShippingOptions;

SELECT [TurnaroundTimes].[ID], [TurnaroundTimes].[Length]
FROM TurnaroundTimes;

SELECT [UnitPrice].[ID], [UnitPrice].[Rate]
FROM UnitPrice;

SELECT *
FROM UncompletedStatusesQ
WHERE (UncompletedStatusesQ.CourtDatesID = [Statuses].[ID]);



SELECT [TurnaroundTimes].[ID], [TurnaroundTimes].[Length]
FROM TurnaroundTimes;

SELECT [UnitPrice].[ID], [UnitPrice].[Rate]
FROM UnitPrice;


SELECT [Invoices].[ID]
FROM Invoices;

SELECT [TurnaroundTimes].[ID], [TurnaroundTimes].[Length]
FROM TurnaroundTimes;

SELECT *
FROM ShippingOptions
WHERE [ShippingOptions].[CourtDatesID] = 1755;

SELECT DISTINCTROW *
FROM Doctors;

SELECT AGShortcuts.ID
FROM AGShortcuts;

SELECT DISTINCTROW *
FROM ShippingOptions;

SELECT DISTINCTROW *
FROM TempTasksDay1;


SELECT Tasks.ID, Tasks.CourtDatesID, Tasks.[Due Date], Tasks.Priority, Tasks.Category, Tasks.PriorityPoints, Tasks.Title, Tasks.Description, Tasks.TimeLength, Tasks.Completed, DSum([TimeLength])
FROM Tasks
WHERE ((Tasks.Priority Not Like "*Waiting For*") And (Tasks.Completed=False) And (Tasks.Category Like "Production"))
ORDER BY Tasks.PriorityPoints DESC , Tasks.[Due Date], Tasks.Title;

SELECT AGShortcuts.CourtDatesID, AGShortcuts.AG1, AGShortcuts.ag2, AGShortcuts.ag3, AGShortcuts.ag4, AGShortcuts.ag5, AGShortcuts.ag6, AGShortcuts.ag11, AGShortcuts.ag12, AGShortcuts.ag13, AGShortcuts.ag14, AGShortcuts.ag15, AGShortcuts.ag16, AGShortcuts.ag21, AGShortcuts.ag22, AGShortcuts.ag23, AGShortcuts.ag24, AGShortcuts.ag25, AGShortcuts.ag26, AGShortcuts.ag31, AGShortcuts.ag32, AGShortcuts.ag33, AGShortcuts.ag34, AGShortcuts.ag35, AGShortcuts.ag36, AGShortcuts.ag41, AGShortcuts.ag42, AGShortcuts.ag43, AGShortcuts.ag44, AGShortcuts.ag45, AGShortcuts.ag46, AGShortcuts.ag51, AGShortcuts.ag52, AGShortcuts.ag53, AGShortcuts.ag54, AGShortcuts.ag55, AGShortcuts.ag56, AGShortcuts.ag61, AGShortcuts.ag62, AGShortcuts.ag63, AGShortcuts.ag64, AGShortcuts.ag65, AGShortcuts.ag66
FROM AGShortcuts
WHERE (((AGShortcuts.CourtDatesID)=[Forms]![NewMainMenu]![ProcessJobSubformNMM].[Form]![JobNumberField]));

SELECT Sum([PaymentQueryInvoiceInfo].[Amount]) AS PaymentSum
FROM PaymentQueryInvoiceInfo;

SELECT CommunicationHistory.CourtDatesID, Format([CommunicationHistory].[DateCreated],"mm/dd/yyyy") AS DateCreated, CommunicationHistory.FileHyperlink1
FROM CommunicationHistory
WHERE CommunicationHistory.CourtDatesID Is Null;

SELECT CommunicationHistory.ID, CommunicationHistory.FileHyperlink, CommunicationHistory.FileHyperlink1, CommunicationHistory.DateCreated, CommunicationHistory.CourtDatesID, CommunicationHistory.CustomersID
FROM CommunicationHistory
ORDER BY CommunicationHistory.CourtDatesID;


SELECT ViewJobFormAppearancesQ.MrMs, ViewJobFormAppearancesQ.LastName
FROM ViewJobFormAppearancesQ
WHERE (((ViewJobFormAppearancesQ.CourtDates.ID)=[Forms]![NewMainMenu]![ProcessJobSubformNMM].[Form]![JobNumberField]));

SELECT CommunicationHistory.CourtDatesID, CommunicationHistory.FileHyperlink, CommunicationHistory.DateCreated
FROM CommunicationHistory
WHERE (((CommunicationHistory.CourtDatesID)=[Forms]![NewMainMenu]![ProcessJobSubformNMM].[Form]![JobNumberField]));

SELECT *
FROM CommunicationHistory;

SELECT QTotalExpensesByInvoiceReal.[TotalExpenses], QTotalPricebyInvoiceNumber.[TotalPrice], QTotalPageCountbyInvoiceNumber.[PageCount], QTotalPricebyInvoiceNumber.[InvoiceNo], QTotalExpensesByInvoiceReal.[InvoiceNo], QTotalPageCountbyInvoiceNumber.[InvoiceNo], QTotalInvoiceNumberDate.[InvoiceNo], QTotalInvoiceNumberDate.[InvoiceDate]
FROM ((QTotalPageCountbyInvoiceNumber INNER JOIN QTotalExpensesByInvoiceReal ON QTotalPageCountbyInvoiceNumber.InvoiceNo = QTotalExpensesByInvoiceReal.InvoiceNo) INNER JOIN QTotalPricebyInvoiceNumber ON QTotalPageCountbyInvoiceNumber.InvoiceNo = QTotalPricebyInvoiceNumber.InvoiceNo) INNER JOIN QTotalInvoiceNumberDate ON QTotalPageCountbyInvoiceNumber.InvoiceNo = QTotalInvoiceNumberDate.InvoiceNo;

SELECT ContactName, InvoiceNumber, Reference AS [PO Number], InvoiceDate AS [Invoice Date], "28" AS [Net Term], ActualQuantity * UnitAmount AS [Invoice Amount]
FROM XeroInvoiceCSV
WHERE Reference=Forms![NewMainMenu]![ProcessJobSubformNMM].Form![JobNumberField];

SELECT FinalUnitPriceQuery.CourtDatesID, FinalUnitPriceQuery.ID AS FinalUnitPriceQueryID, FinalUnitPriceQuery.FinalPrice AS FinalPrice, FinalUnitPriceQuery.AudioLength AS FinalUnitPriceQuery_AudioLength, FinalUnitPriceQuery.TurnaroundTimesCD AS FinalUnitPriceQuery_TurnaroundTimesCD, FinalUnitPriceQuery.InvoiceNo AS FinalUnitPriceQuery_InvoiceNo, FinalUnitPriceQuery.InvoiceDate AS FinalUnitPriceQuery_InvoiceDate, FinalUnitPriceQuery.PaymentDueDate AS FinalUnitPriceQuery_PaymentDueDate, FinalUnitPriceQuery.ExpectedAdvanceDate AS FinalUnitPriceQuery_ExpectedAdvanceDate, FinalUnitPriceQuery.ExpectedRebateDate AS FinalUnitPriceQuery_ExpectedRebateDate, FinalUnitPriceQuery.EstimatedPageCount AS FinalUnitPriceQuery_EstimatedPageCount, FinalUnitPriceQuery.UnitPrice AS FinalUnitPriceQuery_UnitPrice, FinalUnitPriceQuery.Rate, FinalUnitPriceQuery.ActualQuantity AS FinalUnitPriceQuery_ActualQuantity, FinalUnitPriceQuery.DueDate AS FinalUnitPriceQuery_DueDate, InvoiceInfoQ.ID AS InvoiceInfoQ_ID, InvoiceInfoQ.FactoringApproved, InvoiceInfoQ.MrMs, InvoiceInfoQ.Company, InvoiceInfoQ.LastName, InvoiceInfoQ.FirstName, InvoiceInfoQ.BusinessPhone, InvoiceInfoQ.EmailAddress, InvoiceInfoQ.Address, InvoiceInfoQ.City, InvoiceInfoQ.State, InvoiceInfoQ.ZIP, InvoiceInfoQ.HearingDate, InvoiceInfoQ.HearingStartTime, InvoiceInfoQ.HearingEndTime, InvoiceInfoQ.CasesID, InvoiceInfoQ.OrderingID, InvoiceInfoQ.AudioLength AS InvoiceInfoQ_AudioLength, InvoiceInfoQ.Location, InvoiceInfoQ.TurnaroundTimesCD AS InvoiceInfoQ_TurnaroundTimesCD, InvoiceInfoQ.Subtotal, InvoiceInfoQ.DueDate AS InvoiceInfoQ_DueDate, InvoiceInfoQ.InvoiceNo AS InvoiceNo, InvoiceInfoQ.FiledNotFiled, InvoiceInfoQ.InvoiceDate AS InvoiceInfoQ_InvoiceDate, InvoiceInfoQ.PaymentDueDate AS InvoiceInfoQ_PaymentDueDate, InvoiceInfoQ.Quantity, InvoiceInfoQ.ActualQuantity AS InvoiceInfoQ_ActualQuantity, InvoiceInfoQ.UnitPrice AS InvoiceInfoQ_UnitPrice, InvoiceInfoQ.ExpectedAdvanceDate AS InvoiceInfoQ_ExpectedAdvanceDate, InvoiceInfoQ.ExpectedRebateDate AS InvoiceInfoQ_ExpectedRebateDate, InvoiceInfoQ.EstimatedPageCount AS InvoiceInfoQ_EstimatedPageCount, InvoiceInfoQ.Party1, InvoiceInfoQ.Party2, InvoiceInfoQ.CaseNumber1, InvoiceInfoQ.CaseNumber2, InvoiceInfoQ.Jurisdiction, InvoiceInfoQ.HearingTitle, InvoiceInfoQ.Judge, InvoiceInfoQ.JudgeTitle, InvoiceInfoQ.ShipDate, InvoiceInfoQ.TrackingNumber, InvoiceInfoQ.FactoringCost AS FactoringCost, InvoiceInfoQ.Factored, InvoiceInfoQ.FinalPrice AS FinalPrice1
FROM FinalUnitPriceQuery INNER JOIN InvoiceInfoQ ON FinalUnitPriceQuery.[InvoiceNo] = InvoiceInfoQ.[InvoiceNo]
WHERE FinalUnitPriceQuery.[CourtDatesID] = InvoiceInfoQ.[CourtDatesID];


SELECT FinalUnitPriceQuery.InvoiceNo, FinalUnitPriceQuery.InvoiceDate, FinalUnitPriceQuery.Subtotal
FROM FinalUnitPriceQuery;


SELECT First(Payments.[InvoiceNo]) AS [InvoiceNo Field], First(Payments.[Amount]) AS [Amount Field], First(Payments.[RemitDate]) AS [RemitDate Field], Count(Payments.[InvoiceNo]) AS NumberOfDups
FROM Payments
GROUP BY Payments.[InvoiceNo], Payments.[Amount], Payments.[RemitDate]
HAVING (((Count(Payments.[InvoiceNo]))>1) AND ((Count(Payments.[RemitDate]))>1));


SELECT Tasks.ID, Tasks.CourtDatesID, Tasks.[Due Date], Tasks.Priority, Tasks.Category, Tasks.PriorityPoints, Tasks.Title, Tasks.Description, Tasks.TimeLength, Tasks.Completed
FROM Tasks
WHERE ((Tasks.Priority Not Like "*Waiting For*") And (Tasks.Completed=False))
ORDER BY Tasks.PriorityPoints DESC , Tasks.[Due Date], Tasks.Title;

TRANSFORM Sum(GroupTasksIncomplete.TimeLength) AS SumOfTimeLength
SELECT GroupTasksIncomplete.PriorityPoints, Sum(GroupTasksIncomplete.TimeLength) AS [Total Of TimeLength]
FROM GroupTasksIncomplete
GROUP BY GroupTasksIncomplete.PriorityPoints
PIVOT GroupTasksIncomplete.Completed;

SELECT Tasks.ID, Tasks.CourtDatesID, Tasks.[Due Date], Tasks.Priority, Tasks.Category, Tasks.PriorityPoints, Tasks.Title, Tasks.Description, Tasks.TimeLength, Tasks.Completed
FROM Tasks
WHERE ((Tasks.Priority Not Like "*Waiting For*") And (Tasks.Completed=False) And (Tasks.Category Like "Production"))
ORDER BY Tasks.PriorityPoints DESC , Tasks.[Due Date], Tasks.Title;

SELECT GroupTasksIncompleteProduction.PriorityPoints, GroupTasksIncompleteProduction.TimeLength
FROM GroupTasksIncompleteProduction;





SELECT InvoicesQuery4.CourtDatesID, InvoicesQuery4.BrandingTheme AS IQ4BrandingTheme, BrandingThemes.ID, BrandingThemes.BrandingTheme AS BTBrandingTheme
FROM InvoicesQuery4 INNER JOIN BrandingThemes ON InvoicesQuery4.[BrandingTheme]=BrandingThemes.[ID];

UPDATE CourtDates INNER JOIN FinalUnitPriceQuery ON CourtDates.ID = FinalUnitPriceQuery.CourtDatesID SET CourtDates.FinalPrice = ([FinalUnitPriceQuery].[ActualQuantity]*[FinalUnitPriceQuery].[Rate])
WHERE (((CourtDates.ID)=[FinalUnitPriceQuery].[CourtDatesID]));

UPDATE TempCourtDates INNER JOIN TUnitPriceQuery ON TempCourtDates.CourtDatesID = TUnitPriceQuery.CourtDatesID SET TempCourtDates.Subtotal = TUnitPriceQuery.[Subtotal], TempCourtDates.ExpectedAdvanceDate = TUnitPriceQuery.[ExpectedAdvanceDate], TempCourtDates.ExpectedRebateDate = TUnitPriceQuery.[ExpectedRebateDate]
WHERE (([TempCourtDates].[CourtDatesID]=[TUnitPriceQuery].[CourtDatesID]));

UPDATE CourtDates INNER JOIN UnitPriceQuery ON CourtDates.ID = UnitPriceQuery.CourtDatesID SET CourtDates.Subtotal = UnitPriceQuery.[Subtotal], CourtDates.ExpectedAdvanceDate = UnitPriceQuery.[ExpectedAdvanceDate], CourtDates.ExpectedRebateDate = UnitPriceQuery.[ExpectedRebateDate]
WHERE (([CourtDates].[ID]=([UnitPriceQuery].[CourtDatesID])));

SELECT Rates.ID AS Rates_ID, Rates.Code, Rates.[List Price], XeroInvoiceCSV.ID AS XeroInvoiceCSV_ID, XeroInvoiceCSV.InventoryItemCode, XeroInvoiceCSV.UnitAmount
FROM Rates INNER JOIN XeroInvoiceCSV ON Rates.[List Price] = XeroInvoiceCSV.[UnitAmount];






SELECT ID, (SELECT Sum(GroupTasksIncomplete.TimeLength) AS Total FROM GroupTasksIncomplete WHERE GroupTasksIncomplete.ID <= T1.ID) AS Total
FROM GroupTasksIncomplete AS T1;


SELECT Tasks.[ID], Tasks.[Title], Tasks.[Priority], Tasks.[Description], Tasks.[Due Date], Tasks.[PriorityPoints], Tasks.[Category], Tasks.[TimeLength], Tasks.[CourtDatesID]
FROM Tasks
WHERE Tasks.Completed=No
GROUP BY Tasks.CourtDatesID, Tasks.Priority, Tasks.Title, Tasks.PriorityPoints, Tasks.DueDate;

SELECT *
FROM ShippingOptionsQ
WHERE [id] = 1;


SELECT *
FROM Statuses
WHERE ((Statuses.[CourtDatesID])=Forms![NewMainMenu]![ProcessJobSubformNMM].Form![JobNumberField]);

SELECT FinalUnitPriceInvoiceQuery.CourtDatesID AS CourtDatesID, (QTotalPricebyInvoiceNumber.[TotalPrice]-[QTotalPaymentsbyInvoiceNumber].[TotalPayments]) AS BalanceOwed, FinalUnitPriceInvoiceQuery.*, QTotalPaymentsbyInvoiceNumber.TotalPayments, QTotalFactoringCostbyInvoiceNumber.TotalFactoringCost, QTotalPricebyLastFirstName.TotalPrice
FROM ((FinalUnitPriceInvoiceQuery LEFT JOIN QTotalPricebyInvoiceNumber ON FinalUnitPriceInvoiceQuery.InvoiceNo = QTotalPricebyInvoiceNumber.InvoiceNo) LEFT JOIN QTotalPaymentsbyInvoiceNumber ON FinalUnitPriceInvoiceQuery.InvoiceNo = QTotalPaymentsbyInvoiceNumber.InvoiceNo) LEFT JOIN QTotalFactoringCostbyInvoiceNumber ON FinalUnitPriceInvoiceQuery.InvoiceNo = QTotalFactoringCostbyInvoiceNumber.InvoiceNo
WHERE ((((QTotalPricebyInvoiceNumber.[TotalPrice]-[QTotalPaymentsbyInvoiceNumber].[TotalPayments]))>0));

SELECT FindReplaceShortcuts.ID, FindReplaceShortcuts.Find, FindReplaceShortcuts.BankruptcyReplace
FROM FindReplaceShortcuts;


SELECT [SubtotalUnitPriceQuery].InvoiceNo, [SubtotalUnitPriceQuery].InvoiceDate, CDbl(Nz(Sum([SubtotalUnitPriceQuery].[Quantity]),0)) AS PageCount, CDbl(Nz(Sum([SubtotalUnitPriceQuery].[Subtotal]),2)) AS Subtotal, CDbl(Nz(Sum([SubtotalUnitPriceQuery].[AudioLength]),0)) AS AudioLength
FROM SubtotalUnitPriceQuery
GROUP BY [SubtotalUnitPriceQuery].InvoiceNo, [SubtotalUnitPriceQuery].InvoiceDate;

SELECT FindReplaceShortcuts.JEWFDA1, FindReplaceShortcuts.ID
FROM FindReplaceShortcuts;


SELECT *
FROM TRInvoiceCasesQ INNER JOIN TRAppAddrInvQ ON [TRInvoiceCasesQ].[OrderingID]=[TRAppAddrInvQ].[ID];


SELECT QInfobyInvoiceNumber.ID AS QInfobyInvoiceNumber_ID, QInfobyInvoiceNumber.Party1, QInfobyInvoiceNumber.Party2, QInfobyInvoiceNumber.Party1Name, QInfobyInvoiceNumber.Party2Name, QInfobyInvoiceNumber.CaseNumber1, QInfobyInvoiceNumber.CaseNumber2, QInfobyInvoiceNumber.Jurisdiction, QInfobyInvoiceNumber.HearingTitle, QInfobyInvoiceNumber.Judge, QInfobyInvoiceNumber.InvoiceNo, QInfobyInvoiceNumber.UnitPrice, QInfobyInvoiceNumber.Quantity, QInfobyInvoiceNumber.Subtotal, QInfobyInvoiceNumber.AudioLength, QInfobyInvoiceNumber.TurnaroundTimesCD, QInfobyInvoiceNumber.DueDate, QInfobyInvoiceNumber.InvoiceDate, QInfobyInvoiceNumber.HearingStartTime, QInfobyInvoiceNumber.HearingEndTime, QInfobyInvoiceNumber.HearingDate, QInfobyInvoiceNumber.CasesID, QInfobyInvoiceNumber.OrderingID, QInfobyInvoiceNumber.FiledNotFiled, QInfobyInvoiceNumber.PaymentDueDate, QInfobyInvoiceNumber.ExpectedAdvanceDate, QInfobyInvoiceNumber.ExpectedRebateDate, QInfobyInvoiceNumber.EstimatedPageCount, Customers.ID AS Customers_ID, Customers.Company, Customers.MrMs, Customers.LastName, Customers.FirstName, Customers.EmailAddress, Customers.JobTitle, Customers.BusinessPhone, Customers.Address, Customers.City, Customers.State, Customers.ZIP, Customers.FactoringApproved, (QInfobyInvoiceNumber.[Subtotal]*.8) AS ExpectedAdvanceAmount

SELECT *
FROM TempCourtDates;

SELECT Title, PriorityPoints, [Due Date], TimeLength, Description, Completed
FROM Tasks
WHERE [Title] Like '*' & Forms!NewMainMenu!ProcessJobSubformNMM.Form!JobNumberField & '*' AND [Completed]=False;

SELECT Expenses.Memo, Expenses.ExpensesDate, CDbl(Nz(Sum([Expenses].[Amount]),0)) AS TotalExpenses
FROM Expenses
GROUP BY Expenses.Memo, Expenses.ExpensesDate;

SELECT [Expenses].InvoiceNo, CDbl(Nz(Sum([Expenses].[Amount]),0)) AS TotalExpenses
FROM Expenses
GROUP BY [Expenses].InvoiceNo;

SELECT InvoiceNo, TotalExpenses
FROM QTotalInvoicesNoExpenses
UNION SELECT InvoiceNo, TotalExpenses
FROM QTotalExpensesbyInvoiceNumber;

SELECT [Expenses].CourtDatesID, CDbl(Nz(Sum([Expenses].[Amount]),0)) AS TotalExpenses
FROM Expenses
GROUP BY [Expenses].CourtDatesID;

SELECT [FinalUnitPriceQuery].InvoiceNo, CDbl(Nz(Sum([FinalUnitPriceQuery].[FactoringCost]),0)) AS TotalFactoringCost
FROM FinalUnitPriceQuery
GROUP BY [FinalUnitPriceQuery].InvoiceNo;



SELECT [Payments].InvoiceNo, CDbl(Nz(Sum([Payments].[Amount]),0)) AS TotalPayments
FROM Payments
GROUP BY [Payments].InvoiceNo;

SELECT [FinalUnitPriceQuery].InvoiceNo, CDbl(Nz(Sum([FinalUnitPriceQuery].[ActualQuantity]),0)) AS PageCount, CDbl(Nz(Sum([FinalUnitPriceQuery].[FinalPrice]),2)) AS TotalPrice
FROM FinalUnitPriceQuery
GROUP BY [FinalUnitPriceQuery].InvoiceNo;

SELECT FinalUnitPriceInvoiceQuery.LastName, FinalUnitPriceInvoiceQuery.FirstName, FinalUnitPriceInvoiceQuery.InvoiceNo, CDbl(Nz(Sum([FinalUnitPriceInvoiceQuery].[FinalTotal]),0)) AS TotalPrice
FROM FinalUnitPriceInvoiceQuery
GROUP BY FinalUnitPriceInvoiceQuery.LastName, FinalUnitPriceInvoiceQuery.FirstName;


SELECT *
FROM Tasks
WHERE Priority='(2) Stage 2' AND Title LIKE '*1945*';

SELECT ID, CourtDatesID, PriorityPoints, [Due Date], Title, Description, Completed, Category, TimeLength
FROM Tasks
ORDER BY PriorityPoints DESC;

SELECT ID, CourtDatesID, PriorityPoints, [Due Date], Title, Description, Completed, Category, TimeLength, (SELECT Sum(runningtotaltasks.timelength) AS Total FROM runningtotaltasks WHERE runningtotaltasks.ID <= runningtotaltaskssum.ID) AS Total
FROM runningtotaltasks AS running
ORDER BY PriorityPoints DESC;

SELECT *
FROM Statuses
WHERE ((Statuses.CourtDatesID)=(Forms![NewMainMenu]![ProcessJobSubformNMM].Form![JobNumberField]));

SELECT QBalanceOwed.InvoiceNo, QBalanceOwed.CourtDatesID, QBalanceOwed.FinalUnitPriceQuery_AudioLength AS AudioLength, QBalanceOwed.InvoiceInfoQ_InvoiceDate AS InvoiceDate, QBalanceOwed.InvoiceInfoQ_ActualQuantity AS FinalPageCount, QBalanceOwed.InvoiceInfoQ_ExpectedRebateDate AS ERebateDate, QBalanceOwed.InvoiceInfoQ_ExpectedAdvanceDate AS EAdvanceDate, QBalanceOwed.BalanceOwed, QBalanceOwed.FinalUnitPriceQuery_UnitPrice AS PageRate, QBalanceOwed.Party1, QBalanceOwed.Party2, QBalanceOwed.CaseNumber2, QBalanceOwed.HearingTitle, QBalanceOwed.Judge, QBalanceOwed.Jurisdiction, Customers.Company, Customers.MrMs, Customers.LastName, Customers.FirstName, Customers.BusinessPhone, Customers.Address, Customers.City, Customers.State, Customers.ZIP, QBalanceOwed.HearingDate, QBalanceOwed.HearingStartTime, QBalanceOwed.HearingEndTime, QBalanceOwed.ShipDate, QBalanceOwed.TrackingNumber, QBalanceOwed.OrderingID, QBalanceOwed.CasesID, QBalanceOwed.Subtotal, QBalanceOwed.CaseNumber1, QBalanceOwed.FactoringCost
FROM QBalanceOwed
WHERE ((FirstName) Like [Enter search term to search ordering attorney's first name; enter a * before and after to search with wildcard or it will search exact match:]);

SELECT QBalanceOwed.InvoiceNo, QBalanceOwed.CourtDatesID, QBalanceOwed.FinalUnitPriceQuery_AudioLength AS AudioLength, QBalanceOwed.InvoiceInfoQ_InvoiceDate AS InvoiceDate, QBalanceOwed.InvoiceInfoQ_ActualQuantity AS FinalPageCount, QBalanceOwed.InvoiceInfoQ_ExpectedRebateDate AS ERebateDate, QBalanceOwed.InvoiceInfoQ_ExpectedAdvanceDate AS EAdvanceDate, QBalanceOwed.BalanceOwed, QBalanceOwed.FinalUnitPriceQuery_UnitPrice AS PageRate, QBalanceOwed.Party1, QBalanceOwed.Party2, QBalanceOwed.CaseNumber2, QBalanceOwed.HearingTitle, QBalanceOwed.Judge, QBalanceOwed.Jurisdiction, QBalanceOwed.Company, QBalanceOwed.MrMs, QBalanceOwed.LastName, QBalanceOwed.FirstName, QBalanceOwed.BusinessPhone, QBalanceOwed.Address, QBalanceOwed.City, QBalanceOwed.State, QBalanceOwed.ZIP, QBalanceOwed.HearingDate, QBalanceOwed.HearingStartTime, QBalanceOwed.HearingEndTime, QBalanceOwed.ShipDate, QBalanceOwed.TrackingNumber, QBalanceOwed.OrderingID, QBalanceOwed.CasesID, QBalanceOwed.Subtotal, QBalanceOwed.CaseNumber1, QBalanceOwed.EmailAddress, QBalanceOwed.FactoringCost
FROM QBalanceOwed
WHERE (((QBalanceOwed.[CaseNumber1]) Like [Enter search term to search casenumber1; enter a * before and after to search with wildcard or it will search exact match:]));

SELECT CitationHyperlinks.LongCitation, CitationHyperlinks.CHCategory, CitationHyperlinks.WebAddress, CitationHyperlinks.FindCitation, CitationHyperlinks.ReplaceHyperlink
FROM CitationHyperlinks
WHERE (((CitationHyperlinks.LongCitation)like [Enter search term to search citations; enter a * before and after to search with wildcard or it will search exact match:]));


SELECT QBalanceOwed.InvoiceNo, QBalanceOwed.CourtDatesID, QBalanceOwed.FinalUnitPriceQuery_AudioLength AS AudioLength, QBalanceOwed.InvoiceInfoQ_InvoiceDate AS InvoiceDate, QBalanceOwed.InvoiceInfoQ_ActualQuantity AS FinalPageCount, QBalanceOwed.InvoiceInfoQ_ExpectedRebateDate AS ERebateDate, QBalanceOwed.InvoiceInfoQ_ExpectedAdvanceDate AS EAdvanceDate, QBalanceOwed.BalanceOwed, QBalanceOwed.FinalUnitPriceQuery_UnitPrice AS PageRate, QBalanceOwed.Party1, QBalanceOwed.Party2, QBalanceOwed.CaseNumber2, QBalanceOwed.HearingTitle, QBalanceOwed.Judge, QBalanceOwed.Jurisdiction, Customers.Company, Customers.MrMs, Customers.LastName, Customers.FirstName, Customers.BusinessPhone, Customers.Address, Customers.City, Customers.State, Customers.ZIP, QBalanceOwed.HearingDate, QBalanceOwed.HearingStartTime, QBalanceOwed.HearingEndTime, QBalanceOwed.ShipDate, QBalanceOwed.TrackingNumber, QBalanceOwed.OrderingID, QBalanceOwed.CasesID, QBalanceOwed.Subtotal, QBalanceOwed.CaseNumber1, QBalanceOwed.FactoringCost
FROM QBalanceOwed
WHERE ((Company) Like [Enter search term to search ordering company's name; enter a * before and after to search with wildcard or it will search exact match:]);

SELECT QBalanceOwed.InvoiceNo, QBalanceOwed.CourtDatesID, QBalanceOwed.FinalUnitPriceQuery_AudioLength AS AudioLength, QBalanceOwed.InvoiceInfoQ_InvoiceDate AS InvoiceDate, QBalanceOwed.InvoiceInfoQ_ActualQuantity AS FinalPageCount, QBalanceOwed.InvoiceInfoQ_ExpectedRebateDate AS ERebateDate, QBalanceOwed.InvoiceInfoQ_ExpectedAdvanceDate AS EAdvanceDate, QBalanceOwed.BalanceOwed, QBalanceOwed.FinalUnitPriceQuery_UnitPrice AS PageRate, QBalanceOwed.Party1, QBalanceOwed.Party2, QBalanceOwed.CaseNumber2, QBalanceOwed.HearingTitle, QBalanceOwed.Judge, QBalanceOwed.Jurisdiction, Customers.Company, Customers.MrMs, Customers.LastName, Customers.FirstName, Customers.BusinessPhone, Customers.Address, Customers.City, Customers.State, Customers.ZIP, QBalanceOwed.HearingDate, QBalanceOwed.HearingStartTime, QBalanceOwed.HearingEndTime, QBalanceOwed.ShipDate, QBalanceOwed.TrackingNumber, QBalanceOwed.OrderingID, QBalanceOwed.CasesID, QBalanceOwed.Subtotal, QBalanceOwed.CaseNumber1, QBalanceOwed.FactoringCost
FROM QBalanceOwed
WHERE ((Party2) Like [Enter search term to search defendant's name; enter a * before and after to search with wildcard or it will search exact match:]);

SELECT QBalanceOwed.InvoiceNo, QBalanceOwed.CourtDatesID, QBalanceOwed.FinalUnitPriceQuery_AudioLength AS AudioLength, QBalanceOwed.InvoiceInfoQ_InvoiceDate AS InvoiceDate, QBalanceOwed.InvoiceInfoQ_ActualQuantity AS FinalPageCount, QBalanceOwed.InvoiceInfoQ_ExpectedRebateDate AS ERebateDate, QBalanceOwed.InvoiceInfoQ_ExpectedAdvanceDate AS EAdvanceDate, QBalanceOwed.BalanceOwed, QBalanceOwed.FinalUnitPriceQuery_UnitPrice AS PageRate, QBalanceOwed.Party1, QBalanceOwed.Party2, QBalanceOwed.CaseNumber2, QBalanceOwed.HearingTitle, QBalanceOwed.Judge, QBalanceOwed.Jurisdiction, Customers.Company, Customers.MrMs, Customers.LastName, Customers.FirstName, Customers.BusinessPhone, Customers.Address, Customers.City, Customers.State, Customers.ZIP, QBalanceOwed.HearingDate, QBalanceOwed.HearingStartTime, QBalanceOwed.HearingEndTime, QBalanceOwed.ShipDate, QBalanceOwed.TrackingNumber, QBalanceOwed.OrderingID, QBalanceOwed.CasesID, QBalanceOwed.Subtotal, QBalanceOwed.CaseNumber1, QBalanceOwed.FactoringCost
FROM QBalanceOwed
WHERE ((EmailAddress) Like [Enter search term to search ordering company's email; enter a * before and after to search with wildcard or it will search exact match:]);

SELECT QBalanceOwed.InvoiceNo, QBalanceOwed.CourtDatesID, QBalanceOwed.FinalUnitPriceQuery_AudioLength AS AudioLength, QBalanceOwed.InvoiceInfoQ_InvoiceDate AS InvoiceDate, QBalanceOwed.InvoiceInfoQ_ActualQuantity AS FinalPageCount, QBalanceOwed.InvoiceInfoQ_ExpectedRebateDate AS ERebateDate, QBalanceOwed.InvoiceInfoQ_ExpectedAdvanceDate AS EAdvanceDate, QBalanceOwed.BalanceOwed, QBalanceOwed.FinalUnitPriceQuery_UnitPrice AS PageRate, QBalanceOwed.Party1, QBalanceOwed.Party2, QBalanceOwed.CaseNumber2, QBalanceOwed.HearingTitle, QBalanceOwed.Judge, QBalanceOwed.Jurisdiction, Customers.Company, Customers.MrMs, Customers.LastName, Customers.FirstName, Customers.BusinessPhone, Customers.Address, Customers.City, Customers.State, Customers.ZIP, QBalanceOwed.HearingDate, QBalanceOwed.HearingStartTime, QBalanceOwed.HearingEndTime, QBalanceOwed.ShipDate, QBalanceOwed.TrackingNumber, QBalanceOwed.OrderingID, QBalanceOwed.CasesID, QBalanceOwed.Subtotal, QBalanceOwed.CaseNumber1, QBalanceOwed.FactoringCost
FROM QBalanceOwed
WHERE ((HearingTitle) Like [Enter search term to search hearing title; enter a * before and after to search with wildcard or it will search exact match:]);

SELECT QBalanceOwed.InvoiceNo, QBalanceOwed.CourtDatesID, QBalanceOwed.FinalUnitPriceQuery_AudioLength AS AudioLength, QBalanceOwed.InvoiceInfoQ_InvoiceDate AS InvoiceDate, QBalanceOwed.InvoiceInfoQ_ActualQuantity AS FinalPageCount, QBalanceOwed.InvoiceInfoQ_ExpectedRebateDate AS ERebateDate, QBalanceOwed.InvoiceInfoQ_ExpectedAdvanceDate AS EAdvanceDate, QBalanceOwed.BalanceOwed, QBalanceOwed.FinalUnitPriceQuery_UnitPrice AS PageRate, QBalanceOwed.Party1, QBalanceOwed.Party2, QBalanceOwed.CaseNumber2, QBalanceOwed.HearingTitle, QBalanceOwed.Judge, QBalanceOwed.Jurisdiction, Customers.Company, Customers.MrMs, Customers.LastName, Customers.FirstName, Customers.BusinessPhone, Customers.Address, Customers.City, Customers.State, Customers.ZIP, QBalanceOwed.HearingDate, QBalanceOwed.HearingStartTime, QBalanceOwed.HearingEndTime, QBalanceOwed.ShipDate, QBalanceOwed.TrackingNumber, QBalanceOwed.OrderingID, QBalanceOwed.CasesID, QBalanceOwed.Subtotal, QBalanceOwed.CaseNumber1, QBalanceOwed.FactoringCost
FROM QBalanceOwed
WHERE ((CourtDatesID) Like [Enter search term to search job number; enter a * before and after to search with wildcard or it will search exact match:]);

SELECT QBalanceOwed.InvoiceNo, QBalanceOwed.CourtDatesID, QBalanceOwed.FinalUnitPriceQuery_AudioLength AS AudioLength, QBalanceOwed.InvoiceInfoQ_InvoiceDate AS InvoiceDate, QBalanceOwed.InvoiceInfoQ_ActualQuantity AS FinalPageCount, QBalanceOwed.InvoiceInfoQ_ExpectedRebateDate AS ERebateDate, QBalanceOwed.InvoiceInfoQ_ExpectedAdvanceDate AS EAdvanceDate, QBalanceOwed.BalanceOwed, QBalanceOwed.FinalUnitPriceQuery_UnitPrice AS PageRate, QBalanceOwed.Party1, QBalanceOwed.Party2, QBalanceOwed.CaseNumber2, QBalanceOwed.HearingTitle, QBalanceOwed.Judge, QBalanceOwed.Jurisdiction, Customers.Company, Customers.MrMs, Customers.LastName, Customers.FirstName, Customers.BusinessPhone, Customers.Address, Customers.City, Customers.State, Customers.ZIP, QBalanceOwed.HearingDate, QBalanceOwed.HearingStartTime, QBalanceOwed.HearingEndTime, QBalanceOwed.ShipDate, QBalanceOwed.TrackingNumber, QBalanceOwed.OrderingID, QBalanceOwed.CasesID, QBalanceOwed.Subtotal, QBalanceOwed.CaseNumber1, QBalanceOwed.FactoringCost
FROM QBalanceOwed
WHERE ((Judge) Like [Enter search term to search judge's name; enter a * before and after to search with wildcard or it will search exact match:]);

SELECT QBalanceOwed.InvoiceNo, QBalanceOwed.CourtDatesID, QBalanceOwed.FinalUnitPriceQuery_AudioLength AS AudioLength, QBalanceOwed.InvoiceInfoQ_InvoiceDate AS InvoiceDate, QBalanceOwed.InvoiceInfoQ_ActualQuantity AS FinalPageCount, QBalanceOwed.InvoiceInfoQ_ExpectedRebateDate AS ERebateDate, QBalanceOwed.InvoiceInfoQ_ExpectedAdvanceDate AS EAdvanceDate, QBalanceOwed.BalanceOwed, QBalanceOwed.FinalUnitPriceQuery_UnitPrice AS PageRate, QBalanceOwed.Party1, QBalanceOwed.Party2, QBalanceOwed.CaseNumber2, QBalanceOwed.HearingTitle, QBalanceOwed.Judge, QBalanceOwed.Jurisdiction, Customers.Company, Customers.MrMs, Customers.LastName, Customers.FirstName, Customers.BusinessPhone, Customers.Address, Customers.City, Customers.State, Customers.ZIP, QBalanceOwed.HearingDate, QBalanceOwed.HearingStartTime, QBalanceOwed.HearingEndTime, QBalanceOwed.ShipDate, QBalanceOwed.TrackingNumber, QBalanceOwed.OrderingID, QBalanceOwed.CasesID, QBalanceOwed.Subtotal, QBalanceOwed.CaseNumber1, QBalanceOwed.FactoringCost
FROM QBalanceOwed
WHERE ((Jurisdiction) Like [Enter search term to search by name of jurisdiction; enter a * before and after to search with wildcard or it will search exact match:]);

SELECT QBalanceOwed.InvoiceNo, QBalanceOwed.CourtDatesID, QBalanceOwed.FinalUnitPriceQuery_AudioLength AS AudioLength, QBalanceOwed.InvoiceInfoQ_InvoiceDate AS InvoiceDate, QBalanceOwed.InvoiceInfoQ_ActualQuantity AS FinalPageCount, QBalanceOwed.InvoiceInfoQ_ExpectedRebateDate AS ERebateDate, QBalanceOwed.InvoiceInfoQ_ExpectedAdvanceDate AS EAdvanceDate, QBalanceOwed.BalanceOwed, QBalanceOwed.FinalUnitPriceQuery_UnitPrice AS PageRate, QBalanceOwed.Party1, QBalanceOwed.Party2, QBalanceOwed.CaseNumber2, QBalanceOwed.HearingTitle, QBalanceOwed.Judge, QBalanceOwed.Jurisdiction, Customers.Company, Customers.MrMs, Customers.LastName, Customers.FirstName, Customers.BusinessPhone, Customers.Address, Customers.City, Customers.State, Customers.ZIP, QBalanceOwed.HearingDate, QBalanceOwed.HearingStartTime, QBalanceOwed.HearingEndTime, QBalanceOwed.ShipDate, QBalanceOwed.TrackingNumber, QBalanceOwed.OrderingID, QBalanceOwed.CasesID, QBalanceOwed.Subtotal, QBalanceOwed.CaseNumber1, QBalanceOwed.FactoringCost
FROM QBalanceOwed
WHERE ((LastName) Like [Enter search term to search ordering attorneys' last name; enter a * before and after to search with wildcard or it will search exact match:]);


SELECT QBalanceOwed.InvoiceNo, QBalanceOwed.CourtDatesID, QBalanceOwed.FinalUnitPriceQuery_AudioLength AS AudioLength, QBalanceOwed.InvoiceInfoQ_InvoiceDate AS InvoiceDate, QBalanceOwed.InvoiceInfoQ_ActualQuantity AS FinalPageCount, QBalanceOwed.InvoiceInfoQ_ExpectedRebateDate AS ERebateDate, QBalanceOwed.InvoiceInfoQ_ExpectedAdvanceDate AS EAdvanceDate, QBalanceOwed.BalanceOwed, QBalanceOwed.FinalUnitPriceQuery_UnitPrice AS PageRate, QBalanceOwed.Party1, QBalanceOwed.Party2, QBalanceOwed.CaseNumber2, QBalanceOwed.HearingTitle, QBalanceOwed.Judge, QBalanceOwed.Jurisdiction, Customers.Company, Customers.MrMs, Customers.LastName, Customers.FirstName, Customers.BusinessPhone, Customers.Address, Customers.City, Customers.State, Customers.ZIP, QBalanceOwed.HearingDate, QBalanceOwed.HearingStartTime, QBalanceOwed.HearingEndTime, QBalanceOwed.ShipDate, QBalanceOwed.TrackingNumber, QBalanceOwed.OrderingID, QBalanceOwed.CasesID, QBalanceOwed.Subtotal, QBalanceOwed.CaseNumber1, QBalanceOwed.FactoringCost
FROM QBalanceOwed
WHERE ((Party1) Like [Enter search term to search plaintiff's name; enter a * before and after to search with wildcard or it will search exact match:]);


SELECT FinalUnitPriceInvoiceQuery.CourtDatesID AS CourtDatesID, (QTotalPricebyInvoiceNumber.[TotalPrice]-[QTotalPaymentsbyInvoiceNumber].[TotalPayments]) AS BalanceOwed, FinalUnitPriceInvoiceQuery.*, QTotalPaymentsbyInvoiceNumber.TotalPayments, QTotalFactoringCostbyInvoiceNumber.TotalFactoringCost, QTotalPricebyLastFirstName.TotalPrice
FROM ((FinalUnitPriceInvoiceQuery LEFT JOIN QTotalPricebyInvoiceNumber ON FinalUnitPriceInvoiceQuery.InvoiceNo = QTotalPricebyInvoiceNumber.InvoiceNo) LEFT JOIN QTotalPaymentsbyInvoiceNumber ON FinalUnitPriceInvoiceQuery.InvoiceNo = QTotalPaymentsbyInvoiceNumber.InvoiceNo) LEFT JOIN QTotalFactoringCostbyInvoiceNumber ON FinalUnitPriceInvoiceQuery.InvoiceNo = QTotalFactoringCostbyInvoiceNumber.InvoiceNo
WHERE ((((QTotalPricebyInvoiceNumber.TotalPrice-QTotalPaymentsbyInvoiceNumber.TotalPayments))>0) And FinalUnitPriceQuery_UnitPrice=40);

SELECT [Statuses].[ID]
FROM Statuses
WHERE ([Statuses].[ID] = Combo57);

SELECT ContactName, EmailAddress, POAddressLine1, POCity, PORegion, POPostalCode, InvoiceNumber, Reference, InvoiceDate, DueDate, InventoryItemCode, Description, Quantity, UnitAmount, AccountCode, TaxType, BrandingTheme
FROM XeroInvoiceCSV;

SELECT *
FROM ShippingOptions
WHERE [CourtDatesID] = Forms![NewMainMenu]![ProcessJobSubformNMM].Form![JobNumberField];

INSERT INTO ShippingOptions ( CourtDatesID )
SELECT [ShippingOptions]![CourtDatesID] AS Expr1, *
FROM ShippingOptions
WHERE ((([ShippingOptions]![CourtDatesID])=510));

SELECT SpeakersStatic.[ID], SpeakersStatic.[Jurisdiction], SpeakersStatic.[SPKR1], SpeakersStatic.[SPKR2], SpeakersStatic.[SPKR3], SpeakersStatic.[SPKR4], SpeakersStatic.[SPKR5], SpeakersStatic.[SPKR6], SpeakersStatic.[SPKR7], SpeakersStatic.[SPKR8], SpeakersStatic.[SPKR9], SpeakersStatic.[SPKR10], SpeakersStatic.[SPKR11], SpeakersStatic.[SPKR12], SpeakersStatic.[SPKR13], SpeakersStatic.[Spkr14], SpeakersStatic.[SPKR15], SpeakersStatic.[SPKR16], SpeakersStatic.[SPKR17], SpeakersStatic.[SPKR18], SpeakersStatic.[SPKR19], SpeakersStatic.[SPKR20], SpeakersStatic.[SPKR21], SpeakersStatic.[SPKR22], SpeakersStatic.[SPKR23], SpeakersStatic.[SPKR24], SpeakersStatic.[SPKR25], SpeakersStatic.[SPKR26], SpeakersStatic.[SPKR27], SpeakersStatic.[SPKR28], SpeakersStatic.[SPKR29], SpeakersStatic.[SPKR30], SpeakersStatic.[SPKR31], SpeakersStatic.[SPKR32], SpeakersStatic.[SPKR33], SpeakersStatic.[SPKR34], SpeakersStatic.[SPKR35], SpeakersStatic.[SPKR36], SpeakersStatic.[SPKR37], SpeakersStatic.[SPKR38], SpeakersStatic.[SPKR39], SpeakersStatic.[SPKR40], SpeakersStatic.[SPKR41], SpeakersStatic.[SPKR42], SpeakersStatic.[SPKR43], SpeakersStatic.[SPKR44], SpeakersStatic.[SPKR45], SpeakersStatic.[SPKR46], SpeakersStatic.[SPKR47], SpeakersStatic.[SPKR48], SpeakersStatic.[SPKR49], SpeakersStatic.[SPKR50], SpeakersStatic.[SPKR51], SpeakersStatic.[SPKR52], SpeakersStatic.[SPKR53], SpeakersStatic.[SPKR54], SpeakersStatic.[SPKR55], SpeakersStatic.[SPKR56], SpeakersStatic.[SPKR57], SpeakersStatic.[SPKR58], SpeakersStatic.[SPKR59], SpeakersStatic.[SPKR60], SpeakersStatic.[SPKR61], SpeakersStatic.[SPKR62], SpeakersStatic.[SPKR63], SpeakersStatic.[SPKR64], SpeakersStatic.[SPKR65], SpeakersStatic.[SPKR66], SpeakersStatic.[SPKR67], SpeakersStatic.[SPKR68], SpeakersStatic.[SPKR69], SpeakersStatic.[SPKR70], SpeakersStatic.[SPKR71], SpeakersStatic.[SPKR72], SpeakersStatic.[SPKR73], SpeakersStatic.[SPKR74], SpeakersStatic.[SPKR75], SpeakersStatic.[SPKR76], SpeakersStatic.[SPKR77], SpeakersStatic.[SPKR78], SpeakersStatic.[SPKR79], SpeakersStatic.[SPKR80], SpeakersStatic.[SPKR81], SpeakersStatic.[SPKR82], SpeakersStatic.[SPKR83], SpeakersStatic.[SPKR84], SpeakersStatic.[SPKR85], SpeakersStatic.[SPKR86], SpeakersStatic.[SPKR87], SpeakersStatic.[SPKR88], SpeakersStatic.[SPKR89], SpeakersStatic.[SPKR90], SpeakersStatic.[SPKR91], SpeakersStatic.[SPKR92], SpeakersStatic.[SPKR93], SpeakersStatic.[SPKR94], SpeakersStatic.[SPKR95], SpeakersStatic.[SPKR96], SpeakersStatic.[SPKR97], SpeakersStatic.[SPKR98], SpeakersStatic.[SPKR99], SpeakersStatic.[SPKR100]
FROM SpeakersStatic
WHERE SpeakersStatic.[ID]=2;




SELECT Tasks.[Due Date], Tasks.TimeLength, Tasks.Completed
FROM Tasks
WHERE (((Tasks.Completed)=False) AND ((Tasks.[Due Date])<=[Forms]![NewMainMenu]![ProcessJobSubformNMM]![SearchJobsSubform].[Form]![txtDeadline]));

SELECT ShippingOptionsQ.MailClass, ShippingOptionsQ.PackageType, ShippingOptionsQ.Width, ShippingOptionsQ.Length, ShippingOptionsQ.Depth, ShippingOptionsQ.PriorityMailExpress1030, ShippingOptionsQ.HolidayDelivery, ShippingOptionsQ.SundayDelivery, ShippingOptionsQ.SaturdayDelivery, ShippingOptionsQ.SignatureRequired, ShippingOptionsQ.Stealth, ShippingOptionsQ.ReplyPostage, ShippingOptionsQ.InsuredMail, ShippingOptionsQ.COD, ShippingOptionsQ.RestrictedDelivery, ShippingOptionsQ.AdultSignatureRestricted, ShippingOptionsQ.AdultSignatureRequired, ShippingOptionsQ.ReturnReceipt, ShippingOptionsQ.CertifiedMail, ShippingOptionsQ.SignatureConfirmation, ShippingOptionsQ.USPSTracking, ShippingOptionsQ.ReferenceID, ShippingOptionsQ.ToName, ShippingOptionsQ.ToAddress1, ShippingOptionsQ.ToAddress2, ShippingOptionsQ.ToCity, ShippingOptionsQ.ToState, ShippingOptionsQ.ToPostalCode, ShippingOptionsQ.ToCountry, ShippingOptionsQ.Value, ShippingOptionsQ.Description, ShippingOptionsQ.WeightOz, ShippingOptionsQ.ActualWeight, ShippingOptionsQ.ActualWeightText, ShippingOptionsQ.ID, ShippingOptionsQ.Output, ShippingOptionsQ.CourtDatesID
FROM ShippingOptionsQ
WHERE (((ShippingOptionsQ.CourtDatesID)=[Forms]![NewMainMenu]![ProcessJobSubformNMM].[Form]![JobNumberField]));

SELECT ShippingOptionsQ.MailClass, ShippingOptionsQ.PackageType, ShippingOptionsQ.Width, ShippingOptionsQ.Length, ShippingOptionsQ.Depth, ShippingOptionsQ.PriorityMailExpress1030, ShippingOptionsQ.HolidayDelivery, ShippingOptionsQ.SundayDelivery, ShippingOptionsQ.SaturdayDelivery, ShippingOptionsQ.SignatureRequired, ShippingOptionsQ.Stealth, ShippingOptionsQ.ReplyPostage, ShippingOptionsQ.InsuredMail, ShippingOptionsQ.COD, ShippingOptionsQ.RestrictedDelivery, ShippingOptionsQ.AdultSignatureRestricted, ShippingOptionsQ.AdultSignatureRequired, ShippingOptionsQ.ReturnReceipt, ShippingOptionsQ.CertifiedMail, ShippingOptionsQ.SignatureConfirmation, ShippingOptionsQ.USPSTracking, ShippingOptionsQ.ReferenceID, "Court of Appeals Div I Clerk's Office" AS ToName, "600 University St" AS ToAddress1, "One Union Square" AS ToAddress2, "Seattle" AS ToCity, "WA" AS ToState, "98101" AS ToPostalCode, ShippingOptionsQ.ToCountry, ShippingOptionsQ.Value, ShippingOptionsQ.Description, ShippingOptionsQ.WeightOz, ShippingOptionsQ.ActualWeight, ShippingOptionsQ.ActualWeightText, ShippingOptionsQ.ID, ShippingOptionsQ.Output, ShippingOptionsQ.CourtDatesID
FROM ShippingOptionsQ
WHERE (((ShippingOptionsQ.CourtDatesID)=[Forms]![NewMainMenu]![ProcessJobSubformNMM].[Form]![JobNumberField]));

SELECT PaymentQueryInvoiceInfo.["PaymentsID"] AS Expr1, PaymentQueryInvoiceInfo.["PaymentsInvoiceNo"] AS Expr2, PaymentQueryInvoiceInfo.["Amount"] AS Expr3, PaymentQueryInvoiceInfo.["RemitDate"] AS Expr4, PaymentQueryInvoiceInfo.["CourtDatesID"] AS Expr5, PaymentQueryInvoiceInfo.["HearingDate"] AS Expr6, PaymentQueryInvoiceInfo.["HearingStartTime"] AS Expr7, PaymentQueryInvoiceInfo.["HearingEndTime"] AS Expr8, PaymentQueryInvoiceInfo.["CasesID"] AS Expr9, PaymentQueryInvoiceInfo.["OrderingID"] AS Expr10, PaymentQueryInvoiceInfo.["AudioLength"] AS Expr11, PaymentQueryInvoiceInfo.["TurnaroundTimesCD"] AS Expr12, PaymentQueryInvoiceInfo.["InvoiceNo"] AS Expr13, PaymentQueryInvoiceInfo.["InvoiceDate"] AS Expr14, PaymentQueryInvoiceInfo.["PaymentDueDate"] AS Expr15, PaymentQueryInvoiceInfo.["UnitPrice"] AS Expr16, PaymentQueryInvoiceInfo.["Quantity"] AS Expr17, PaymentQueryInvoiceInfo.["Subtotal"] AS Expr18
FROM PaymentQueryInvoiceInfo;

UPDATE TempShippingOptionsQ INNER JOIN ShippingOptions ON (TempShippingOptionsQ.PackageType = ShippingOptions.PackageType) AND (TempShippingOptionsQ.MailClass = ShippingOptions.MailClass) AND (TempShippingOptionsQ.CourtDatesID = ShippingOptions.CourtDatesID) AND (TempShippingOptionsQ.EmailAddress = ShippingOptions.ToEMail) AND (TempShippingOptionsQ.ZIP = ShippingOptions.ToPostalCode) AND (TempShippingOptionsQ.ToState = ShippingOptions.ToState) AND (TempShippingOptionsQ.ToCity = ShippingOptions.ToCity) AND (TempShippingOptionsQ.ToAddress1 = ShippingOptions.ToAddress2) AND (TempShippingOptionsQ.Company = ShippingOptions.ToAddress1) SET ShippingOptions.ToName = [TempShippingOptionsQ].[FirstName] & " " & [TempShippingOptionsQ].[LastName], ShippingOptions.ToAddress1 = [TempShippingOptionsQ]![Company], ShippingOptions.ToAddress2 = [TempShippingOptionsQ]![ToAddress1], ShippingOptions.ToCity = [TempShippingOptionsQ]![City], ShippingOptions.ToState = [TempShippingOptionsQ]![State], ShippingOptions.ToPostalCode = [TempShippingOptionsQ]![ZIP], ShippingOptions.ToEMail = [TempShippingOptionsQ]![EmailAddress];

UPDATE ShippingOptions INNER JOIN TempShippingOptionsQ ON TempShippingOptionsQ.CourtDatesID=ShippingOptions.CourtDatesID SET TempShippingOptionsQ.ToName = [ShippingOptions].[FirstName] & " " & [ShippingOptions].[LastName], TempShippingOptionsQ.ToAddress1 = [ShippingOptions]![Company], TempShippingOptionsQ.ToAddress2 = [ShippingOptions]![ToAddress1], TempShippingOptionsQ.ToCity = [ShippingOptions]![City], TempShippingOptionsQ.ToState = [ShippingOptions]![State], TempShippingOptionsQ.ToPostalCode = [ShippingOptions]![ZIP], TempShippingOptionsQ.ToEMail = [ShippingOptions]![EmailAddress];

SELECT #3/16/2020# AS Deadline, 1080 AS AudioLength, 810 AS PageCount, 2146.5 AS Subtotal1, 2632.5 AS Subtotal2, 3037.5 AS Subtotal3, 3442.5 AS Subtotal4, 2025 AS Subtotal5;





SELECT *
FROM [TR-AppAddrQ] INNER JOIN [TR-Court-Q] ON ([TR-AppAddrQ].ID=[TR-Court-Q].App6) Or ([TR-AppAddrQ].ID=[TR-Court-Q].App5) Or ([TR-AppAddrQ].ID=[TR-Court-Q].App4) Or ([TR-AppAddrQ].ID=[TR-Court-Q].App3) Or ([TR-AppAddrQ].ID=[TR-Court-Q].App2) Or ([TR-AppAddrQ].ID=[TR-Court-Q].App1) OR ([TR-AppAddrQ].ID=[TR-Court-Q].OrderingID);



SELECT *
FROM TRInv INNER JOIN TRAppAddrInvQ ON [TRInv].[CourtDates.OrderingID]=TRAppAddrInvQ.ID;

SELECT *
FROM TRInvoiceCasesQ INNER JOIN TRInv ON TRInvoiceCasesQ.[Cases.ID]=TRInv.CasesID;


SELECT TempCourtDates.[CourtDatesID], UnitPrice.[ID], TempCourtDates.[AudioLength], TempCourtDates.TurnaroundTimesCD, TempCourtDates.InvoiceNo, TempCourtDates.InvoiceDate, TempCourtDates.EstimatedPageCount, TempCourtDates.Quantity, TempCourtDates.DueDate, TempCourtDates.UnitPrice, UnitPrice.Rate, Rate*Quantity AS ["Subtotal"], (DateAdd('d',30,DueDate)) AS ["ExpectedRebateDate"], (DateAdd('d',2,[DueDate])) AS ["ExpectedAdvanceDate"]
FROM TempCourtDates INNER JOIN UnitPrice ON TempCourtDates.[UnitPrice] = UnitPrice.[ID];

SELECT *
FROM Statuses
WHERE (((Statuses.CourtDatesID)=Forms![SBFMUncompletedStatuses]![Combo57]));

SELECT Statuses.ContactsEntered, Statuses.JobEntered, Statuses.CoverPage, Statuses.AutoCorrect, Statuses.Schedule, Statuses.Invoice, Statuses.Transcribe, Statuses.AddRDtoCover, Statuses.FindReplaceRD, Statuses.HyperlinkTranscripts, Statuses.SpellingsEmail, Statuses.AudioProof, Statuses.InvoiceCompleted, Statuses.NoticeofService, Statuses.PackageEnclosedLetter, Statuses.CDLabel, Statuses.GenerateZIPs, Statuses.TranscriptsReady, Statuses.InvoicetoFactorEmail, Statuses.FileTranscript, Statuses.BurnCD, Statuses.ShippingXMLs, Statuses.GenerateShippingEM, Statuses.AddTrackingNumber, Statuses.CourtDatesID
FROM Statuses
WHERE Statuses.ContactsEntered=0 OR Statuses.JobEntered=0 OR Statuses.CoverPage=0 OR Statuses.AutoCorrect=0 OR Statuses.Schedule=0 OR Statuses.Invoice=0 OR Statuses.Transcribe=0 OR Statuses.AddRDtoCover=0 OR Statuses.FindReplaceRD=0 OR Statuses.HyperlinkTranscripts=0 OR Statuses.SpellingsEmail=0 OR Statuses.AudioProof=0 OR Statuses.InvoiceCompleted=0 OR Statuses.NoticeofService=0 OR Statuses.PackageEnclosedLetter=0 OR Statuses.CDLabel=0 OR Statuses.GenerateZIPs=0 OR Statuses.TranscriptsReady=0 OR Statuses.InvoicetoFactorEmail=0 OR Statuses.FileTranscript=0 OR Statuses.BurnCD=0 OR Statuses.ShippingXMLs=0 OR Statuses.GenerateShippingEM=0 OR Statuses.AddTrackingNumber=0;


SELECT UnpaidInvoicesQ.[FinalPrice], UnpaidInvoicesQ.[PaymentsID], UnpaidInvoicesQ.[pInvoiceNo], UnpaidInvoicesQ.[Amount], UnpaidInvoicesQ.[RemitDate], UnpaidInvoicesQ.[CourtDatesID], UnpaidInvoicesQ.[HearingDate], UnpaidInvoicesQ.[HearingStartTime], UnpaidInvoicesQ.[HearingEndTime], UnpaidInvoicesQ.[CasesID], UnpaidInvoicesQ.[OrderingID], UnpaidInvoicesQ.[AudioLength], UnpaidInvoicesQ.[TurnaroundTimesCD], UnpaidInvoicesQ.[DueDate], UnpaidInvoicesQ.[cInvoiceNo], UnpaidInvoicesQ.[InvoiceDate], UnpaidInvoicesQ.[PaymentDueDate], UnpaidInvoicesQ.[Subtotal], UnpaidInvoicesQ.[UnitPrice], UnpaidInvoicesQ.[ActualQuantity], UnpaidInvoicesQ.[PaymentSum], UnpaidInvoicesQ.[Company], UnpaidInvoicesQ.[FirstName], UnpaidInvoicesQ.[LastName], UnpaidInvoicesQ.[Address], UnpaidInvoicesQ.[City], UnpaidInvoicesQ.[State], UnpaidInvoicesQ.[Zip], UnpaidInvoicesQ.[FactoringApproved]
FROM UnpaidInvoicesQ
WHERE (((UnpaidInvoicesQ.[FactoringApproved])=True));

UPDATE CourtDates INNER JOIN InvoiceFPaymentDueDateQuery ON CourtDates.ID = InvoiceFPaymentDueDateQuery.CourtDatesID SET CourtDates.PaymentDueDate = ["PaymentDueDate"];

UPDATE CourtDates SET CourtDates.PaymentDueDate = (SELECT PaymentDueDate FROM InvoicePPaymentDueDateQuery WHERE ID = InvoicePPaymentDueDateQuery.CourtDatesID;);


SELECT BrandingThemes.ID, BrandingThemes.BrandingTheme AS BrandingThemes_BrandingTheme, XeroInvoiceCSV.BrandingTheme AS XeroInvoiceCSV_BrandingTheme
FROM XeroInvoiceCSV INNER JOIN BrandingThemes ON XeroInvoiceCSV.[BrandingTheme] = BrandingThemes.[BrandingTheme];


UPDATE XeroInvoiceCSV SET XeroInvoiceCSV.InventoryItemCode = [CourtDatesBTRIQ4QXero].[Code], XeroInvoiceCSV.BrandingTheme = [CourtDatesBTRIQ4QXero].[BrandingTheme_BrandingTheme], XeroInvoiceCSV.UnitAmount = [CourtDatesBTRIQ4QXero].[List Price]
WHERE (([XeroInvoiceCSV].[Reference]=[CourtDatesBTRIQ4QXero].[Reference]));

SELECT Rates.ID AS RatesID, Rates.Code, Rates.[List Price], XeroInvoiceCSV.ID AS XeroInvoiceCSVID, XeroInvoiceCSV.InventoryItemCode, XeroInvoiceCSV.UnitAmount
FROM Rates INNER JOIN XeroInvoiceCSV ON XeroInvoiceCSV.[InventoryItemCode]=
Rates.[ID];

SELECT InvoicesQuery4.CourtDatesID, InvoicesQuery4.Reference, InvoicesQuery4.HearingDate, InvoicesQuery4.HearingStartTime, InvoicesQuery4.HearingEndTime, InvoicesQuery4.CasesID, InvoicesQuery4.OrderingID, InvoicesQuery4.AudioLength, InvoicesQuery4.Location, InvoicesQuery4.TurnaroundTimesCD, InvoicesQuery4.Expr1010, InvoicesQuery4.Cases_ID, InvoicesQuery4.Party1, InvoicesQuery4.Party2, InvoicesQuery4.CaseNumber1, InvoicesQuery4.CaseNumber2, InvoicesQuery4.Jurisdiction, InvoicesQuery4.CustomersID, InvoicesQuery4.Company, InvoicesQuery4.FirstName, InvoicesQuery4.LastName, InvoicesQuery4.Address, InvoicesQuery4.City, InvoicesQuery4.State, InvoicesQuery4.ZIP, InvoicesQuery4.EmailAddress, InvoicesQuery4.InvoiceNo, InvoicesQuery4.Quantity, InvoicesQuery4.InventoryItemCode, InvoicesQuery4.DueDate, InvoicesQuery4.InvoiceDate, InvoicesQuery4.AccountCode, InvoicesQuery4.TaxType, InvoicesQuery4.BrandingTheme, Rates.ID, Rates.[List Price], Rates.Code
FROM Rates INNER JOIN InvoicesQuery4 ON Rates.[ID] = InvoicesQuery4.[InventoryItemCode];

SELECT Rates.[ID], Rates.[Code], Rates.[List Price], InvoicesQuery4.[UnitAmount], InvoicesQuery4.[InventoryItemCode]
FROM Rates INNER JOIN InvoicesQuery4 ON Rates.[ID] = InvoicesQuery4.[InventoryItemCode];
*/