
	
console.log("quiz page loaded")

const optionspanid = ["optionone","optiontwo","optionthree","optionfour"]

var selectedoption =null;
var question = null ;
let correctanswer ;
const questiontext = document.getElementById("quiztext");
//const urlbasepath=" https://7315974104d5.ngrok-free.app";
const urlbasepath="http://localhost:8080";
const quizid = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20];
let id =0;

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
	  .then(  response => {
	 if (response.status === 200) {
			getquestiondata();
	    } else if (response.status === 404) {
			shuffleArray(quizid);
			getquestiondata();
	    } else {
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

setTimeout(startquiz(),1000);

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
	  id++;
	  console.log(id);
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
	
	
	getquestiondata()
	uncheckradios()
	if(selectedoption === correctanswer ){
		console.log("correct")
	}
	console.log(correctanswer)
}



function uncheckradios(){const radios = document.getElementsByName("option");
	radios.forEach(radio=>{
		radio.checked = false;
	})
}


