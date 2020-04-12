exports.up = function (knex) {
	return knex.schema.createTable('usertypes', usertypes => {
		usertypes.increments('utid');

		usertypes.string('usertype', 256).notNullable().defaultTo('customer');

		usertypes
			.integer('customersid')
			.unsigned()
			.notNullable()
			.unique()
			.references('customersid')
			.inTable('customers')
			.onUpdate('CASCADE')
			.onDelete('RESTRICT');
	});
};

exports.down = function (knex) {
	return knex.schema.dropTableIfExists('usertypes');
};
