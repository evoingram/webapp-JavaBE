exports.seed = function(knex) {
	// Deletes ALL existing entries
	return knex('turnaroundtimes')
		.del()
		.then(function() {
			// Inserts seed entries
			return knex('turnaroundtimes').insert([
				{ ttid: 1, turnaroundtime: 45 },
				{ ttid: 2, turnaroundtime: 30 },
				{ ttid: 3, turnaroundtime: 14 },
				{ ttid: 4, turnaroundtime: 10 },
				{ ttid: 5, turnaroundtime: 7 },
				{ ttid: 6, turnaroundtime: 3 },
				{ ttid: 7, turnaroundtime: 1 }
			]);
		});
};
