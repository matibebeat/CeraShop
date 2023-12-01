package fr.efrei.domain;

public class Customer {

    private long phone;
    private String name;
    private int purchases   ;

    private Customer(){
    }
    private Customer(Builder builder){
        this.phone = builder.phone;
        this.name = builder.name;
        this.purchases = builder.purchases;
    }
    public long getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getPurchases() {
        return purchases;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "phone=" + phone +
                ", name='" + name + '\'' +
                ", purchases=" + purchases +
                '}';
    }

    public static class Builder {
        public long phone;
        private int purchases;
        private String name;

        public Builder setPurchases(int purchases) {
            this.purchases = purchases;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPhone(long phone) {
            this.phone = phone;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}