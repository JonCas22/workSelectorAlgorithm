<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<c:url value="/css/jquery.jsonPresenter.css" var="jstlJsonCss" />
<link href="${jstlJsonCss}" rel="stylesheet" />

<c:url value="/js/jquery.jsonPresenter.js" var="jstlJsonJs" />
<script src="${jstlJsonJs}"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#companySelect').change(function() {
			getCompanyinfo();
		});
		
		getCompanyinfo();
	});

	function getCompanyinfo() {
		var url = "http://localhost:8080/App/company/"
				+ $('#companySelect option:selected').val();
		$.ajax({
			url : url,
			type : 'get',
		}).done(function(response) {
			console.log("Response: " + response);
			$('#json-container').jsonPresenter({
				json : JSON.parse(response)
			});
			$('#json-container').jsonPresenter('expandAll');
			
			//$('#textFieldContent').text(response);
		}).fail(function() {
			console.log("FAIL");
		});
	}
</script>

</head>
<body>
	<fieldset class="color-black">
		<select id="companySelect" class="selector" name="company">
			<c:forEach items="${companies}" var="company">
				<option value="${company.name}">${company.name}</option>
			</c:forEach>
		</select>
		<fieldset id="textFieldContent" name="textFieldContent" class="text-container"><div id="json-container"></div></fieldset>
		<a href="postman"><button>Next Page</button></a>
	</fieldset>
	
</body>

</html>