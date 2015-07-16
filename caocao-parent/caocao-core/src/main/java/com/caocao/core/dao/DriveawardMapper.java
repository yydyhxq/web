package com.caocao.core.dao;

import com.caocao.core.model.Driveaward;
import com.caocao.core.model.DriveawardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DriveawardMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driveaward
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int countByExample(DriveawardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driveaward
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int deleteByExample(DriveawardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driveaward
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driveaward
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int insert(Driveaward record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driveaward
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int insertSelective(Driveaward record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driveaward
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    List<Driveaward> selectByExampleWithBLOBs(DriveawardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driveaward
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    List<Driveaward> selectByExample(DriveawardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driveaward
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    Driveaward selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driveaward
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int updateByExampleSelective(@Param("record") Driveaward record, @Param("example") DriveawardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driveaward
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") Driveaward record, @Param("example") DriveawardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driveaward
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int updateByExample(@Param("record") Driveaward record, @Param("example") DriveawardExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driveaward
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int updateByPrimaryKeySelective(Driveaward record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driveaward
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int updateByPrimaryKeyWithBLOBs(Driveaward record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driveaward
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int updateByPrimaryKey(Driveaward record);
}