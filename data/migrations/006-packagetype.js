exports.up = function(knex) {
	return knex.schema.createTable('packagetype', packagetype => {
		packagetype.increments('ptid');

		packagetype.string('packagetype', 128).notNullable();
		packagetype.string('description', 128).notNullable();
	});
};

exports.down = function(knex) {
	return knex.schema.dropTableIfExists('packagetype');
};
