package com.study.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "m_version")
public class MVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 版本名称
     */
    private String name;

    /**
     * 类型状态 0 删除 1 正常
     */
    private Integer status;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取版本名称
     *
     * @return name - 版本名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置版本名称
     *
     * @param name 版本名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取类型状态 0 删除 1 正常
     *
     * @return status - 类型状态 0 删除 1 正常
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置类型状态 0 删除 1 正常
     *
     * @param status 类型状态 0 删除 1 正常
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}