package net.rasikalakmal.employeemanagementsystembackend.reposiory;

import net.rasikalakmal.employeemanagementsystembackend.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
