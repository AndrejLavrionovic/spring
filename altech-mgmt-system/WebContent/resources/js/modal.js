/**
 * 
 */
var sm = document.getElementById("modalFirstname");
sm.addEventListener("click", function(event){
	alert("Click, click");
});
$("#modalFirstname").html("Fuck You");
$("#modalFirstname").css("width", '100px');
$("#modalLastname").click(function(){
	alert("Fuck You");
});