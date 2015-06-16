package com.caocao.service.integration.gis;

import com.fasterxml.jackson.annotation.JsonInclude;

public class DataDto {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String _id;
	private String _name;
	private String _location;
	private String coordtype;
	private String _address;

	public DataDto(String _id,String _name, String _location, String coordtype,
			String _address) {
		this._id=_id;
		this._name = _name;
		this._location = _location;
		this.coordtype = coordtype;
		this._address = _address;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
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

	public String getCoordtype() {
		return coordtype;
	}

	public void setCoordtype(String coordtype) {
		this.coordtype = coordtype;
	}

	public String get_address() {
		return _address;
	}

	public void set_address(String _address) {
		this._address = _address;
	}

}
