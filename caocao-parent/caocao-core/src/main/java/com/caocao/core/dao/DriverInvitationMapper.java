package com.caocao.core.dao;

import com.caocao.core.model.DriverInvitation;
import com.caocao.core.model.DriverInvitationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DriverInvitationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_invitation
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int countByExample(DriverInvitationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_invitation
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int deleteByExample(DriverInvitationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_invitation
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_invitation
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int insert(DriverInvitation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_invitation
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int insertSelective(DriverInvitation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_invitation
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    List<DriverInvitation> selectByExample(DriverInvitationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_invitation
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    DriverInvitation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_invitation
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int updateByExampleSelective(@Param("record") DriverInvitation record, @Param("example") DriverInvitationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_invitation
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int updateByExample(@Param("record") DriverInvitation record, @Param("example") DriverInvitationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_invitation
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int updateByPrimaryKeySelective(DriverInvitation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_driver_invitation
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    int updateByPrimaryKey(DriverInvitation record);
}