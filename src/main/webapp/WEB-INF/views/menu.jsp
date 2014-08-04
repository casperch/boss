<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class=menu_ul>
	<li><a href="<c:url value='/' />">Home</a></li>
	<li><a href="<c:url value='/browser' />">Browser</a></li>
	<li><a href="<c:url value='/marker' />">Marker</a></li>
	<li><a href="<c:url value='/tm' />" title="Trait Map">TM</a></li>	 
	<li><a href="<c:url value='/igm' />" title="in silico intergrated genetic map">IGM</a></li>
	<li><a href="<c:url value='/hvr' />" title="Highly Variable Region">HVR</a></li>
	<!--<li><a href="<c:url value='/download' />">Download</a></li>  -->
</ul>