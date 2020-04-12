exports.up = function(knex) {
	return knex.schema.createTable('mailclass', mailclass => {
		mailclass.increments('mcid');

		mailclass.string('mailclass').notNullable();
		mailclass.string('description').notNullable();
	});
};

exports.down = function(knex) {
	return knex.schema.dropTableIfExists('mailclass');
};
