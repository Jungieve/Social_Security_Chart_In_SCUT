package org.scut.mychart.mapper;

import java.util.List;
import java.util.Map;

import org.scut.mychart.model.Chart01;;

public interface Chart01Mapper {
	List<Chart01> selectPayment(Map<String,String> param);
}	
