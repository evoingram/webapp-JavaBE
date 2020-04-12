exports.up = function(knex) {
	return knex.schema.createTable('stylenames', stylenames => {
		stylenames.increments('sid');

		stylenames.string('stylename').notNullable();
	});
};

exports.down = function(knex) {
	return knex.schema.dropTableIfExists('stylenames');
};
