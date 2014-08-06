<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<link rel="stylesheet" type="text/css" media="screen"
	href="css/marker.css" />

<style>
<!--
table {
	border-collapse: collapse;
	width: 900px;
	font-size: 14px;
}

th {
	font-size: 14px;
}

td {
	font-size: 12px;
}

#chrBar {
	display: inline-block;
}

#chrBar canvas {
	/* background-color: black; */
	
}

#markerTable {
	display: inline-table;
	vertical-align: top;
	width: 800px;
}

#markerTable caption {
	text-align: left
}

#startPos,#endPos {
	width: 100px;
	text-align: right;
}
-->
</style>

<script>
	$(document).ready(function() {
		//alert("페이지 작업중");

		$("a[data-name='detail']").click(function(){
			var url = "markerDetail?chrom=";
			var chrom = "${chrMarkerVO.chrom}";
			var loci = $(this).attr("data-loci");
			var markerType = "${markerType}";
			url += chrom;
			url += "&loci=" + loci;
			url += "&markerType=" + "${chrMarkerVO.markerType}";
			alert(url);
			window.open(url);
		});		

		var canvas = $('canvas.chrCanvas');
		var rateChrlen = parseInt(eval("${curChrLen} * ${rate}"));
		var slider_y = eval("(${chrMarkerVO.startPos} - 1) * ${rate}");
		var slider_height = eval("(${chrMarkerVO.endPos} - ${chrMarkerVO.startPos}) * ${rate} + 1");

		//console.log(slider_height);
		

		//chromosome
		canvas.drawLine({
			layer : true,
			x1 : 10,
			y1 : 10,
			x2 : 10,
			y2 : rateChrlen + 10
		}).drawLine({
			layer : true,
			x1 : 30,
			y1 : 10,
			x2 : 30,
			y2 : rateChrlen + 10
		}).drawArc({
			layer : true,
			x : 20,
			y : 10,
			start : -90,
			end : 90,
			radius : 10
		}).drawArc({
			layer : true,
			x : 20,
			y : rateChrlen + 10,
			start : 90,
			end : -90,
			radius : 10
		});		
		
		canvas.setLayers({
			fillstyle : '#000',
			strokeStyle : '#000',
			strokeWidth : 1
		}).drawLayers();
		
		
		
		
		$.ajax({
			type : "POST",
			url : "<c:url value="/markerDist.json" />",						
			async : false,
			data : $("#chrMarkerForm").serialize(),
			success : function(data) {
				
				var h = 1000000 * ${rate} + 1;				
				$.each(data, function(k,v){
					var p = ${totalCnt} / v + 50 ;
					p = parseInt(p) + 50;					
					var y = Math.round( k * ${rate} ) + 10;										
					var color = 'rgb('+p+', '+p+', '+p+')';					
					canvas.drawRect({
						layer : true,
						fillStyle : color,
						fromCenter : false,
						x : 10,
						y : y,
						width: 20,
						height: h
					});					
					
				});
				
			},
			beforeSend : function() {

			},
			error : function(e) {							
				alert("데이터 로드 오류, 잠시 후 새로 고침");
			}

		});
		

		canvas.drawRect({
			layer : true,
			fillstyle : '#000',
			fromCenter : false,
			x : 10,
			y : 10,
			width: 20,
			height : rateChrlen,
			click : function(layer) {
				var y_pos = layer.mouseY;
				var slider = canvas.getLayer("slider");						
				if ((y_pos + slider.height) >= (rateChrlen + 20)) {
					y_pos = rateChrlen - slider.height + 10;
				}						

				canvas.animateLayer('slider', {
					y : y_pos
				}, 400, function(layer){
					console.log(layer.y, layer.height);
					var startPos = parseInt(((layer.y - 10) / ${rate})+1);
					var endPos = Math.round((layer.y + layer.height - 10 - 1) / ${rate})+1;
					$("#startPos").val(startPos);
					$("#endPos").val(endPos);
					$("#chrMarkerForm").submit();
				});							
				
			}
		}).drawRect({
			layer : true,
			name : "slider",
			draggable : true,
			fillStyle : 'rgba(0, 153, 0, 0.5)',
			fromCenter : false,
			x : 5,
			y : slider_y + 10,
			width : 30,
			height : slider_height,
			dragstart : function() {
			},
			drag : function(layer) {
				layer.x = 5;
				if (layer.y < 10) {
					layer.y = 10;
				}
				if (layer.y + layer.height + 10 > rateChrlen + 10) {
					layer.y = rateChrlen + 10
							- layer.height;
				}						
			},
			dragstop : function(layer) {
				var startPos = parseInt(((layer.y - 10) / ${rate})+1);
				var endPos = Math.round((layer.y + layer.height - 10 - 1) / ${rate})+1;
				$("#startPos").val(startPos);
				$("#endPos").val(endPos);
				$("#chrMarkerForm").submit();
				console.log(startPos, endPos);
			}
		});		

	});
</script>



<h1>Markers</h1>
<br />

<p>
<h2>${chrMarkerVO.chrom} - ${chrMarkerVO.markerType}</h2>
Marker 전체 개수 :
<fmt:formatNumber value="${totalCnt}" pattern="#,###" />
</p>

<div>
	<form:form id="chrMarkerForm" commandName="chrMarkerVO">

		<label for="markerType">Change MarkerType : </label>
		<form:select path="markerType">
			<form:option value="SNP" label="SNP" />
			<form:option value="InDel" label="InDel" />
			<form:option value="SSR" label="SSR" />
		</form:select>
		<form:hidden path="chrom" />
		<br />
		<label for="tags">Tag : </label>
		<form:select path="tags" id="tags">
			<form:option value="all" label="All" />
			<form:option value="exon" label="Exon" />
			<form:option value="intron" label="Intron" />
			<form:option value="intergenic" label="Intergenic" />
		</form:select>
		<label for="startPos">Start Position : </label>
		<form:input path="startPos" />
		<label for="endPos">End Position : </label>
		<form:input path="endPos" />
		<input type="submit">

	</form:form>
</div>

<div id="chrBar">
	<canvas width="200" height="700" class="chrCanvas">지원하지 않는 브라우저 입니다. 최신버전의 브라우저를 이용하세요.</canvas>
</div>

<div id="markerTable">
	<table>
		<caption>Marker Count : ${markersCnt}</caption>
		<thead>
			<tr>
				<th>Chr.</th>
				<th>locus</th>
				<th>Gene</th>
				<th>Tag</th>
				<th>Forward primer</th>
				<th>Reverse primer</th>
				<th>L tm</th>
				<th>R tm</th>
				<th>GenoType</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="marker" items="${markers}" varStatus="status">
				<tr>
					<td>${marker.chrom}</td>
					<td><fmt:formatNumber value="${marker.loci}" pattern="#,###" /></td>
					<td>${marker.genes}</td>
					<td nowrap="nowrap">${marker.tags}</td>
					<td>${marker.fprimer}</td>
					<td>${marker.rprimer}</td>
					<td>${marker.ltm}</td>
					<td>${marker.rtm}</td>
					<td><a data-name="detail" href="#" data-loci="${marker.loci}">View</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
