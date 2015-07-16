package com.caocao.core.dao;

import com.caocao.core.model.Car;
import com.caocao.core.model.CarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int countByExample(CarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int deleteByExample(CarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int insert(Car record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int insertSelective(Car record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    List<Car> selectByExample(CarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    Car selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByExample(@Param("record") Car record, @Param("example") CarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByPrimaryKeySelective(Car record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByPrimaryKey(Car record);
}