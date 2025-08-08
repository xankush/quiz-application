
	
console.log("quiz page loaded")

const optionspanid = ["optionone","optiontwo","optionthree","optionfour"]
let timer;
let timeLeft = 60;
var selectedoption =null;
var question = null ;
let correctanswer ;
const questiontext = document.getElementById("quiztext");
//const urlbasepath=" https://7315974104d5.ngrok-free.app";
const urlbasepath="http://localhost:8080";
let quizid = [];
fetch(`${urlbasepath}/getquizarray`).then(response=>response.json()).then(data=>{quizid = data;console.log(quizid)});
let id =0;
fetch(`${urlbasepath}/getquizid`).then(response=>response.text()).then(data=>{id = data;console.log(id)});

function shuffleArray(arr) {
  for (let i = arr.length - 1; i > 0; i--) {
    // Pick a random index from 0 to i
    const j = Math.floor(Math.random() * (i + 1));

    // Swap arr[i] with arr[j]
    [arr[i], arr[j]] = [arr[j], arr[i]];
  }
  console.log(arr);
  return arr;
}

const startquiz = ()=>{
	fetch(`${urlbasepath}/checksessionstatus`)
	.then(resp => resp.text())  
	.then(response => {
	 if (response === "Session active") {
		getquestiondata();
	    } else if (response === "session is found but it is created first time") {
			quizid  = shuffleArray(quizid);
			fetch(`${urlbasepath}/submitquizarray`,{
				method:"post",
				headers:{"Content-Type":"application/json"},
				body:JSON.stringify(quizid)
			}).then(resp=>resp.text())
			.then(response=>console.log(response))
			
			.catch(err=>console.log(err));
			getquestiondata();
			
	    }
		else if(response ==="Session not found"){
			window.location.href=`${urlbasepath}`;	
		}
		 else {
	      console.log(`Unexpected status: ${response.status}`);
	   }
		console.log(response);
		console.log(quizid);
	  }
  )
	  .catch(error => {
	    console.error('Fetch error:', error);
	  });
}

startquiz()

async function getquestiondata(){
	if(id<15){
	const radios = document.getElementsByName("option");
	fetch(`${urlbasepath}/getquestion/${quizid[id]}`)
	  .then(response => response.json()) 
	  .then(data => {question = data;
		questiontext.innerHTML = question.quizText;
		correctanswer = question.correctAnswer;
		for(let i = 0 ; i<radios.length;i++){
			radios[i].value = question.options[i].optionText;
			const optid = optionspanid[i];
			document.getElementById(optid).innerHTML =question.options[i].optionText;
		}
	  })
	  .catch(error => console.error('Fetch error:', error));
	 
	  console.log(id);
	  if(id==14){
		document.getElementById("quizpagebutton").innerHTML="Submit quiz";
		
	  }
	startTimer()
  }
	
  }

console.log(question)
  
async function getselectedansweer(){
	const radios = document.getElementsByName("option");
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
	
	nextquestion();
	
	if(selectedoption === correctanswer ){
		console.log("correct")
	}
	console.log(correctanswer)
	if(id ==15){alert("the quiz is submited")};
}



function uncheckradios(){const radios = document.getElementsByName("option");
	radios.forEach(radio=>{
		radio.checked = false;
	})
}
function startTimer() {
  clearInterval(timer);  // Clear any existing timer
  timeLeft = 60;
  document.getElementById("time").textContent = timeLeft;

  timer = setInterval(() => {
    timeLeft--;
    document.getElementById("time").textContent = timeLeft;

    if (timeLeft <= 0) {
      clearInterval(timer);
	  getselectedansweer();
      nextquestion();
    }
  }, 1000);
}

function nextquestion(){
	id++;
		 if(id<15){
		 	
		   fetch(`${urlbasepath}/submitquizid`,{
		 	method:"post",
		 	headers:{
		 		"Content-Type":"application/json"
		 	},
		 	body:JSON.stringify({"id":id})
		      }).then(resp=>resp.text()).then(res=>console.log(res));
		   }
		   getquestiondata();
		   uncheckradios();
}