package com.cogent.GreatOutdoors.service;

import java.util.List;

import com.cogent.GreatOutdoors.dto.CustomerQuery;

public interface CustomerQueryService {
	public CustomerQuery addQuery(CustomerQuery query);
	public String updateQuery(CustomerQuery query, int Id);
	public String deleteQueryById(int id);
	public CustomerQuery getQueryById(int id);
	public List<CustomerQuery> getAllQueries();
	public String deleteAllQueries();
}
