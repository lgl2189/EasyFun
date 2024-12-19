package com.easyfun.mapper;

import com.easyfun.pojo.LikeSave;
import java.util.List;

public interface LikeSaveMapper {
    int insert(LikeSave row);

    List<LikeSave> selectAll();
}