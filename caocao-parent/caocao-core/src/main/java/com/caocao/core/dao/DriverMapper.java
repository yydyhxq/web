package com.caocao.core.dao;

import com.caocao.core.model.Driver;
import com.caocao.core.model.DriverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DriverMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int countByExample(DriverExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int deleteByExample(DriverExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int insert(Driver record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int insertSelective(Driver record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    List<Driver> selectByExample(DriverExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    Driver selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int updateByExampleSelective(@Param("record") Driver record, @Param("example") DriverExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int updateByExample(@Param("record") Driver record, @Param("example") DriverExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int updateByPrimaryKeySelective(Driver record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver
     *
     * @mbggenerated Wed Jun 10 11:11:27 CST 2015
     */
    int updateByPrimaryKey(Driver record);
}