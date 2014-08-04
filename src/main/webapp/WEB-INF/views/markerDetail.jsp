<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MarkerDetail</title>

<link rel="stylesheet" type="text/css" media="screen"
	href="css/marker.css" />

<style>
<!--
table {
	border-collapse: collapse;
	width: 600px;
	font-size: 14px;
}

th {
	font-size: 12px;
	background-color: #DDFFDD;
}

#markerInfo th {
	width:200px;
}

td {
	font-size: 12px;
	text-align: left;
	padding-left: 20px;
}

H6 { font-size: 15px;}
</style>

</head>
<body>
	<div id="markerInfo">
		<h6>Marker Infomation</h6>
		<table>
			<tr>
				<th>ID.</th>
				<td>${marker.id}</td>
			</tr>
			<tr>
				<th>Chromosome</th>
				<td>${marker.chrom}</td>
			</tr>
			<tr>
				<th>Loci</th>
				<td>${marker.loci}</td>
			</tr>
			<tr>
				<th>Motif Standard</th>
				<td>${marker.motifstdseed}</td>
			</tr>
			<tr>
				<th>Amplicon Length</th>
				<td>${marker.amplen}</td>
			</tr>
			<tr>
				<th colspan=2>Template Sequence</th>
			</tr>
			<tr>
				<td colspan=2><textarea rows="6" cols="80" readonly="readonly">${marker.template }</textarea></td>
			</tr>
		</table>
	</div>
	<c:if test="${imgName ne null}">
		<div id="geneStructure">
			<h6>Gene Structure</h6>
			<img src="resources/${imgName}">
			<table>
				<tr>
					<th>Chromosome</th>
					<th>Loci</th>
					<th>Marker</th>
					<th>Type</th>
					<th>Link(?)</th>
				</tr>
				<c:forEach var="t_marker" items="${markers}">
					<tr>
						<td>${t_marker.chrom}</td>
						<td>${t_marker.loci}</td>
						<td>${t_marker.type}</td>
						<td>${t_marker.tags}</td>
						<td><a data-name="detail_veiw" href="#">view</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	<div id="potentialGenotype">
		<h6>Potential Genotype</h6>
		<table>
			<tr>
				<th>Line</th>
				<th>Trait</th>
				<th>Genotype</th>
			</tr>
			<tr>
				<td>K0001</td>
				<td>${traitMap['K0001']}</td>
				<td>${marker.k0001}</td>
			</tr>
			<tr>
				<td>K0002</td>
				<td>${traitMap['K0002']}</td>
				<td>${marker.k0002}</td>
			</tr>
			<tr>
				<td>K0003</td>
				<td>${traitMap['K0003']}</td>
				<td>${marker.k0003}</td>
			</tr>
			<tr>
				<td>K0004</td>
				<td>${traitMap['K0004']}</td>
				<td>${marker.k0004}</td>
			</tr>
			<tr>
				<td>K0005</td>
				<td>${traitMap['K0005']}</td>
				<td>${marker.k0005}</td>
			</tr>
			<tr>
				<td>K0006</td>
				<td>${traitMap['K0006']}</td>
				<td>${marker.k0006}</td>
			</tr>
			<tr>
				<td>K0007</td>
				<td>${traitMap['K0007']}</td>
				<td>${marker.k0007}</td>
			</tr>
			<tr>
				<td>K0008</td>
				<td>${traitMap['K0008']}</td>
				<td>${marker.k0008}</td>
			</tr>
			<tr>
				<td>K0009</td>
				<td>${traitMap['K0009']}</td>
				<td>${marker.k0009}</td>
			</tr>
			<tr>
				<td>K0010</td>
				<td>${traitMap['K0010']}</td>
				<td>${marker.k0010}</td>
			</tr>
			<tr>
				<td>K0011</td>
				<td>${traitMap['K0011']}</td>
				<td>${marker.k0011}</td>
			</tr>
			<tr>
				<td>K0012</td>
				<td>${traitMap['K0012']}</td>
				<td>${marker.k0012}</td>
			</tr>
			<tr>
				<td>K0013</td>
				<td>${traitMap['K0013']}</td>
				<td>${marker.k0013}</td>
			</tr>
			<tr>
				<td>K0014</td>
				<td>${traitMap['K0014']}</td>
				<td>${marker.k0014}</td>
			</tr>
			<tr>
				<td>K0015</td>
				<td>${traitMap['K0015']}</td>
				<td>${marker.k0015}</td>
			</tr>
			<tr>
				<td>K0016</td>
				<td>${traitMap['K0016']}</td>
				<td>${marker.k0016}</td>
			</tr>
			<tr>
				<td>K0017</td>
				<td>${traitMap['K0017']}</td>
				<td>${marker.k0017}</td>
			</tr>
			<tr>
				<td>K0018</td>
				<td>${traitMap['K0018']}</td>
				<td>${marker.k0018}</td>
			</tr>
			<tr>
				<td>K0019</td>
				<td>${traitMap['K0019']}</td>
				<td>${marker.k0019}</td>
			</tr>
			<tr>
				<td>K0020</td>
				<td>${traitMap['K0020']}</td>
				<td>${marker.k0020}</td>
			</tr>
			<tr>
				<td>K0021</td>
				<td>${traitMap['K0021']}</td>
				<td>${marker.k0021}</td>
			</tr>
			<tr>
				<td>K0022</td>
				<td>${traitMap['K0022']}</td>
				<td>${marker.k0022}</td>
			</tr>
			<tr>
				<td>K0023</td>
				<td>${traitMap['K0023']}</td>
				<td>${marker.k0023}</td>
			</tr>
			<tr>
				<td>K0024</td>
				<td>${traitMap['K0024']}</td>
				<td>${marker.k0024}</td>
			</tr>
			<tr>
				<td>K0025</td>
				<td>${traitMap['K0025']}</td>
				<td>${marker.k0025}</td>
			</tr>
			<tr>
				<td>K0026</td>
				<td>${traitMap['K0026']}</td>
				<td>${marker.k0026}</td>
			</tr>
			<tr>
				<td>K0027</td>
				<td>${traitMap['K0027']}</td>
				<td>${marker.k0027}</td>
			</tr>
			<tr>
				<td>K0028</td>
				<td>${traitMap['K0028']}</td>
				<td>${marker.k0028}</td>
			</tr>
			<tr>
				<td>K0029</td>
				<td>${traitMap['K0029']}</td>
				<td>${marker.k0029}</td>
			</tr>
		</table>
	</div>
</body>
</html>