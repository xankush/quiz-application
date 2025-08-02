const radios = document.getElementsByName("option");
console.log(radios[1].value);
const optionspanid = ["optionone","optiontwo","optionthree","optionfour"]
var selectedoption =null

function getselectedansweer(){
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
	getquestiondata()
	if(selectedoption === correctanswer ){
		console.log("correct")
	}
	console.log(correctanswer)
}

let correctanswer ;

var question = null 

  
  
  console.log(question)
  
let id = 1;
  async function getquestiondata(){
	
	
	fetch(`http://localhost:8080/getquestion/${id}`)
	  .then(response => response.json()) // Convert response to JSON
	  .then(data => {question = data;
		console.log(question);
		questiontext.innerHTML = question.quiztext;
		correctanswer = question.correctanswer;
		for(let i = 0 ; i<radios.length;i++){
			radios[i].value = question.options[i];
			const optid = optionspanid[i];
			document.getElementById(optid).innerHTML =question.options[i];
		}
		
	  })
	     // Log the actual question data
	  .catch(error => console.error('Fetch error:', error));
	  id++;
	  console.log(id);
  }

  getquestiondata();
    

 const questiontext = document.getElementById("quiztext");

