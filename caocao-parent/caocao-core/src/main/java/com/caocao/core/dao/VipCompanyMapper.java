package com.caocao.core.dao;

import com.caocao.core.model.VipCompany;
import com.caocao.core.model.VipCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VipCompanyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_vipcompany
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int countByExample(VipCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_vipcompany
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int deleteByExample(VipCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_vipcompany
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_vipcompany
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int insert(VipCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_vipcompany
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int insertSelective(VipCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_vipcompany
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    List<VipCompany> selectByExampleWithBLOBs(VipCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_vipcompany
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    List<VipCompany> selectByExample(VipCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_vipcompany
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    VipCompany selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_vipcompany
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByExampleSelective(@Param("record") VipCompany record, @Param("example") VipCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_vipcompany
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") VipCompany record, @Param("example") VipCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_vipcompany
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByExample(@Param("record") VipCompany record, @Param("example") VipCompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_vipcompany
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByPrimaryKeySelective(VipCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_vipcompany
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByPrimaryKeyWithBLOBs(VipCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_vipcompany
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByPrimaryKey(VipCompany record);
}