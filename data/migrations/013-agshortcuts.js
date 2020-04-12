exports.up = function(knex) {
	return knex.schema.createTable('agshortcuts', agshortcuts => {
		agshortcuts.increments('agsid');

		agshortcuts
			.integer('courtdatesid')
			.unsigned()
			.notNullable()
			.references('courtdatesid')
			.inTable('courtdates')
			.onUpdate('CASCADE')
			.onDelete('RESTRICT');

		agshortcuts.string('ag1');
		agshortcuts.string('ag2');
		agshortcuts.string('ag3');
		agshortcuts.string('ag4');
		agshortcuts.string('ag5');
		agshortcuts.string('ag6');
		agshortcuts.string('ag11');
		agshortcuts.string('ag12');
		agshortcuts.string('ag13');
		agshortcuts.string('ag14');
		agshortcuts.string('ag15');
		agshortcuts.string('ag16');
		agshortcuts.string('ag21');
		agshortcuts.string('ag22');
		agshortcuts.string('ag23');
		agshortcuts.string('ag24');
		agshortcuts.string('ag25');
		agshortcuts.string('ag26');
		agshortcuts.string('ag31');
		agshortcuts.string('ag32');
		agshortcuts.string('ag33');
		agshortcuts.string('ag34');
		agshortcuts.string('ag35');
		agshortcuts.string('ag36');
		agshortcuts.string('ag41');
		agshortcuts.string('ag42');
		agshortcuts.string('ag43');
		agshortcuts.string('ag44');
		agshortcuts.string('ag45');
		agshortcuts.string('ag46');
		agshortcuts.string('ag51');
		agshortcuts.string('ag52');
		agshortcuts.string('ag53');
		agshortcuts.string('ag54');
		agshortcuts.string('ag55');
		agshortcuts.string('ag56');
		agshortcuts.string('ag61');
		agshortcuts.string('ag62');
		agshortcuts.string('ag63');
		agshortcuts.string('ag64');
		agshortcuts.string('ag65');
		agshortcuts.string('ag66');
	});
};

exports.down = function(knex) {
	return knex.schema.dropTableIfExists('agshortcuts');
};
