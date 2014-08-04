<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<script>
	$('document').ready( function() {
	
		$("#chrom").change(function(e){			
			var src = $("#hvr").attr("src");
			var pattern = /C[1-9]/;
			var newsrc = src.trim().replace(pattern,$(this).val());			
			$("#hvr").attr("src",newsrc);
		});		
		
	});
</script>

<h1><span class="titleBlock">&nbsp;</span><span>HVR - Highly Variable Region</span></h1>
<br /><br />

<label for="chrom">Chromosome : </label>
<select id="chrom">
	<option value="C1">C1
	<option value="C2">C2
	<option value="C3">C3
	<option value="C4">C4
	<option value="C5">C5
	<option value="C6">C6
	<option value="C7">C7
	<option value="C8">C8
	<option value="C9">C9
</select>

<div style="width: 1180px; margin: 0 auto;">

	<img id="hvr" src='<c:url value="/images/hvr/C1.png" />'>

</div>