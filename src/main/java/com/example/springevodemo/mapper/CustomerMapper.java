package com.example.springevodemo.mapper;

import com.example.springevodemo.dao.CustomerEntity;
import com.example.springevodemo.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "firstName", target = "name", qualifiedByName = "test")
    CustomerEntity mapToEntity(Customer customer);
    Customer mapToCustomer(CustomerEntity customerEntity);

    @Named("test")
    default String test(String firstName) {
        //
        return firstName.toUpperCase();
    }
}
