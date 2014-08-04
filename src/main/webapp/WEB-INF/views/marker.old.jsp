<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<h1>Marker</h1>
<br />

<link rel="stylesheet" type="text/css" media="screen"
	href="css/marker.css" />

<script>
	$(document).ready(
			function() {

				$(".pagelink").click(function() {
					//console.log($(this).attr("page"));
					$("#page").attr("value", $(this).attr("page"));
					$("#markerSearch").submit();
				});

				$("#all_checker").click(
						function() {
							console.log($(this).is(':checked'));
							if ($(this).is(':checked') == true) {
								$(".tabl_marker")
										.find("input[type='checkbox']").attr(
												"checked", true);
							} else {
								$(".tabl_marker")
										.find("input[type='checkbox']").attr(
												"checked", false);
							}
						});

			});
</script>


<div id="snpmarkertbl">
	<form:form id="markerSearch" modelAttribute="markerVO"
		autocomplete="off">
		<div class="search">
			<label for="chr">Chromosome</label>
			<form:select path="chr" items="${chrs}" />
			&nbsp; <label for="start">Loci between</label>
			<form:input path="start" size="8" class="num" />
			..
			<form:input path="end"  size="8" class="num" />
			<br> <label for="gene">Gene</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<form:input id="gene" path="gene" />
			<br> <label for="annot">annotation</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<form:input id="annot" path="annot" />
			<form:input path="page" type="hidden" />
			<br> <input type="submit"><input type="reset">
		</div>
	</form:form>
	<span>Total count : ${totalCnt}</span>
	<table class='tabl_marker'>
		<tr>
			<th><input id="all_checker" type="checkbox"></th>
			<th>Chrom.</th>
			<th>Loci</th>
			<th>Ref.</th>
			<th>ALT</th>
			<th>GT1</th>
			<th>GT2</th>
			<th>GT3</th>
			<th>GT4</th>
			<th>GT5</th>
			<th>GT6</th>
			<th>GT7</th>
			<th>GT8</th>
			<th>GT9</th>
			<th>GT10</th>
			<th>GT11</th>
			<th>GT12</th>
			<th>GT13</th>
			<th>GT14</th>
			<th>GT15</th>
			<th>GT16</th>
			<th>GT17</th>
			<th>GT18</th>
			<th>GT19</th>
			<th>GT20</th>
			<th>GT21</th>
			<th>GT22</th>
			<th>GT23</th>
			<th>GT24</th>
			<th>GT25</th>
			<th>GT26</th>
			<th>GT27</th>
			<th>GT28</th>
			<th>GT29</th>
			<th>Gene</th>
			<th>Tags</th>
			<th>Forward primer</th>
			<th>Reverse primer</th>
			<th>L tm</th>
			<th>R tm</th>
		</tr>
		<c:forEach var="makrerRec" items="${markers}" varStatus="status">
			<tr>
				<td><input type="checkbox" value="${makrerRec.id}"></td>
				<td>${makrerRec.id},${makrerRec.chrom}</td>
				<td>${makrerRec.loci}</td>
				<td>${makrerRec.ref}</td>
				<td>${makrerRec.alt}</td>
				<td>${makrerRec.gt1}</td>
				<td>${makrerRec.gt2}</td>
				<td>${makrerRec.gt3}</td>
				<td>${makrerRec.gt4}</td>
				<td>${makrerRec.gt5}</td>
				<td>${makrerRec.gt6}</td>
				<td>${makrerRec.gt7}</td>
				<td>${makrerRec.gt8}</td>
				<td>${makrerRec.gt9}</td>
				<td>${makrerRec.gt10}</td>
				<td>${makrerRec.gt11}</td>
				<td>${makrerRec.gt12}</td>
				<td>${makrerRec.gt13}</td>
				<td>${makrerRec.gt14}</td>
				<td>${makrerRec.gt15}</td>
				<td>${makrerRec.gt16}</td>
				<td>${makrerRec.gt17}</td>
				<td>${makrerRec.gt18}</td>
				<td>${makrerRec.gt19}</td>
				<td>${makrerRec.gt20}</td>
				<td>${makrerRec.gt21}</td>
				<td>${makrerRec.gt22}</td>
				<td>${makrerRec.gt23}</td>
				<td>${makrerRec.gt24}</td>
				<td>${makrerRec.gt25}</td>
				<td>${makrerRec.gt26}</td>
				<td>${makrerRec.gt27}</td>
				<td>${makrerRec.gt28}</td>
				<td>${makrerRec.gt29}</td>
				<td>${makrerRec.genes}</td>
				<td>${makrerRec.tags}</td>
				<td>${makrerRec.fprimer}</td>
				<td>${makrerRec.rprimer}</td>
				<td>${makrerRec.ltm}</td>
				<td>${makrerRec.rtm}</td>
			</tr>
		</c:forEach>
	</table>
	<div id="pager">
		<span> <c:forEach var="page" items="${pager.pages}"
				varStatus="status">
				<c:choose>
					<c:when test="${page == pager.curPage}">
						<b>${page+1}</b>
					</c:when>
					<c:otherwise>
						<a href="javascript:void();" page=${page+1 } class="pagelink">${page+1}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</span>
	</div>

</div>