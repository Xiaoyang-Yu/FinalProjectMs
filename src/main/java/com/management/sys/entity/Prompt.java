package com.management.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Xiaoyang
 * @since 2023-09-09
 */
public class Prompt implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 1,diet 2,exsersice
     */
    private Integer type;

    private String content;

    /**
     * 1,office 2,outside
     * 遇到map字段名字与数据库表中字段名不符合问题
     * 解决方案：将FieldName强制写成与数据库一致    @TableField("workType")
     */
    @TableField("workType")
    private Integer workType;

    /**
     * 1,true 0,false
     */
    @TableField("isVegetarian")
    private Boolean isVegetarian;

    /**
     * 1,peanut 2,milk
     */
    private Integer allergens;

    /**
     * 1,high blood pressure
     */
    private Integer disease;

    /**
     * 0,no 1,loosew,2muc
     */
    @TableField("goalType")
    private Integer goalType;

    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }
    public Boolean getIsVegetarian() {
        return isVegetarian;
    }

    public void setIsVegetarian(Boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }
    public Integer getAllergens() {
        return allergens;
    }

    public void setAllergens(Integer allergens) {
        this.allergens = allergens;
    }
    public Integer getDisease() {
        return disease;
    }

    public void setDisease(Integer disease) {
        this.disease = disease;
    }
    public Integer getGoalType() {
        return goalType;
    }

    public void setGoalType(Integer goalType) {
        this.goalType = goalType;
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Prompt{" +
            "id=" + id +
            ", type=" + type +
            ", content=" + content +
            ", workType=" + workType +
            ", isVegetarian=" + isVegetarian +
            ", allergens=" + allergens +
            ", disease=" + disease +
            ", goalType=" + goalType +
            ", uid=" + uid +
        "}";
    }
}
