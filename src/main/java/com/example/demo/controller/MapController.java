package com.example.demo.controller;


import com.example.demo.model.Group;
import com.example.demo.model.Mark;
import com.example.demo.service.MapService;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
public class MapController {

    @Autowired
    MapService mapService;

    @RequestMapping(path = {"/getMap"})
    @ResponseBody
    public Map<String, Object> getMap(@RequestBody Map m) {
        int userId = Integer.parseInt(m.get("userId").toString());

        List<com.example.demo.model.Map> map = mapService.getMapByUserid(userId);

        Map<String, Object> ret = new HashMap<>();
        ret.put("map", map);
        return ret;
    }

    @RequestMapping(path = {"/addMap"})
    @ResponseBody
    public Map<String, Object> addMap(@RequestBody Map m) {
        int userId = Integer.parseInt(m.get("userId").toString());
        String mapName = m.get("mapName").toString();
        String mapUrl = m.get("mapUrl").toString();

        com.example.demo.model.Map map = new com.example.demo.model.Map(1, userId, mapName, mapUrl, 0);

        mapService.addMap(map);

        List<com.example.demo.model.Map> mm = mapService.getMapByUserid(userId);


        Map<String, Object> ret = new HashMap<>();
        ret.put("map", mm);
        return ret;
    }


    @RequestMapping(path = {"/deleteMap"})
    @ResponseBody
    public Map<String, Object> deleteMap(@RequestBody Map m) {
        int id = Integer.parseInt(m.get("id").toString());
        int userId = Integer.parseInt(m.get("userId").toString());

        mapService.deleteMap(id);

        Map<String, Object> ret = new HashMap<>();
        ret.put("map", mapService.getMapByUserid(userId));
        return ret;
    }

    @RequestMapping(path = {"/updateMark"})
    @ResponseBody
    public Map<String, Object> updateMark(@RequestBody Map m) {

        List<Mark> marks = (List<Mark>)(m.get("mark"));
        int mapId = 0;
        for(Object mm : marks) {
            LinkedHashMap<String, Object> lhm = (LinkedHashMap<String, Object>)mm;
            int id = (Integer)lhm.get("id");
            mapId = (Integer)lhm.get("mapId");
            String markName = lhm.get("markName").toString();
            double rowMark = (Double)lhm.get("rowMark");
            double columnMark = (Double)lhm.get("columnMark");
            String deviceSerial = lhm.get("deviceSerial").toString();
            String deviceName = lhm.get("deviceName").toString();

            Mark mark = new Mark(id, mapId, markName, (float)rowMark, (float)columnMark, deviceSerial, deviceName);
            mapService.updateMark(mark);
        }


        Map<String, Object> ret = new HashMap<>();
        ret.put("mark", mapService.getMarkByMapId(mapId));
        return ret;
    }

    @RequestMapping(path = {"/addMark"})
    @ResponseBody
    public Map<String, Object> addMark(@RequestBody Map m) {
        int mapId = Integer.parseInt(m.get("mapId").toString());
        String markName = m.get("markName").toString();
        float row = Float.parseFloat(m.get("rowMark").toString());
        float column = Float.parseFloat(m.get("columnMark").toString());
        String deviceSerial = m.get("deviceSerial").toString();
        String deviceName = m.get("deviceName").toString();

        Mark mark = new Mark(1, mapId, markName, row, column, deviceSerial, deviceName);

        mapService.insertMark(mark);

        Map<String, Object> ret = new HashMap<>();
        ret.put("mark", mapService.getMarkByMapId(mapId));
        return ret;
    }

    @RequestMapping(path = {"/deleteMark"})
    @ResponseBody
    public Map<String, Object> deleteMark(@RequestBody Map m) {
        int id = Integer.parseInt(m.get("id").toString());

        Mark mark = mapService.getMark(id);
        mapService.deleteMark(id);

        Map<String, Object> ret = new HashMap<>();
        ret.put("mark", mapService.getMarkByMapId(mark.getMapId()));
        return ret;
    }








}
