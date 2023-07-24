package com.management.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * <p>
 *
 * </p>
 *
 * @author Xiaoyang
 * @since 2023-04-28
 */
public class Diet implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "diet_id", type = IdType.AUTO)
    private Integer dietId;
    private Integer questionId;
    private Integer userId;
    private String recipe;
    private LocalTime createTime;

    public Integer getDietId() {
        return dietId;
    }

    public void setDietId(Integer dietId) {
        this.dietId = dietId;
    }
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
    public LocalTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Diet{" +
            "dietId=" + dietId +
            ", questionId=" + questionId +
            ", userId=" + userId +
            ", recipe=" + recipe +
            ", createTime=" + createTime +
        "}";
    }
}
