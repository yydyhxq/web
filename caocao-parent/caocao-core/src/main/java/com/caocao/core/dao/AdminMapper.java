package com.caocao.core.dao;

import com.caocao.core.model.Admin;
import com.caocao.core.model.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_admin
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int countByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_admin
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int deleteByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_admin
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_admin
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int insert(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_admin
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int insertSelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_admin
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    List<Admin> selectByExampleWithBLOBs(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_admin
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    List<Admin> selectByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_admin
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    Admin selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_admin
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_admin
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_admin
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_admin
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_admin
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByPrimaryKeyWithBLOBs(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_admin
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByPrimaryKey(Admin record);
}