package fr.efrei.domain;

public class Product {
    private int id;
    private String description;
    private String size;
    private int quantity;

    private Product(){
    }
    private Product(Builder builder){
        this.description = builder.description;
        this.id = builder.id;
        this.quantity = builder.quantity;
        this.size = builder.size;
    }
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + id +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public static class Builder {
        private int id;
        private String description;
        private String size;
        private int quantity;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setSize(String size) {
            this.size = size;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}

