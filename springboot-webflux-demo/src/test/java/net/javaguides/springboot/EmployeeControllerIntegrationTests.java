package net.javaguides.springboot;

import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    public void before() {
        System.out.println("Before the test empty database table");
        employeeRepository.deleteAll().subscribe();
    }

    @Test
    public void testSaveEmployee() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Mock");
        employeeDto.setLastName("Luser");
        employeeDto.setEmail("test.user@fakecompany.com");

        webTestClient.post().uri("/api/employees/add").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).body(Mono.just(employeeDto), EmployeeDto.class)
                .exchange().expectStatus().isCreated().expectBody().consumeWith(System.out::println)
                .jsonPath("$.firstName").isEqualTo(employeeDto.getFirstName())
                .jsonPath("$.lastName").isEqualTo(employeeDto.getLastName())
                .jsonPath("$.email").isEqualTo(employeeDto.getEmail());

    }
    @Test
    public void testGettingEmployeeById() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Suksi");
        employeeDto.setLastName("Suohon");
        employeeDto.setEmail("suksi.suohon@fakecompany.com");

        EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto).block();

        webTestClient.get().uri("/api/employees/{id}", Collections.singletonMap("id", savedEmployeeDto.getId()))
                .exchange().expectStatus().isOk().expectBody().consumeWith(System.out::println)
                .jsonPath("$.id").isEqualTo(savedEmployeeDto.getId())
                .jsonPath("$.firstName").isEqualTo(savedEmployeeDto.getFirstName())
                .jsonPath("$.lastName").isEqualTo(savedEmployeeDto.getLastName())
                .jsonPath("$.email").isEqualTo(savedEmployeeDto.getEmail());
    }
    @Test
    public void testGetAllEmployees() {
        webTestClient.get().uri("/api/employees").accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk()
                .expectBodyList(EmployeeDto.class).consumeWith(System.out::println);
    }

    @Test
    public void testUpdateEmployee() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Suksi");
        employeeDto.setLastName("Suohon");
        employeeDto.setEmail("suksi.suohon@fakecompany.com");

        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto).block();

        EmployeeDto updatedEmployeeDto = new EmployeeDto();
        updatedEmployeeDto.setFirstName("Luistin");
        updatedEmployeeDto.setLastName("Hiekkaan");
        updatedEmployeeDto.setEmail("lustin.hiekkaan@fakecompany.com");

        webTestClient.put().uri("/api/employees/update/{id}", Collections.singletonMap("id", savedEmployee.getId()))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(updatedEmployeeDto), EmployeeDto.class)
                .exchange().expectStatus().isOk().expectBody().consumeWith(System.out:: println)
                .jsonPath("$.firstName").isEqualTo(updatedEmployeeDto.getFirstName())
                .jsonPath("$.lastName").isEqualTo(updatedEmployeeDto.getLastName())
                .jsonPath("$.email").isEqualTo(updatedEmployeeDto.getEmail());

    }

    @Test
    public void testDeleteEmployee() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Suksi");
        employeeDto.setLastName("Suohon");
        employeeDto.setEmail("suksi.suohon@fakecompany.com");

        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto).block();

        webTestClient.delete().uri("/api/employees/delete/{id}", Collections.singletonMap("id", savedEmployee.getId()))
                .exchange().expectStatus().isNoContent().expectBody().consumeWith(System.out::println);
    }

}
