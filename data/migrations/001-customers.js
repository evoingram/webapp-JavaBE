exports.up = function (knex) {
	return knex.schema.createTable('customers', customers => {
		customers.increments('customersid');

		customers.string('username', 256).notNullable().unique();

		customers.string('email', 256).notNullable().unique();

		customers.string('password').notNullable();
		customers.string('usertype').defaultTo('customer');
		customers.string('company').notNullable();
		customers.string('mrms').notNullable();
		customers.string('lastname').notNullable();
		customers.string('firstname').notNullable();
		customers.string('jobtitle');
		customers.string('businessphone');
		customers.string('address1');
		customers.string('address2');
		customers.string('city');
		customers.string('state');
		customers.string('zip');
		customers.string('notes');
		customers.boolean('factoring').notNullable().defaultTo(false);
	});
};

exports.down = function (knex) {
	return knex.schema.dropTableIfExists('customers');
};
