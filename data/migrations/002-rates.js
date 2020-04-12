exports.up = function(knex) {
	return knex.schema.createTable('rates', rates => {
		rates.increments('ratesid');

		rates.string('code', 128).notNullable();
		rates.string('inventoryratecode', 128).notNullable();
		rates.string('productname', 128).notNullable();
		rates.string('description', 128).notNullable();
		rates.decimal('rate').notNullable();
	});
};

exports.down = function(knex) {
	return knex.schema.dropTableIfExists('rates');
};
