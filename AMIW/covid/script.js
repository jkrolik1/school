fetch('https://api.covid19api.com/country/poland/status/confirmed?from=2020-03-01T00:00:00Z&to=2020-04-01T00:00:00Z%27%27')
  .then(response => response.json())
  .then(function (data) {
  appData(data);
});

function appData(data) {
  var mainD = document.getElementById("data");
  for (var i = data.length - 2; i != 0 ; --i) {
    var div = document.createElement("div");
    div.innerHTML = 
    	new Date(data[i+1].Date).toLocaleDateString() + '  ' + parseInt(data[i+1].Cases-data[i].Cases);
    mainD.appendChild(div);
  }
}
