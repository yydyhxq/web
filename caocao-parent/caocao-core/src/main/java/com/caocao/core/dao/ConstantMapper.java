package com.caocao.core.dao;

import com.caocao.core.model.Constant;
import com.caocao.core.model.ConstantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConstantMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_constant
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int countByExample(ConstantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_constant
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int deleteByExample(ConstantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_constant
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int deleteByPrimaryKey(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_constant
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int insert(Constant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_constant
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int insertSelective(Constant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_constant
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    List<Constant> selectByExample(ConstantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_constant
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    Constant selectByPrimaryKey(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_constant
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int updateByExampleSelective(@Param("record") Constant record, @Param("example") ConstantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_constant
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int updateByExample(@Param("record") Constant record, @Param("example") ConstantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_constant
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int updateByPrimaryKeySelective(Constant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_constant
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int updateByPrimaryKey(Constant record);
}