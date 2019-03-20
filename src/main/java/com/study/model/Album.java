package com.study.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;

public class Album {
    @Transient
    private  String dateString;
    @Transient
    private  Integer musicCount;
    @Transient
    private String username;
    /**
     * 专辑id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 专辑类型 专辑 EP/Single 精选集 合集 杂集
     */
    @Column(name = "type_id")
    private String type;

    /**
     * 专辑名称
     */
    private String name;

    /**
     * 专辑版本 现场版 伴奏版 录音室版 混合版 Demo及其他
     */
    @Column(name = "version_id")
    private String version;

    /**
     * 发行日期
     */
    @Column(name = "public_time")
    private Date publicTime;


    /**
     * 语种 华语 日语 韩语 欧美 其他
     */
    @Column(name = "languages_id")
    private String languages;

    @Column(name = "style_id")
    private String style ;

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
     * 发布用户的id
     */
    @Column(name = "user_id")
    private Integer userId;

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

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public Integer getMusicCount() {
        return musicCount;
    }

    public void setMusicCount(Integer musicCount) {
        this.musicCount = musicCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
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
     * 获取发布用户的id
     *
     * @return user_id - 发布用户的id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置发布用户的id
     *
     * @param userId 发布用户的id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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