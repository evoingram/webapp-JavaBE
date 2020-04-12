exports.up = function(knex) {
	return knex.schema.createTable('shippingoptions', shippingoptions => {
		shippingoptions.increments('soid');

		shippingoptions
			.integer('courtdatesid')
			.unsigned()
			.notNullable()
			.references('courtdatesid')
			.inTable('courtdates')
			.onUpdate('CASCADE')
			.onDelete('RESTRICT');

		shippingoptions
			.integer('mcid')
			.unsigned()
			.notNullable()
			.references('mcid')
			.inTable('mailclass')
			.onUpdate('CASCADE')
			.onDelete('RESTRICT');

		shippingoptions
			.integer('ptid')
			.unsigned()
			.notNullable()
			.references('ptid')
			.inTable('packagetype')
			.onUpdate('CASCADE')
			.onDelete('RESTRICT');

		shippingoptions
			.integer('customersid')
			.unsigned()
			.notNullable()
			.references('customersid')
			.inTable('customers')
			.onUpdate('CASCADE')
			.onDelete('RESTRICT');

		shippingoptions.decimal('amount').notNullable();
		shippingoptions.decimal('shippingcost').notNullable();
		shippingoptions.integer('width').notNullable();
		shippingoptions.integer('length').notNullable();
		shippingoptions.integer('height').notNullable();

		shippingoptions
			.boolean('prioritymailexpress1030')
			.notNullable()
			.defaultTo(false);
		shippingoptions
			.boolean('holidaydelivery')
			.notNullable()
			.defaultTo(false);
		shippingoptions
			.boolean('sundaydelivery')
			.notNullable()
			.defaultTo(false);
		shippingoptions
			.boolean('saturdaydelivery')
			.notNullable()
			.defaultTo(false);
		shippingoptions
			.boolean('signaturerequired')
			.notNullable()
			.defaultTo(false);
		shippingoptions
			.boolean('stealth')
			.notNullable()
			.defaultTo(false);
		shippingoptions
			.boolean('replypostage')
			.notNullable()
			.defaultTo(false);
		shippingoptions
			.boolean('insuredmail')
			.notNullable()
			.defaultTo(false);
		shippingoptions
			.boolean('cod')
			.notNullable()
			.defaultTo(false);
		shippingoptions
			.boolean('restricteddelivery')
			.notNullable()
			.defaultTo(false);
		shippingoptions
			.boolean('adultsigrestricted')
			.notNullable()
			.defaultTo(false);
		shippingoptions
			.boolean('adultsigrequired')
			.notNullable()
			.defaultTo(false);
		shippingoptions
			.boolean('returnreceipt')
			.notNullable()
			.defaultTo(false);
		shippingoptions
			.boolean('certifiedmail')
			.notNullable()
			.defaultTo(false);
		shippingoptions
			.boolean('sigconfirmation')
			.notNullable()
			.defaultTo(false);
		shippingoptions
			.boolean('uspstracking')
			.notNullable()
			.defaultTo(true);

		shippingoptions.string('reference').notNullable();
		shippingoptions
			.string('tocountry')
			.notNullable()
			.defaultTo('USA');
		shippingoptions.decimal('value').notNullable();
		shippingoptions.string('description').notNullable();
		shippingoptions.integer('weightoz').notNullable();
		shippingoptions.string('output').notNullable();
	});
};

exports.down = function(knex) {
	return knex.schema.dropTableIfExists('shippingoptions');
};
