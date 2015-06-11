package com.caocao.core.dao;

import com.caocao.core.model.Carrelation;
import com.caocao.core.model.CarrelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarrelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_car_relation
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int countByExample(CarrelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_car_relation
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int deleteByExample(CarrelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_car_relation
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_car_relation
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int insert(Carrelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_car_relation
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int insertSelective(Carrelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_car_relation
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    List<Carrelation> selectByExample(CarrelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_car_relation
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    Carrelation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_car_relation
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int updateByExampleSelective(@Param("record") Carrelation record, @Param("example") CarrelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_car_relation
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int updateByExample(@Param("record") Carrelation record, @Param("example") CarrelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_car_relation
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int updateByPrimaryKeySelective(Carrelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_car_relation
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int updateByPrimaryKey(Carrelation record);
}