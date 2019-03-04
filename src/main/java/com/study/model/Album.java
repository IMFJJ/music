package com.study.model;

import java.util.Date;
import javax.persistence.*;

public class Album {
    /**
     * 专辑id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 专辑类型 专辑 EP/Single 精选集 合集 杂集
     */
    private Integer type;

    /**
     * 专辑名称
     */
    private String name;

    /**
     * 专辑版本 现场版 伴奏版 录音室版 混合版 Demo及其他
     */
    private Integer version;

    /**
     * 发行日期
     */
    @Column(name = "public_time")
    private Date publicTime;

    /**
     * 语种 华语 日语 韩语 欧美 其他
     */
    private Integer languages;

    private Integer style;

    private String statement;

    /**
     *  专辑封面图
     */
    @Column(name = "cover_image")
    private String coverImage;

    /**
     * 状态 0 删除 1 审核中  2 发布成功
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取专辑id
     *
     * @return id - 专辑id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置专辑id
     *
     * @param id 专辑id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取专辑类型 专辑 EP/Single 精选集 合集 杂集
     *
     * @return type - 专辑类型 专辑 EP/Single 精选集 合集 杂集
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置专辑类型 专辑 EP/Single 精选集 合集 杂集
     *
     * @param type 专辑类型 专辑 EP/Single 精选集 合集 杂集
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取专辑名称
     *
     * @return name - 专辑名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置专辑名称
     *
     * @param name 专辑名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取专辑版本 现场版 伴奏版 录音室版 混合版 Demo及其他
     *
     * @return version - 专辑版本 现场版 伴奏版 录音室版 混合版 Demo及其他
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置专辑版本 现场版 伴奏版 录音室版 混合版 Demo及其他
     *
     * @param version 专辑版本 现场版 伴奏版 录音室版 混合版 Demo及其他
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取发行日期
     *
     * @return public_time - 发行日期
     */
    public Date getPublicTime() {
        return publicTime;
    }

    /**
     * 设置发行日期
     *
     * @param publicTime 发行日期
     */
    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    /**
     * 获取语种 华语 日语 韩语 欧美 其他
     *
     * @return languages - 语种 华语 日语 韩语 欧美 其他
     */
    public Integer getLanguages() {
        return languages;
    }

    /**
     * 设置语种 华语 日语 韩语 欧美 其他
     *
     * @param languages 语种 华语 日语 韩语 欧美 其他
     */
    public void setLanguages(Integer languages) {
        this.languages = languages;
    }

    /**
     * @return style
     */
    public Integer getStyle() {
        return style;
    }

    /**
     * @param style
     */
    public void setStyle(Integer style) {
        this.style = style;
    }

    /**
     * @return statement
     */
    public String getStatement() {
        return statement;
    }

    /**
     * @param statement
     */
    public void setStatement(String statement) {
        this.statement = statement;
    }

    /**
     * 获取 专辑封面图
     *
     * @return cover_image -  专辑封面图
     */
    public String getCoverImage() {
        return coverImage;
    }

    /**
     * 设置 专辑封面图
     *
     * @param coverImage  专辑封面图
     */
    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    /**
     * 获取状态 0 删除 1 审核中  2 发布成功
     *
     * @return status - 状态 0 删除 1 审核中  2 发布成功
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0 删除 1 审核中  2 发布成功
     *
     * @param status 状态 0 删除 1 审核中  2 发布成功
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}