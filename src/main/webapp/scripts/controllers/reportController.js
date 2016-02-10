angular
		.module('trumpedwebapp')
		.controller(
				'ReportController',
				function($scope, $http, $location) {
					$scope.republicans = [ "Donald Trump", "John Kasich",
							"Ted Cruz", "Jeb Bush", "Marco Rubio",
							"Chris Christie", "Carly Fiorina", "Ben Carson",
							"Jim Gilmore" ];
					$scope.democrats = [ "Bernie Sanders", "Hillary Clinton",
							"Martin O'Malley" ];

					$scope.mood = function(republican, democrat) {
						var contextPath = $location.absUrl()
								.contains('trumped') ? '/trumped' : '';
						$scope.republicansImg = null;
						$scope.democratsImg = null;
						$scope.loading = contextPath + '/img/loading.gif';
						$http
								.get(
										contextPath + '/rest/mood?democrat='
												+ democrat + '&republican='
												+ republican)
								.success(
										function(data) {
											$scope.result = data;
											$scope.loading = null;
											var republicanIdx = '01';
											var democratIdx = '12';
											if (data[republican] < data[democrat]) {
												republicanIdx = '12';
												democratIdx = '01';
											} else if (data[republican] == data[democrat]) {
												republicanIdx = '06';
												democratIdx = '06';
											}
											$scope.republicansImg = contextPath
													+ '/img/face'
													+ republicanIdx + '.jpg';
											$scope.democratsImg = contextPath
													+ '/img/face' + democratIdx
													+ '.jpg';
										})
					}

				});