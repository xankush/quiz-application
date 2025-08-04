console.log("this is the login page")
const urlbasepath="http://localhost:8080";


document.getElementById("submitbutton").addEventListener("click",function(e){
	e.preventDefault();
	const participant = {
		participantname:document.getElementById("username").value,
	course:document.getElementById("coursename").value,
		year:document.getElementById("currentyear").value
	};
	
	console.log(participant);
	
	fetch(`${urlbasepath}/quiz`,{
		method:"post",
		headers:{"Content-Type":"application/json"},
		body:JSON.stringify(participant)
		
	}).then(response => {
		if(response.redirected){
			window.location.href = response.url;
			//document.addEventListener("DOMContentLoaded",startquiz())
		}
	})
	.catch(error => console.error('Fetch error:', error));
	
	
	
});
//import {startquiz} from "./quiz.js";