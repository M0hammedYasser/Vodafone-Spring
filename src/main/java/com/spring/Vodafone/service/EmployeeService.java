package com.spring.Vodafone.service;

import com.spring.Vodafone.exception.exceptions.EmployeeNotFoundException;
import com.spring.Vodafone.model.dto.EmployeeDto;
import com.spring.Vodafone.model.entity.Employee;
import com.spring.Vodafone.model.mapper.EmployeeMapper;
import com.spring.Vodafone.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;


    public List<EmployeeDto> getAllEmployees() {
        return repository.findAll().stream()
                .map(mapper::mapToDto)
                .collect(toList());
    }

    public EmployeeDto getEmployeeById(Long id) {
        Employee emp = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));
        return mapper.mapToDto(emp);
    }

    public EmployeeDto createEmployee(EmployeeDto dto) {
        Employee emp = repository.save(mapper.mapToEntity(dto));
        return mapper.mapToDto(emp);
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
        Employee emp = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));

        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());
        emp.setEmail(dto.getEmail());
        emp.setPosition(dto.getPosition());

        return mapper.mapToDto(repository.save(emp));
    }

    public void deleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        repository.deleteById(id);
    }
}
