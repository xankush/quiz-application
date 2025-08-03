const radios = document.getElementsByName("option");
console.log(radios[1].value);
const optionspanid = ["optionone","optiontwo","optionthree","optionfour"]
var selectedoption =null
var question = null ;
let correctanswer ;
const questiontext = document.getElementById("quiztext");
const urlbasepath=" https://7315974104d5.ngrok-free.app";
//const urlbasepath="http://localhost:8080";
let id = 1;

async function getquestiondata(){
	
	
	fetch(`${urlbasepath}/getquestion/${id}`)
	  .then(response => response.json()) // Convert response to JSON
	  .then(data => {question = data;
		
		questiontext.innerHTML = question.quizText;
	
		correctanswer = question.correctAnswer;
		for(let i = 0 ; i<radios.length;i++){
			radios[i].value = question.options[i].optionText;
			const optid = optionspanid[i];
			document.getElementById(optid).innerHTML =question.options[i].optionText;
		}
		
	  })
	     // Log the actual question data
	  .catch(error => console.error('Fetch error:', error));
	  id++;
	  console.log(id);
  }

getquestiondata();

console.log(question)
  
async function getselectedansweer(){
	for(let i = 0 ; i<radios.length;i++){
		if(radios[i].checked){
			selectedoption=radios[i].value;	
			break;	
		}
	}
	if(selectedoption){
		console.log(selectedoption)
	}
	else{
		console.log("no option is selected");
	}
	await fetch(`${urlbasepath}/saveanswer`, {
		method:"post",
		headers:{"Content-Type":"application/json"},
		body:JSON.stringify({answer:selectedoption,quizid:question.quizId})
		
	}).then(res=>res.json())
	.then(data=>console.log("saved:",data));
	
	
	getquestiondata()
	if(selectedoption === correctanswer ){
		console.log("correct")
	}
	console.log(correctanswer)
}




  
  
  

