$(document).ready(function(){ 
	//Scroll to plan section when corresponding button clicked
	$('.scroll-to-plans').click(function(){
		$('html, body').animate({scrollTop: $('.plans').offset().top}, 800);
	});
	//Scroll to summary section when corresponding button clicked
	$('.scroll-to-summary').click(function(){
		$('html, body').animate({scrollTop: $('.summary').offset().top}, 1300);
	});
});