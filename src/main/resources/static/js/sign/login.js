$(document).ready(function () {
    const errorAlert = $(".errorAlert");

    if (errorAlert.length > 0) {
        setTimeout(function () {
            errorAlert.css({ opacity: 0, transition: "opacity 0.5s ease-in-out" });

            setTimeout(function () {
                errorAlert.remove();
            }, 500);
        }, 3000);
    }
});