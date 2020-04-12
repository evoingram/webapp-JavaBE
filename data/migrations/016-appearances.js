exports.up = function(knex) {
	return knex.schema.createTable('appearances', appearances => {
		appearances.increments('appid');


		appearances
			.integer('customersid')
			.unsigned()
			.notNullable()
			.references('customersid')
			.inTable('customers')
			.onUpdate('CASCADE')
			.onDelete('RESTRICT');

		appearances
			.integer('courtdatesid')
			.unsigned()
			.notNullable()
			.references('courtdatesid')
			.inTable('courtdates')
			.onUpdate('CASCADE')
			.onDelete('RESTRICT');
		
		appearances.integer('cdappid').notNullable();
	});
};

exports.down = function(knex) {
	return knex.schema.dropTableIfExists('appearances');
};
