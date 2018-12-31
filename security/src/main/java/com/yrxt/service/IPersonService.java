package com.yrxt.service;

import java.util.List;

import com.yrxt.model.Person;

public interface IPersonService {

    /**
     * 加载全部的person
     * @return
     */
    List<Person> loadPersons();
}
