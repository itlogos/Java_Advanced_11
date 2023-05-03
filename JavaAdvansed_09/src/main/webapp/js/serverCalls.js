
$("button.createMagazine")
		.click(
				function() {
					
					var name = $("form.createMagazine input.magazineName").val();
					var description = $("form.createMagazine input.magazineDescription").val();
					var price = $("form.createMagazine input.magazinePrice").val();
				
						var magazine = {
								name : name,
								description : description,
								price : price
						};
//add validation
						$.post("magazine", magazine,
								function(data) {
									if (data == 'Success') {
										alert('Success');
									}
								});
					
				});
$("button.buy-magazine").click(function() {
	var magazineId = jQuery(this).attr("magazine-id");
	
	
	$.post("subscribe", {'magazineId':magazineId},
			function(data) {
				if (data == 'Success') {
$("[data-dismiss=modal]").trigger({ type: "click" });
					alert('Success');
				}
			});
});