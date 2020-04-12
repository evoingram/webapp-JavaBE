exports.up = function(knex) {
	return knex.schema.createTable('citations', citations => {
		citations.increments('citationsid');

		citations.integer('uscid');
		citations.integer('citlinksid');
		citations.integer('courtdatesid').notNullable();
	});
};

exports.down = function(knex) {
	return knex.schema.dropTableIfExists('citations');
};
