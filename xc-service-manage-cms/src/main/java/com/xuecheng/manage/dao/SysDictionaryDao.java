package com.xuecheng.manage.dao;

import com.xuecheng.framework.domain.system.SysDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SysDictionaryDao extends MongoRepository<SysDictionary,String> {

    List<SysDictionary> findByDType(String type);
}
