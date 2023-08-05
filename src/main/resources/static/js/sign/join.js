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
                    $(".error-message").text("");

                    Object.keys(errors).forEach(function (key) {
                        var errorMessage = errors[key];
                        $("#" + key + "Error").text(errorMessage).css("color", "red");
                    });
                } else {
                    var errorMessage = "이미 등록된 이메일입니다.";
                    showToast(errorMessage,3000);
                }
            }
        });
    });

    function showToast(message, duration) {
        var toastContainer = $("#toastContainer");

        var toast = $("<div class='toast' role='alert' aria-live='assertive' aria-atomic='true'></div>");
        toast.addClass("bg-danger text-white"); // 빨간색 배경과 흰색 글자색을 적용

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

        // 토스트가 사라진 후에 컨테이너에서 제거합니다.
        toast.on("hidden.bs.toast", function () {
            toast.remove();
        });
    }
});