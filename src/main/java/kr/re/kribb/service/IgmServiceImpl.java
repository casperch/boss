package kr.re.kribb.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import kr.re.kribb.mapper.GeneticMapMapper;
import kr.re.kribb.model.GeneticMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IgmServiceImpl {

	@Autowired
	GeneticMapMapper geneticMapMapper;

	public HashMap<Integer, String> getAuthors() {
		HashMap<Integer, String> geneticAuthors = new HashMap<Integer, String>();
		ArrayList<GeneticMap> authors = geneticMapMapper.select_authors();
		for (GeneticMap author : authors) {
			geneticAuthors.put(author.getAuthorIdx(), author.getAuthor());
		}
		return geneticAuthors;
	}

	public GeneticMap getAuthor(GeneticMap authorVO) {				
		return geneticMapMapper.select_author(authorVO); 
	}
	
	public ArrayList<HashMap<String, Object>> countMarker(GeneticMap authorVO) {
		DecimalFormat dFormat = new DecimalFormat("###.##");
		HashMap<String, Object> chrPerCountFrimer;
		ArrayList<HashMap<String, Object>> chrCount = new ArrayList<HashMap<String,Object>>();
		String chrNo;
		int totalCnt = geneticMapMapper.selectAuthorbyTotalCount(authorVO.getAuthorIdx());
		Double chrCnt;
		Double percent;
		for (int i = 1; i <= 9; i++) {
			chrNo = "C" + i;
			chrPerCountFrimer = geneticMapMapper.selectAuthorbyCount(authorVO.getAuthorIdx(),chrNo);
			chrCnt = ((Long)chrPerCountFrimer.get("noMarker")).doubleValue();
			percent = chrCnt / totalCnt * 100.0f;
			//System.out.println(percent);			
			chrPerCountFrimer.put("percent", dFormat.format(percent));
			chrCount.add(chrPerCountFrimer);
		}
		
		//scaffold
		chrPerCountFrimer = geneticMapMapper.selectAuthorbyCountScaffold(authorVO.getAuthorIdx());
		chrCnt = ((Long)chrPerCountFrimer.get("noMarker")).doubleValue();
		percent = chrCnt / totalCnt * 100.0f;			
		chrPerCountFrimer.put("percent", dFormat.format(percent));		
		chrCount.add(chrPerCountFrimer);
		
		//unmapped
		chrPerCountFrimer = geneticMapMapper.selectAuthorbyCountUnmapped(authorVO.getAuthorIdx());
		chrCnt = ((Long)chrPerCountFrimer.get("noMarker")).doubleValue();
		percent = chrCnt / totalCnt * 100.0f;			
		chrPerCountFrimer.put("percent", dFormat.format(percent));
		chrCount.add(chrPerCountFrimer);
		
		return chrCount;		
	}

	public int authorTotalPrimerCnt(GeneticMap authorVO) {
		return geneticMapMapper.selectAuthorbyTotalCount(authorVO.getAuthorIdx());
	}

	public ArrayList<GeneticMap> getData(int authorIdx, String chrNo) {		
		return geneticMapMapper.searchAuthorChrData(authorIdx, chrNo);
	}
}
