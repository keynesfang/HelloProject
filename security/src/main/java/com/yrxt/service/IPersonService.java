package com.yrxt.service;

import java.util.List;

import com.yrxt.model.Person;

public interface IPersonService {

    /**
     * ����ȫ����person
     * @return
     */
    List<Person> loadPersons();
}
