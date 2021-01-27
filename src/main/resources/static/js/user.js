let index = {
	init: function() {
		$("#btn-signup").on("click", () => {	// To bind 'this', use arrow function
			this.save();
		});
	},
	
	save: function() {
		// alert("Save function called.");
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		
		// console.log(data);
		
		// Requesting Insert using ajax asynchronous method, changing 3 data to json
		// In default, asynchronous call
		$.ajax({
			type: "POST",
			url: "/blog/api/user",
			data: JSON.stringify(data),	// Converting JS object to JSON string (http body data)
			contentType: "application/json; charset=utf-8",	// body data type (MIME)
			dataType: "json"	// Responsed in JSON string, converting to JS object, pass to done()
			
		}).done(function(res) {
			alert("Sign up is completed");
			//console.log(res);
			location.href = "/blog";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
		
	}
}

index.init();