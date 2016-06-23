/*
 * custom jQuery function
 * */

// override jquery validate plugin defaults
$.validator.setDefaults({
    highlight: function(element) {
        $(element).closest('.form-group').addClass('has-error');
    },
    unhighlight: function(element) {
        $(element).closest('.form-group').removeClass('has-error');
    },
    errorElement: 'span',
    errorClass: 'help-block',
    errorPlacement: function(error, element) {
        if(element.parent('.input-group').length) {
            error.insertAfter(element.parent());
        } else {
            error.insertAfter(element);
        }
    }
});

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
	
	/*
	 * Login form validation
	 * */
	$('#f').validate({
	    rules: {
	    	inputEmail: {
	            email: true
	        },
	        inputPassword: {
	            required: true
	        }
	    },
	    messages: {
	    	inputEmail : {
	    		email: 'Please enter proper email id!'
	    	},
	    	inputPassword: {
	    		required: 'Please enter password!'
	    	}
	    },
	    highlight: function(element) {
	        $(element).closest('.form-group').addClass('has-error');
	    },
	    unhighlight: function(element) {
	        $(element).closest('.form-group').removeClass('has-error');
	    }
	});
		
});
