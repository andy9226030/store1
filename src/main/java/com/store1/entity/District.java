package com.store1.entity;

import java.util.Objects;

public class District extends BaseEntity {
    private Integer id;
    private String parent;
    private String code;
    private String name;

    @Override
    public String toString() {
        return "dispicker{" +
                "id=" + id +
                ", parent='" + parent + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        District dispicker = (District) o;

        if (!Objects.equals(id, dispicker.id)) return false;
        if (!Objects.equals(parent, dispicker.parent)) return false;
        if (!Objects.equals(code, dispicker.code)) return false;
        return Objects.equals(name, dispicker.name);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getparent() {
        return parent;
    }

    public void setparent(String parent) {
        this.parent = parent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
