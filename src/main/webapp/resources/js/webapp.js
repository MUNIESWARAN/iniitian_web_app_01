/*
 * custom jQuery function
 * */

$(function(){
	// active menu problem
	switch(view){
	case 'about':
		$('#about').addClass('active');
		break;
	case 'contact':
		$('#contact').addClass('active');
		break;
	case 'register':
		$('#register').addClass('active');
		break;
	case 'login':
		$('#login').addClass('active');
		break;
	case 'products':
		$('#products').addClass('active');
		break;
	case 'admin':
		$('#admin').addClass('active');
		break;
	}
	
	
});
