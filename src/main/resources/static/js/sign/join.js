$(document).ready(function () {
    $('#joinButton').on('click', function () {
        var formData = {};

        $("#joinForm input").each(function() {
          var inputId = $(this).attr("id");
          var inputValue = $(this).val();
          formData[inputId] = inputValue;
        });

        var jsonData = JSON.stringify(formData);

        $.ajax({
            url: "/LeeMart/join",
            method: "POST",
            data: jsonData,
            contentType: "application/json",
            processData: false,
            /*beforeSend: function () {
                $('.loading-mask').removeClass('d-none');
            },
            complete: function () {
                $('.loading-mask').addClass('d-none');
            },*/
            success: function (response) {
                alert('회원가입에 성공했습니다');
                //location.href = '/LeeMart/login';
            },
            error: function (xhr) {
                alert(xhr.responseText);
            }
        });
    });
});