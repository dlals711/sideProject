$(document).ready(function () {
    $('#loginButton').on('click', function () {
        var formData = {};

        $("#loginForm input").each(function() {
          var inputId = $(this).attr("id");
          var inputValue = $(this).val();
          formData[inputId] = inputValue;
        });

        var jsonData = JSON.stringify(formData);

        $.ajax({
            url: "/LeeMart/login",
            method: "POST",
            data: jsonData,
            contentType: "application/json",
            processData: false,
            beforeSend: function () {
                $('.loading-mask').removeClass('d-none');
            },
            complete: function () {
                setTimeout(function() {
                    $('.loading-mask').addClass('d-none');
                }, 100);
            },
            success: function (response) {
                location.href = '/LeeMart';
            },
            error: function (xhr) {
                if (xhr.status === 400) {
                    var errors = JSON.parse(xhr.responseText);
                    $(".error-message").text("");

                    Object.keys(errors).forEach(function (key) {
                        var errorMessage = errors[key];
                        $("#" + key + "Error").text(errorMessage).css("color", "red");
                    });
                } else {
                    var errorMessage = JSON.parse(xhr.responseText).exception.errorMessage;
                    showToast(errorMessage,3000);
                }
            }
        });
    });

    function showToast(message, duration) {
        var toastContainer = $("#toastContainer");

        var toast = $("<div class='toast' role='alert' aria-live='assertive' aria-atomic='true'></div>");
        toast.addClass("bg-danger text-white");

        var toastBody = $("<div class='toast-body'></div>");
        toastBody.text(message);
        toast.append(toastBody);

        toastContainer.append(toast);

        var toastObj = new bootstrap.Toast(toast[0]);
        toastObj.show();

        if (duration && duration > 0) {
            setTimeout(function () {
                toastObj.hide();
            }, duration);
        }

        toast.on("hidden.bs.toast", function () {
            toast.remove();
        });
    }
});