package Forms;

import Framework.BaseForm;
import Framework.Button;
import Framework.TextBox;
import Models.UserData;
import org.openqa.selenium.By;

public class RegistrationForm extends BaseForm {

    private final TextBox firstNameInput = new TextBox(By.id("firstName"), "firstNameInput");
    private final TextBox lastNameInput = new TextBox(By.id("lastName"), "lastNameInput");
    private final TextBox emailInput = new TextBox(By.id("userEmail"), "emailInput");
    private final TextBox ageInput = new TextBox(By.id("age"), "ageInput");
    private final TextBox salaryInput = new TextBox(By.id("salary"), "salaryInput");
    private final TextBox departmentInput = new TextBox(By.id("department"), "departmentInput");
    private final Button submitButton = new Button(By.id("submit"), "submitButton");


    public RegistrationForm() {
        super(By.id("registration-form-modal"), "registrationForm");
    }

    public void fillTheForm(UserData user) {
        firstNameInput.putText(user.getName());
        lastNameInput.putText(user.getLastName());
        emailInput.putText(user.getEmail());
        ageInput.putText(user.getAge());
        salaryInput.putText(user.getSalary());
        departmentInput.putText(user.getDepartment());
        submitButton.scrollTo().click();
    }
}
