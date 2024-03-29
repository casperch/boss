package kr.re.kribb.mapper;

import java.util.ArrayList;
import java.util.List;

import kr.re.kribb.model.Line;
import kr.re.kribb.model.LineExample;

public interface LineMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    int countByExample(LineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table line
     *
     * @mbggenerated Sat Feb 22 17:43:26 KST 2014
     */
    List<Line> selectByExample(LineExample example);
    

    ArrayList<Line> selectLines();
    
}