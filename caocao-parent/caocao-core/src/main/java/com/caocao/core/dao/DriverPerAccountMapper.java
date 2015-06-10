package com.caocao.core.dao;

import com.caocao.core.model.DriverPerAccount;
import com.caocao.core.model.DriverPerAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DriverPerAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int countByExample(DriverPerAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int deleteByExample(DriverPerAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int insert(DriverPerAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int insertSelective(DriverPerAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    List<DriverPerAccount> selectByExample(DriverPerAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    DriverPerAccount selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByExampleSelective(@Param("record") DriverPerAccount record, @Param("example") DriverPerAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByExample(@Param("record") DriverPerAccount record, @Param("example") DriverPerAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByPrimaryKeySelective(DriverPerAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_per_account
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByPrimaryKey(DriverPerAccount record);
}