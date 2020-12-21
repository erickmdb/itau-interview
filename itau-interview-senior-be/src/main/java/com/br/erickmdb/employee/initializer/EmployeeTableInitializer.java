package com.br.erickmdb.employee.initializer;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.br.erickmdb.employee.model.Employee;

public class EmployeeTableInitializer {

	private final DynamoDBMapper mapper;

	public EmployeeTableInitializer(AmazonDynamoDB dynamoClient) {
		this.mapper = new DynamoDBMapper(dynamoClient);
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			Employee employee = Employee.builder().//
					firstName(String.format("firstName for Employee-%s", i)).//
					lastName(String.format("lastName for Employee-%s", i)).//
					email(String.format("email for Employee-%s", i)).//
					build();
			mapper.save(employee);
		}
	}
}
