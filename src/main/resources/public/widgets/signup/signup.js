$(document).ready(function () {
    $('#signupButton').click(function (e) {

        e.preventDefault();
        debugger
        var name = $("#orangeForm-name").val();
        var email = $("#orangeForm-email").val();
        var password = $("#orangeForm-password").val();
        var confirmPassword = $("#orangeForm-confirm-password").val();
        var mobile = $("#orangeForm-mobile").val();

        if (password != confirmPassword) {
            alert("Password and Confirm Password are not equal");
            return;
        }





    });
});