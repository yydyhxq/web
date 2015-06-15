package com.caocao.core.model;

public class DriverInvitation {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_driver_invitation._id
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_driver_invitation._driver_id
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    private String driverId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_driver_invitation._favored_id
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    private String favoredId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tsp_caocao_driver_invitation._version
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    private Double version;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_driver_invitation._id
     *
     * @return the value of tsp_caocao_driver_invitation._id
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_driver_invitation._id
     *
     * @param id the value for tsp_caocao_driver_invitation._id
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_driver_invitation._driver_id
     *
     * @return the value of tsp_caocao_driver_invitation._driver_id
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    public String getDriverId() {
        return driverId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_driver_invitation._driver_id
     *
     * @param driverId the value for tsp_caocao_driver_invitation._driver_id
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_driver_invitation._favored_id
     *
     * @return the value of tsp_caocao_driver_invitation._favored_id
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    public String getFavoredId() {
        return favoredId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_driver_invitation._favored_id
     *
     * @param favoredId the value for tsp_caocao_driver_invitation._favored_id
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    public void setFavoredId(String favoredId) {
        this.favoredId = favoredId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tsp_caocao_driver_invitation._version
     *
     * @return the value of tsp_caocao_driver_invitation._version
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    public Double getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tsp_caocao_driver_invitation._version
     *
     * @param version the value for tsp_caocao_driver_invitation._version
     *
     * @mbggenerated Fri Jun 05 15:26:33 CST 2015
     */
    public void setVersion(Double version) {
        this.version = version;
    }
}