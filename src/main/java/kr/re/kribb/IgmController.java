package kr.re.kribb;

import java.util.ArrayList;
import java.util.HashMap;

import kr.re.kribb.model.GeneticMap;
import kr.re.kribb.service.ChrInfo;
import kr.re.kribb.service.IgmServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application IGM page. in silico integrated genetic
 * map
 */
@Controller
public class IgmController {

	@Autowired
	IgmServiceImpl igmService;
	@Autowired
	ChrInfo chrInfo;

	private static final Logger logger = LoggerFactory
			.getLogger(IgmController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/igm")
	public String home(@ModelAttribute("authorVO") GeneticMap authorVO,
			Model model) {
		logger.info("IGM");

		HashMap<Integer, String> authors = igmService.getAuthors();
		model.addAttribute("authors", authors); // 셀렉트박스 데이터

		authorVO = igmService.getAuthor(authorVO);
		model.addAttribute("authorVO", authorVO);

		ArrayList<HashMap<String, Object>> chrCount = igmService
				.countMarker(authorVO);
		model.addAttribute("chrCount", chrCount);

		int authorTotalPrimerCnt = igmService.authorTotalPrimerCnt(authorVO);
		model.addAttribute("totalCnt", authorTotalPrimerCnt);

		return "igm.tiles";
	}
	
	/**
	 * Chromosome 맵을 보여준다
	 * @param geneticMap 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/igm_map")
	public String chrMap(@ModelAttribute("geneticMap") GeneticMap geneticMap, Model model) {
		
		return "igm_map.tiles";
	}

	@RequestMapping(value = "/igm_map.json")
	@ResponseBody
	public HashMap<String, Object> chrMap_data(int authorIdx, String chrom) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<GeneticMap> result = igmService.getData(authorIdx, chrom);
		int chrLen = chrInfo.chrLength(chrom);
		int maxLen = chrInfo.maxChrLenght();
		double rate = 450.0 / maxLen;		
		map.put("primers", result);
		map.put("chrLen", chrLen);
		map.put("rate", rate);		
		return map;
	}

}
