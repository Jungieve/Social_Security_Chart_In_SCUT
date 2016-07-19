package org.scut.mychart.mapper;

import org.scut.mychart.model.Chartvenn;

import java.util.HashMap;

public interface VennChartsMapper {
	Integer selectChart10Personnum1(HashMap<String, String> param);
	Integer selectChart10Personnum2(HashMap<String, String> param);
	Integer selectChart10Personnum3(HashMap<String, String> param);
	
}
