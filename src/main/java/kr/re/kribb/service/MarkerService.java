package kr.re.kribb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.re.kribb.model.Marker;
import kr.re.kribb.model.MarkerVO;
import kr.re.kribb.model.SSR_Marker;
import kr.re.kribb.model.SnpMarker;
import kr.re.kribb.model.TmVO;
import kr.re.kribb.model.Trait;

public interface MarkerService {
	public ArrayList<SnpMarker> getMarkers(MarkerVO markerVO);
	public ArrayList<SnpMarker> getMarkersTrim(MarkerVO markerVO);
	public int getCount(MarkerVO markerVO);
	public Map<String, Object> pager(int totalCnt,MarkerVO markerVO);
	public Map<String, String> getChars();
	public void makeChromsomeMap(String chrNo);
	public HashMap<String, Integer> getMarkerCount(String string);	
	public int getMarkerCount(TmVO chrMarkerVO);
	public ArrayList<Marker> getChrMarkers(TmVO chrMarkerVO);
	public HashMap<Integer, Integer> getMfCnt(TmVO chrMarkerVO);
	public SSR_Marker getSsrMarker(SSR_Marker ssrVO);
	public Map<String, Object> drawGeneStructure(Marker marker);
	public HashMap<String, String> getTraits();	
}
