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
                location.href = '/LeeMart/login';
            },
            error: function (xhr) {
                if (xhr.status === 400) {
                    var errors = JSON.parse(xhr.responseText);
                    //console.log(errors.exception);
                    $(".error-message").text("");

                    Object.keys(errors).forEach(function (key) {
                        var errorMessage = errors[key];
                        $("#" + key + "Error").text(errorMessage).css("color", "red");
                    });
                } else if (xhr.status === 500) {
                    console.log('xhr.status === 500');
                } else {
                    console.log('xhr.status === else')
                }
            }
        });
    });
});