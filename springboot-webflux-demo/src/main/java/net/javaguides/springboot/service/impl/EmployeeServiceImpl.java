package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.mapper.EmployeeMapper;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee newEmployee = EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> savedEmployee = employeeRepository.save(newEmployee);
        return savedEmployee.map((employeeEntity) -> EmployeeMapper.mapToEmployeeDto(employeeEntity));
    }

    @Override
    public Mono<EmployeeDto> getEmployee(String id) {
        Mono <Employee> employee = employeeRepository.findById(id);
        return employee.map((employeeEntity) -> EmployeeMapper.mapToEmployeeDto(employeeEntity));
    }

    @Override
    public Flux<EmployeeDto> getAllEmployees() {
       Flux<Employee> employees = employeeRepository.findAll();
        return employees.map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String id) {

        Mono<Employee> employee = employeeRepository.findById(id);
        Mono <Employee> updatedEmployee = employee.flatMap((existingEmployee) -> {
           existingEmployee.setFirstName(employeeDto.getFirstName());
           existingEmployee.setLastName(employeeDto.getLastName());
           existingEmployee.setEmail(employeeDto.getEmail());

           return employeeRepository.save(existingEmployee);
        });

        return updatedEmployee.map((employee1) -> EmployeeMapper.mapToEmployeeDto(employee1));
    }

    @Override
    public Mono<Void> deleteEmployee(String id) {
        return employeeRepository.deleteById(id);
    }
}
