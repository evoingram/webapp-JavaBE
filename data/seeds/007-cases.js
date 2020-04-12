exports.seed = function(knex) {
	// Deletes ALL existing entries
	return knex('cases')
		.del()
		.then(function() {
			// Inserts seed entries
			return knex('cases').insert([
				{
					casesid: 1,
					party1: 'John Doe',
					party1name: 'Plaintiff',
					party2: 'Jane Doe',
					party2name: 'Defendant',
					casenumber1: '13-1-15898',
					casenumber2: '88888-13-I',
					jurisdiction: 'King County Superior Court',
					notes: ''
				},
				{
					casesid: 2,
					party1: 'Mickey Mouse',
					party1name: 'Petitioner',
					party2: 'Donald Duck',
					party2name: 'Respondent',
					casenumber1: '6-66-666665',
					casenumber2: '777-77-7777',
					jurisdiction: 'USBC District of Hawaii',
					notes: ''
				},
				{
					casesid: 3,
					party1: 'Ricky Martin',
					party1name: 'Plaintiff',
					party2: 'Michael Buble',
					party2name: 'Defendant',
					casenumber1: '545-1-544326',
					casenumber2: '12-1-15788',
					jurisdiction: 'King County Superior Court',
					notes: ''
				},
				{
					casesid: 4,
					party1: 'Cordanas Felsong',
					party1name: 'Petitioner',
					party2: 'Maiev Shadowsong',
					party2name: 'Respondent',
					casenumber1: '12-3-44444-5',
					casenumber2: '76890-6-I',
					jurisdiction: 'Snohomish County Superior Court',
					notes: ''
				},
				{
					casesid: 5,
					party1: 'Thrall',
					party1name: 'Employee',
					party2: 'City of Orgrimmar',
					party2name: 'Employer',
					casenumber1: '23-2-58642-1',
					casenumber2: '65039-89-I',
					jurisdiction: 'Franklin County Superior Court',
					notes: ''
				},
				{
					casesid: 6,
					party1: 'Illidan Stormrage',
					party1name: 'Plaintiff',
					party2: 'Malfurian Stormrage',
					party2name: 'Defendant',
					casenumber1: '123456',
					casenumber2: '987564123',
					jurisdiction: 'Yakima County Superior Court',
					notes: ''
				}
			]);
		});
};
