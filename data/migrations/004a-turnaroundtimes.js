exports.up = function(knex) {
	return knex.schema.createTable('turnaroundtimes', turnaroundtimes => {
		turnaroundtimes.increments('ttid');

		turnaroundtimes
			.integer('turnaroundtime')
			.notNullable()
			.unique();
	});
};

exports.down = function(knex) {
	return knex.schema.dropTableIfExists('turnaroundtimes');
};
