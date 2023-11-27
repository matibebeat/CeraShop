package fr.efrei.domain;

public class Employee {
    private int id;
    private String name;
    private String password;

    private Employee(){
    }
    private Employee(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.password = builder.password;
    }
    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
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

        public Employee build() {
            return new Employee(this);
        }
    }
}

