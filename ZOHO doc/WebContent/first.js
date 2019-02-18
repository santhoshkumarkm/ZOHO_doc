function navigate(element) {
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("mySpace").innerHTML = this.responseText;
		}
	};
	xmlhttp
			.open("GET", "../NavigationController?option=" + element.value,
					true);
	xmlhttp.send();
}

function validateFile() {
	var url = new File(document.getElementById("fileurl"));
	if (url.exists()) {
		alert('true');
	} else {
		alert('false');
	}
}

function alertTemp(element){
	alert(element);
}