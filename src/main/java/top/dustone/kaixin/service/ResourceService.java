package top.dustone.kaixin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dustone.kaixin.dao.ResourceDAO;
import top.dustone.kaixin.entity.Resource;

@Service
public class ResourceService {
    @Autowired
    ResourceDAO resourceDAO;
    public Resource update(Resource resource){
        resourceDAO.save(resource);
        return resource;
    }
    public void delete(Resource resource) {
        resourceDAO.delete(resource);
    }
    public Resource findById(int id){
        return resourceDAO.findFirstByIdEquals(new Integer(id));
    }
}
