exports.up = function (knex) {
	return knex.schema.createTable('statuses', statuses => {
		statuses.increments('sid');

		statuses
			.integer('courtdatesid')
			.unsigned()
			.notNullable()
			.references('courtdatesid')
			.inTable('courtdates')
			.onUpdate('CASCADE')
			.onDelete('RESTRICT');

		statuses.boolean('appsentered').notNullable().defaultTo(false);
		statuses.boolean('jobentered').notNullable().defaultTo(false);
		statuses.boolean('coverpage').notNullable().defaultTo(false);
		statuses.boolean('autocorrect').notNullable().defaultTo(false);
		statuses.boolean('schedule').notNullable().defaultTo(false);
		statuses.boolean('prepinvoice').notNullable().defaultTo(false);
		statuses.boolean('agshortcuts').notNullable().defaultTo(false);

		statuses.boolean('tassigned').notNullable().defaultTo(false);
		statuses.boolean('tfiletransmission').notNullable().defaultTo(false);
		statuses.boolean('ttranscriptsubmitted').notNullable().defaultTo(false);
		statuses.boolean('tinvoicereceived').notNullable().defaultTo(false);
		statuses.boolean('tinvoicepaid').notNullable().defaultTo(false);
		statuses.boolean('passigned').notNullable().defaultTo(false);
		statuses.boolean('pfiletransmission').notNullable().defaultTo(false);
		statuses.boolean('ptranscriptsubmitted').notNullable().defaultTo(false);
		statuses.boolean('pinvoicereceived').notNullable().defaultTo(false);
		statuses.boolean('pinvoicepaid').notNullable().defaultTo(false);

		statuses.boolean('transcribe').notNullable().defaultTo(false);
		statuses.boolean('addrdtocover').notNullable().defaultTo(false);
		statuses.boolean('findreplacerd').notNullable().defaultTo(false);
		statuses.boolean('hyperlink').notNullable().defaultTo(false);
		statuses.boolean('spellingsemail').notNullable().defaultTo(false);
		statuses.boolean('audioproof').notNullable().defaultTo(false);
		statuses.boolean('invoicecompleted').notNullable().defaultTo(false);
		statuses.boolean('noticeofservice').notNullable().defaultTo(false);
		statuses.boolean('peletter').notNullable().defaultTo(false);
		statuses.boolean('cdlabel').notNullable().defaultTo(false);
		statuses.boolean('generatezips').notNullable().defaultTo(false);
		statuses.boolean('transcriptsready').notNullable().defaultTo(false);
		statuses.boolean('invoicetofactoremail').notNullable().defaultTo(false);
		statuses.boolean('filetranscript').notNullable().defaultTo(false);
		statuses.boolean('burncd').notNullable().defaultTo(false);
		statuses.boolean('shippingxmls').notNullable().defaultTo(false);
		statuses.boolean('shippingemail').notNullable().defaultTo(false);
		statuses.boolean('addtrackingno').notNullable().defaultTo(false);
	});
};

exports.down = function (knex) {
	return knex.schema.dropTableIfExists('statuses');
};
