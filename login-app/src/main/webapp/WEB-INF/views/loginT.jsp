<html>
<head>
<script type="text/javascript"
src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<!-- <script type="text/javascript">           
function makeSearch()
            {
                if(validateIdata())
                {
                	
                }
            }

            function validateIdata()
            {
                if($('#username').val() =='')
                {
                    alert("Invalid Name");
                    return false;
                }

                if($('#password').val() =='')
                {
                    alert("Invalid Password");
                    return false;
                }

                return true;
            }
        </script>
 -->        
       <!--  <script>
		jQuery(document).ready(function($) {
			$("#login").click(function() {
				if ($('#username').val() == '') {
					alert('User ID can not be left blank');
					return false;
				}
				if ($('#password').val() == '') {
					alert('Password can not be left blank');
					return false;
				}
				var loginData = {};
				loginData["username"] = $("#username").val();
				loginData["password"] = $("#password").val();
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "login",
					data : JSON.stringify(loginData),
					dataType : 'json',
					success : function(data) {
						var errorMessage = data.errorMessage;
						if (data.errorCode == 0) {
							alert(errorMessage)
						} else {
							alert(errorMessage);
						}
					}
				});
			});
		});
	</script> -->
	
	
	<script type="text/javascript">
		jQuery(document).ready(
				function($) {
					$("#login").click(
							function() {
								if ($('#username').val() == '') {
									alert('User ID can not be left blank');
									return false;
								}
								if ($('#password').val() == '') {
									alert('Password can not be left blank');
									return false;
								}
								var loginData = {};
								loginData["username"] = $("#username").val();
								loginData["password"] = $("#password").val();
								$.ajax({
									type : "POST",
									contentType : "application/json",
									url : "/login",
									data : JSON.stringify(loginData),
									dataType : 'json',
									success : function(response) {
									alert(response.status.statusCodeValue);
									}
								});
							});
				});
	</script>
        
</head>
<body>
	<form>
		Username: <input type="text" id="username" name="username" /> 
		Password: <input type="password" id="password" name="password" />
		<input type="button" id="login"  />
	</form>
</body>
</html>