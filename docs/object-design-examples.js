/*
Data Design, main endpoint /jobnumber
returned object of one single job number
*/

// citationhyperlinks, usc -- need additional table

// TABLES USED:

//courtdates, turnaroundtimes, invoices, cases, rates, brandingthemes, expenses, payments, shipping,appearances, customers, citationhyperlinks, usc, communicationhistory, agshortcuts, mailclass, packagetype, courtdatescasescustomers, statuses, tasks

let object = {
	'2173': {
		general: {
			courtdatesid: '',
			ttid: '',
			turnaround: '',
			hearingdate: '',
			starttime: '',
			endtime: '',
			audiolength: '',
			location: '',
			duedate: '',
			filed: '',
			hearingtitle: '',
			judgename: '',
			judgetitle: ''
		},
		financial: {
			invoiceno: '',
			rate: '',
			ratesid: '',
			brandingtheme: '',
			btid: '',
			paymenttype: '',
			factoringcost: '',
			estimatedquantity: '',
			actualquantity: '',
			subtotal: '',
			finalprice: '',
			estimatedadvancedate: '',
			estimatedrebatedate: '',
			ppid: '',
			ppstatus: '',
			discount: '',
			reference: '',
			invoicedate: '',
			duedate: '',
			itemcode: '',
			description: '',
			accountcode: '',
			taxtype: '',
			expenses: {
				expense1: {
					eid: '',
					vendor: '',
					date: '',
					amount: '',
					description: ''
				}
			},
			payments: {
				payment1: {
					pid: '',
					amount: '',
					remitdate: ''
				}
			},
			'': ''
		},
		case: {
			party1: 'Ricky Martin',
			party1name: 'Petitioner',
			party2: 'Michael Buble',
			party2name: 'Respondent',
			casenumber1: '13-5-04965-3 SEA',
			casenumber2: '00000-0',
			jurisdiction: 'King County Superior Court',
			notes: 'notes'
		},
		shipping: {
			package1: {
				shipdate: '',
				trackingno: '',
				soid: '',
				mcid: '',
				mailclass: '',
				ptid: '',
				packagetype: '',
				customerid: '',
				amount: '',
				shippingcost: '',
				width: '',
				length: '',
				height: '',
				prioritymailexpress1030: false,
				holidaydelivery: false,
				sundaydelivery: false,
				saturdaydelivery: false,
				signaturerequired: false,
				stealth: false,
				replypostage: false,
				insuredmail: false,
				cod: false,
				restricteddelivery: false,
				adultsigrestricted: false,
				adultsigrequired: false,
				returnreceipt: false,
				certifiedmail: false,
				sigconfirmation: false,
				uspstracking: false,
				reference: 1,
				value: 100,
				description: 'transcripts',
				weightoz: 10,
				output: ''
			},
			package2: {
				shipdate: '',
				trackingno: '',
				soid: '',
				mcid: '',
				mailclass: '',
				ptid: '',
				packagetype: '',
				customerid: '',
				amount: '',
				shippingcost: '',
				width: '',
				length: '',
				height: '',
				prioritymailexpress1030: false,
				holidaydelivery: false,
				sundaydelivery: false,
				saturdaydelivery: false,
				signaturerequired: false,
				stealth: false,
				replypostage: false,
				insuredmail: false,
				cod: false,
				restricteddelivery: false,
				adultsigrestricted: false,
				adultsigrequired: false,
				returnreceipt: false,
				certifiedmail: false,
				sigconfirmation: false,
				uspstracking: false,
				reference: 1,
				value: 100,
				description: 'transcripts',
				weightoz: 10,
				output: ''
			}
		},
		appearances: {
			speakerlist: [],
			ordering: {
				customersid: '',
				factoring: '',
				company: '',
				mrms: '',
				lastname: '',
				firstname: '',
				email: '',
				jobtitle: '',
				businessphone: '',
				address1: '',
				address2: '',
				city: '',
				state: '',
				zip: '',
				notes: ''
			},
			appearance1: {
				customersid: '',
				factoring: '',
				company: '',
				mrms: '',
				lastname: '',
				firstname: '',
				email: '',
				jobtitle: '',
				businessphone: '',
				address1: '',
				address2: '',
				city: '',
				state: '',
				zip: '',
				notes: ''
			},
			appearance2: {
				customersid: '',
				factoring: '',
				company: '',
				mrms: '',
				lastname: '',
				firstname: '',
				email: '',
				jobtitle: '',
				businessphone: '',
				address1: '',
				address2: '',
				city: '',
				state: '',
				zip: '',
				notes: ''
			}
		},
		citations: {
			citation1: {
				findcitation: '',
				replacehyperlink: '',
				longcitation: '',
				chcategory: '',
				webaddress: ''
			},
			citation2: {
				findcitation: '',
				replacehyperlink: '',
				longcitation: '',
				chcategory: '',
				webaddress: ''
			}
		},
		commHistory: {
			comm1: {
				chid: '',
				filepath: '',
				datecreated: '',
				customersid: ''
			},
			comm2: {
				chid: '',
				filepath: '',
				datecreated: '',
				customersid: ''
			}
		},
		agShortcuts: {
			ag1: '',
			ag2: ''
		},
		status: {
			stage1: {},
			stage2: {},
			stage3: {},
			stage4: {}
		},
		tasks: {}
	}
};
