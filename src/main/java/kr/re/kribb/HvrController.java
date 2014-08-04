package kr.re.kribb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application IGM page.
 * in silico integrated genetic map
 */
@Controller
public class HvrController {

	private static final Logger logger = LoggerFactory
			.getLogger(HvrController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/hvr", method = RequestMethod.GET)
	public String home(Model model) {		

		return "hvr.tiles";
	}

}
