function validate() {
	var name = document.getElementById("name").value;
	if (name == '') {
		alert('Please enter a valid name.');
		return false;
	} else {
		return true;
	}
}

function loadDoc() {
	alert(1);
	var xhr = new XMLHttpRequest();
	var url = "login";
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onreadystatechange = function () {
	    if (xhr.readyState === 4 && xhr.status === 200) {
	    	alert(xhr.responseText);
	        var json = JSON.parse(xhr.responseText);
	        console.log(json.email + ", " + json.password);
	    }
	};
	var data = JSON.stringify({"username": "hey@mail.com", "password": "101010"});
	xhr.send(data);
}