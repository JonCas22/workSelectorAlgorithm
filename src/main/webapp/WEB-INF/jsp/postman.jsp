<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<c:url value="/css/jquery.jsonPresenter.css" var="jstlJsonCss" />

<link href="${jstlJsonCss}" rel="stylesheet" />

<c:url value="/js/jquery.jsonPresenter.js" var="jstlJsonJs" />
<script src="${jstlJsonJs}"></script>


<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		$('#btnSend').on('click', function() {
			getCompanyinfo();

		});
	});

	function getCompanyinfo() {
		var url = $('#inputURL').val();
		$.ajax({
			url : url,
			type : 'get',
		}).done(function(response) {
			console.log("Response: " + $.parseHTML(response));
			$('#json-container').jsonPresenter({
				json : JSON.parse(response)
			});
			$('#json-container').jsonPresenter('expandAll');
		}).fail(function() {
			console.log("FAIL");
		});
	}
</script>
</head>
<body>
	<fieldset class="color-black">
		<input class="selector" type="text" id="inputURL"
			placeholder="Insert your URL">
		<button class="button" id="btnSend">SEND</button>
		<fieldset id="textFieldContent" name="textFieldContent"
			class="text-container2">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h3>Postman</h3>
						<div class="container">
							<div class="row">
								<div class="col-xs-12 text-container3">
									<nav>
										<div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
											<a class="nav-item nav-link active" id="nav-home-tab"
												data-toggle="tab" href="#nav-home" role="tab"
												aria-controls="nav-home" aria-selected="true">Body</a> <a
												class="nav-item nav-link" id="nav-profile-tab"
												data-toggle="tab" href="#nav-profile" role="tab"
												aria-controls="nav-profile" aria-selected="false">Cookies</a>
											<a class="nav-item nav-link" id="nav-contact-tab"
												data-toggle="tab" href="#nav-contact" role="tab"
												aria-controls="nav-contact" aria-selected="false">Headers</a>
										</div>
									</nav>
									<div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">
										<div class="tab-pane fade show active" id="nav-home"
											role="tabpanel" aria-labelledby="nav-home-tab">
											<div id="json-container"></div>
										</div>
										<div class="tab-pane fade" id="nav-profile" role="tabpanel"
											aria-labelledby="nav-profile-tab">
											<c:forEach var="cookies" items="${cookie}">

												<strong>Name=<c:out value="${cookies.key}" /></strong> Object=<c:out
													value="${cookies.value} " />, value=<c:out
													value="${cookies.value.value}" />
												<br />

											</c:forEach>
										</div>
										<div class="tab-pane fade margin-left" id="nav-contact" role="tabpanel"
											aria-labelledby="nav-contact-tab">
											<c:forEach var="nextHeader" items="${header}">
												<p><c:out value="${nextHeader.key}" /> = <c:out
														value="${nextHeader.value}" />
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</fieldset>
		<a href="/App"><button>Back</button></a>
	</fieldset>
</body>
</html>