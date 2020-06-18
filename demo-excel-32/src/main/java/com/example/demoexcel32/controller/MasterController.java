/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demoexcel32.controller;

import com.example.demoexcel32.model.Detail;
import com.example.demoexcel32.model.Exam;
import com.example.demoexcel32.model.Master;
import com.example.demoexcel32.model.Qualification;
import com.example.demoexcel32.model.Task;
import com.example.demoexcel32.service.MasterService;
import com.example.demoexcel32.service.UploadService;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.commons.compress.utils.IOUtils;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Rey Messon
 */

@RestController
public class MasterController {
    
    public MasterService service;
    
    public MasterController(MasterService service){
    
        this.service = service;
    }
            
//    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(value = "/masters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Master> getMaster() throws Exception{

        return service.getMasterList();
    }
    
    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(value = "/addmaster", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addMaster(@RequestBody String str) throws Exception{

        service.addMaster(str);

    }
//    
//    @CrossOrigin(origins="http://localhost:4200")
//    @RequestMapping(value = "/adddetail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public void addDetail(@RequestBody String str) throws Exception{
//        
//        service.addDetail(str);
//    }
//    
    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(value = "/removemaster", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeDetail(@RequestBody String str) throws Exception{
    
        service.removeDetail(str);
    }
//    
    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(value = "/editdetail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void editDetail(@RequestBody String str) throws Exception{
    
        service.editDetail(str);
    }
//    
    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(value = "/addtask", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addTask(@RequestBody String str) throws Exception{

        service.addTask(str);
    }

    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(value = "/edittask", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void editTask(@RequestBody String str) throws Exception{
    
        service.editTask(str);
    }    
//    
    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(value = "/removetask", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeTask(@RequestBody String str) throws Exception{
    
        service.removeTask(str);
    }
//
    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(value = "/qualification", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Qualification> getQualification(@RequestBody String str){

        return service.getQualification(str);
    }
    
    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(value = "/download/customers.xlsx", method = RequestMethod.GET)
    public void downloadCsv(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=customers.xlsx");
        ByteArrayInputStream stream = ExcelFileExporter.contactListToExcelFile(createTestData());
        IOUtils.copy(stream, response.getOutputStream());
    }

    private List<Qualification> createTestData(){
        return service.qualifications;
    }

    
}
