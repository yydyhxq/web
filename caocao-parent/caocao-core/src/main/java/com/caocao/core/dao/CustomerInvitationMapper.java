package com.caocao.core.dao;

import com.caocao.core.model.CustomerInvitation;
import com.caocao.core.model.CustomerInvitationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerInvitationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_invitation
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int countByExample(CustomerInvitationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_invitation
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int deleteByExample(CustomerInvitationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_invitation
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_invitation
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int insert(CustomerInvitation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_invitation
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int insertSelective(CustomerInvitation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_invitation
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    List<CustomerInvitation> selectByExample(CustomerInvitationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_invitation
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    CustomerInvitation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_invitation
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByExampleSelective(@Param("record") CustomerInvitation record, @Param("example") CustomerInvitationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_invitation
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByExample(@Param("record") CustomerInvitation record, @Param("example") CustomerInvitationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_invitation
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByPrimaryKeySelective(CustomerInvitation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_customer_invitation
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    int updateByPrimaryKey(CustomerInvitation record);
}