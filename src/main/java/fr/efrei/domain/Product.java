package fr.efrei.domain;

public class Product {
    private int id;
    private String description;
    private Size size;
    private Color color;

    private Product(){
    }
    private Product(Builder builder){
        this.description = builder.description;
        this.id = builder.id;
        this.color = builder.color;
        this.size = builder.size;
    }
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + id +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                ", color=" + color +
                '}';
    }

    public static class Builder {
        private int id;
        private String description;
        private Size size;
        private Color color;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setSize(Size size) {
            this.size = size;
            return this;
        }

        public Builder setColor(Color color) {
            this.color = color;
            return this;
        }

        public Product build() {return new Product(this);}
    }
}

