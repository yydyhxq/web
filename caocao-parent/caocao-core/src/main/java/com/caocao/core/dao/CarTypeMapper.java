package com.caocao.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.caocao.core.model.CarType;
import com.caocao.core.model.CarTypeExample;

public interface CarTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_cartype
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int countByExample(CarTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_cartype
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int deleteByExample(CarTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_cartype
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int insert(CarType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_cartype
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int insertSelective(CarType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_cartype
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    List<CarType> selectByExample(CarTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_cartype
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByExampleSelective(@Param("record") CarType record, @Param("example") CarTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_cartype
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByExample(@Param("record") CarType record, @Param("example") CarTypeExample example);
    
    int updateByPrimaryKey(CarType record);
    
    List<CarType> QueryPageList(CarType record);
    
    CarType QueryOne(CarType record);
    
    CarType QueryById(CarType record);
}