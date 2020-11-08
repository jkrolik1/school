fetch('https://api.covid19api.com/country/poland/status/confirmed/live?from=2020-09-01T00:00:00Z&to=2020-11-01T00:00:00Z%27')
	.then(response => response.json())
	.then(data => {
		let cases = [], day = [], colors = [];
		var prevDay = data[data.length-1].Cases;
		var c = 0, total = 0;
		for(var i = data.length-2; i>=1; i--){
			c = (parseInt(prevDay - data[i].Cases));
			cases.push(c);
			total += c;
			day.push(new Date(data[i+1].Date).toLocaleDateString());
			prevDay = data[i].Cases;
		}

		var avg = (total/cases.length);

		for(i in cases){
			if(cases[i] >= avg)
				colors.push("#F08080");
			else 
				colors.push("#2E8B57");
		}

		function loadChart() {
			Chart.defaults.global.defaultFontColor = '#EAEAEA';
			Chart.defaults.global.defaultFontSize = 17;
			Chart.defaults.global.borderColor = 'blue';
			var ch = new Chart(document.getElementById("chart"), {
				type: 'horizontalBar',
				data: {
					labels: day,
					datasets: [{
						label: 'Liczba przypadków',
						data: cases,
						backgroundColor: colors
					}]
				},
				options: {
					legend: { display: false },
					title: {
						display: true,
						text: 'Przypadki koronawirusa w Polsce',
						fontSize: 30,
						padding: 25
					}
				}
			});
		}
		loadChart();
	});