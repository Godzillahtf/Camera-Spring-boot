package com.example.demo.service;

import com.example.demo.dao.MapDao;
import com.example.demo.dao.MarkDao;
import com.example.demo.model.Map;
import com.example.demo.model.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService {
    @Autowired
    MapDao mapDao;
    @Autowired
    MarkDao markDao;

    public List<Map> getMapByUserid(int userid) {
        List<Map> ret = mapDao.getMapByUserId(userid);
        for(Map m: ret) {
            List<Mark> mark = markDao.getMarkByMapId(m.getId());
            Mark[] marks = new Mark[mark.size()];
            for(int i=0;i<mark.size();i++) {
                marks[i] = mark.get(i);
            }
            m.setMarks(marks);
            m.setMarkNumber(mark.size());
        }

        return ret;
    }

    public void addMap(Map map) {
        mapDao.insertMap(map);
    }

    public void deleteMap(int id) {
        mapDao.deleteMapById(id);
    }

    public List<Mark> getMarkByMapId(int mapId) {
        List<Mark> mark = markDao.getMarkByMapId(mapId);
        return mark;
    }

    public Mark getMark(int markId) {
        return markDao.getMarkByMarkId(markId);
    }

    public void updateMark(Mark mark) {
        markDao.updateMarkById(mark);
    }

    public void insertMark(Mark mark) {
        markDao.insertMark(mark);
        mapDao.upMarkNumber(mark.getMapId());
    }

    public void deleteMark(int markId) {
        mapDao.downMarkNumber(markDao.getMarkByMarkId(markId).getMapId());
        markDao.deleteMarkById(markId);
    }
}
