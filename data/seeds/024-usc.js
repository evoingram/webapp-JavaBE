exports.seed = function(knex) {
	// Deletes ALL existing entries
	return knex('usc')
		.del()
		.then(function() {
			// Inserts seed entries
			return knex('usc').insert([
				{
					uscid: 1,
					findcitation: '50 U.S.C. 2601',
					replacehyperlink: '#Nothing#',
					longcitation: '50 U.S.C. 2601',
					chcategory: 1,
					webaddress: 'https://www.courtlistener.com/1'
				},
				{
					uscid: 2,
					findcitation: '50 U.S.C. 2602',
					replacehyperlink: '#Nothing#',
					longcitation: '50 U.S.C. 2602',
					chcategory: 2,
					webaddress: 'https://www.courtlistener.com/2'
				},
				{
					uscid: 3,
					findcitation: '50 U.S.C. 2603',
					replacehyperlink: '#Nothing#',
					longcitation: '50 U.S.C. 2603',
					chcategory: 1,
					webaddress: 'https://www.courtlistener.com/3'
				},
				{
					uscid: 4,
					findcitation: '50 U.S.C. 2604',
					replacehyperlink: '#Nothing#',
					longcitation: '50 U.S.C. 2604',
					chcategory: 2,
					webaddress: 'https://www.courtlistener.com/4'
				},
				{
					uscid: 5,
					findcitation: '50 U.S.C. 2605',
					replacehyperlink: '#Nothing#',
					longcitation: '50 U.S.C. 2605',
					chcategory: 1,
					webaddress: 'https://www.courtlistener.com/5'
				}
			]);
		});
};
