package com.springbootcamp.springsecurity.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductDto {
    private Long id;

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    private String description;

    private boolean isCancellable;
    private boolean isReturnable;

    @Size(max = 25)
    @NotNull
    private String brand;
    private boolean isActive;

    public ProductDto(){

    }

    public ProductDto(Long id, @NotNull @Size(max = 50) String name, @NotNull String description,
                      boolean isCancellable, boolean isReturnable, @Size(max = 25) @NotNull String brand,
                      boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isCancellable = isCancellable;
        this.isReturnable = isReturnable;
        this.brand = brand;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCancellable() {
        return isCancellable;
    }

    public void setCancellable(boolean cancellable) {
        isCancellable = cancellable;
    }

    public boolean isReturnable() {
        return isReturnable;
    }

    public void setReturnable(boolean returnable) {
        isReturnable = returnable;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isCancellable=" + isCancellable +
                ", isReturnable=" + isReturnable +
                ", brand='" + brand + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
