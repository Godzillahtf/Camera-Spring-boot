package com.example.demo.controller;

import com.example.demo.model.Group;
import com.example.demo.model.VersionConfig;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
public class GroupController {
    @Autowired
    GroupService groupService;

    @RequestMapping(path = {"/getRootGroup"})
    @ResponseBody
    public Map<String, Object> getRootGroup(@RequestBody Map m) {
        int userId = Integer.parseInt(m.get("userId").toString());
        Group root = groupService.getRootByUserId(userId);

        Map<String, Object> ret = new HashMap<>();
        ret.put("node", new Group[]{groupService.getRootByUserId(userId)});
        return ret;
    }

    @RequestMapping(path = {"/deleteLeafGroup"})
    @ResponseBody
    public Map<String, Object> deleteLeafGroup(@RequestBody Map m) {
        int id = Integer.parseInt(m.get("id").toString());

        groupService.deleteGroup(id);
        Map<String, Object> ret = new HashMap<>();
        ret.put("code", 0);
        return ret;
    }

    @RequestMapping(path = {"/addGroup"})
    @ResponseBody
    public Map<String, Object> addGroup(@RequestBody Map m) {
        int id = Integer.parseInt(m.get("id").toString());
        int nodeType = Integer.parseInt(m.get("nodeType").toString());
        String nodeName = m.get("nodeName").toString();
        String deviceSerial = "";
        if(nodeType == 1) {
            deviceSerial = m.get("deviceSerial").toString();
        }

        Group group = groupService.getGroupById(id);
        Group son = new Group(1, group.getUserId(), nodeType, group.getNodeLevel()+1, group.getId(), nodeName, deviceSerial);

        groupService.addGroup(son);
        Map<String, Object> ret = new HashMap<>();
        ret.put("node", new Group[]{groupService.getRootByUserId(group.getUserId())});
        return ret;
    }

}
