window.onload = function(){

	shirt.style.display = "none";
	hair.style.display = "none";
	trousers.style.display = "none";
	glasses.style.display = "none";

	var hairS = document.getElementById("hairS");

	var glassesS = document.getElementById("glassesS");

	var shirtS = document.getElementById("shirtS");

	var trousersS = document.getElementById("trousersS");

	hairS.onclick = function(){
		var hair = document.getElementById("hair");
		var span = hairS.getElementsByTagName("span")[0];
		if(hair.style.display !== "block"){
			hair.style.display = "block";
			span.innerHTML = "Take off hair";
			span.style.fontWeight = "bold";
		}else{
			hair.style.display = "none";
			span.innerHTML = "Put on hair";
			span.style.fontWeight = "lighter";
		}
	}

	glassesS.onclick = function(){
		var glasses = document.getElementById("glasses");
		var span1 = glassesS.getElementsByTagName("span")[0];
		if(glasses.style.display !== "block"){
			glasses.style.display = "block";
			span1.innerHTML = "Take off glasses";
			span1.style.fontWeight = "bold";
		}else{
			glasses.style.display = "none";
			span1.innerHTML = "Put on glasses";
			span1.style.fontWeight = "lighter";
		}
	}

	shirtS.onclick = function(){
		var shirt = document.getElementById("shirt");
		var span2 = shirtS.getElementsByTagName("span")[0];
		if(shirt.style.display !== "block"){
			shirt.style.display = "block";
			span2.innerHTML = "Take off shirt";
			span2.style.fontWeight = "bold";
		}else{
			shirt.style.display = "none";
			span2.innerHTML = "Put on shirt";
			span2.style.fontWeight = "lighter";
		}
	}

	trousersS.onclick = function(){
		var trousers = document.getElementById("trousers");
		var span3 = trousersS.getElementsByTagName("span")[0];
		if(trousers.style.display !== "block"){
			trousers.style.display = "block";
			span3.innerHTML = "Take off trousers";
			span3.style.fontWeight = "bold";
		}else{
			trousers.style.display = "none";
			span3.innerHTML = "Put on trousers";
			span3.style.fontWeight = "lighter";
		}
	}
	
}
