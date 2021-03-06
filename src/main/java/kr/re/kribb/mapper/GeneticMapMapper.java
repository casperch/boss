package kr.re.kribb.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.re.kribb.model.GeneticMap;
import kr.re.kribb.model.GeneticMapExample;

public interface GeneticMapMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table geneticMap
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	int countByExample(GeneticMapExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table geneticMap
	 * @mbggenerated  Wed Jul 30 09:22:09 KST 2014
	 */
	GeneticMap selectByPrimaryKey(Integer idx);

	ArrayList<GeneticMap> select_authors();

	GeneticMap select_author(GeneticMap authorVO);

	HashMap<String, Object> selectAuthorbyCount(
			@Param(value = "authorIdx") Integer authorIdx,
			@Param(value = "chrNo") String chrNo);

	HashMap<String, Object> selectAuthorbyCountScaffold(Integer authorIdx);

	HashMap<String, Object> selectAuthorbyCountUnmapped(Integer authorIdx);

	int selectAuthorbyTotalCount(Integer authorIdx);

	ArrayList<GeneticMap> searchAuthorChrData(
			@Param(value = "authorIdx") Integer authorIdx,
			@Param(value = "chrNo") String chrNo);
}