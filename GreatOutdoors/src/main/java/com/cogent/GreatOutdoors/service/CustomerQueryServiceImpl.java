package com.cogent.GreatOutdoors.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.GreatOutdoors.dto.CustomerQuery;
import com.cogent.GreatOutdoors.repository.CustomerQueryRepository;

@Service
public class CustomerQueryServiceImpl implements CustomerQueryService {
	
	@Autowired
	private CustomerQueryRepository queryRepository;
	
	@Override
	public CustomerQuery addQuery(CustomerQuery query) {
		// TODO Auto-generated method stub
		CustomerQuery q = queryRepository.save(query);
		return q;
	}

	@Override
	public String updateQuery(CustomerQuery query, int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteQueryById(int id) {
		// TODO Auto-generated method stub
		queryRepository.deleteById(id);
		return "Deleted";
	}

	@Override
	public CustomerQuery getQueryById(int id) {
		// TODO Auto-generated method stub
		CustomerQuery q1 = queryRepository.getById(id);
		return q1;
	}

	@Override
	public List<CustomerQuery> getAllQueries() {
		// TODO Auto-generated method stub
		List<CustomerQuery> queryList = new ArrayList<CustomerQuery>();
		queryList = queryRepository.findAll();
		return queryList;
	}

	@Override
	public String deleteAllQueries() {
		// TODO Auto-generated method stub
		queryRepository.deleteAll();
		return "Deleted all queries";
	}

}
