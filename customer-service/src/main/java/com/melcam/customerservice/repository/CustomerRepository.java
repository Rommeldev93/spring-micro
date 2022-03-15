package com.melcam.customerservice.repository;

import com.melcam.customerservice.entity.Customer;
import com.melcam.customerservice.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  public Customer findByNumberID(String numberID);

  public List<Customer> findByLastName(String lastName);

  public List<Customer> findByRegion(Region region);
}
