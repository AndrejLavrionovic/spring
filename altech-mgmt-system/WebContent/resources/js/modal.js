/**
 * 
 */

$(document).ready(function(){
	
	var cond = [
	    {
	    	'field' : '',
	    	'condition' : []
	    },
	    {
	    	'field' : '',
	    	'condition' : []
	    },
	    {
	    	'field' : '',
	    	'condition' : []
	    },
	    {
	    	'field' : '',
	    	'condition' : []
	    },
        {
            'field' : 'Username',
            'condition' : [
                'Username must be unique',
                'Username must be 8 characters min',
                'Username must not content symbols'
            ]
        },
        {
            'field' : 'Password',
            'condition' : [
                'Password must be unique',
                'Password must be at least 8 characters long',
                'Password must be at most 32 characters long',
                'Password must contain at least one uppercase letter (e.g. A, B, C)',
                'Password must contain at least one lowercase letter (e.g. a, b, c)',
                'Password must contain at least one number (e.g. 1, 2, 3)',
                'Password must contain at least one symbol (e.g. #, !, ?, $, & etc.)'
            ]
        }
    ];
	
	var modalContent=function(index){
		$('#conditions').empty();
        $('#fieldName').html(cond[index].field);
        for(var i=0; i<cond[index].condition.length; i++){
            $('#conditions').append('<li>' + cond[index].condition[i] + '</li>');
        }
	}
	
	$('.spanModal').click(function(event){
		if($(event.target).is('#modalFirstname')){
			modalContent($('.spanModal').index($(event.target)));
		}
		else if($(event.target).is('#modalLastname')){
			modalContent($('.spanModal').index($(event.target)));
		}
		else if($(event.target).is('#modalTel')){
			modalContent($('.spanModal').index($(event.target)));
		}
		else if($(event.target).is('#modalEmail')){
			modalContent($('.spanModal').index($(event.target)));
		}
		else if($(event.target).is('#modalUsername')){
			modalContent($('.spanModal').index($(event.target)));
		}
		else if($(event.target).is('#modalPassword')){
			modalContent($('.spanModal').index($(event.target)));
		}
        $('.modal').css({
            'display': 'block'
        });
	});
	$('#imgClose').click(function(){
        $('.modal').css({'display': 'none'});
    })
});