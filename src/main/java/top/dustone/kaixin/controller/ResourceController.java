package top.dustone.kaixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.dustone.kaixin.entity.Resource;
import top.dustone.kaixin.service.ResourceService;
import top.dustone.kaixin.util.CommonResponseModel;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@CrossOrigin
@RestController
public class ResourceController {
    @Autowired
    ResourceService resourceService;
    @PostMapping("/resource_upload")
    public CommonResponseModel<Resource> uploadFile(int pId, String saveDir, String originName,MultipartFile fileUpload,HttpServletRequest request){
        CommonResponseModel<Resource> result=new CommonResponseModel<Resource>();
        Resource pResource=resourceService.findById(pId);
        String targetURL="resource/uploadFiles/"+saveDir+"/"+pResource.getName()+"_"+pResource.getId()+"/"+originName;
        String targetHost=request.getServletContext().getRealPath("resource/uploadFiles/"+saveDir+"/"+pResource.getName()+"_"+pResource.getId());
        File targetFolder=new File(targetHost);
        File targetFile=new File(targetFolder,originName);
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdirs();
        }
        if(targetFile.exists()){
            result.setCode("500");
            result.setMsg("上传失败！ 请勿上传重名文件！");
            return result;
        }
        try {
            fileUpload.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
            result.setCode("501");
            result.setMsg("上传失败！ 服务器文件存储错误！ 请重试或联系管理员");
            return result;
        }
        Resource cResource=new Resource();
        cResource.setName(originName);
        cResource.setParent(pResource);
        cResource.setSize((int)fileUpload.getSize());
        cResource.setType(originName.substring(originName.lastIndexOf(".")+1));
        cResource.setUrl(targetURL);

        resourceService.update(cResource);
        result.setCode("200");
        result.setMsg("上传成功！");
        result.setT(cResource);
        return result;
    }
}
