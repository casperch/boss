package kr.re.kribb.service;

import kr.re.kribb.model.GeneInfo;

public interface GeneInfoService {

	GeneInfo getGeneInfo(String genes);
	int[] up1kb_pos(GeneInfo geneInfo);

}
