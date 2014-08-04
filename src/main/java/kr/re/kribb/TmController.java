package kr.re.kribb;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.re.kribb.model.Line;
import kr.re.kribb.model.SnpMarker;
import kr.re.kribb.model.TmVO;
import kr.re.kribb.model.Trait;
import kr.re.kribb.service.TmServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application IGM page. in silico integrated genetic
 * map
 */
@Controller
public class TmController {

	@Autowired
	TmServiceImpl tmService;

	private static final Logger logger = LoggerFactory
			.getLogger(TmController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/tm")
	public String home(@ModelAttribute(value="tmVO") TmVO tmVO, Model model, HttpServletRequest req) {
		logger.info("TmPage");
		
		ArrayList<Trait> traits = tmService.getTtaits();
		model.addAttribute("traits", traits);
		
		model.addAttribute("bgClass", tmService.getColor(tmVO));				
		
		ArrayList<SnpMarker> markers = tmService.diffMarker(tmVO);
		//System.out.println(markers.size());
		model.addAttribute("markers", markers);

		return "tm.tiles";
	}

}
