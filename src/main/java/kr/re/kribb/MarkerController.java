package kr.re.kribb;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import kr.re.kribb.model.Marker;
import kr.re.kribb.model.MarkerVO;
import kr.re.kribb.model.SSR_Marker;
import kr.re.kribb.model.SnpMarker;
import kr.re.kribb.model.TmVO;
import kr.re.kribb.service.ChrInfo;
import kr.re.kribb.service.GeneInfoService;
import kr.re.kribb.service.GffReader;
import kr.re.kribb.service.MarkerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
/* @SessionAttributes("markerVO") */
public class MarkerController {

	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private ChrInfo chrInfoService;
	
	@Autowired
	private GffReader gffReader;
	
	@Autowired
	private GeneInfoService geneInfoService;	
 

	private static final Logger logger = LoggerFactory
			.getLogger(MarkerController.class);

	@RequestMapping(value = "/marker.old", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String marker_old(@ModelAttribute("markerVO") MarkerVO markerVO,
			Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Map<String, Object> map = new HashMap<String, Object>();

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);

		int totalCnt = markerService.getCount(markerVO);
		ArrayList<SnpMarker> markers = markerService.getMarkersTrim(markerVO);

		Map<String, Object> pager = markerService.pager(totalCnt, markerVO);

		Map<String, String> chrs = markerService.getChars();
		map.put("chrs", chrs);
		map.put("serverTime", formattedDate);
		map.put("totalCnt", totalCnt);
		map.put("markers", markers);
		map.put("pager", pager);

		model.addAllAttributes(map);

		return "marker.tiles";
	}
	
	
	/**
	 * 마커 통계 보여줄께요
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/marker", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String marker(Model model) {
		
		HashMap<String, Integer> snpCount = markerService.getMarkerCount("SNP");
		HashMap<String, Integer> indelCount = markerService.getMarkerCount("InDel");
		HashMap<String, Integer> ssrCount = markerService.getMarkerCount("SSR");
		
		model.addAttribute("snpCount", snpCount);
		model.addAttribute("indelCount", indelCount);
		model.addAttribute("ssrCount", ssrCount);

		return "marker.tiles";
	}

	@RequestMapping(value = "/geneinfo")
	public @ResponseBody Map<String, String> geneinfo() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("string", "test");		
		return result;
	}
	
	@RequestMapping(value = "chrMarker")
	public String chrMarker(@ModelAttribute(value="chrMarkerVO") TmVO chrMarkerVO, Model model){		
		
		int totalCnt = markerService.getMarkerCount(chrMarkerVO);
		ArrayList<Marker> markers = markerService.getChrMarkers(chrMarkerVO);
		int maxChrLen = chrInfoService.maxChrLenght();
		int curChrLen = chrInfoService.chrLength(chrMarkerVO.getChrom());
		float rate = (float) (600 / (float) maxChrLen);
		//HashMap<Integer, Integer> mfcount = markerService.getMfCnt(chrMarkerVO);

		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("markers", markers);
		model.addAttribute("markersCnt", markers.size());
		model.addAttribute("maxChrLen", maxChrLen);
		model.addAttribute("curChrLen", curChrLen);
		model.addAttribute("rate", rate );
		//model.addAttribute("mfcount", mfcount);

		return "chrMarker.tiles";
	}
	
	@RequestMapping(value = "/markerDist.json")
	public @ResponseBody HashMap<Integer, Integer> markerDist(@ModelAttribute(value="chrMarkerVO") TmVO chrMarkerVO) {
		HashMap<Integer, Integer> result = markerService.getMfCnt(chrMarkerVO);				
		return result;
	}
	
	@RequestMapping(value = "/markerDetail")
	public String markerDetail(SSR_Marker ssrVO, Model model){		
		SSR_Marker ssrMarker = markerService.getSsrMarker(ssrVO);
		Map<String, Object> imgGeneStructure = markerService.drawGeneStructure(ssrMarker);
		HashMap<String, String> traitMap = markerService.getTraits();
	
		model.addAttribute("marker", ssrMarker);
		model.addAttribute("imgName", imgGeneStructure.get("imgName"));
		model.addAttribute("markers", imgGeneStructure.get("markers"));
		model.addAttribute("traitMap", traitMap);
		return "markerDetail";
	}

}
