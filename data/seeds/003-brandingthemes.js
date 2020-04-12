exports.seed = function(knex) {
	// Deletes ALL existing entries
	return knex('brandingthemes')
		.del()
		.then(function() {
			// Inserts seed entries
			return knex('brandingthemes').insert([
				{ btid: 1, brandingtheme: 'WRTS NC Factoring' },
				{ btid: 2, brandingtheme: 'WRTS NC 100 Deposit' },
				{ btid: 3, brandingtheme: 'WRTS C 50 Deposit Filed NONBK' },
				{ btid: 4, brandingtheme: 'WRTS C 50 Deposit Filed BK' },
				{ btid: 5, brandingtheme: 'WRTS C 50 Deposit Not Filed' },
				{ btid: 6, brandingtheme: 'WRTS C Factoring Filed' },
				{ btid: 7, brandingtheme: 'WRTS C Factoring Not Filed' },
				{ btid: 8, brandingtheme: 'WRTS C 100 Deposit Filed' },
				{ btid: 9, brandingtheme: 'WRTS C 100 Deposit Not Filed' },
				{ btid: 10, brandingtheme: 'WRTS JJ Factoring' },
				{ btid: 11, brandingtheme: 'WRTS Tabula Not Factored/Filed' },
				{ btid: 12, brandingtheme: 'WRTS AMOR Factoring' }
			]);
		});
};
