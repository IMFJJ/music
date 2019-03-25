package com.study.service;

import com.study.model.MMusic;

import java.util.List;

public interface MMusicService  {
    List<MMusic> findList(Integer ablumId);
}
