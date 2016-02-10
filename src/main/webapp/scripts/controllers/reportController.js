angular.module('trumpedwebapp')
		.controller(
				'ReportController',
				function($scope, $http, $location) {
					$scope.republicans = [ "Donald Trump", "John Kasich",
							"Ted Cruz", "Jeb Bush", "Marco Rubio",
							"Chris Christie", "Carly Fiorina", "Ben Carson",
							"Jim Gilmore" ];
					$scope.democrats = [ "Bernie Sanders", "Hillary Clinton",
							"Martin O'Malley" ];

					$scope.mood = function(left, right) {
						var contextPath = $location.absUrl()
								.contains('trumped') ? '/trumped' : '';
						$http.get(
								contextPath + '/rest/mood?democrat=' + left
										+ '&republican=' + right).success(
								function(data) {
									$scope.result = data;
								})
					}

				});