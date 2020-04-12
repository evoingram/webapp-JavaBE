exports.seed = function(knex) {
	// Deletes ALL existing entries
	return knex('citationhyperlinks')
		.del()
		.then(function() {
			// Inserts seed entries
			return knex('citationhyperlinks').insert([
				{
					chid: 1,
					findcitation: '50 U.S.C. 2344',
					longcitation:
						'50 U.S.C. 2344#http://uscode.house.gov/view.xhtml?req=granuleid:USC-prelim-title50-section2344&num=0&edition=prelim#',
					chcategory: '2',
					webaddress:
						'http://uscode.house.gov/view.xhtml?req=granuleid:USC-prelim-title50-section2344&num=0&edition=prelim#'
				},
				{
					chid: 2,
					findcitation: 'Landmark Communication v. Virginia',
					longcitation:
						'Landmark Communications, Inc. v. Virginia, 1978 U.S. LEXIS 84, 56 L. Ed. 2d 1, 98 S. Ct. 1535, 435 U.S. 829',
					chcategory: '2',
					webaddress: 'https://www.courtlistener.com/opinion/109837/landmark-communications-inc-v-virginia/'
				},
				{
					chid: 3,
					findcitation: 'Graham v. Connor',
					longcitation:
						'Graham v. Connor, 1989 U.S. LEXIS 2467, 104 L. Ed. 2d 443, 109 S. Ct. 1865, 490 U.S. 386',
					chcategory: '1',
					webaddress: 'https://www.courtlistener.com/opinion/112257/graham-v-connor/'
				},
				{
					chid: 4,
					findcitation: 'Miranda',
					longcitation:
						'Miranda v. Arizona, 1966 U.S. LEXIS 2817, 16 L. Ed. 2d 694, 86 S. Ct. 1602, 384 U.S. 436',
					chcategory: '1',
					webaddress: 'https://www.courtlistener.com/opinion/107252/miranda-v-arizona/'
				},
				{
					chid: 5,
					findcitation: 'Sullivan v. New York Times',
					longcitation:
						'New York Times Co. v. Sullivan, 1964 U.S. LEXIS 1655, 11 L. Ed. 2d 686, 84 S. Ct. 710, 376 U.S. 254',
					chcategory: '1',
					webaddress: 'https://www.courtlistener.com/opinion/106761/new-york-times-co-v-sullivan/'
				}
			]);
		});
};
