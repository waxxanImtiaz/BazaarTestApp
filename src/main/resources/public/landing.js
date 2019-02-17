
$(document).ready(function(){

	$("#products").load('widgets/product/product_item.html');

	$('#products').load('widgets/product/product_item.html',
		getItemByCategory('Phone'));
});



var _baseURL = "http://localhost:8111";
var _itemsByCategoryURL = _baseURL+'/list/';
var getItemByCategory = function(category,callBackMethod){

	var finalURL = _itemsByCategoryURL+category;

	$.ajax({
		async:false,
		type: "GET",
		dataType: "json",
		url: finalURL,
		success: function (data) {
			debugger
			var products = document.getElementById("products");
			for (var item in data) {
				var cols = document.getElementById("col-md-3");
				cols.getElementById("itemName").innerHTML = data[item].itemName;
				cols.getElementById("price").innerHTML = data[item].price;
				cols.getElementById("date").innerHTML = data[item].date;
				cols.getElementById("address").innerHTML = data[address].date;

				products.add(cols);

			}
			alert(data[0].itemName);

		},
		error: function (error) {
			console.log(error);
		},
		failure: function (fail) {
			console.log(fail);
		}
	});
};


