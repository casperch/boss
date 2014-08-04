<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<style>
<!--
.markerCntTbl td{
	text-align: right;
	padding-right: 5px;
}
-->
</style>

<h1><span class='titleBlock'>&nbsp;</span><span>Markers</span></h1>
<br /><br />

<script>
	$(document).ready(function() {
		$("a.chrMove").click(function(e) {
			$("#markerType").val($(this).attr("markerType"));
			$("#chrom").val($(this).attr("chrom"));
			$("#moveChr").submit();
			e.preventDefault();
		});
	});
</script>

<div>

	<table class="markerCntTbl">
		<caption>Marker Count</caption>
		<thead>
			<tr>
				<th>&nbsp;</th>
				<c:forEach var="i" begin="1" end="9">
					<th>C0${i}</th>
				</c:forEach>
				<th>Sum</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>SNP</th>
				<c:forEach var="i" begin="1" end="9">
					<c:set var="chrom" value="C0${i}" />
					<td><a class="chrMove"
						href='<c:url value="/chrMarker?markerType=SNP&chrom=${chrom}" />'
						markerType="SNP" chrom="${chrom}"> <fmt:formatNumber
								value="${snpCount[chrom]}" pattern="#,###" /></a></td>
				</c:forEach>
				<td><fmt:formatNumber value="${snpCount['sum']}"
						pattern="#,###" /></td>
			</tr>
			<tr>
				<th>InDel</th>
				<c:forEach var="i" begin="1" end="9">
					<c:set var="chrom" value="C0${i}" />
					<td><a class="chrMove"
						href='<c:url value="/chrMarker?markerType=InDel&chrom=${chrom}" />'
						markerType="InDel" chrom="${chrom}"><fmt:formatNumber
								value="${indelCount[chrom]}" pattern="#,###" /></a></td>
				</c:forEach>
				<td><fmt:formatNumber value="${indelCount['sum']}"
						pattern="#,###" /></td>
			</tr>
			<tr>
				<th>SSR</th>
				<c:forEach var="i" begin="1" end="9">
					<c:set var="chrom" value="C0${i}" />
					<td><a class="chrMove"
						href='<c:url value="/chrMarker?markerType=SSR&chrom=${chrom}" />'
						markerType="SSR" chrom="${chrom}"><fmt:formatNumber
								value="${ssrCount[chrom]}" pattern="#,###" /></a></td>
				</c:forEach>
				<td><fmt:formatNumber value="${ssrCount['sum']}"
						pattern="#,###" /></td>
			</tr>
		</tbody>
	</table>

</div>

<form id="moveChr" action='<c:url value="/chrMarker" />' method="post">
	<input type="hidden" id="markerType" name="markerType"> <input
		type="hidden" id="chrom" name="chrom">
</form>
