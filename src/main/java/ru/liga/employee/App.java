package ru.liga.employee;

import ru.liga.employee.domain.Employee;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        List<String> strings = namesOfYoungAndRichEmployees(Arrays.asList(
                new Employee("Витя", 20, 110000),
                new Employee("Константин Иванович", 38, 90000),
                new Employee("Владислав Игнатьевич", 37, 300000),
                new Employee("Настя", 19, 190000),
                new Employee("Вова", 20, 30000)));
        System.out.println(strings);
    }

    /**
     *
     * @param allEmployees список сотрудников
     * @return Список имен сотрудников отсортированном по алфавиту, у которых зарплата больше 100 000 и возраст меньше 21 лет
     */
    public static List<String> namesOfYoungAndRichEmployees(List<Employee> allEmployees) {
        return allEmployees.stream()
                .filter(employee -> employee.getAge() < 21)
                .filter(employee -> employee.getSalary() > 100000)
                .map(Employee::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
