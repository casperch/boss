<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
<!--
#primers {	
	display: inline-table;
	width: 800px;	
}

#primers .seq {
	text-align: left;
	padding-left : 5px;
}
#primers


-->
</style>

<script type="text/javascript">
	$('document').ready(
			function() {
				rate = 0.0;
				if (typeof (Storage) !== "undefined") {
					$.ajax({
						type : "POST",
						url : "<c:url value="/igm_map.json" />",						
						async : false,
						data : {
							authorIdx : '${geneticMap.authorIdx }',
							chrom : '${geneticMap.chrom }'
						},
						success : function(data) {							
							localStorage.clear();
							localStorage.setItem("primers", JSON
									.stringify(data.primers));
							localStorage.setItem("chrLen", data.chrLen);
							localStorage.setItem("rate", data.rate);
							rate = data.rate;
						},
						beforeSend : function() {

						},
						error : function(e) {							
							alert("데이터 로드 오류, 잠시 후 새로 고침");
						}

					});

				} else {
					// Sorry! No Web Storage support.
					alert('지원하지 않는 브라우저 버전입니다. 입니다. 업그레이드 하세요');
				}

				var canvas = $('canvas.demo');
				var rate = localStorage.getItem("rate");
				var chrlen = localStorage.getItem("chrLen");
				var chrlen_rate = localStorage.getItem("chrLen")
						* localStorage.getItem("rate");
				canvas.setLayers({fillstyle:'#000'});				

				$.each(JSON.parse(localStorage.getItem("primers")), function(
						index, primer) {
					var pt = primer.pst + (primer.pend - primer.pst) / 2;
					var pt_rate = pt * rate;
					var pt_draw = pt_rate + 20;

					canvas.drawLine({
						layer : true,
						strokeStyle : '#F00',
						strokeWidth : 1,
						x1 : 40,
						y1 : pt_draw,
						x2 : 60,
						y2 : pt_draw
					});
				});
				
				canvas.drawText({
					layer : true,
					fillStyle : '#000',
					x:48,
					y:6,
					fontSize : 12,
					text: '${geneticMap.chrom}'
				});

				canvas.drawArc({
					layer : true,
					strokeStyle : '#000',
					x : 50,
					y : 20,
					radius : 10,
					start : -90,
					end : 90
				});

				canvas.drawLine({
					layer : true,
					strokeStyle : '#000',
					strokeWidth : 1,
					x1 : 40,
					y1 : 20,
					x2 : 40,
					y2 : chrlen_rate + 20
				});

				canvas.drawLine({
					layer : true,
					strokeStyle : '#000',
					strokeWidth : 1,
					x1 : 60,
					y1 : 20,
					x2 : 60,
					y2 : chrlen_rate + 20
				});

				canvas.drawArc({
					layer : true,
					strokeStyle : '#000',
					x : 50,
					y : chrlen_rate + 20,
					radius : 10,
					start : 90,
					end : -90
				});

				i = 0;
				var y_val=0;
				while (i < chrlen) {
					y_val = i * rate + 20;
					canvas.drawLine({
						layer : true,
						strokeStyle : '#000',
						strokeWidth : 1,
						x1 : 10,
						y1 : y_val,
						x2 : 20,
						y2 : y_val
					});
					i += 1000000;
				}

				canvas.drawLine({
					layer : true,
					strokeStyle : '#000',
					strokeWidth : 1,
					x1 : 10,
					y1 : 20,
					x2 : 10,
					y2 : y_val
				});

				canvas.drawRect({
					layer : true,
					//fillStyle : '#000',
					name : "clickEvent",
					fromCenter : false,
					x : 35,
					y : 20,
					width : 30,
					height : chrlen_rate,
					click : function(layer) {
						var y_pos = layer.mouseY;
						var slider = canvas.getLayer("slider");						
						if ((y_pos + slider.height) >= (chrlen_rate + 20)) {
							y_pos = chrlen_rate - slider.height + 20;
						}						
						canvas.removeLayer("zoompos");
						canvas.animateLayer('slider', {
							y : y_pos
						}, 400, zoomview);
					}
				});

				//Slider
				canvas.drawRect({
					layer : true,
					name : "slider",
					fromCenter : false,
					fillStyle : 'rgba(0, 255, 0, 0.5)',
					x : 35,
					y : 20,
					width : 30,
					height : 5000000 * rate,
					draggable : true,
					dragstart : function() {
						console.log("dragstart");
						canvas.removeLayer("zoompos");
					},
					drag : function(layer) {
						layer.x = 35;
						if (layer.y <= 20) {
							layer.y = 20;
						}

						if ((layer.y + layer.height) >= (chrlen_rate + 20)) {
							layer.y = chrlen_rate - layer.height + 20;
						}
					},
					dragstop : zoomview
				});

				function zoomview() {
					var slider = canvas.getLayer("slider");
					//console.log("슬라이더입니다람쥐", slider);
					canvas.removeLayer("ylocation");
					canvas.removeLayer("zoomprimer");
					var r_st = (slider.y - 20) / rate;
					var r_ed = (slider.y + slider.height - 20) / rate;
					canvas.drawLine({
						layer : true,
						name : "zoompos",
						strokeStyle : '#000',
						strokeWidth : 1,
						x1 : slider.x + slider.width,
						y1 : slider.y,
						x2 : 200,
						y2 : 20,
						x3 : 200,
						y3 : 500,
						x4 : slider.x + slider.width,
						y4 : slider.y + slider.height
					}).drawRect({
						layer : true,
						name : "zoomprimer",
						fromCenter : false,
						strokeStyle : '#000',
						strokeWidth : 1,
						x : 200,
						y : 20,
						width : 20,
						height : 480
					});					
					
					
					var layers = canvas.getLayerGroup('zoomPrimers');					 
					if ( layers != undefined ){
						canvas.removeLayerGroup('zoomPrimers');
					}
					
					console.log(r_st);
					canvas.drawText({
						layer : true,
						groups: ['zoomPrimers'],
						fromCenter : false,
						fillStyle : '#000',
						x:200,
						y:0,
						fontSize : 12,
						text: "Start : " + r_st.toFixed(0)
					}).drawText({
						layer : true,
						groups: ['zoomPrimers'],
						fromCenter : false,
						fillStyle : '#000',
						x:200,
						y:510,
						fontSize : 12,
						text: "End : " + r_ed.toFixed(0)						
					});
					
					var tbl = $("#tbl_primers");
					tbl.empty();
					
					var zoomrate = 480 / (r_ed - r_st);
					var primers = JSON.parse(localStorage.getItem("primers"));
					function posSort(a,b) {
						if(a.pst==b.pst){return 0;}
						return a.pst > b.pst  ? 1 : -1;
					}
					primers.sort(posSort);
					$.each(primers, function(
							index, primer) {
						
						if(r_st <= primer.pst && r_ed >= primer.pend ){
						
							var zst = (primer.pst - r_st) * zoomrate + 20;
							var zlen = (primer.pend - primer.pst) * zoomrate;							
	
							canvas.drawRect({
								layer : true,
								groups: ['zoomPrimers'],
								fromCenter : false,
								strokeStyle : '#F00',
								strokeWidth : 1,
								x : 200,
								y : zst,
								width : 20,
								height : zlen
							});
							
							var text = canvas.drawText({
								layer : true,
								fromCenter : false,
								groups: ['zoomPrimers'],
								fillStyle : '#000',
								x : 230,
								y : zst - 6,
								fontSize : 10,
								fontFamily : 'Verdana, sans-serif',
								text : primer.name,
								click : function(layer){
									//누르면 테이블색상;
									$("#"+primer.idx+" td").effect("highlight", {}, 1500);									
								}
							});	
							
							//console.log(text);
						
							//테이블 데이터 생성
							var tr = $("<tr>");
							var td = $("<td>");
							$.each(primer,function(k,v){
								td = $("<td class='seq'>").text(v);
								tr.append(td);	
								tr.attr("id",primer.idx);
								return (k !== "markertype");
							});						
							$("#tbl_primers").append(tr);
							
						}
						
					});					
					
					//console.log(slider);
					canvas.drawLayers();

				}

				zoomview(); //초기값
				canvas.drawLayers();

			}); //document.ready
</script>

<h1><span class="titleBlock">&nbsp;</span><span>IGM - in silico intergrated genetic map</span></h1>

<br /><br />

<div style="width: 100%; text-align: left">
	<canvas class="demo" width="300" height="520"
		style="vertical-align: top; display:inline-block;">Your browser doesn't support canvas</canvas>
	<table id="primers">
		<thead>
			<tr>
				<th>Idx</th>
				<th>Chrom</th>
				<th>Start</th>
				<th>End</th>
				<th>Name</th>
				<th>Forward Primer</th>
				<th>Reverse Primer</th>
				<th>PCR Length</th>
				<th>Marker Type</th>
			</tr>
		</thead>
		<tbody id="tbl_primers">
		</tbody>
	</table>
</div>
