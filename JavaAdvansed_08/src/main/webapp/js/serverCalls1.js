
$("button.createMagazine")
		.click(
				function() {
					
					var name = $("form.createMagazine input.magazineName").val();
					var publishDate = $("form.createMagazine input.magazinePublishDate").val();
					var price = $("form.createMagazine input.magazinePrice").val();
				
						var magazine = {
								name : name,
								publishDate : publishDate,
								price : price
						};
//add validation
						$.post("magazine", magazine,
								function(data) {
									if (data == 'Success') {
//										$("form")[0].reset();
//										$("form")[1].reset();
//										showAlertAfterRegistration();
										alert('Success');
									}
								});
					
				});
