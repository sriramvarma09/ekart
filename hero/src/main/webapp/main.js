/**
 * 
 */function login(){
	 console.log("login");
	 			var username = $('#log-logemail').val();
				var password = $('#log-logpass').val();
				var errorDiv = $('#loginError');
				
				errorDiv.html('');
				console.log(username)
				// Perform client-side validations
				if (!username || !password) {
					errorDiv.html('Username and password are required.');
					return false;
				}

				// Send AJAX request to validate credentials
				$.ajax({
					url: 'http://localhost:8080/hero/login', 
					method: 'POST',
					data: { username: username, password: password },
					success: function(response) {
						if (response.valid) {
							window.location.href = response.url;
						} else {
							errorDiv.html('Invalid username or password.');
						}
					},
					error: function(xhr, status, error) {
						errorDiv.html('Error occurred while processing the request.');
					}
				});
			}
function registerUser() {
            var username = $('#reg-logname').val();
            var email = $('#reg-logemail').val();
            var password = $('#reg-logpass').val();
            var confirmPassword = $('#reg-confirmlogpass').val();
            var errorDiv = $('#registerError');
            errorDiv.html('');

            // Perform client-side validations
            if (!username || !email || !password || !confirmPassword) {
                errorDiv.html('All fields are required.');
                return false;
            }

            if (password !== confirmPassword) {
                errorDiv.html('Passwords do not match.');
                return false;
            }

            $.ajax({
                url: 'http://localhost:8080/hero/createUser', 
                method: 'POST',
                data: { username: username, email: email, password: password },
                success: function(response) {
                    if (response.success) {
                        window.location.href = 'http://localhost:8080/hero/customer-login.jsp';
                    } else {
                        errorDiv.html('Registration failed. Please try again.');
                    }
                },
                error: function(xhr, status, error) {
                    errorDiv.html('Error occurred while processing the request.');
                }
            })
        }
