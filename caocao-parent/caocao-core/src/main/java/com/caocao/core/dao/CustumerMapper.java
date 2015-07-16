package com.caocao.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.caocao.core.model.BigCustumerBase;
import com.caocao.core.model.Book;
import com.caocao.core.model.Custumer;
import com.caocao.core.model.CustumerExample;
import com.caocao.core.model.Journey;
import com.caocao.core.model.MyWallet;

public interface CustumerMapper {
	
	Journey acquireJourney(int orderId);
	
	Book acquireBook(Integer orderId);

	MyWallet acquireMyWallet(int customerId, int isDefault);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_custumer
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int countByExample(CustumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_custumer
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int deleteByExample(CustumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_custumer
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_custumer
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int insert(Custumer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_custumer
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int insertSelective(Custumer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_custumer
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    List<Custumer> selectByExampleWithBLOBs(CustumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_custumer
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    List<Custumer> selectByExample(CustumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_custumer
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    Custumer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_custumer
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByExampleSelective(@Param("record") Custumer record, @Param("example") CustumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_custumer
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") Custumer record, @Param("example") CustumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_custumer
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByExample(@Param("record") Custumer record, @Param("example") CustumerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_custumer
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByPrimaryKeySelective(Custumer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_custumer
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByPrimaryKeyWithBLOBs(Custumer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tsp_caocao_custumer
     *
     * @mbggenerated Thu Jun 18 13:20:28 CST 2015
     */
    int updateByPrimaryKey(Custumer record);
    
    List<Custumer> QueryPageList(Custumer record);
    
    Custumer QueryOne(Custumer record);
    
    Custumer QueryById(Custumer record);
}