
// Creating questionss and answers
//*****************************************************************************
var question1 = {
                  question: "아침에 일어난 당신은 방문을 열고 나오니 부모님과 마주치게 되었습니다. 다음 중 적절한 발언은 무엇인가요?",
                  answers: ["좋은 아침이에요!", "무시한다", "다시 자러 갈게요", "밥주세요"],
                  correct: 0
                };

var question2 = {
                  question: "등굣길에서 친구를 만났습니다. 반가운 마음에 친구를 불러서 같이 가고 싶은 당신이 해야 할 말은 무엇인가요?",
                  answers: ['어디 가냐, 같이 가야지', '좋은 아침이야 친구야, 친한척하자', '친구야 반갑다. 같이 가자!', '나버리고 혼자 가지마'],
                  correct: 2
                };

var question3 = {
                  question: '지인과 의견이 달라 다툼이 생길 것 같습니다. 다음 중 하면 안 되는 말은 무엇일까요?',
                  answers: ['제 생각은 이런 이유로 조금 다른데 어떤 거 같나요?', '그 의견도 좋은 생각인 거 같은데 같이 생각해 볼까요?', '조금만 더 생각해 보고 의견을 공유해 볼까요?', '제 말이 맞는 거 같은 데 왜 그렇게 말씀하시죠?'],
                  correct: 3
                }

var question4 = {
                  question: "길을 걷다가 친구들끼리 싸우는 것을 보았습니다. 다음 중 당신이 하면 안 되는 말은 무엇인가요?",
                  answers: ["(싸움을 말리며) 싸움은 나쁜 거야!", "(싸움을 말리며) 친구끼리 사이좋게 지내야지 둘 다 멈춰!", "(싸움을 지켜보며) 재밌네, 계속 싸워라!", '(싸움을 말리며) 둘이 싸우는 것을 보니 슬프구나.'],
                  correct: 2
                };

var question5 = {
                  question: "어딘가로 향하던 중 옆집에 사는 할아버지를 만났습니다. 할아버지는 당신에게 우체국의 위치를 물어보는데 다음 중 해야 하는 말은 무엇인가요?(당신은 우체국의 위치를 알고 있습니다.)",
                  answers: ["앞에 보이는 마트에서 왼쪽으로 돌아서 가면 있어요!", "저는 모르겠는데요?", "말없이 무시하고 지나간다.", "왜 그걸 알려드려야 하는 거죠?"],
                  correct: 0
                };

var question6 = {
                  question: "당신은 여자(남자) 친구와 데이트 약속을 잡았습니다. 그런데 당신은 그만 약속에 늦었는데요. 다음 중 하면 안 되는 말은 무엇일까요?",
                  answers: ["늦어서 미안해.", "많이 기다렸지, 앞으로는 늦지 않을게.", "사람이 살다 보면 늦을 수도 있지, 너무 뭐라 하지 마.","좀 더 일찍 나와야 했는데, 앞으로 안 늦도록 노력할게."],
                  correct: 3
                };

var question7 = {
                  question: "어머니께서 당신에게 심부름을 부탁했습니다. 다음 중 상황에 맞는 말은 무엇일까요?",
                  answers: ["심부름 값은 얼마 주실 건데요?", "(장바구니를 집어 들며) 조심히 다녀오겠습니다!", "제가 왜요?", "저 말고 동생 시키면 안 되나요?"],
                  correct: 1
                };
                
var question8 = {
                  question: "길을 가던 중 모르는 사람과 부딪히게 되었습니다. 상대방이 먼저 사과를 하고 있을 때 하면 안 되는 말은 무엇일까요?",
                  answers: ["저도 조심해야 했는데 죄송합니다.", "다치신 곳은 없으신가요?", "저는 괜찮습니다. 조심히 들어가세요!", "눈을 어디에 뜨고 다니시는 겁니까?"],
                  correct: 3
                };
                
var question9 = {
                  question: "형제(자매, 남매) 간에 다툼이 일어났습니다. 다음 중 해야 하는 말은 무엇일까요?",
                  answers: ["더 맞고 싶냐?", "엄마, (형)이 또 저 때려요!", "미안해! 다시는 안 그럴게!", "주먹맛 좀 볼래?"],
                  correct: 2
                };
                
var question10 = {
                  question: "자러 갈 시간입니다. 자기 전에 가족들에게 해야 할 말은 무엇일까요?",
                  answers: ["잘 거니까 깨우지 마라.", "안녕히 주무세요!", "잘 시간인데 티브이 좀 끄면 안 돼?", "굳잠!"],
                  correct: 3
                };                            

// create an array of objects

