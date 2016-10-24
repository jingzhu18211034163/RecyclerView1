package com.bw.recyclerview.bean;



import java.util.List;

/**
 * Created by 荆著 on 2016/10/24.
 */
public class Forum_list {
    public List<Group>   group;
    public int id;
    public String name;

    public List<Group> getGroup() {
        return group;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Forum_list{" +
                "group=" + group +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class Group{
    public String description;
    public String id;
    public String name;
    public String photo;
    public String total_threads;
    public List<Types> types;

    @Override
    public String toString() {
        return "Group{" +
                "description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", total_threads='" + total_threads + '\'' +
                ", types=" + types +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTotal_threads() {
        return total_threads;
    }

    public void setTotal_threads(String total_threads) {
        this.total_threads = total_threads;
    }

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }
}
class Types{
    public int id;
    public String name;

    @Override
    public String toString() {
        return "Types{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
