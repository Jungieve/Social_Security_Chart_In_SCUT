package org.scut.mychart.mapper;

import java.util.List;
import java.util.Map;

import org.scut.mychart.model.*;

public interface ChartsMapper {
	List<Chart01> selectChart01Payment(Map<String,String> param);
	List<Chart03> selectChart03Charges();
	int selectChart10Personnum(List<String> param);
}	

