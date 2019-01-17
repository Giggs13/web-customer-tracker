package com.giggs13.web.dao;

import com.giggs13.web.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void save(Customer customer);

    Customer getCustomer(Integer id);

    void delete(Integer id);

    List<Customer> searchByName(String searchName);
}
