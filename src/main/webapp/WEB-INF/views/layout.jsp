<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>

<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link href="<c:url value='/css/style.css' />" rel="stylesheet"
	type="text/css" media="screen" />
<link rel="stylesheet"
	href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<script src="<c:url value='/js/jcanvas.min.js' />"></script>
<script type="text/javascript">
	if (typeof String.prototype.trim !== 'function') {
		String.prototype.trim = function() {
			return this.replace(/^\s+|\s+$/g, '');
		}
	}
</script>

</head>
<body>
	<div id='topline'></div>
	<div id='headerBox'>
		<tiles:insertAttribute name="header" />
	</div>
	<div id='mainBox'>
		<div id='menuBox'>
			<tiles:insertAttribute name="menu" />
		</div>
		<div id='bodyBox'>
			<tiles:insertAttribute name="body" />
		</div>
		<div id='footerBox'>
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>