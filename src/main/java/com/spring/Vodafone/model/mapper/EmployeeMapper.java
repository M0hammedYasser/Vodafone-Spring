package com.spring.Vodafone.model.mapper;

import com.spring.Vodafone.model.dto.EmployeeDto;
import com.spring.Vodafone.model.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {


    public EmployeeDto mapToDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .position(employee.getPosition())
                .build();
    }

    public Employee mapToEntity(EmployeeDto dto) {
        return Employee.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .position(dto.getPosition())
                .build();
    }

}
