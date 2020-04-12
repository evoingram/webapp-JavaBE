exports.seed = function(knex) {
	// Deletes ALL existing entries
	return knex('courtdatescasescustomers')
		.del()
		.then(function() {
			// Inserts seed entries
			return knex('courtdatescasescustomers').insert([
				{ cdccid: 1, casesid: 1, courtdatesid: 1, orderingid: 1 },
				{ cdccid: 2, casesid: 2, courtdatesid: 2, orderingid: 2 },
				{ cdccid: 3, casesid: 3, courtdatesid: 3, orderingid: 3 },
				{ cdccid: 4, casesid: 4, courtdatesid: 4, orderingid: 4 },
				{ cdccid: 5, casesid: 5, courtdatesid: 5, orderingid: 5 }
			]);
		});
};
