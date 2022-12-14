
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

	$("#save").click(function() {
		saveImg();
	});
	

	$("#brush").click(function(){
		ctx=document.getElementById("canvas").getContext("2d");
		$("#canvas").drawMouse();
	});

	$("#line").click(function(){
		ctx=document.getElementById("canvas").getContext("2d");
		$("#canvas").drawLine();
	});

	$("#rect").click(function(){
		ctx=document.getElementById("canvas").getContext("2d");
		$("#canvas").drawRect();
	});

	$("#circ").click(function(){
		ctx=document.getElementById("canvas").getContext("2d");
		$("#canvas").drawCirc();
	});
	
});


function newCanvas(){

    $("#content").height($(window).height()-90);
    var canvas = '<canvas id="canvas" width="'+$(window).width()+'" height="'+($(window).height()-90)+'"></canvas>';
	$("#content").html(canvas);
    
	ctx=document.getElementById("canvas").getContext("2d");
	ctx.strokeStyle = color;
	ctx.lineWidth = 4;
}

function updateWidth(){
	ctx = document.getElementById("canvas").getContext("2d");
	ctx.lineWidth = Math.round(document.getElementById("width").value);
}

function saveImg(){
	var ctx=document.querySelector("#canvas");
	var img = ctx.toDataURL("image/png",1.0);
	var a = document.createElement('a');
    a.href = img;
    a.download = "canvas.png";
    document.body.appendChild(a);
    a.click();
}


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

$.fn.drawLine = function() {
	var clicked = 0;
	var start = function(e) {
		clicked = 1;
		ctx.beginPath();
		x = e.pageX;
		y = e.pageY-44;
		ctx.moveTo(x,y);
	};
	var stop = function(e) {
		if(clicked){
		x = e.pageX;
		y = e.pageY-44;
		ctx.lineTo(x,y);
		ctx.stroke();
		}
		clicked = 0;
	};

	$(this).on("mousedown", start);
	$(window).on("mouseup", stop);
}

$.fn.drawRect = function() {
	var clicked = 0;
	x1 = 0; y1 = 0;
	var start = function(e) {
		clicked = 1;
		ctx.beginPath();
		x = e.pageX;
		y = e.pageY-44;
		[x1,y1]=[x,y];
		ctx.moveTo(x,y);
	};
	var stop = function(e) {
		if(clicked){
		x = e.pageX;
		y = e.pageY-44;
		if(x<x1)
			[x,x1] = [x1,x];
		if(y<y1)
			[y,y1] = [y1,y];
		x-=x1;
		y-=y1;
		ctx.rect(x1,y1,x,y);
		ctx.stroke();
		}
		clicked = 0;
	};

	$(this).on("mousedown", start);
	$(window).on("mouseup", stop);
}

$.fn.drawCirc = function() {
	var clicked = 0;
	x1 = 0; y1 = 0;
	var start = function(e) {
		clicked = 1;
		ctx.beginPath();
		x = e.pageX;
		y = e.pageY-44;
		x1=x;
		y1=y;
	};
	var stop = function(e) {
		if(clicked){
		x = e.pageX;
		y = e.pageY-44;
		if(x<x1)
			[x,x1] = [x1,x];
		if(y<y1)
			[y,y1] = [y1,y];
		r=((x-x1)+(y-y1))/4;
		x1=(x1+x)/2;
		y1=(y1+y)/2;
		ctx.arc(x1,y1,r,0,2*Math.PI,false);
		ctx.stroke();
		}
		clicked = 0;
	};

	$(this).on("mousedown", start);
	$(window).on("mouseup", stop);
}