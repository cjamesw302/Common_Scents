//Checks to see if password and confirm password match in the registration form
function check(input) {
	if (input.value != document.getElementById('password').value) {
    	input.setCustomValidity('Password must be matching.');
    } 
    else {
    	input.setCustomValidity('');
    }
}