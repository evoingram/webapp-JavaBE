exports.up = function(knex) {
	return knex.schema.createTable('examtypes', examtypes => {
		examtypes.increments('eid');

		examtypes.string('examination').notNullable();
		examtypes.string('ecode').notNullable();
	});
};

exports.down = function(knex) {
	return knex.schema.dropTableIfExists('examtypes');
};
