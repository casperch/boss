package kr.re.kribb.mapper;


import kr.re.kribb.model.ChromosomeInfo;
import kr.re.kribb.model.ChromosomeInfoExample;

public interface ChromosomeInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ChromosomeInfo
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	int countByExample(ChromosomeInfoExample example);

	int getMaxChrLen();

	int getChrLen(String chrom);

	ChromosomeInfo selectByPrimaryKey(String chrNo);

}