var questions = [question1, question2, question3, question4, question5, question6, question7, question8, question9, question10];

// Initialize variables
//------------------------------------------------------------------

var tags;
var tagsClass = '';
var liTagsid = [];
var correctAns = 0;
var quizPage = 1;


var currentIndex = 0;
var currentQuestion = questions[currentIndex];

var prevousQuestion;
var previousIndex = 0;

var ulTag = document.getElementsByTagName('ul')[0];
var button = document.getElementById('submit');
var questionTitle = document.getElementById('question');

//save class name so it can be reused easily
//if I want to change it, I have to change it one place
var classHighlight = 'selected';


// Display Answers and hightlight selected item
//------------------------------------------------------------------
function showQuestions (){

  if (currentIndex != 0) {
    // create again submit button only for next pages
    ulTag.innerHTML ='';
    button.innerHTML = '제출';
    button.className = 'submit';
    button.id = 'submit';

    //update the number of questions displayed
    document.getElementById('quizNumber').innerHTML = quizPage;
  }

  //Display Results in the final page
  if (currentIndex ==  (questions.length)) {
    ulTag.innerHTML = '';
    document.getElementById('question').innerHTML = '';

    showResults();

    return
  }

  questionTitle.innerHTML = currentQuestion.question;
  console.log(currentQuestion.question);

  // create a for loop to generate the answers and display them in the page
  for (var i = 0; i < currentQuestion.answers.length; i++) {
    // creating answers
    var newAns = document.createElement('li');
    newAns.id = 'ans'+ (i+1);
    newAns.className = "notSelected";
    var textAns = document.createTextNode(currentQuestion.answers[i]);
    newAns.appendChild(textAns);
    var addNewAnsHere = document.getElementById('answer');
    addNewAnsHere.appendChild(newAns);

    console.log(currentQuestion.answers[i]);
  }


  //.click() will return the result of $('.notSelected')
    var $liTags = $('.notSelected').click(function(list) {
        list.preventDefault();
        //run removeClass on every element
        //if the elements are not static, you might want to rerun $('.notSelected')
        //instead of the saved $litTags
        $liTags.removeClass(classHighlight);
        //add the class to the currently clicked element (this)
        $(this).addClass(classHighlight);

        //get id name of clicked answer
        for (var i = 0; i < currentQuestion.answers.length ; i++) {
          // console.log(liTagsid[i]);
          if($liTags[i].className == "notSelected selected"){
            //store information to check answer
            tags = $liTags[i].id;
            // tagsClass = $LiTags.className;
            console.log(tags);
            tagsClassName = $liTags[i];
          }
        }
    });

    //check answer once it has been submitted
    button.onclick = function (){ checkAnswer()};
}

//self calling function
showQuestions();


// Show Correct Answer
//------------------------------------------------------------------
function checkAnswer (){
  // get selected list
  var selectedItem = document.getElementById(tags);

  // check that an answer has been selected
  if (selectedItem == undefined) {
    alert("Please selected an answer!")
    return
  } else {
    // get user answer if form of text
    var userAns = selectedItem.innerHTML;
  }

  // change the background of the answer according to the Results
  if (userAns == currentQuestion.answers[currentQuestion.correct]) {
    console.log("Correct! The answer is: "+ userAns);
    // change color of selected item by changing className
    selectedItem.className = 'correct';
    // count the number of correct answers
    correctAns++;
    console.log(correctAns);
  } else {
    console.log("Wrong! The corrent answer is: "+  currentQuestion.answers[currentQuestion.correct]);
    //change the background of the wrong answer
    selectedItem.className = 'wrong';
    //hightlight the right answer if the user got it wrong
    //change the class name of the correct answer
    ulTag.getElementsByTagName('li')[currentQuestion.correct].className = 'correct';

    console.log(currentQuestion.answers[currentQuestion.correct]);
  }

  // Create a next Question button once the answer has been submitted
  button.innerHTML = '다음 문제';
  button.className = 'next';
  button.id = 'next';

  prevousQuestion = currentQuestion;
  quizPage++;
  currentIndex++;
  currentQuestion = questions[currentIndex];

  // Start with the next question once the "Next" button has been clicked
  button.onclick = function (){showQuestions()};
  return
}

