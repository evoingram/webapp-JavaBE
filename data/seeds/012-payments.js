exports.seed = function(knex) {
	// Deletes ALL existing entries
	return knex('payments')
		.del()
		.then(function() {
			// Inserts seed entries
			return knex('payments').insert([
				{
					pid: 1,
					iid: 1,
					remitdate: '2020-07-01 00:00:00',
					amount: 50.0
				},
				{
					pid: 2,
					iid: 2,
					remitdate: '2020-08-01 00:00:00',
					amount: 75.6
				},
				{
					pid: 3,
					iid: 3,
					remitdate: '2020-09-01 00:00:00',
					amount: 125.35
				},
				{
					pid: 4,
					iid: 4,
					remitdate: '2020-10-01 00:00:00',
					amount: 545.9
				},
				{
					pid: 5,
					iid: 5,
					remitdate: '2020-11-01 00:00:00',
					amount: 2498.6
				}
			]);
		});
};
