package com.caocao.service.integration.gis;

import java.util.ArrayList;
import java.util.List;

import com.caocao.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoundDto {
	private int status;
	private String info;
	private int count;
	private List<Datas> datas;

	public List<Datas> getDatas() {
		return datas;
	}
	public void setDatas(List<Datas> datas) {
		this.datas = datas;
	}
	public RoundDto() {

	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


/*public  static void main(String[] args)
{
	String abc="{'count':'3','info':'OK','status':'1'}";
JsonUtil.getObjectFromJSONString(abc, RoundDto.class);
}*/
}

class Datas {
	private int _id;
	private String _name;
	private String _location;
	private String _address;
	private String _createtime;
	private String _updatetime;
	private int _distance;
	private byte[] _image;

	public Datas() {

	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_location() {
		return _location;
	}

	public void set_location(String _location) {
		this._location = _location;
	}

	public String get_address() {
		return _address;
	}

	public void set_address(String _address) {
		this._address = _address;
	}

	public String get_createtime() {
		return _createtime;
	}

	public void set_createtime(String _createtime) {
		this._createtime = _createtime;
	}

	public String get_updatetime() {
		return _updatetime;
	}

	public void set_updatetime(String _updatetime) {
		this._updatetime = _updatetime;
	}

	public int get_distance() {
		return _distance;
	}

	public void set_distance(int _distance) {
		this._distance = _distance;
	}

	public byte[] get_image() {
		return _image;
	}

	public void set_image(byte[] _image) {
		this._image = _image;
	}


}