// Final score
//------------------------------------------------------------------
function showResults () {
  //deleting page number
  document.getElementById('pages').innerHTML='';

  // Change Title
  questionTitle.innerHTML = '<h1>당신의 점수는!?!?!?!?!?!?</h1>';

  // Get the area that will be used to display the user's score
  var newInfo = document.getElementById('quiz-results');
  //Change the id and className of the area for the circle
  newInfo.innerHTML = '';
  newInfo.id = 'circle';
  newInfo.className = 'circle';


  //Create a Div for the fill element
  var newDiv = document.createElement('div');
  newDiv.className = 'fill';
  var addHere = document.getElementById('circle');
  addHere.appendChild(newDiv);

  // add the score to the circle
  var newScore = document.createElement('h3');
  newScore.className = 'score';
  var textScore = document.createTextNode(Math.floor((correctAns/questions.length)*100) + '%');
  newScore.appendChild(textScore);
  addHere.appendChild(newScore);

  //use jquary to grab the text of the score
  var score = $(".score").text();

  //fill the circle in base of the score
  $(".fill").css("height",score);

  if (correctAns >= 5) {
    var newCongrats = document.createElement('p');
    var textCongrats = document.createTextNode('Congratulations! You did a Good Job!')
    newCongrats.appendChild(textCongrats);
    document.getElementById('display-area').appendChild(newCongrats);

    confettiEffect();
  }

}

// Confetti Effect by Gtibo "Confetti Party"
//------------------------------------------------------------------
function confettiEffect (){
  //grabing area to create the effect
  canvas = document.getElementById("canvas");
  context = canvas.getContext("2d");
  width = canvas.width = window.innerWidth;
  height = canvas.height = window.innerHeight;

  // creating the tabel
  particle = [];
  particleCount = 0,
  gravity = 0.3,
  colors = [
    '#f44336', '#e91e63', '#9c27b0', '#673ab7', '#3f51b5',
    '#2196f3', '#03a9f4', '#00bcd4', '#009688', '#4CAF50',
    '#8BC34A', '#CDDC39', '#FFEB3B', '#FFC107', '#FF9800',
    '#FF5722', '#795548'
  ];

  for( var i = 0; i < 300; i++){

    particle.push({
    	x : width/2,
    	y : height/2,
    	boxW : randomRange(5,20),
    	boxH : randomRange(5,20),
    	size : randomRange(2,8),

    	spikeran:randomRange(3,5),

    	velX :randomRange(-8,8),
    	velY :randomRange(-50,-10),

    	angle :convertToRadians(randomRange(0,360)),
    	color:colors[Math.floor(Math.random() * colors.length)],
    	anglespin:randomRange(-0.2,0.2),

    	draw : function(){
    		context.save();
        context.translate(this.x,this.y);
        context.rotate(this.angle);
    		context.fillStyle=this.color;
    		context.beginPath();

    	  context.fillRect(this.boxW/2*-1,this.boxH/2*-1,this.boxW,this.boxH);
    		context.fill();
				context.closePath();
    		context.restore();
    	  this.angle += this.anglespin;
        this.velY*= 0.999;
    	  this.velY += 0.3;

        this.x += this.velX;
        this.y += this.velY;

    		if(this.y < 0){
      	   this.velY *= -0.2;
      		 this.velX *= 0.9;
      	};

      	if(this.y > height){
        	this.anglespin = 0;
        	this.y = height;
        	this.velY *= -0.2;
      		this.velX *= 0.9;
    	  };

    		if(this.x > width ||this.x< 0){
        	this.velX *= -0.5;
        };
    	},
  	});
  }

  function drawScreen(){
  			context.globalAlpha = 1;
    		for( var i = 0; i < particle.length; i++){
    			particle[i].draw();
    		}
  }

	function loadImage(url){
		var img = document.createElement("img");
		img.src=url;
		return img;
	}

  function update(){
  context.clearRect(0,0,width,height);
  drawScreen();
  requestAnimationFrame(update);
  }

  update();

  function randomRange(min, max){
  	return min + Math.random() * (max - min );
  }

  function randomInt(min, max){
  	return Math.floor(min + Math.random()* (max - min + 1));
  }

   function convertToRadians(degree) {
        return degree*(Math.PI/180);
    }

		function drawStar(cx, cy, spikes, outerRadius, innerRadius,color) {
    var rot = Math.PI / 2 * 3;
    var x = cx;
    var y = cy;
    var step = Math.PI / spikes;

    context.strokeSyle = "#000";
    context.beginPath();
    context.moveTo(cx, cy - outerRadius)
    for (i = 0; i < spikes; i++) {
        x = cx + Math.cos(rot) * outerRadius;
        y = cy + Math.sin(rot) * outerRadius;
        context.lineTo(x, y)
        rot += step

        x = cx + Math.cos(rot) * innerRadius;
        y = cy + Math.sin(rot) * innerRadius;
        context.lineTo(x, y)
        rot += step
    }

    context.lineTo(cx, cy - outerRadius)
    context.closePath();
    context.fillStyle = color;
    context.fill();

  }
}
