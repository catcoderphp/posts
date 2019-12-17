package com.catcoderdev.Posts.Entity;

import Utils.Utils;
import com.catcoderdev.Posts.Model.PostRequest;

import javax.persistence.*;

@Entity
@Table(name = "properties")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String location;
    private int category_id;
    private String description;
    private int price;
    private int created_by;
    private long created_at;
    private long updated_at;
    private long active_until;
    private String seo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }

    public long getActive_until() {
        return active_until;
    }

    public void setActive_until(long active_until) {
        this.active_until = active_until;
    }

    public String getSeo() {
        return seo;
    }

    public void setSeo(String seo) {
        this.seo = Utils.toSlug(seo);
    }

    public void mapFromRequest(PostRequest request) {
        this.setTitle(request.getTitle());
        this.setLocation(request.getLocation());
        this.setCategory_id(request.getCategory_id());
        this.setDescription(request.getDescription());
        this.setPrice(request.getPrice());
        this.setCreated_by(request.getCreated_by());
        this.setCreated_at(Utils.getCurrentTimeUnix(0));
        this.setUpdated_at(Utils.getCurrentTimeUnix(0));
        this.setActive_until(Utils.getCurrentTimeUnix(Utils.ADDITIONAL_DAYS));
        this.setSeo(request.getTitle());
    }
}