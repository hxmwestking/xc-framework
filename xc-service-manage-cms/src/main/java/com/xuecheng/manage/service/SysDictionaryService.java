package com.xuecheng.manage.service;

import com.xuecheng.framework.domain.system.SysDictionary;
import com.xuecheng.manage.dao.SysDictionaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictionaryService {

    @Autowired
    private SysDictionaryDao sysDictionaryDao;

    public List<SysDictionary> findByDType(String type) {
        return sysDictionaryDao.findByDType(type);
    }
}
