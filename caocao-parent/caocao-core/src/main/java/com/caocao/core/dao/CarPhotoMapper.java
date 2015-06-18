package com.caocao.core.dao;

import com.caocao.core.model.CarPhoto;
import com.caocao.core.model.CarPhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarPhotoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car_photo
     *
     * @mbggenerated Wed Jun 17 23:27:14 CST 2015
     */
    int countByExample(CarPhotoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car_photo
     *
     * @mbggenerated Wed Jun 17 23:27:14 CST 2015
     */
    int deleteByExample(CarPhotoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car_photo
     *
     * @mbggenerated Wed Jun 17 23:27:14 CST 2015
     */
    int deleteByPrimaryKey(Integer carId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car_photo
     *
     * @mbggenerated Wed Jun 17 23:27:14 CST 2015
     */
    int insert(CarPhoto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car_photo
     *
     * @mbggenerated Wed Jun 17 23:27:14 CST 2015
     */
    int insertSelective(CarPhoto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car_photo
     *
     * @mbggenerated Wed Jun 17 23:27:14 CST 2015
     */
    List<CarPhoto> selectByExample(CarPhotoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car_photo
     *
     * @mbggenerated Wed Jun 17 23:27:14 CST 2015
     */
    CarPhoto selectByPrimaryKey(Integer carId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car_photo
     *
     * @mbggenerated Wed Jun 17 23:27:14 CST 2015
     */
    int updateByExampleSelective(@Param("record") CarPhoto record, @Param("example") CarPhotoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car_photo
     *
     * @mbggenerated Wed Jun 17 23:27:14 CST 2015
     */
    int updateByExample(@Param("record") CarPhoto record, @Param("example") CarPhotoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car_photo
     *
     * @mbggenerated Wed Jun 17 23:27:14 CST 2015
     */
    int updateByPrimaryKeySelective(CarPhoto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_car_photo
     *
     * @mbggenerated Wed Jun 17 23:27:14 CST 2015
     */
    int updateByPrimaryKey(CarPhoto record);
}