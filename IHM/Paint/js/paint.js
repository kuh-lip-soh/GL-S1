
var ctx, color = "#000";	

$(document).ready(function () {
	

    setTimeout(function(){
	   newCanvas();
    }, 1000);
		

	$(".palette").click(function(){
		$(".palette").css("border-color", "#777");
		$(".palette").css("border-style", "solid");
		$(this).css("border-color", "#fff");
		$(this).css("border-style", "dashed");
		color = $(this).css("background-color");
		ctx.beginPath();
		ctx.strokeStyle = color;
	});
    
	$("#new").click(function() {
		newCanvas();
	});

	$("#rect").click(function (){
		$("#canvas").drawRect();
	});	
});


function newCanvas(){

    $("#content").height($(window).height()-90);
    var canvas = '<canvas id="canvas" width="'+$(window).width()+'" height="'+($(window).height()-90)+'"></canvas>';
	$("#content").html(canvas);
    
    // setup canvas
	ctx=document.getElementById("canvas").getContext("2d");
	ctx.strokeStyle = color;
	ctx.lineWidth = 5;	
	

	$("#canvas").drawMouse();
}


    
      

// Dessiner les lignes avec moveTo et lineTo
$.fn.drawMouse = function() {
	var clicked = 0;
	var start = function(e) {
		clicked = 1;
		ctx.beginPath();
		x = e.pageX;
		y = e.pageY-44;
		ctx.moveTo(x,y);
	};
	var move = function(e) {
		if(clicked){
			x = e.pageX;
			y = e.pageY-44;
			ctx.lineTo(x,y);
			ctx.stroke();
		}
	};
	var stop = function(e) {
		clicked = 0;
	};
	$(this).on("mousedown", start);
	$(this).on("mousemove", move);
	$(window).on("mouseup", stop);
};

function drawRect() {
    const canvas = document.querySelector('#canvas');

    if (!canvas.getContext) {
        return;
    }
    const ctx = canvas.getContext('2d');

    // set line stroke and line width
    ctx.strokeStyle = document.getElementById("color").style.backgroundColor;
    ctx.lineWidth = 5;
	

    // draw a red line
    ctx.beginPath();
    ctx.rect(100,100,20,20);
    ctx.stroke();

}

function drawrect() {
    const canvas = document.querySelector('#canvas');

    if (!canvas.getContext) {
        return;
    }
    const ctx = canvas.getContext('2d');

    // set line stroke and line width
    ctx.strokeStyle = document.getElementById("color").style.backgroundColor;
    ctx.lineWidth = 3;
	

    // draw a red line
    ctx.beginPath();
    ctx.rect(100,100,120,350);
    ctx.stroke();

}
/*
drawRect = function () {
	var clicked = 0;
	var x, y;
	var start = function(e){
		clicked = 1;
		ctx.beginPath();
		x = e.pageX;
		y = e.pageY-44;
		ctx.moveTo(x1,y1);
	}
	
	var stop = function(e) {
		if(clicked)
		x2=e.pageX;
		y2=e.pageY-44;
		ctx.rect(x,y,x1,y1);
	}

	$(this).on("mousedown", start);
	$(window).on("mouseup", stop);
}
*/