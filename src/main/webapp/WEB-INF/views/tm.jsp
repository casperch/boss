<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<style>
<!--
.groupA {
	/* background-color: #EFEFEF; */	
	background-color: #DDEEDD;
}

.groupB {
	/* background-color: #EFFFEE; */
	background-color: #EEDDDD;
}

#myform span {
	display: inline-block;
	width: 150px;
}

.table_marker td {
	text-align: center;
}

.table_marker .text_right {
	text-align: right;
	padding-right: 3px;
}

.table_marker .text_left {
	text-align: left;
	padding-left: 3px;
}

-->
</style>
<script>
	$("document").ready(function() {

		$("#btn_apply").click(function() {
			$("#myform").submit();
		});

		$("#btn_reset").click(function(e) {
			e.preventDefault();
			$("#myform input[type='checkbox']").each(function() {
				$(this).prop("checked", false);
			});

		});

		$("#myform [name^='group']").change(function() {
			var source_id = $(this).attr("id");
			var target_id = "";
			if ($(this).attr("name") == "groupA")
				target_id = source_id.replace("A", "B");
			else if ($(this).attr("name") == "groupB")
				target_id = source_id.replace("B", "A");
			if ($(this).prop("checked"))
				$("#" + target_id).prop("checked", false);

		});

	});
</script>
<h1><span class='titleBlock'>&nbsp;</span><span>Trait Map</span></h1>
<br /><br />


<h3>Search</h3>

<div>
	<form:form id="myform" commandName="tmVO" method="POST">

		<label for="chrom">Chromosome : </label>
		<form:select path="chrom" id="chrom">
			<form:option value="all" label="All" />
			<form:option value="C1" />
			<form:option value="C2" />
			<form:option value="C3" />
			<form:option value="C4" />
			<form:option value="C5" />
			<form:option value="C6" />
			<form:option value="C7" />
			<form:option value="C8" />
			<form:option value="C9" />
		</form:select>

		<label for="tags">Tag : </label>
		<form:select path="tags" id="tags">
			<form:option value="all" label="All" />
			<form:option value="exon" label="Exon" />
			<form:option value="intron" label="Intron" />
			<form:option value="upstream" label="Upstream" />
			<form:option value="intergenic" label="Intergenic" />
		</form:select>

		<fieldset class="groupA">
			<legend>Group1</legend>
			<c:forEach var="trait" items="${traits}" varStatus="status">
				<span> <form:checkbox id="groupA_${status.index}"
						path="groupA" name="groupA" value="${trait.getCode()}" /> <label
					for="groupA_${status.index}" title="${trait.getTrait()}">${trait.getCode()}</label>
				</span>
			</c:forEach>
		</fieldset>
		<div class='text_center'>
			<img src='<c:url value="/images/not_equal.png" />'>
		</div>
		<fieldset class="groupB">
			<legend>Group2</legend>
			<c:forEach var="trait" items="${traits}" varStatus="status">
				<span> <form:checkbox id="groupB_${status.index}"
						path="groupB" name="groupB" value="${trait.getCode()}" /> <label
					for="groupB_${status.index}" title="${trait.getTrait()}">${trait.code}</label>
				</span>
			</c:forEach>
		</fieldset>


		<br />

		<button id="btn_apply">apply</button>
		<button id="btn_reset">reset</button>

	</form:form>
</div>


<br />

