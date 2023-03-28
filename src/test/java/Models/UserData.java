package Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserData {
    @JsonProperty("name")
    private String name;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("age")
    private String age;
    @JsonProperty("salary")
    private String salary;
    @JsonProperty("department")
    private String department;

    public UserData() {
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public List<String> getPropertiesAsList() {
        return List.of(name, lastName, email, age, salary, department);
    }
}
