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
     * 0,no 1,loosew,2muc
     */
    @TableField("goalType")
    private Integer goalType;

    private Integer uid;
    private Integer bfpid;
    private Integer score;

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

    public Integer getBFPid() {
        return bfpid;
    }

    public void setBFPid(Integer bfpid) {
        this.bfpid = bfpid;
    }
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Prompt{" +
            "id=" + id +
            ", type=" + type +
            ", content=" + content +
            ", goalType=" + goalType +
            ", uid=" + uid +
            ", uid=" + bfpid +
            ", score="+ score +
        "}";
    }
}