<c:if test="${markers.size() > 0}">
	<span>Total count : ${markers.size()}</span>
	<table class='table_marker'>
		<tr>
			<th rowspan="2">Chrom.</th>
			<th rowspan="2">Loci</th>
			<th rowspan="2">Ref.</th>
			<th rowspan="2">ALT</th>

			<th colspan="${tmVO.groupAcnt}">Group1</th>
			<th colspan="${tmVO.groupBcnt}">Group2</th>

			<th rowspan="2">Gene</th>
			<th rowspan="2">Tags</th>
			<th rowspan="2">Forward primer</th>
			<th rowspan="2">Reverse primer</th>
			<th rowspan="2">Forward Tm</th>
			<th rowspan="2">Reverse Tm</th>
		</tr>

		<tr>
			<c:forEach var="ga" items="${tmVO.groupA }">
				<th>${ga}</th>
			</c:forEach>
			<c:forEach var="gb" items="${tmVO.groupB }">
				<th>${gb}</th>
			</c:forEach>
		</tr>

		<c:forEach var="makrerRec" items="${markers}" begin="0" end="100"
			varStatus="status">
			<tr>
				<td>${makrerRec.chrom}</td>
				<td class="text_right"><fmt:formatNumber value="${makrerRec.loci}" pattern="#,###" /></td>
				<td>${makrerRec.ref}</td>
				<td>${makrerRec.alt}</td>

				<c:forEach var="ga" items="${tmVO.groupA }">
					<c:if test="${ga == 'K0001'}"><td class='groupA'>${makrerRec.k0001}</td></c:if>
					<c:if test="${ga == 'K0002'}"><td class='groupA'>${makrerRec.k0002}</td></c:if>
					<c:if test="${ga == 'K0003'}"><td class='groupA'>${makrerRec.k0003}</td></c:if>
					<c:if test="${ga == 'K0004'}"><td class='groupA'>${makrerRec.k0004}</td></c:if>
					<c:if test="${ga == 'K0005'}"><td class='groupA'>${makrerRec.k0005}</td></c:if>
					<c:if test="${ga == 'K0006'}"><td class='groupA'>${makrerRec.k0006}</td></c:if>
					<c:if test="${ga == 'K0007'}"><td class='groupA'>${makrerRec.k0007}</td></c:if>
					<c:if test="${ga == 'K0008'}"><td class='groupA'>${makrerRec.k0008}</td></c:if>
					<c:if test="${ga == 'K0009'}"><td class='groupA'>${makrerRec.k0009}</td></c:if>
					<c:if test="${ga == 'K0010'}"><td class='groupA'>${makrerRec.k0010}</td></c:if>
					<c:if test="${ga == 'K0011'}"><td class='groupA'>${makrerRec.k0011}</td></c:if>
					<c:if test="${ga == 'K0012'}"><td class='groupA'>${makrerRec.k0012}</td></c:if>
					<c:if test="${ga == 'K0013'}"><td class='groupA'>${makrerRec.k0013}</td></c:if>
					<c:if test="${ga == 'K0014'}"><td class='groupA'>${makrerRec.k0014}</td></c:if>
					<c:if test="${ga == 'K0015'}"><td class='groupA'>${makrerRec.k0015}</td></c:if>
					<c:if test="${ga == 'K0016'}"><td class='groupA'>${makrerRec.k0016}</td></c:if>
					<c:if test="${ga == 'K0017'}"><td class='groupA'>${makrerRec.k0017}</td></c:if>
					<c:if test="${ga == 'K0018'}"><td class='groupA'>${makrerRec.k0018}</td></c:if>
					<c:if test="${ga == 'K0019'}"><td class='groupA'>${makrerRec.k0019}</td></c:if>
					<c:if test="${ga == 'K0020'}"><td class='groupA'>${makrerRec.k0020}</td></c:if>					
					<c:if test="${ga == 'K0021'}"><td class='groupA'>${makrerRec.k0021}</td></c:if>
					<c:if test="${ga == 'K0022'}"><td class='groupA'>${makrerRec.k0022}</td></c:if>					
					<c:if test="${ga == 'K0023'}"><td class='groupA'>${makrerRec.k0023}</td></c:if>
					<c:if test="${ga == 'K0024'}"><td class='groupA'>${makrerRec.k0024}</td></c:if>					
					<c:if test="${ga == 'K0025'}"><td class='groupA'>${makrerRec.k0025}</td></c:if>
					<c:if test="${ga == 'K0026'}"><td class='groupA'>${makrerRec.k0026}</td></c:if>					
					<c:if test="${ga == 'K0027'}"><td class='groupA'>${makrerRec.k0027}</td></c:if>
					<c:if test="${ga == 'K0028'}"><td class='groupA'>${makrerRec.k0028}</td></c:if>					
					<c:if test="${ga == 'K0029'}"><td class='groupA'>${makrerRec.k0029}</td></c:if>
				</c:forEach>
				
				<c:forEach var="gb" items="${tmVO.groupB }">
					<c:if test="${gb == 'K0001'}"><td class='groupB'>${makrerRec.k0001}</td></c:if>
					<c:if test="${gb == 'K0002'}"><td class='groupB'>${makrerRec.k0002}</td></c:if>
					<c:if test="${gb == 'K0003'}"><td class='groupB'>${makrerRec.k0003}</td></c:if>
					<c:if test="${gb == 'K0004'}"><td class='groupB'>${makrerRec.k0004}</td></c:if>
					<c:if test="${gb == 'K0005'}"><td class='groupB'>${makrerRec.k0005}</td></c:if>
					<c:if test="${gb == 'K0006'}"><td class='groupB'>${makrerRec.k0006}</td></c:if>
					<c:if test="${gb == 'K0007'}"><td class='groupB'>${makrerRec.k0007}</td></c:if>
					<c:if test="${gb == 'K0008'}"><td class='groupB'>${makrerRec.k0008}</td></c:if>
					<c:if test="${gb == 'K0009'}"><td class='groupB'>${makrerRec.k0009}</td></c:if>
					<c:if test="${gb == 'K0010'}"><td class='groupB'>${makrerRec.k0010}</td></c:if>
					<c:if test="${gb == 'K0011'}"><td class='groupB'>${makrerRec.k0011}</td></c:if>
					<c:if test="${gb == 'K0012'}"><td class='groupB'>${makrerRec.k0012}</td></c:if>
					<c:if test="${gb == 'K0013'}"><td class='groupB'>${makrerRec.k0013}</td></c:if>
					<c:if test="${gb == 'K0014'}"><td class='groupB'>${makrerRec.k0014}</td></c:if>
					<c:if test="${gb == 'K0015'}"><td class='groupB'>${makrerRec.k0015}</td></c:if>
					<c:if test="${gb == 'K0016'}"><td class='groupB'>${makrerRec.k0016}</td></c:if>
					<c:if test="${gb == 'K0017'}"><td class='groupB'>${makrerRec.k0017}</td></c:if>
					<c:if test="${gb == 'K0018'}"><td class='groupB'>${makrerRec.k0018}</td></c:if>
					<c:if test="${gb == 'K0019'}"><td class='groupB'>${makrerRec.k0019}</td></c:if>
					<c:if test="${gb == 'K0020'}"><td class='groupB'>${makrerRec.k0020}</td></c:if>					
					<c:if test="${gb == 'K0021'}"><td class='groupB'>${makrerRec.k0021}</td></c:if>
					<c:if test="${gb == 'K0022'}"><td class='groupB'>${makrerRec.k0022}</td></c:if>					
					<c:if test="${gb == 'K0023'}"><td class='groupB'>${makrerRec.k0023}</td></c:if>
					<c:if test="${gb == 'K0024'}"><td class='groupB'>${makrerRec.k0024}</td></c:if>					
					<c:if test="${gb == 'K0025'}"><td class='groupB'>${makrerRec.k0025}</td></c:if>
					<c:if test="${gb == 'K0026'}"><td class='groupB'>${makrerRec.k0026}</td></c:if>					
					<c:if test="${gb == 'K0027'}"><td class='groupB'>${makrerRec.k0027}</td></c:if>
					<c:if test="${gb == 'K0028'}"><td class='groupB'>${makrerRec.k0028}</td></c:if>					
					<c:if test="${gb == 'K0029'}"><td class='groupB'>${makrerRec.k0029}</td></c:if>
				</c:forEach>


				<td>${makrerRec.genes}</td>
				<td>${makrerRec.tags}</td>
				<td class="text_left">${makrerRec.fprimer}</td>
				<td class="text_left">${makrerRec.rprimer}</td>
				<td class="text_right">${makrerRec.ltm}</td>
				<td class="text_right">${makrerRec.rtm}</td>
			</tr>
		</c:forEach>

	</table>

</c:if>

<c:if test="${markers.size() == 0}">검색 결과가 없어요</c:if>