package com.durbar.ottservice.models.category.root.all;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubCategory {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("seo_title")
    @Expose
    private String seoTitle;
    @SerializedName("seo_description")
    @Expose
    private String seoDescription;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("root_category_id")
    @Expose
    private Integer rootCategoryId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;


    public SubCategory(

            Integer id, String title, String slug, String image, Integer order,
            String seoTitle, String seoDescription, String status,
            Integer rootCategoryId, String createdAt, String updatedAt
    )
    {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.image = image;
        this.order = order;
        this.seoTitle = seoTitle;
        this.seoDescription = seoDescription;
        this.status = status;
        this.rootCategoryId = rootCategoryId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public String getImage() {
        return image;
    }

    public Integer getOrder() {
        return order;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public String getStatus() {
        return status;
    }

    public Integer getRootCategoryId() {
        return rootCategoryId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
