fetch('https://api.covid19api.com/country/poland/status/confirmed/live?from=2020-09-01T00:00:00Z&to=2020-11-01T00:00:00Z%27')
	.then(response => response.json())
	.then(data => {
		let cases = [], day = [];
		var prevDay = data[data.length-1].Cases;
		for(var i = data.length-2; i>=1; i--){
			cases.push(parseInt(prevDay - data[i].Cases));
			day.push(new Date(data[i+1].Date).toLocaleDateString());
			prevDay = data[i].Cases;
		}

		function loadChart() {
			var myChart = new Chart(document.getElementById("chart"), {
				type: 'horizontalBar',
				data: {
					labels: day,
					datasets: [{
						label: 'Cases',
						data: cases,
					}]
				},
			});
		}
		loadChart();
	});