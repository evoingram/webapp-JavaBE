exports.up = function(knex) {
	return knex.schema.createTable('usc', usc => {
		usc.increments('uscid');

		usc.string('findcitation').notNullable();
		usc.string('replacehyperlink').notNullable();
		usc.string('longcitation').notNullable();
		usc.string('chcategory').notNullable();
		usc.string('webaddress').notNullable();
	});
};

exports.down = function(knex) {
	return knex.schema.dropTableIfExists('usc');
};
