package com.caocao.core.dao;

import com.caocao.core.model.DriverBillInfo;
import com.caocao.core.model.DriverBillInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DriverBillInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_bill_info
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int countByExample(DriverBillInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_bill_info
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int deleteByExample(DriverBillInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_bill_info
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_bill_info
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int insert(DriverBillInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_bill_info
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int insertSelective(DriverBillInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_bill_info
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    List<DriverBillInfo> selectByExample(DriverBillInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_bill_info
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    DriverBillInfo selectByPrimaryKey(String orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_bill_info
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByExampleSelective(@Param("record") DriverBillInfo record, @Param("example") DriverBillInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_bill_info
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByExample(@Param("record") DriverBillInfo record, @Param("example") DriverBillInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_bill_info
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByPrimaryKeySelective(DriverBillInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_bill_info
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByPrimaryKey(DriverBillInfo record);
}