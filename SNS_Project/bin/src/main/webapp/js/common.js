$(function(){
	if($("#check").val()==''){
		alert("로그인을 해주세요");
		location.href = '/';
	}
	
})


function check_id() {	
	if ($("#check").val()=='' || $("#check").val()==null) {
		alert("로그인을 해주세요");
		$("#goProfile1").attr("href","/");
		$("#goProfile2").attr("href","/");
		$("#goProfile3").attr("href","/");
		$("#goProfile4").attr("href","/");
		$("#goProfile5").attr("href","/");
	}
}