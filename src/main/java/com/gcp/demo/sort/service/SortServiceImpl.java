package com.gcp.demo.sort.service;

import com.gcp.demo.sort.dao.SortDao;
import com.gcp.demo.sort.entity.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SortServiceImpl implements SortService {
    @Autowired
    private SortDao sortDao;
    @Override
    public Sort queryBySid(int sid){
        return sortDao.selectBySort(sid);
    }
}
