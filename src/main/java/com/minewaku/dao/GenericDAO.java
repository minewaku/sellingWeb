package com.minewaku.dao;

import java.util.List;

import com.minewaku.mapper.RowMapper;

public interface GenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object...parameters);
}
