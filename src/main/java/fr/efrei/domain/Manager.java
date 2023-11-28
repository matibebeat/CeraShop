package fr.efrei.domain;

public class Manager {
    private Employee employee;

    // Constructor for Manager
    public Manager(Builder builder) {
        this.employee = new Employee.Builder()
                .setId(builder.id)
                .setName(builder.name)
                .setPassword(builder.password)
                .build();
    }

    // Getter methods to access Employee's attributes
    public int getId() {
        return employee.getId();
    }

    public String getName() {
        return employee.getName();
    }

    public String getPassword() {
        return employee.getPassword();
    }

    // Additional methods specific to Manager can be added here

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }

    public static class Builder {
        private int id;
        private String name;
        private String password;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Manager build() {
            return new Manager(this);
        }
    }
}
