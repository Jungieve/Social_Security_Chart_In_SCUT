package org.scut.mychart.mapper;

import org.scut.mychart.model.Chart09;

import java.util.List;
import java.util.Map;

public interface Charts09Mapper {
	List<Chart09> selectChart09Payment(Map<String, String> param);
	List<Chart09> selectChart09Age(Map<String, String> param);
}	
