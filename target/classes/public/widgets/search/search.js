var showSearchResult = function(){

    var searchValue = $('#formData').val();
    debugger
    $.ajax({
        async:false,
        type: "GET",
        dataType: "text",
        url: '/search?formData='+searchValue,
        success: function (data) {
           // debugger
            alert(data);
        },
        error: function (error) {
            alert(error);
            console.log(error);
        },
        failure: function (fail) {
            alert(fail);
            console.log(fail);
        }
    });
}