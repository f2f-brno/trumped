angular
		.module('trumpedwebapp')
		.controller(
				'ReportController',
				function($scope, $http, $location) {
					var lowerCaseCandidate = function(name) {
						return name.toLowerCase().replace(' ', '_');
					}
					$scope.republicans = [ "Donald Trump", "Ted Cruz",
							"Jeb Bush" ];
					$scope.democrats = [ "Bernie Sanders", "Hillary Clinton" ];

					$scope.mood = function(republican, democrat) {
						var contextPath = $location.absUrl()
								.contains('trumped/') ? '/trumped' : '';
						$scope.republicansImg = null;
						$scope.democratsImg = null;
						$scope.result = {};
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
											var republicanIdx = 'happy';
											var democratIdx = 'sad';
											if (data[republican] < data[democrat]) {
												// Democrats win
												republicanIdx = 'sad';
												democratIdx = 'happy';
											} else if (data[republican] == data[democrat]) {
												// Both win
												republicanIdx = 'happy';
												democratIdx = 'happy';
											}
											$scope.republicansImg = contextPath
													+ '/img/'
													+ lowerCaseCandidate(republican)
													+ '_' + republicanIdx
													+ '.jpeg';
											$scope.democratsImg = contextPath
													+ '/img/'
													+ lowerCaseCandidate(democrat)
													+ '_' + democratIdx
													+ '.jpeg';
										})
					}

				});