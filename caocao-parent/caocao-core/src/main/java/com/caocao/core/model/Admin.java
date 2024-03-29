package com.caocao.core.model;

import java.util.Date;

public class Admin {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_admin._id
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_admin._username
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_admin._phone
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_admin._psw
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    private String psw;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_admin._post
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    private String post;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_admin._isActive
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    private Integer isactive;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_admin._isActiveTime
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    private Date isactivetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_admin._freezeTime
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    private Date freezetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_admin._loginTime
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    private Date logintime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_admin._company_name
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    private String companyName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_admin._createtime
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_admin._updatetime
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    private Date updatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_admin._author_update
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    private String authorUpdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_admin._version
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    private Double version;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_admin._remark
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_admin._id
     *
     * @return the value of tsp_caocao_admin._id
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    
    private String isactiveStr;
    
    private String loginTimeStr;
    
    private String isactivetimeStr;
    
    private String freezetimeStr;
    
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_admin._id
     *
     * @param id the value for tsp_caocao_admin._id
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_admin._username
     *
     * @return the value of tsp_caocao_admin._username
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_admin._username
     *
     * @param username the value for tsp_caocao_admin._username
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_admin._phone
     *
     * @return the value of tsp_caocao_admin._phone
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_admin._phone
     *
     * @param phone the value for tsp_caocao_admin._phone
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_admin._psw
     *
     * @return the value of tsp_caocao_admin._psw
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public String getPsw() {
        return psw;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_admin._psw
     *
     * @param psw the value for tsp_caocao_admin._psw
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setPsw(String psw) {
        this.psw = psw;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_admin._post
     *
     * @return the value of tsp_caocao_admin._post
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public String getPost() {
        return post;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_admin._post
     *
     * @param post the value for tsp_caocao_admin._post
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_admin._isActive
     *
     * @return the value of tsp_caocao_admin._isActive
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public Integer getIsactive() {
        return isactive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_admin._isActive
     *
     * @param isactive the value for tsp_caocao_admin._isActive
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_admin._isActiveTime
     *
     * @return the value of tsp_caocao_admin._isActiveTime
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public Date getIsactivetime() {
        return isactivetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_admin._isActiveTime
     *
     * @param isactivetime the value for tsp_caocao_admin._isActiveTime
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setIsactivetime(Date isactivetime) {
        this.isactivetime = isactivetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_admin._freezeTime
     *
     * @return the value of tsp_caocao_admin._freezeTime
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public Date getFreezetime() {
        return freezetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_admin._freezeTime
     *
     * @param freezetime the value for tsp_caocao_admin._freezeTime
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setFreezetime(Date freezetime) {
        this.freezetime = freezetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_admin._loginTime
     *
     * @return the value of tsp_caocao_admin._loginTime
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public Date getLogintime() {
        return logintime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_admin._loginTime
     *
     * @param logintime the value for tsp_caocao_admin._loginTime
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_admin._company_name
     *
     * @return the value of tsp_caocao_admin._company_name
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_admin._company_name
     *
     * @param companyName the value for tsp_caocao_admin._company_name
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_admin._createtime
     *
     * @return the value of tsp_caocao_admin._createtime
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_admin._createtime
     *
     * @param createtime the value for tsp_caocao_admin._createtime
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_admin._updatetime
     *
     * @return the value of tsp_caocao_admin._updatetime
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_admin._updatetime
     *
     * @param updatetime the value for tsp_caocao_admin._updatetime
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_admin._author_update
     *
     * @return the value of tsp_caocao_admin._author_update
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public String getAuthorUpdate() {
        return authorUpdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_admin._author_update
     *
     * @param authorUpdate the value for tsp_caocao_admin._author_update
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setAuthorUpdate(String authorUpdate) {
        this.authorUpdate = authorUpdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_admin._version
     *
     * @return the value of tsp_caocao_admin._version
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public Double getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_admin._version
     *
     * @param version the value for tsp_caocao_admin._version
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setVersion(Double version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_admin._remark
     *
     * @return the value of tsp_caocao_admin._remark
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_admin._remark
     *
     * @param remark the value for tsp_caocao_admin._remark
     *
     * @mbggenerated Tue Jun 16 10:42:40 CST 2015
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

	public String getIsactiveStr() {
		return isactiveStr;
	}

	public void setIsactiveStr(String isactiveStr) {
		this.isactiveStr = isactiveStr;
	}

	public String getLoginTimeStr() {
		return loginTimeStr;
	}

	public void setLoginTimeStr(String loginTimeStr) {
		this.loginTimeStr = loginTimeStr;
	}

	public String getIsactivetimeStr() {
		return isactivetimeStr;
	}

	public void setIsactivetimeStr(String isactivetimeStr) {
		this.isactivetimeStr = isactivetimeStr;
	}

	public String getFreezetimeStr() {
		return freezetimeStr;
	}

	public void setFreezetimeStr(String freezetimeStr) {
		this.freezetimeStr = freezetimeStr;
	}
}