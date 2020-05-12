package com.example.demo.service;

import com.example.demo.dao.GroupDao;
import com.example.demo.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    GroupDao groupDao;

    public Group getRootByUserId(int userId) {
        if(groupDao.getRoot(userId)==null) {
            Group group = new Group(1, userId, 0, 0, 0, "root", "");
            groupDao.insertGroup(group);
        }
        Group root = groupDao.getRoot(userId);
        root.setCanDelete(0);

        root.setSons(getAllSon(root));
        return root;
    }

    public Group[] getAllSon(Group god) {
        if(groupDao.getGroupsByParentId(god.getId()).isEmpty()) {
            god.setCanDelete(1);
            Group[] son = new Group[0];
            return son;
        }
        List<Group> groups = groupDao.getGroupsByParentId(god.getId());
        Group[] son = new Group[groups.size()];
        for(int i=0;i<groups.size();i++) {
            son[i] = groups.get(i);
            son[i].setSons(getAllSon(son[i]));
        }
        return son;
    }

    public Group getGroupById(int id) {
        return groupDao.getGroupById(id);
    }

    public void addGroup(Group group) {
        groupDao.insertGroup(group);
    }

    public void deleteGroup(int id) {
        groupDao.deleteGroupById(id);
    }

    public List<Group> getGroupListByParentId(int parentId) {
        return groupDao.getGroupsByParentId(parentId);
    }
}
