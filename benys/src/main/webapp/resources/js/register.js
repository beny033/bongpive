function checkPw() {
	var tbl_password = document.getElementById('tbl_password').value;
	var checkMSG = document.getElementById('checkMSG');
	
	checkMSG.style.color = 'red';

	if(isNaN(tbl_password) || tbl_password.indexOf(' ') !== -1 || tbl_password.length < 4) {
		checkMSG.innerHTML = '형식이 올바르지 않습니다.';
	} else {
		checkMSG.style.color = '#2171d4';
		checkMSG.innerHTML = 'Ok';
	}
}

function checkSubmit() {
	var tbl_password = document.getElementById('tbl_password').value;
	
	var writer = document.getElementById('tbl_writer');
	var title = document.getElementById('tbl_title');
	var content = document.getElementById('tbl_content');
	
	
	if(writer.value == "" || title.value == "" || content.value == "") {
		alert('입력란을 확인하세요.');
	} else {
		if(isNaN(tbl_password) || tbl_password.indexOf(' ') !== -1 || tbl_password.length < 4){
			alert('비밀번호를 확인하세요.');
		} else {
			document.form.submit();
		}
	}
}
