package org.scut.mychart.mapper;

import org.scut.mychart.model.AC01;

public interface AC01Mapper {
    int insert(AC01 record);

    int insertSelective(AC01 record);
    
    AC01 selectByPrimaryKey(String aac001);
}