package com.vvs.javastreamsproc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.vvs.javastreamsproc.model.Employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaStreamsProcApplication {

	public static List<Employee> getEmpList() {
		return Arrays.asList(
			new Employee(UUID.randomUUID().toString().substring(0, 31), "Zacharias", "Schwerin", "zchwerin@gmail.com", "Male", "True", 101146, 0),
			new Employee(UUID.randomUUID().toString().substring(0, 31), "Kyle", "Frudd", "kfrudd1@ovh.net", "Male", "FALSE", 29310, 2),
			new Employee(UUID.randomUUID().toString().substring(0, 31), "Axe", "Gumb", "agumb2@twitter.com", "Female", "FALSE", 62291, 4),
			new Employee(UUID.randomUUID().toString().substring(0, 31), "Robinet", "Batterham", "rbatterham3@last.fm", "Male", "FALSE", 142439, 4),
			new Employee(UUID.randomUUID().toString().substring(0, 31), "Ulick", "Burrel", "uburrel4@google.ru", "Male", "FALSE", 128764, 5),
			new Employee(UUID.randomUUID().toString().substring(0, 31), "Tailor", "Ridding", "Ridding", "Female", "FALSE", 152924, 4),
			new Employee(UUID.randomUUID().toString().substring(0, 31), "Joete", "Braybrooke", "jbraybrooke6@prnewswire.com", "Male", "TRUE", 128907, 0),
			new Employee(UUID.randomUUID().toString().substring(0, 31), "Elroy", "Baverstock", "ebaverstock7@ehow.com", "Male", "TRUE", 2510, 0)
		);
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaStreamsProcApplication.class, args);

		List<Employee> empList = getEmpList();
		System.out.println("\n");
		// empList.stream().forEach(System.out::println);
		// empList.stream()
		// 	.filter(e -> e.getGender().equals("Female"))
		// 	.forEach(System.out::println);
		// empList.stream()
		// 	.filter(e -> e.getNewJoiner().equals("True"))
		// 	.forEach(System.out::println);
		// empList.stream()
		// 	.sorted(Comparator.comparing(Employee::getRating).reversed())
		// 	.forEach(System.out::println);
		// empList.stream()
		// 	.sorted(Comparator.comparing(Employee::getRating).reversed())
		// 	.sorted(Comparator.comparing(Employee::getRating).reversed())
		// 	.forEach(System.out::println);
		// boolean isSalary = empList.stream()
		// 	.allMatch(e -> e.getSalary() > 1000);
		// System.out.println(isSalary);
		empList.stream()
			.max(Comparator.comparing(Employee::getSalary))
			.ifPresent(System.out::println);
		System.out.println("\n");

		Map<String, List<Employee>> employeesBygenger = empList.stream()
			.collect(Collectors.groupingBy(Employee::getGender));
		employeesBygenger.forEach(((g, e) -> {
			System.out.print(g);
			e.forEach(System.out::println);
		}));
		System.out.println("\n");
	}

}
