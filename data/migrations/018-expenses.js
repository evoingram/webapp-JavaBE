exports.up = function(knex) {
	return knex.schema.createTable('expenses', expenses => {
		expenses.increments('eid');

		expenses
			.integer('courtdatesid')
			.unsigned()
			.notNullable()
			.references('courtdatesid')
			.inTable('courtdates')
			.onUpdate('CASCADE')
			.onDelete('RESTRICT');

		expenses.string('vendor').notNullable();
		expenses.date('date').notNullable();
		expenses.decimal('amount').notNullable();
		expenses.string('description').notNullable();
	});
};

exports.down = function(knex) {
	return knex.schema.dropTableIfExists('expenses');
};
