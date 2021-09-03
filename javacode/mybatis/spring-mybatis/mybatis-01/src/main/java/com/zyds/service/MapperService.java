package com.zyds.service;

import com.zyds.mapper.Mapper;

public class MapperService implements MapperServiceIP{
    private Mapper mapper;

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public Mapper getMapper() {
        return mapper;
    }

    @Override
    public void getMapperS() {
        mapper.getSql();
    }
}
