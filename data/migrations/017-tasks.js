exports.up = function(knex) {
	return knex.schema.createTable('tasks', tasks => {
		tasks.increments('tid');

		tasks
			.integer('courtdatesid')
			.unsigned()
			.notNullable()
			.references('courtdatesid')
			.inTable('courtdates')
			.onUpdate('CASCADE')
			.onDelete('RESTRICT');

		tasks.string('title').notNullable();
		tasks.string('priority').notNullable();
		tasks.string('status').notNullable();
		tasks.string('description').notNullable();
		tasks.date('startdate').notNullable();
		tasks.date('duedate').notNullable();
		tasks.integer('prioritypoints').notNullable();
		tasks.string('category').notNullable();
		tasks.integer('timelength').notNullable();

		tasks
			.boolean('completed')
			.notNullable()
			.defaultTo(false);
	});
};

exports.down = function(knex) {
	return knex.schema.dropTableIfExists('tasks');
};
