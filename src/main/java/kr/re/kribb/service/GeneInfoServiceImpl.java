package kr.re.kribb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.kribb.mapper.GeneInfoMapper;
import kr.re.kribb.model.GeneInfo;

@Service
public class GeneInfoServiceImpl implements GeneInfoService {

	@Autowired
	GeneInfoMapper geneInfoMapper;
	
	@Override
	public GeneInfo getGeneInfo(String genes) {
		// TODO Auto-generated method stub
		GeneInfo geneInfo = geneInfoMapper.getGeneInfo(genes);
		return geneInfo;
	}

	@Override
	public int[] up1kb_pos(GeneInfo geneInfo) {
		// TODO Auto-generated method stub
		int[] startEnd = {0,0};
		if(geneInfo.getStrand().equals("+"))
		{
			startEnd[0] = geneInfo.getStart() - 1000;
			startEnd[1] = geneInfo.getEnd();
			
		}else if(geneInfo.getStrand().equals("-")){
			startEnd[0] = geneInfo.getStart();
			startEnd[1] = geneInfo.getEnd() + 1000;
		}		
		return startEnd;
	}

}
