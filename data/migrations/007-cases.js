exports.up = function(knex) {
	return knex.schema.createTable('cases', cases => {
		cases.increments('casesid');

		cases.string('party1').notNullable();
		cases.string('party1name');
		cases.string('party2');
		cases.string('party2name');
		cases.string('casenumber1').notNullable();
		cases.string('casenumber2');
		cases.string('jurisdiction').notNullable();
		cases.string('notes');
	});
};

exports.down = function(knex) {
	return knex.schema.dropTableIfExists('cases');
};
