package com.study.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "m_music")
public class MMusic {
    /**
     * 歌曲名称
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 歌曲名称
     */
    private String name;

    /**
     * 歌曲文件上传路径
     */
    private String url;

    /**
     * 所属专辑
     */
    @Column(name = "album_id")
    private Integer albumId;

    /**
     * 演唱者
     */
    private String singer;

    /**
     * 作词
     */
    private String author;

    /**
     * 作曲
     */
    @Column(name = "Composer")
    private String composer;

    /**
     * 类型 1 翻唱 2 原创
     */
    private Integer type;

    /**
     * 状态 0 删除 1 审核 2 通过
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     *  最近修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 发布时间
     */
    @Column(name = "public_time")
    private Date publicTime;

    /**
     * 歌词
     */
    @Column(name = "Lyric")
    private String lyric;

    /**
     * 获取歌曲名称
     *
     * @return id - 歌曲名称
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置歌曲名称
     *
     * @param id 歌曲名称
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取歌曲名称
     *
     * @return name - 歌曲名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置歌曲名称
     *
     * @param name 歌曲名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取歌曲文件上传路径
     *
     * @return url - 歌曲文件上传路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置歌曲文件上传路径
     *
     * @param url 歌曲文件上传路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取所属专辑
     *
     * @return album_id - 所属专辑
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 设置所属专辑
     *
     * @param albumId 所属专辑
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 获取演唱者
     *
     * @return singer - 演唱者
     */
    public String getSinger() {
        return singer;
    }

    /**
     * 设置演唱者
     *
     * @param singer 演唱者
     */
    public void setSinger(String singer) {
        this.singer = singer;
    }

    /**
     * 获取作词
     *
     * @return author - 作词
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作词
     *
     * @param author 作词
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取作曲
     *
     * @return Composer - 作曲
     */
    public String getComposer() {
        return composer;
    }

    /**
     * 设置作曲
     *
     * @param composer 作曲
     */
    public void setComposer(String composer) {
        this.composer = composer;
    }

    /**
     * 获取类型 1 翻唱 2 原创
     *
     * @return type - 类型 1 翻唱 2 原创
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型 1 翻唱 2 原创
     *
     * @param type 类型 1 翻唱 2 原创
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取状态 0 删除 1 审核 2 通过
     *
     * @return status - 状态 0 删除 1 审核 2 通过
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0 删除 1 审核 2 通过
     *
     * @param status 状态 0 删除 1 审核 2 通过
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
     * 获取 最近修改时间
     *
     * @return update_time -  最近修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 最近修改时间
     *
     * @param updateTime  最近修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取发布时间
     *
     * @return public_time - 发布时间
     */
    public Date getPublicTime() {
        return publicTime;
    }

    /**
     * 设置发布时间
     *
     * @param publicTime 发布时间
     */
    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    /**
     * 获取歌词
     *
     * @return Lyric - 歌词
     */
    public String getLyric() {
        return lyric;
    }

    /**
     * 设置歌词
     *
     * @param lyric 歌词
     */
    public void setLyric(String lyric) {
        this.lyric = lyric;
    }
}