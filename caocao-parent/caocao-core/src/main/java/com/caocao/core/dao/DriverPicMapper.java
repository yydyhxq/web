package com.caocao.core.dao;

import com.caocao.core.model.DriverPic;
import com.caocao.core.model.DriverPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DriverPicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_img
     *
     * @mbggenerated Wed Jun 17 22:47:04 CST 2015
     */
    int countByExample(DriverPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_img
     *
     * @mbggenerated Wed Jun 17 22:47:04 CST 2015
     */
    int deleteByExample(DriverPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_img
     *
     * @mbggenerated Wed Jun 17 22:47:04 CST 2015
     */
    int deleteByPrimaryKey(Integer driverId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_img
     *
     * @mbggenerated Wed Jun 17 22:47:04 CST 2015
     */
    int insert(DriverPic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_img
     *
     * @mbggenerated Wed Jun 17 22:47:04 CST 2015
     */
    int insertSelective(DriverPic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_img
     *
     * @mbggenerated Wed Jun 17 22:47:04 CST 2015
     */
    List<DriverPic> selectByExample(DriverPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_img
     *
     * @mbggenerated Wed Jun 17 22:47:04 CST 2015
     */
    DriverPic selectByPrimaryKey(Integer driverId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_img
     *
     * @mbggenerated Wed Jun 17 22:47:04 CST 2015
     */
    int updateByExampleSelective(@Param("record") DriverPic record, @Param("example") DriverPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_img
     *
     * @mbggenerated Wed Jun 17 22:47:04 CST 2015
     */
    int updateByExample(@Param("record") DriverPic record, @Param("example") DriverPicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_img
     *
     * @mbggenerated Wed Jun 17 22:47:04 CST 2015
     */
    int updateByPrimaryKeySelective(DriverPic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_img
     *
     * @mbggenerated Wed Jun 17 22:47:04 CST 2015
     */
    int updateByPrimaryKey(DriverPic record);
}