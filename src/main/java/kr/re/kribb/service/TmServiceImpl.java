package kr.re.kribb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.re.kribb.mapper.LineMapper;
import kr.re.kribb.mapper.SnpMarkerMapper;
import kr.re.kribb.mapper.TraitMapper;
import kr.re.kribb.model.Line;
import kr.re.kribb.model.SnpMarker;
import kr.re.kribb.model.SnpMarkerSearch;
import kr.re.kribb.model.TmVO;
import kr.re.kribb.model.Trait;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TmServiceImpl {

	@Autowired
	SnpMarkerMapper snpMarkerMapper;
	@Autowired
	LineMapper lineMapper;
	@Autowired
	TraitMapper traitMapper;
	SnpMarkerSearch snpMarkerSearch;

	/**
	 * @param groupA
	 *            genotype A List
	 * @param groupB
	 *            genotype B List
	 * @return MarkerVO 
	 */
	public ArrayList<SnpMarker> diffMarker(TmVO tmVO) {

		List<String> groupA = tmVO.getGroupA();
		List<String> groupB = tmVO.getGroupB();
		if (groupA == null)
			tmVO.setGroupA(new ArrayList<String>());
		if (groupB == null)
			tmVO.setGroupB(new ArrayList<String>());

		return snpMarkerMapper.traitSelect(tmVO);
	}

	/**
	 * �덉쥌 紐⑸줉 媛�졇�ㅺ린
	 * 
	 * @return
	 */
	public ArrayList<Line> getLines() {
		return lineMapper.selectLines();		
	}
	
	public ArrayList<Trait> getTtaits() {		
		return traitMapper.selectTraits();
	}	

	public HashMap<String, String> getColor(TmVO tmVO) {

		HashMap<String, String> containGroup = new HashMap<String, String>();
		List<String> groupA = tmVO.getGroupA();
		List<String> groupB = tmVO.getGroupB();

		if (groupA != null) {
			for (String group : groupA) {
				containGroup.put(group, "groupA");			
			}
		}

		if (groupB != null) {
			for (String group : groupB) {
				containGroup.put(group, "groupB");				
			}
		}

		return containGroup;
	}

}
