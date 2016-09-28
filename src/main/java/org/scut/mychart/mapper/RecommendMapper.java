package org.scut.mychart.mapper;

import org.scut.mychart.model.RecommendResultModel;

import java.util.List;
import java.util.Map;

/**
 * @author gzw
 */
public interface RecommendMapper {
	List<RecommendResultModel> selectRecommendResult(Map<String, String> param);

}	

