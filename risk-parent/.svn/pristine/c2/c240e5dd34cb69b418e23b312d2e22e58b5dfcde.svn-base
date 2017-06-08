$(function () {
	
	function parseISO8601(timestamp){
		function pad(n){  
	        return n<10 ? '0'+n : n  ;
	    }
		var d = new Date(timestamp);
		return d.getFullYear()+"-"+
			pad(d.getMonth()+1)+"-"+
			pad(d.getDate())+"T"+
			pad(d.getHours())+":"+
			pad(d.getMinutes())+":"+
			pad(d.getSeconds());
	};
	
	function uuid() {
	    var s = [];
	    var hexDigits = "0123456789abcdef";
	    for (var i = 0; i < 36; i++) {
	        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
	    }
	    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
	    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
	    s[8] = s[13] = s[18] = s[23] = "-";
	    var uuid = s.join("");
	    return uuid;
	};
	
    /* initialize the external events
     -----------------------------------------------------------------*/
    function ini_events(ele) {
      ele.each(function () {
        // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
        // it doesn't need to have a start or end
        var eventObject = {
          title: $.trim($(this).text()) // use the element's text as the event title
        };
        // store the Event Object in the DOM element so we can get to it later
        $(this).data('eventObject', eventObject);
        // make the event draggable using jQuery UI
        $(this).draggable({
          zIndex: 1070,
          revert: true, // will cause the event to go back to its
          revertDuration: 0  //  original position after the drag
        });
      });
    }
    ini_events($('#external-events div.external-event'));
    /* initialize the calendar
     -----------------------------------------------------------------*/
    //Date for the calendar events (dummy data)
    var date = new Date();
    var d = date.getDate(),
        m = date.getMonth(),
        y = date.getFullYear();
    $('#calendar').fullCalendar({
      header: {
        left: 'prev,next,today',
        center: 'title',
        right: 'month,agendaWeek,agendaDay'
      },
      buttonText: {
        today: '今天',
        month: '月份',
        week: '星期',
        day: '日'
      },
      height:650,
      monthNames:['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
      monthNamesShort:['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
      dayNames:['周日','周一','周二','周三','周四','周五','周六'],
      dayNamesShort:['周日','周一','周二','周三','周四','周五','周六'],
      //Random default events
      editable: true,
      events: function(start, end, timezone, callback) {
    	  worf.ajax({
		 		url : ctx+'/system/calEvent/queryAllCalEvent',
		 		type : 'get',
		 		success : function(data) {
		 			if(data.status==1){
		 				// console.info(data);
		 				var eventData = data.data;
		 				var events = [];
		 				for(var i in eventData){
		 					if(eventData[i].allDay == 0){
		 						events.push({
			 						id : eventData[i].id,
			 						allDay : true,
			 						color : eventData[i].color,
			 						title: eventData[i].title,
			 						start: parseISO8601(eventData[i].startTime),
			 						end: parseISO8601(eventData[i].endTime)
			 					});
		 					}else {
		 						events.push({
			 						id : eventData[i].id,
			 						allDay : false,
			 						color : eventData[i].color,
			 						title: eventData[i].title,
			 						start: parseISO8601(eventData[i].startTime),
			 						end: parseISO8601(eventData[i].endTime)
			 					});
		 					}
		 					
		 				}
		 				callback(events);
		 			}else{
		 				$.alert(data.message);
		 			}
		 		},
		 		error : function(){
		 		}
		 	});
      },
      droppable: true, // this allows things to be dropped onto the calendar !!!
      drop: function (date, allDay) { // this function is called when something is dropped
        // retrieve the dropped element's stored Event Object
    	 //  console.info(date);
        var originalEventObject = $(this).data('eventObject');
        // console.info(originalEventObject);
        // we need to copy it, so that multiple events don't have a reference to the same object
        var copiedEventObject = $.extend({}, originalEventObject);
        // assign it the date that was reported
        copiedEventObject.id = uuid().replace(/-/g,"");

        copiedEventObject.start = date;
        copiedEventObject.allDay = allDay;
        copiedEventObject.backgroundColor = $(this).css("background-color");
        copiedEventObject.borderColor = $(this).css("border-color");
	      // console.log(copiedEventObject.title)
	      if(!copiedEventObject.title){
	      	return;
	      }
        worf.ajax({
        	url : ctx+'/system/calEvent/addCalEvent',
	 		type : 'post',
	 		data : {
	 			id : copiedEventObject.id,
	 			allDay : 0,
	 			isFinish : 0,
	 			color : copiedEventObject.backgroundColor,
	 			title : copiedEventObject.title,
	 			startTime : date.format()+" 00:00:00"
	 		},
	 		success : function(data) {

	 		}
        });
        // render the event on the calendar
        // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
        $('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
        // is the "remove after drop" checkbox checked?
        if ($('#drop-remove').is(':checked')) {
          // if so, remove the element from the "Draggable Events" list
          $(this).remove();
        }

      },
      eventDragStop:function( event, jsEvent, ui, view ){
      	// console.log(jsEvent)
    	  if( jsEvent.clientX < 300 ){
    		  worf.ajax({
    	          	url : ctx+'/system/calEvent/deleteCalEvent',
    	  	 		type : 'post',
    	  	 		data : {
    	  	 			id : event.id
    	  	 		},
    	  	 		success : function(data) {
    	  	 			$('#calendar').fullCalendar('removeEvents',event.id);
    	  	 		}
    	          });
    		  
    	  }
      },
      eventDrop:function(event, delta, revertFunc, jsEvent, ui, view ){
    	  var data = {
    			id : event.id,
    	 		allDay : event.allDay?0:1,
    	 		isFinish : 0,
    	 		color : event.backgroundColor,
    	 		title : event.title
    	  };
    	  if(event.allDay){
    		  data.startTime =(event.start.format()+" 00:00:00");
    	  } else {
    		  data.startTime =(event.start.format().replace("T"," "));
    	  }
    	  if(event.allDay && event.end != null ){
    		  data.endTime =(event.end.format().replace("T"," "));
    	  }
    	  
    	  if( jsEvent.clientX < 300 ){
    		  worf.ajax({
    	          	url : ctx+'/system/calEvent/deleteCalEvent',
    	  	 		type : 'post',
    	  	 		data : {
    	  	 			id : event.id
    	  	 		},
    	  	 		success : function(data) {
    	  	 			$('#calendar').fullCalendar('removeEvents',event.id);
    	  	 		}
    	          });
    		  
    	  }else {
    		  worf.ajax({
    	          	url : ctx+'/system/calEvent/updateCalEvent',
    	  	 		type : 'post',
    	  	 		data : data,
    	  	 		success : function(data) {
    	  	 			
    	  	 		}
    	          });
    	  }
      },
      eventResize: function(event, delta, revertFunc) {
    	  // console.info(event);
    	  var data = {
    			  id : event.id,
    	 			allDay : event.allDay?0:1,
    	 			isFinish : 0,
    	 			color : event.backgroundColor,
    	 			title : event.title
    	  };
    	  if(event.allDay){
    		  data.startTime =(event.start.format()+" 00:00:00");
    	  } else {
    		  data.startTime =(event.start.format().replace("T"," "));
    	  }
    	  if(event.end != null ){
    		  data.endTime =(event.end.format().replace("T"," "));
    	  } 
    	  worf.ajax({
          	url : ctx+'/system/calEvent/updateCalEvent',
  	 		type : 'post',
  	 		data : data,
  	 		success : function(data) {

  	 		}
          });
      },
      eventClick:function (event, jsEvent, view) {
	      var title=event.title;
	      var startTime=event._start._i;
	      var time=$.fullCalendar.moment(startTime).format('YYYY-MM-DD hh:mm:ss');
	      var $dayEventModal=$('#dayEventModal');
	      var $delBtn=$dayEventModal.find('.delBtn');
	      var $comfirmBtn=$dayEventModal.find('.confirmBtn');
	      var eventContent=$dayEventModal.find('[name="eventContent"]'),
		      eventTime=$dayEventModal.find('[name="eventTime"]');
	      eventContent.val(title);
	      eventTime.val(time);
	      $dayEventModal.modal('show');
	      $comfirmBtn.off().on('click',function () {
		      var $this=$(this);
		      $this.button('loading');
		      var title=eventContent.val();
		      if(!title||!title.toString().trim()){
		      	$.showPop('行程说明不能为空');
			      $this.button('reset');
			      return;
		      }
		      var data = {
			      id : event.id,
			      allDay : event.allDay?0:1,
			      isFinish : 0,
			      color : event.backgroundColor,
			      title : title
		      };
		      worf.ajax({
			      url : ctx+'/system/calEvent/updateCalEvent',
			      type : 'post',
			      data : data,
			      success : function(data) {
				      $.showPop('修改成功');
				      $dayEventModal.modal('hide');
				      $('#calendar').fullCalendar('refetchEvents')
			      },
			      complete:function () {
				      $this.button('reset');
			      }
		      });
	      })
	      $delBtn.off().on('click',function () {
	      	    var $this=$(this);
		      $this.button('loading')
		      $.confirm({
		      	    title:'',
			      content: '是否删除？',
			      confirm: function(){
				      worf.ajax({
					      url : ctx+'/system/calEvent/deleteCalEvent',
					      type : 'post',
					      data : {
						      id : event.id
					      },
					      success : function(data) {
						      $.showPop('删除成功');
						      $dayEventModal.modal('hide')
						      $('#calendar').fullCalendar('refetchEvents')
					      },
					      complete:function () {
						      $this.button('reset');
					      }
				      });
			      },
			      cancel:function () {
				      $this.button('reset')
			      }
		      });
	      })
      }

    });
    
    
    /* ADDING EVENTS */
    var currColor = "#3c8dbc"; //Red by default
    //Color chooser button
    var colorChooser = $("#color-chooser-btn");
    $("#color-chooser > li > span").click(function (e) {
      e.preventDefault();
      //Save color
      currColor = $(this).css("color");
      //Add color effect to button
      $('#add-new-event').css({"background-color": currColor, "border-color": currColor});
    });
    $("#add-new-event").click(function (e) {
      e.preventDefault();
      //Get value and make sure it is not null
      var val = $("#new-event").val();
      if (val.length == 0) {
        return;
      }
      //Create events
      var event = $("<div />");
      event.css({"background-color": currColor, "border-color": currColor, "color": "#fff"}).addClass("external-event");
      event.html(val);
      $('#external-events').prepend(event);
      //Add draggable funtionality
      ini_events(event);
      //Remove event from text input
      $("#new-event").val("");
    });
    
    
    //由于日志无法在隐藏的div中加载，所以在显示的时候加载一次  
    var calisload = false;  
    $('a[data-toggle="tab"][href="#action"]').on('shown.bs.tab',function(e) {  
        if(!calisload){  
            $("#action #calendar").fullCalendar('render');  
            calisload = true;  
        }  
    }); 
});