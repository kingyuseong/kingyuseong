const userInput = document.getElementById('userInput');
const chatArea = document.getElementById('chatArea');
const infoButton = document.getElementById("infoButton");
const infoPopup = document.getElementById("infoPopup");
const closePopup = document.getElementById("closePopup");


const trigger = [
  ['안녕', '웅 안녕'],
  ['오늘 그냥 집에 있었어'],
  ['별로 나가고 싶지 않았어', '그냥..'],
  ['고마워', '그럴까?'],
  ['나 문제풀기 좋아해'],
  ['좋아', '풀어볼게'],
  ['웅웅', '문제줘'],
];

const reply = [
  ['오늘은 뭐했어?'],
  ['왜 무슨 일 있어?', '왜 이야기 해줄 수 있어?'],
  ['그렇구나 그래도 나랑 이야기하다보면 괜찮아질거야', '그렇구나 괜찮아 나랑 재밌게 놀자'],
  ['그럼~ 재밌게 놀아보자 취미는 뭐야?', '그럼~ 좋아하는 거 있어?'],
  ['준비해볼게'],
  ['오 그럼 나에게 퀴즈문제가 있는데 풀어볼래?'],
  ['"업무대화 문제풀고싶어" 또는 "일상대화 문제풀고싶어" 를 입력해줘'],
];

function handleKeyPress(event) {
  if (event.key === 'Enter') {
    sendMessage();
  }
}


function sendMessage() {
  const message = userInput.value.trim().toLowerCase();
  userInput.value = '';

  if (message !== '') {
    addMessage('나', message);
    processMessage(message);
  }
}

function processMessage(message) {
  let response = '미안해 이해를 못했어.';
  
  let popupWidth = 600;
  let popupHeight = 600;

  // 화면 크기를 얻어오기
  let screenWidth = window.screen.width;
  let screenHeight = window.screen.height;

  // 윈도우를 가운데로 위치시키기 위한 좌표 계산
  let left = (screenWidth - popupWidth) / 2;
  let top = (screenHeight - popupHeight) / 2;

  if (message.includes('업무대화 문제풀고싶어')) {
    window.open('company_talk.do', '_blank', 'width=600,height=600,left=' + left + ',top=' + top);
    response = '잘풀어봐 ㅋㅋ';
  } else if (message.includes('업무 문제풀고싶어!') || message.includes('업무문제풀고싶어') || message.includes('업무문제풀래')) {
     window.open('company_talk.do', '_blank', 'width=600,height=600,left=' + left + ',top=' + top);
    response = '그래! 잘풀어봐';
  } else if (message.includes('일상대화 문제풀고싶어') || message.includes('일상문제풀고싶어') || message.includes('일상대화') || message.includes('일상문제풀래')) {
     window.open('daily_talk.do', '_blank', 'width=1000,height=700');
     response = '그래! 잘풀어봐';
  } else {
    for (let i = 0; i < trigger.length; i++) {
      for (let j = 0; j < trigger[i].length; j++) {
        if (message.includes(trigger[i][j])) {
          response = getRandomResponse(reply[i]);
          break;
        }
      }
    }
  }

  setTimeout(() => {
    addMessage('친구', response);
  }, 1000);
}

function getRandomResponse(responses) {
  const randomIndex = Math.floor(Math.random() * responses.length);
  return responses[randomIndex];
}

function addMessage(sender, message) {
  chatArea.innerHTML += `<p><strong>${sender}:</strong> ${message}</p>`;
  chatArea.scrollTop = chatArea.scrollHeight;
}

addMessage('친구 ' , '안녕!!');


infoButton.addEventListener("click", () => {
    infoPopup.style.display = "block";
});

closePopup.addEventListener("click", () => {
    infoPopup.style.display = "none";
});

window.addEventListener("click", (event) => {
    if (event.target === infoPopup) {
        infoPopup.style.display = "none";
    }
});