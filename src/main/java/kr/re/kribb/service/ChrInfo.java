package kr.re.kribb.service;

import kr.re.kribb.mapper.ChromosomeInfoMapper;
import kr.re.kribb.model.ChromosomeInfo;
import kr.re.kribb.model.ChromosomeInfoSearch;
import kr.re.kribb.model.ChromosomeInfoSearch.Criteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChrInfo {
	@Autowired
	ChromosomeInfoMapper chromosomeInfoMapper;

	public int chrLength(String chrNo){
		ChromosomeInfoSearch search = new ChromosomeInfoSearch();
		Criteria criteria = search.createCriteria();
		criteria.andChrnoEqualTo(chrNo);
		ChromosomeInfo info = chromosomeInfoMapper.selectByPrimaryKey(chrNo);
		return info.getChrlen();		
	}
	
	public int maxChrLenght(){		
		return chromosomeInfoMapper.getMaxChrLen();		
	}
	

	public static void main(String[] args) {
		ChrInfo info = new ChrInfo();
		System.out.println(info.chrLength("C2"));

	}

}
