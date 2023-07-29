let json = {};

$(function() {
    $('#loginBtn').on('click', function() {
        let email = $('#emailInput').val();
        let password = $('#passwordInput').val();

        json = {
            email : email,
            password : password
        };

        let success = function(result){
            console.log('success');
            console.log(result);
        };
        let error = function(result){
            console.log('err');
            console.log(result);
        };

        AjaxUtil.ajax('/member/login', 'POST', json, success, error);

        json = {};
    });
});

