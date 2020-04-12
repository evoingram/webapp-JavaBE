exports.seed = function(knex) {
	// Deletes ALL existing entries
	return knex('mailclass')
		.del()
		.then(function() {
			// Inserts seed entries
			return knex('mailclass').insert([
				{
					mcid: 1,
					mailclass: 'FIRST',
					description: 'First Class Mail'
				},
				{
					mcid: 2,
					mailclass: 'EXPRESS',
					description: 'Express Mail'
				},
				{
					mcid: 3,
					mailclass: 'PRIORITY',
					description: 'Priority Mail'
				},
				{
					mcid: 4,
					mailclass: 'NONE',
					description: 'Do not print postage'
				},
				{
					mcid: 5,
					mailclass: 'PARCELPOST',
					description: 'Parcel Post'
				},
				{
					mcid: 6,
					mailclass: 'INTLFIRST',
					description: 'International First-Class'
				},
				{
					mcid: 7,
					mailclass: 'INTLEXPRESS',
					description: 'International Express Mail'
				},
				{
					mcid: 8,
					mailclass: 'INTLPRIORITY',
					description: 'International Priority Mail'
				},
				{
					mcid: 9,
					mailclass: 'MEDIAMAIL',
					description: 'Media Mail'
				},
				{
					mcid: 10,
					mailclass: 'LIBRARYMAIL',
					description: 'Library Mail'
				},
				{
					mcid: 11,
					mailclass: 'BOUNDPRINTEDMATTER',
					description: 'Bound Printed Matter'
				},
				{
					mcid: 12,
					mailclass: 'PRESORTEDFIRST',
					description: 'Presorted, First-Class'
				},
				{
					mcid: 13,
					mailclass: 'PRESORTEDSTANDARD',
					description: 'Presorted, Standard Class'
				},
				{
					mcid: 14,
					mailclass: 'INTLGXG',
					description: 'Global Express Guaranteed'
				},
				{
					mcid: 15,
					mailclass: 'INTLGXGNODOC',
					description: 'Global Express Guaranteed Non-Docs'
				}
			]);
		});
};
