exports.seed = function(knex) {
	// Deletes ALL existing entries
	return knex('appearances')
		.del()
		.then(function() {
			// Inserts seed entries
			return knex('appearances').insert([
				{
					appid: 1,
					customersid: 1,
					courtdatesid: 1,
					cdappid: 1
				},
				{
					appid: 2,
					customersid: 3,
					courtdatesid: 2,
					cdappid: 1
				},
				{
					appid: 3,
					customersid: 2,
					courtdatesid: 3,
					cdappid: 1
				},
				{
					appid: 4,
					customersid: 1,
					courtdatesid: 1,
					cdappid: 2
				},
				{
					appid: 5,
					customersid: 5,
					courtdatesid: 4,
					cdappid: 1
				},
				{
					appid: 6,
					customersid: 4,
					courtdatesid: 1,
					cdappid: 3
				},
				{
					appid: 7,
					customersid: 1,
					courtdatesid: 5,
					cdappid: 1
				},
				{
					appid: 8,
					customersid: 3,
					courtdatesid: 5,
					cdappid: 2
				}
			]);
		});
};
