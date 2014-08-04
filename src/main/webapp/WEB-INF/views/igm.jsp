<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
<!--
#statistics {
	width: 80%;
}

#statistics td {
	text-align: center;
}
-->
</style>


<h1>
	<span class='titleBlock'>&nbsp;</span><span>IGM - in silico intergrated genetic map</span>
</h1>

<br /><br />


<h2><i>B. oleracea</i> gentic marker</h2>
<form:form commandName="authorVO">
Author :  
<form:select path="authorIdx" items="${authors}" />
	<c:if test="${authorVO.trait != ''}">
	Trait : ${authorVO.trait}
</c:if>


	<input type="submit">
</form:form>




<br />
<img
	src='<c:url value="/images/geneticMap/${authorVO.authorIdx}.png" />'
	border="0" usemap="#chrmap">
<map name="chrmap">
	<area shape="rect" coords="100,10,120,400"
		href="<c:url value="/igm_map?authorIdx=${authorVO.authorIdx}&chrom=C1" />"
		title="C1">
	<area shape="rect" coords="200,10,220,480"
		href="<c:url value="/igm_map?authorIdx=${authorVO.authorIdx}&chrom=C2" />"
		title="C2">
	<area shape="rect" coords="300,10,320,560"
		href="<c:url value="/igm_map?authorIdx=${authorVO.authorIdx}&chrom=C3" />"
		title="C3">
	<area shape="rect" coords="400,10,420,480"
		href="<c:url value="/igm_map?authorIdx=${authorVO.authorIdx}&chrom=C4" />"
		title="C4">
	<area shape="rect" coords="500,10,520,450"
		href="<c:url value="/igm_map?authorIdx=${authorVO.authorIdx}&chrom=C5" />"
		title="C5">
	<area shape="rect" coords="600,10,620,380"
		href="<c:url value="/igm_map?authorIdx=${authorVO.authorIdx}&chrom=C6" />"
		title="C6">
	<area shape="rect" coords="700,10,720,460"
		href="<c:url value="/igm_map?authorIdx=${authorVO.authorIdx}&chrom=C7" />"
		title="C7">
	<area shape="rect" coords="800,10,820,380"
		href="<c:url value="/igm_map?authorIdx=${authorVO.authorIdx}&chrom=C8" />"
		title="C8">
	<area shape="rect" coords="900,10,920,480"
		href="<c:url value="/igm_map?authorIdx=${authorVO.authorIdx}&chrom=C9" />"
		title="C9">
</map>

<br />


<br />

<table id="statistics">
	<caption>*Statistics : total ${totalCnt}</caption>
	<thead>
		<tr>
			<th>Chromosome</th>
			<th>No. of Primers</th>
			<th>%</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="map" items="${chrCount}">
			<tr>
				<th width="100">${map.chrNo}</th>
				<td>${map.noMarker}</td>
				<td>${map.percent}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>