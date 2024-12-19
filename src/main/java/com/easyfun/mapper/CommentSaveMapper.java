package com.easyfun.mapper;

import com.easyfun.pojo.CommentSave;
import java.util.List;

public interface CommentSaveMapper {
    int insert(CommentSave row);

    List<CommentSave> selectAll();
}