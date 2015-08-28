var $ = function (id) {
    return document.getElementById(id); 
}

function calculate_click(){
	var sub = parseFloat($("subtotal").value);
	var tax = parseFloat($("taxRate").value);

	if(isNaN(sub) || sub < 0){
		alert("Sub Total must be a positive number!");
	}
	else if(isNaN(tax) || tax < 0){
		alert("Tax rate must be a positive number");
	}
	else{
		
	var salesTax = (sub * tax) / 100;
	salesTax = parseFloat(salesTax.toFixed(2));
	var total = sub + salesTax;
	
	$("salesTax").value=salesTax;
	$("total").value=total.toFixed(2);
	}
}

window.onload = function () {
	 $("calculate").onclick = calculate_click;
	 $("subtotal").focus;
	}

