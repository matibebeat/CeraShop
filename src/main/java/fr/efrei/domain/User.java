package fr.efrei.domain;

public class User extends Employee {

    private String email;

    private String password;

    private Role role;

    private User() {}

    private User(Builder builder) {
        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder {
        private int employeeId;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private Role role;

        public Builder setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}