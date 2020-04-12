exports.seed = function(knex) {
	// Deletes ALL existing entries
	return knex('packagetype')
		.del()
		.then(function() {
			// Inserts seed entries
			return knex('packagetype').insert([
				{
					ptid: 1,
					packagetype: 'ENVELOPE',
					description: 'Standard letter rate.'
				},
				{
					ptid: 2,
					packagetype: 'RECTPARCEL',
					description: 'Rectangular Parcel, the standard parcel.'
				},
				{
					ptid: 3,
					packagetype: 'NONRECTPARCEL',
					description: 'Non-rectangular parcel – impacts rate for PM.'
				},
				{
					ptid: 4,
					packagetype: 'FLATRATEENVELOPE',
					description: 'Flat Rate Envelope – PM and EM.'
				},
				{
					ptid: 5,
					packagetype: 'FLATRATEBOX',
					description: 'Flat Rate Box PM.'
				},
				{
					ptid: 6,
					packagetype: 'FLATRATELARGEBOX',
					description: 'Flat Rate Large Box PM.'
				},
				{
					ptid: 7,
					packagetype: 'POSTCARD',
					description: 'Postcard rate (FC and International FC)'
				},
				{
					ptid: 8,
					packagetype: 'FLAT',
					description: 'Flat rate (only effects rate for FC mail).'
				}
			]);
		});
};
