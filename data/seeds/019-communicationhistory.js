exports.seed = function(knex) {
	return knex('communicationhistory')
		.del()
		.then(function() {
			return knex('communicationhistory').insert([
				{
					chid: 1,
					courtdatesid: 1,
					customersid: 1,
					filepath: '/sample/path/1',
					datecreated: '2020-05-15 00:00:00'
				},
				{
					chid: 2,
					courtdatesid: 2,
					customersid: 2,
					filepath: '/sample/path/2',
					datecreated: '2020-06-15 00:00:00'
				},
				{
					chid: 3,
					courtdatesid: 3,
					customersid: 3,
					filepath: '/sample/path/3',
					datecreated: '2020-07-15 00:00:00'
				},
				{
					chid: 4,
					courtdatesid: 4,
					customersid: 4,
					filepath: '/sample/path/4',
					datecreated: '2020-08-15 00:00:00'
				},
				{
					chid: 5,
					courtdatesid: 5,
					customersid: 5,
					filepath: '/sample/path/5',
					datecreated: '2020-09-15 00:00:00'
				}
			]);
		});
};
