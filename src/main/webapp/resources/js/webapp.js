/*
 * custom jQuery function
 * */

$(function() {
	// active menu problem
	switch (view) {
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

	/*
	 * Carousel Issue
	 */
	$('.carousel').carousel({
		interval : 2000,
		pause : "hover",
		wrap : true
	}).on('click', '.carousel-control', handle_nav);

	var handle_nav = function(e) {
		e.preventDefault();
		var nav = $(this);
		nav.parents('.carousel').carousel(nav.data('slide'));
	}
		
});
