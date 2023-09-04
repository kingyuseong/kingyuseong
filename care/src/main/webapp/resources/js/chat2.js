   let peer = null;
   let lastPeerId = null;
   let conn = null;
   
   
   function init() {
      peer = new Peer();
      
      
      peer.on('open', function(id) {
         if(peer.id === null){
            peer.id = lastpeerId;   
         }else {
            lastPeerId = peer.id;
         }
         $('#receiver-id').html("방 코드  : " + peer.id);
         $('#status').html('연결을 기다리는중..');
          
      });
      
      peer.on('connection', function(con2) {
         if(conn && coo.open){
            con2.on('open', function () {
               con2.send('Already connected to another client');
               setTimeout(function() {
                  con2.close();
               }, 500);
            });
         }
         
         conn = con2;
         $('#status').html("연결이 되었습니다!");
         ready();
      });
      peer.on('disconnected', function () {
         $('#status').html('Connection lost. Please reconnect.');
         peer.id = lastPeerId;
         peer._lastServerId = lastPeerId;
         peer.reconnect();
      });      
      
      peer.on('close', function () {
         conn = null;
         $('#status').html('connection destroyed');
      });
      
      peer.on('error', function(err) {
         alert(err);
         
      });
   }
   function ready() {
      conn.on('data', function (data) {
         addMessage(data, "right");
      });
      
      conn.on('close', function () {
         $('#status').html('연결이 끊어졌습니다.');
         conn = null;
      });
      // 연결이 되었을 때 방 코드와 알림 보내기 버튼 숨기기
          $('#receiver-id').hide();
          $('#notifyButton').hide();
      
      }
   
   
   function addMessage(msg, side) {
      var now = new Date();
      var h = now.getHours();
      var m = now.getMinutes();
      var s = now.getSeconds();
      
      if(h < 10) h = "0" + h;
      if(m < 10) m = "0" + m;
      if(s < 10) s = "0" + s;
      
      var msgHtml = [];
       
      if(side == 'left'){
      msgHtml.push('<li class="chat-left">');
      msgHtml.push('<div class="chat-avatar">');
      msgHtml.push('<img src= resources/images/sds/1.jpg alt="Retail Admin">');
      msgHtml.push('<div class="chat-name">나</div>');
      msgHtml.push('</div>');
      msgHtml.push('<div class="chat-text"> ' + msg + '</div>');
      msgHtml.push('<div class="chat-hour">' + h + ':' + m + ':' + s +'<span class="fa fa-check-circle"></span></div>');
      msgHtml.push('</li>');
      }else {
      msgHtml.push('<li class="chat-right">');
      msgHtml.push('<div class="chat-hour">' + h + ':' + m + ':' + s +'<span class="fa fa-check-circle"></span></div>');
      msgHtml.push('<div class="chat-text">' + msg +'</div>');
      msgHtml.push('<div class="chat-avatar">');
      msgHtml.push('<img src= resources/images/user/sd.png alt="Retail Admin">');
      msgHtml.push('<div class="chat-name">회원</div>');
      msgHtml.push('</div>');
      msgHtml.push('</li>');
      }
      
      $('#chat_box').append(msgHtml.join(""));
      }
         
         $(document).ready(function () {
        init();
      
        $('#sendMessageBox').keydown(function (key) {
          if (key.keyCode == 13) {
            if (conn && conn.open) {
              var msg = $('#sendMessageBox').val();
              $('#sendMessageBox').val('');
              conn.send(msg);
              addMessage(msg, "left");
            } else {
              $('#status').html('Connection is closed');
            }
          }
        });
      
        // 알림 보내기 버튼 클릭 이벤트
        $('#notifyButton').click(function () {
          // 사용자에게 확인을 받기 위한 확인 창 띄우기
          var userConfirm = confirm("회원에게 알림을 보내시겠습니까?");
        
          if (userConfirm) {
            makeNoti(peer.id); // 방 코드를 전달하여 알림 생성
          }
        });
      });
      
      // 알림 보내기 함수
      function makeNoti(roomCode) {
        if (Notification.permission === "denied" || Notification.permission === "default") {
          alert("알림이 차단된 상태입니다. 알림 권한을 허용해주세요.");
        } else {
          let notification = new Notification("상담사가 방 코드를 보냈습니다.", {
            body: "회원 채팅방에서 방 코드 확인을 눌러주세요.",
            icon: "resources/images/logo/logo_icon.png",
            requireInteraction: true,
          });
      
          // 방 코드를 localStorage에 저장
          localStorage.setItem("roomCode", roomCode);
        }
      }