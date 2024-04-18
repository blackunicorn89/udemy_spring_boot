package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    //Method to handle reactive get all employees REST API calls
    @GetMapping()
    public Flux<EmployeeDto> getEmployees() {
        return employeeService.getAllEmployees();
    }

    //Method to handle reactive get an employee REST API calls
    @GetMapping("/{id}")
    public Mono<EmployeeDto> getEmployee(@PathVariable("id") String id) {
        return employeeService.getEmployee(id);
    }

    //Method to handle reactive save employee REST API calls
    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

    //Method to handle reactive update employee REST API calls
    @PutMapping("/update/{id}")
    public Mono<EmployeeDto> UpdateEmployee(@PathVariable("id") String id, @RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(employeeDto, id);
    }

    //Method to handle reactive delete employee REST API calls
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> DeleteEmployee(@PathVariable("id") String id) {
        return employeeService.deleteEmployee(id);
    }
}
