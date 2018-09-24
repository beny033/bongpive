function check() {
	var password = document.getElementById('pw').value;
	
	if(isNaN(password)) {
		alert('숫자만 입력하세요.');
	} 
}


function goSubmit() {
	var password = document.getElementById('pw').value;
	
	if(!isNaN(password)) {
		document.form.submit();
	}
}