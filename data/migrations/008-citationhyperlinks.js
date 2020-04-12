exports.up = function(knex) {
	return knex.schema.createTable('citationhyperlinks', citationhyperlinks => {
		citationhyperlinks.increments('chid');

		citationhyperlinks.string('findcitation').notNullable();
		citationhyperlinks.string('longcitation').notNullable();
		citationhyperlinks.string('chcategory').notNullable();
		citationhyperlinks.string('webaddress').notNullable();
	});
};

exports.down = function(knex) {
	return knex.schema.dropTableIfExists('citationhyperlinks');
};
