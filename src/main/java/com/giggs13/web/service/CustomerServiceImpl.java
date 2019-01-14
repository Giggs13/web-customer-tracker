package com.giggs13.web.service;

import com.giggs13.web.dao.CustomerDAO;
import com.giggs13.web.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl
        implements CustomerService {

    private CustomerDAO customerDAO;

    public CustomerServiceImpl(@Autowired CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional(readOnly = true)
    public Customer getCustomer(Integer id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        customerDAO.save(customer);
    }
}
