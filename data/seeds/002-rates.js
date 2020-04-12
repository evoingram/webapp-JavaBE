exports.seed = function(knex) {
	// Deletes ALL existing entries
	return knex('rates')
		.del()
		.then(function() {
			// Inserts seed entries
			return knex('rates').insert([
				{
					ratesid: 1,
					code: 'CNB45',
					inventoryratecode: 'CNB45',
					productname: '45 calendar-day turnaround',
					description: '45 calendar-day turnaround',
					rate: 2.5
				},
				{
					ratesid: 2,
					code: 'CNB30',
					inventoryratecode: 'CNB30',
					productname: '30 calendar-day turnaround',
					description: '30 calendar-day turnaround',
					rate: 2.65
				},
				{
					ratesid: 3,
					code: 'CNB14',
					inventoryratecode: 'CNB14',
					productname: '14 calendar-day turnaround',
					description: '14 calendar-day turnaround',
					rate: 3.25
				},
				{
					ratesid: 4,
					code: 'CNB07',
					inventoryratecode: 'CNB07',
					productname: '7 calendar-day turnaround',
					description: '7 calendar-day turnaround',
					rate: 3.75
				},
				{
					ratesid: 5,
					code: 'CNB03',
					inventoryratecode: 'CNB03',
					productname: '3 calendar-day turnaround',
					description: '3 calendar-day turnaround',
					rate: 4.25
				},
				{
					ratesid: 6,
					code: 'CNB01',
					inventoryratecode: 'CNB01',
					productname: '1 calendar-day turnaround',
					description: '1 calendar-day turnaround',
					rate: 5.25
				},
				{
					ratesid: 7,
					code: 'MC',
					inventoryratecode: 'MC',
					productname: 'minimum charge',
					description: 'minimum charge',
					rate: 50
				},
				{
					ratesid: 8,
					code: 'KCI',
					inventoryratecode: 'KCI',
					productname: 'king county rate',
					description: 'king county rate',
					rate: 3.65
				},
				{
					ratesid: 9,
					code: 'NC',
					inventoryratecode: 'NC',
					productname: 'noncourt regular',
					description: 'noncourt regular',
					rate: 2
				},
				{
					ratesid: 10,
					code: 'NC',
					inventoryratecode: 'NC',
					productname: 'noncourt overnight',
					description: 'noncourt overnight',
					rate: 5.25
				},
				{
					ratesid: 11,
					code: 'AMOR',
					inventoryratecode: 'AMOR',
					productname: 'janet evans rate',
					description: 'janet evans rate',
					rate: 2.2
				},
				{
					ratesid: 12,
					code: 'COPY',
					inventoryratecode: 'COPY',
					productname: 'copy rate',
					description: 'copy rate',
					rate: 0.4
				},
				{
					ratesid: 13,
					code: 'JJ',
					inventoryratecode: 'JJ',
					productname: 'generic subcontractor rate',
					description: 'generic subcontractor rate',
					rate: 1.75
				}
			]);
		});
};
