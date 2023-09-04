document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth',
          locale : "ko",
          dayCellContent: function(info) {
            var number = document.createElement("a");
            number.classList.add("fc-daygrid-day-number");
            number.innerHTML = info.dayNumberText.replace("일",'');
            return{html: number.outerHTML};   
            },           
    	  googleCalendarApiKey: 'AIzaSyBIiCaO4g9I9R3Khwgfoahs_9SSIldDq5k',
    	  eventSources: [
    		  {
    	    googleCalendarId: '5830add103fa0f920e3119bf14f328e2d99947842f3335aaaf80589368b78462@group.calendar.google.com',
    	    className: 'gcal-event', // an option!
    	    color: '#33CC00',
    	  },
    	  {
    	    googleCalendarId: '2b84f4800dfe37f9436f9492bf7468a67fea6923cd257eabab4b47150e496bc3@group.calendar.google.com',
    	    className: 'gcal-event2', // an option!
    	    color: '#be5683',
    	  },
    	  {
    	    googleCalendarId: '16bf41169575bf9b3f431a8565b33d76381d130d0bbdc95cddb4b302b6b4fb05@group.calendar.google.com',
    	    className: 'gcal-event3', // an option!
    	    color: '#E5CCFF',
    	  },
    	  {
    	    googleCalendarId: '2c20420daf2789e32b482431c99934eb54cbb6f6cc2cacde31e987510bd05770@group.calendar.google.com',
    	    className: 'gcal-event4', // an option!
    	    color: '#3366CC',
    	  },
    	  {
    	    googleCalendarId: '891988c5e824e901d93346a3f7c12306637d6a501dfecb4d05f27c41faa50994@group.calendar.google.com',
    	    className: 'gcal-event5', // an option!
    	    color: '#663333',
    	  },
    	  {
    	    googleCalendarId: '291fb9a07dc3375c0385b8c8c76d66cd443cc4e0e707e019c862329175263928@group.calendar.google.com',
    	    className: 'gcal-event6', // an option!
    	    color: '#C7C745',
    	  },
    	  ],
    	  eventClick: function(info) {
    		  info.jsEvent.stopPropagation();
    		  info.jsEvent.preventDefault();
    	  },
        });
        calendar.render();
      });