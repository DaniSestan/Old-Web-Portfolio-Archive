// $( "#target" ).click(function() {
(function ($) {
    "use strict";




    //run validation on button-click event rather than hit submit action, replace the submit input with a button type in the html
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');
    // var initPh = $('.validate-input .input100').data('initPlaceholder', $('.validate-input .input100').getAttribute('placeholder'));

    // $('.validate-form' ).on('submit',function(){
    $("#send-message").click(function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
            hideValidate(this);
        // $(this).attr('placeholder', initPh);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
        $(input).attr('placeholder', "");

    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }


})(jQuery);

//
// (function ($) {
//     "use strict";
//
//
//
//
//
//     /*==================================================================
//     [ Validate ]*/
//     var input = $('.validate-input .input100');
//
//     $('.validate-form').on('submit',function(){
//         var check = true;
//
//         for(var i=0; i<input.length; i++) {
//             if(validate(input[i]) == false){
//                 showValidate(input[i]);
//                 check=false;
//             }
//         }
//
//         return check;
//     });
//
//
//     $('.validate-form .input100').each(function(){
//         $(this).focus(function(){
//             hideValidate(this);
//         });
//     });
//
//     function validate (input) {
//         if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
//             if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
//                 return false;
//             }
//         }
//         else {
//             if($(input).val().trim() == ''){
//                 return false;
//             }
//         }
//     }
//
//     function showValidate(input) {
//         var thisAlert = $(input).parent();
//
//         $(thisAlert).addClass('alert-validate');
//         $(input).attr('placeholder', "");
//
//     }
//
//     function hideValidate(input) {
//         var thisAlert = $(input).parent();
//
//         $(thisAlert).removeClass('alert-validate');
//     }
//
//
// })(jQuery);
//
// // /***TODO****
// //  * add a function to remove the placeholder text when the element has an "alert-validate"
// //  * class added
// //  */
// // (function ($) {
// //     "use strict";
// //
// //
// //
// //
// //
// //     /*==================================================================
// //     [ Validate ]*/
// //     var input = $('.validate-input .input100');
// //     // var alertTriggered = false;
// //     input.data('initPlaceholder', $(input).getAttribute('placeholder'));
// //     input.data('alertTriggered', "N");
// //
// //
// //     $('.validate-form').on('submit',function(){
// //         var check = true;
// //
// //         for(var i=0; i<input.length; i++) {
// //             if(validate(input[i]) == false){
// //                 showValidate(input[i]);
// //                 check=false;
// //             }
// //         }
// //
// //         return check;
// //     });
// //
// //
// //     $('.validate-form .input100').each(function(){
// //         $(this).focus(function(){
// //            hideValidate(this);
// //         });
// //         // $(this).on('focusout', function(){
// //         //     hidePlaceholderOnShowValidate(this);
// //         // });
// //     });
// //
// //     function validate (input) {
// //         if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
// //             if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
// //                 return false;
// //             }
// //         }
// //         else {
// //             if($(input).val().trim() == ''){
// //                 return false;
// //             }
// //         }
// //     }
// //
// //     function showValidate(input) {
// //         var thisAlert = $(input).parent();
// //
// //         $(thisAlert).addClass('alert-validate');
// //         // $(input).attr('placeholder', "");
// //         input.data('alertTriggered',"Y");
// //     }
// //
// //     function hidePlaceholderOnShowValidate(input){
// //         if (input.data('alertTriggered') == "Y") {
// //             if (input.data('initPlaceholder')) { //|| input.data('initPlaceholder').trim() == "") {
// //
// //                 input.attr('placeholder', input.data('placeholder'));
// //             }
// //          }
// //     }
// //
// //     function hideValidate(input) {
// //         var thisAlert = $(input).parent();
// //
// //         $(thisAlert).removeClass('alert-validate');
// //         input.data('alertTriggered', "N");
// //     }
// //
// //
// // })(jQuery);