var showSearchResult = function () {

    var searchValue = $('#formData').val();

    $.ajax({
        async: false,
        type: "GET",
        dataType: "text",
        url: '/search?formData=' + searchValue,
        success: function (data) {
            if (data)
                showResult(data);
            else alert("Search not Found");
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
};

var showResult = function (data) {
    var html = "";

    for (var itemData in data) {

        html += "<div class=\"col-md-3\">\n" +"<a href='javascript:showItemDetails("+data[itemData].id+");'>"+
            "                    <div class=\"product-item-1\">\n" +
            "                        <div class=\"product-thumb\" >\n" +
            "                            <img src="+data[itemData].images+" alt="+data[itemData].itemName +"> \n" +
            "                        </div> <!-- /.product-thumb -->\n" +
            "                        <div class=\"product-content\">\n" +
            "                            <h5><a href=\"#\"><span id=\"itemName\"> "+data[itemData].itemName +"</span></a></h5>\n" +
            "                            <span class=\"tagline\"><span id=\"address\"> "+ data[itemData].location +" </span></span>\n" +
            "                            <span class=\"price\"><span id=\"price\">"+ data[itemData].price +"</span></span>\n" +
            "                            <span class=\"h6\" ><span id=\"date\"> "+data[itemData].date +" </span></span>\n" +
            "                        </div> <!-- /.product-content -->\n" +
            "                    </div> <!-- /.product-item -->\n" +"</a>"+
            "</div> <!-- /.col-md-3 -->";


    }
    $('#products').html(html);

};