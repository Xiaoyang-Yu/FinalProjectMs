package com.management.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Xiaoyang
 * @since 2023-09-09
 */
@TableName("Body_Fat_Percentage")
public class BodyFatPercentage implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer uid;
    /** 身高 单位：cm*/
    private Integer height;
    /** 体重 单温：kg*/
    private Integer weight;
    /** 体脂率 用户输入*/
    private Integer bfp;

    /** 身体质量指数(BMI) = (体重/2.205) / (身高/39.37)^2 */

    /**
      身体质量指数(BMI) < 18.5:	低于正常体重
      身体质量指数(BMI) >= 18.5 以及 < 25:	正常体重
      身体质量指数(BMI) >= 25 以及 < 30:	超重
      身体质量指数(BMI) >= 30 以及 < 35:	一类肥胖
      身体质量指数(BMI) >= 35 以及 < 40:	二类肥胖
      身体质量指数(BMI) >= 40:	三类肥胖
     */
    private Integer bmi;

    private LocalDateTime createTime;

    private Integer age;
    /**  下拉框
    * 1 male
    * 0 female
    */
    private Integer sex;
    /** 工作类型
     * 1,indoor 2,outdoor
     * 遇到map字段名字与数据库表中字段名不符合问题
     * 解决方案：将FieldName强制写成与数据库一致    @TableField("workType")
     */
    @TableField("workType")
    private Integer workType;

    /** 下拉框 是否是素食者
     * 1,true 0,false
     */
    @TableField("isVegetarian")
    private Boolean isVegetarian;

    /** 过敏源
     * 1.Nut and seed 2.Fruit 3.Vegetable 4.Milk
     */
    private Integer allergens;

    /**
     * 1,Atheromatous disease 2.Cancer 3.Chronic respiratory disease 4.Degenerative (including autoimmune) disease
     * 5.Dementia 6.Diabetes 7.Infectious disease 8.Medically unexplained physical symptoms (MUPS)
     * 9.Mental illness and substance abuse 10.Musculoskeletal
     */
    private Integer disease;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public Integer getBfp() {
        return bfp;
    }

    public void setBfp(Integer bfp) {
        this.bfp = bfp;
    }
    public Integer getBmi() {
        return bmi;
    }

    public void setBmi(Integer bmi) {
        this.bmi = bmi;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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
    @Override
    public String toString() {
        return "BodyFatPercentage{" +
            "id=" + id +
            ", uid=" + uid +
            ", height=" + height +
            ", weight=" + weight +
            ", bfp=" + bfp +
            ", bmi=" + bmi +
            ", createTime=" + createTime +
            ", age=" + age +
            ", sex=" + sex + ", workType=" + workType +
            ", isVegetarian=" + isVegetarian +
            ", allergens=" + allergens +
            ", disease=" + disease +
        "}";
    }
}
