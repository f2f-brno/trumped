angular.module('trumpedwebapp').controller(
		'ReportController',
		function($scope, $http) {
			$scope.republicans = [ "Donald Trump", "John Kasich", "Ted Cruz",
					"Jeb Bush", "Marco Rubio", "Chris Christie",
					"Carly Fiorina", "Ben Carson", "Jim Gilmore" ];
			$scope.democrats = [ "Bernie Sanders", "Hillary Clinton",
					"Martin O'Malley" ];

		});