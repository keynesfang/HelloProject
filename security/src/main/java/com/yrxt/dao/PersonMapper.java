package com.yrxt.dao;

import java.util.List;

import com.yrxt.model.Person;

public interface PersonMapper {
    /**
     * ����һ����¼
     * @param person
     */
    void insert(Person person);
    
    /**
     * ��ѯ����
     * @return
     */
    List<Person> queryAll();
}
