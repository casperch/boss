package kr.re.kribb.service;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import kr.re.kribb.model.GffRecord;
import kr.re.kribb.model.Marker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneStructureMap {

	@Autowired
	ServletContext context;

	public String drawGeneStructure(int[] startEnd, List<GffRecord> gffRecords, Marker marker, List<Marker> markers) {

		int canvasWidth = 540;
		int canvasHeight = 100;
		
		float rate = 500.0f / (startEnd[1] - startEnd[0]);

		BufferedImage buffImg = new BufferedImage(canvasWidth, canvasHeight,
				BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g2 = buffImg.createGraphics();		
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, canvasWidth, canvasHeight);
		g2.setColor(Color.BLACK);

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		ArrayList<Integer> pos = new ArrayList<Integer>();
		
		for (Iterator<GffRecord> iterator = gffRecords.iterator(); iterator
				.hasNext();) {
			GffRecord r = (GffRecord) iterator.next();
			if (r.getFeature().equals("exon")) {
				float st = Math.min(r.getStart(), r.getEnd());
				float ed = Math.max(r.getStart(), r.getEnd());
				float x1 = (st - startEnd[0]) * rate + 20;
				float width = (ed - st) * rate;
				pos.add(r.getStart());
				pos.add(r.getEnd());
				g2.fillRect((int) x1, 10, (int) width, 16);
				System.out.println(r);
			}
		}
		
		g2.setColor(Color.GRAY);
		min = Collections.min(pos);
		max = Collections.max(pos);
		int width = (int)((max - min) * rate); 
		int r_min = (int) ((min - startEnd[0]) * rate + 20);		
		int r_max = (int)((max-startEnd[0]) *rate + 20);
		 
		g2.drawRect(r_min, 10, width-1, 15);	//회색 사각형

		g2.setColor(Color.BLACK);		
		if (gffRecords.get(0).getStrand().equals("+")) {
			g2.drawString("5'", 0, 10);
			g2.drawString("3'", 510, 10);
			
			Polygon p = new Polygon();
			p.addPoint(r_min, 10);
			p.addPoint(r_min-10, 18);
			p.addPoint(r_min, 26);		
			g2.fillPolygon(p);			
		} else {
			g2.drawString("3'", 0, 10);
			g2.drawString("5'", 510, 10);
			
			Polygon p = new Polygon();
			p.addPoint(r_max, 10);
			p.addPoint(r_max+10, 18);
			p.addPoint(r_max, 26);		
			g2.fillPolygon(p);
		}
		
		System.out.println("marker No:" + markers.size());
		
		for (Iterator<Marker> markerItr = markers.iterator(); markerItr.hasNext();) {
			Marker rMarker = (Marker) markerItr.next();
			int x = (int) ((rMarker.getLoci() - startEnd[0]) * rate + 20);
			Polygon p = new Polygon();
			p.addPoint(x, 30);
			p.addPoint(x+5, 35);
			p.addPoint(x-5, 35);
			
			int curMarkerLoci = marker.getLoci();
			int loopMarkerLoci = rMarker.getLoci();
			
			if(curMarkerLoci == loopMarkerLoci) {
				g2.setColor(Color.RED);				
				g2.fillPolygon(p);
			}else{
				g2.setColor(Color.BLACK);				
				g2.fillPolygon(p);
			}
		}		

		String path = context.getRealPath("resources");
		File dir = new File(path);
		File outfile = null;
		try {
			outfile = File.createTempFile("geneStructure", ".png", dir);
			//System.out.println(outfile.getPath());
			ImageIO.write(buffImg, "PNG", outfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outfile.getName();		 
	}

}
