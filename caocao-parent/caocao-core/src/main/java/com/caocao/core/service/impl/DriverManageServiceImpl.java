package com.caocao.core.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.caocao.core.dao.DriverMapper;
import com.caocao.core.model.Driver;
import com.caocao.core.service.DriverManageService;

@Service("driverManageService")
public class DriverManageServiceImpl implements DriverManageService {
	@Resource
	private DriverMapper driverMapper;
	
	public Driver QueryOne(Driver driver) {
		Driver modelDO = driverMapper.QueryOne(driver);
	    return modelDO;
	}
	
	public Driver QueryById(Driver driver) {
		Driver modelDO = driverMapper.QueryById(driver);
	    return modelDO;
	}
	
	public List<Driver> QueryPageList(Driver driver) {
		List<Driver> list = driverMapper.QueryPageList(driver);
		return list;
	}
	
	public List<Driver> QueryQualifiedList(Driver driver) {
		List<Driver> list = driverMapper.QueryQualifiedList(driver);
		return list;
	}
	
	public int insert(Driver driver) {
		int result = driverMapper.insert(driver);
		return result;
	}
	
	public int update(Driver driver) {
		int result = driverMapper.updateByPrimaryKey(driver);
		return result;
	}
	
	public String DriversImport(InputStream is, String type) {
		List<Driver> list = new ArrayList<Driver>();
		StringBuffer sb = new StringBuffer();
		Sheet sheet = null;
		Row nameRow = null;
		int numRow = 0;
		try {
			if ("xls".equals(type)) {
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
				sheet = hssfWorkbook.getSheetAt(0);
				nameRow = sheet.getRow(3);
			} else if ("xlsx".equals(type)) {
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
				sheet = xssfWorkbook.getSheetAt(0);
				nameRow = sheet.getRow(3);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=4; i<sheet.getLastRowNum(); i++) {
			Driver driver = new Driver();
			numRow = i+1;
			Row row = sheet.getRow(i);
			Cell name = row.getCell(1);
			if(!StringUtils.isEmpty(getValue(name).trim())) {
				driver.setName(getValue(name));
			} else {
				sb.append(CollectEmpty(getValue(nameRow.getCell(1)), numRow));
			}
			
			Cell sex = row.getCell(2);
			if(!StringUtils.isEmpty(getValue(sex).trim())) {
				driver.setSex(Integer.parseInt(getValue(sex)));
			} else {
				sb.append(CollectNonNumeric(getValue(nameRow.getCell(2)), numRow));
			}
			
			Cell birthPlace = row.getCell(3);
			if(!StringUtils.isEmpty(getValue(birthPlace).trim())) {
				driver.setBirthPlace(getValue(birthPlace));
			} else {
				continue;
			}
			
			Cell cityName = row.getCell(4);
			if(!StringUtils.isEmpty(getValue(cityName).trim())) {
				driver.setCityName(getValue(cityName));
			} else {
				sb.append(CollectEmpty(getValue(nameRow.getCell(4)), numRow));
			}
			
			Cell livePlace = row.getCell(5);
			if(!StringUtils.isEmpty(getValue(livePlace).trim())) {
				driver.setLivePlace(getValue(livePlace).trim());
			} else {
				continue;
			}
			
			Cell phone = row.getCell(6);
			if(!StringUtils.isEmpty(getValue(phone).trim())) {
				driver.setPhone(getValue(phone));
			} else {
				sb.append(CollectEmpty(getValue(nameRow.getCell(4)), numRow));
			}
			
			Cell educateDegree = row.getCell(7);
			if(!StringUtils.isEmpty(getValue(educateDegree).trim())) {
				driver.setEducateDegree(getValue(educateDegree));
			} else {
				continue;
			}
			
			Cell cardno = row.getCell(8);
			if(!StringUtils.isEmpty(getValue(cardno).trim())) {
				driver.setCardno(getValue(cardno));
			} else {
				sb.append(CollectEmpty(getValue(nameRow.getCell(8)), numRow));
			}
			
			Cell emergencyPeople = row.getCell(9);
			if(!StringUtils.isEmpty(getValue(emergencyPeople).trim())) {
				driver.setEmergencyPeople(getValue(emergencyPeople));
			} else {
				continue;
			}
			
			Cell emergencyPhone = row.getCell(10);
			if(!StringUtils.isEmpty(getValue(emergencyPhone).trim())) {
				driver.setEmergencyPhone(getValue(emergencyPhone));
			} else {
				continue;
			}
			
			Cell evaluateScore = row.getCell(11);
			if(!StringUtils.isEmpty(getValue(evaluateScore).trim())) {
				driver.setEvaluateScore(Double.parseDouble(getValue(evaluateScore)));
			} else {
				continue;
			}
			
			Cell joinWay = row.getCell(16);
			if(!StringUtils.isEmpty(getValue(joinWay).trim())) {
				driver.setJoinWay(Integer.parseInt(getValue(joinWay)));
			} else {
				sb.append(CollectNonNumeric(getValue(nameRow.getCell(2)), numRow));
			}
			
			Cell passFirstTry = row.getCell(17);
			if(!StringUtils.isEmpty(getValue(passFirstTry).trim())) {
				driver.setPassFirstTry(Integer.parseInt(getValue(passFirstTry)));
			} else {
				continue;
			}
			
			Cell firstNoPass = row.getCell(18);
			if(!StringUtils.isEmpty(getValue(firstNoPass).trim())) {
				driver.setFirstNoPass(getValue(firstNoPass));
			} else {
				continue;
			}
			list.add(driver);
		}
		if(null != sb.toString()) {
			return sb.toString();
		} else {
			for(int i=0; i<list.size(); i++) {
				int result = driverMapper.insert(list.get(i));
				if(result < 0) {
					return "fail";
				}
			}
		}
		
		return "success";
	}
	
	private String getValue(Cell cell) {
		if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值
			return String.valueOf(cell.getNumericCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
			// 当Excel单元格有公式时返回其值
			return String.valueOf(cell.getNumericCellValue());
		} else {
			// 返回字符串类型的值
			return String.valueOf(cell.getStringCellValue());
		}
	}
	
	private String CollectEmpty(String name, int numRow) {
		String str = name+"列第"+numRow+"行是空格，请您修改！<br/>";
		return str;
	}
	
	private String CollectNonNumeric(String name, int numRow) {
		String str = name+"列第"+numRow+"行是非数字类型或为空，请您修改！<br/>";
		return str;
	}
}
