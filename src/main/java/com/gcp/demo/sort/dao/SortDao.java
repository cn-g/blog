package com.gcp.demo.sort.dao;

import com.gcp.demo.sort.entity.Sort;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface SortDao {
    public Sort selectBySort(int sid);
}
