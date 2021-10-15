package co.com.sofka.util;

public enum JobVacancy {
    IT_MANAGER("Associate IT Manager"),
    ACCOUNT_ASSISTANT("Junior Account Assistant"),
    PAY_ADMIN("Payroll Administrator"),
    SALES_REPRESENTATIVE("Sales Representative"),
    SENIOR_QA("Senior QA Lead"),
    SUPPORT_SPENCIALIST("Senior Support Specialist"),
    SOF_ENGINEER("Software Engineer");

    private final String value;

    public String getValue() {
        return value;
    }

    JobVacancy(String value) {
        this.value = value;
    }
}
