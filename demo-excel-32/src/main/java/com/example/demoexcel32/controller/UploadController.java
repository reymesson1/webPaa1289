/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demoexcel32.controller;

import com.example.demoexcel32.model.Master;
import com.example.demoexcel32.model.Detail;
import com.example.demoexcel32.model.Exam;
import com.example.demoexcel32.model.Task;
import com.example.demoexcel32.model.User;
import com.example.demoexcel32.model.Answer;
import com.example.demoexcel32.model.Qualification;
import com.example.demoexcel32.model.Question;
import com.example.demoexcel32.service.MasterService;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demoexcel32.service.UploadService;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class UploadController {

        UploadService uploadService;
        
        public UploadController(UploadService uploadService){
            this.uploadService = uploadService;        
        }
        
        @CrossOrigin(origins="http://localhost:4200")
        @RequestMapping(value = "/loading", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)

        public List<User> loading(@RequestBody String str) throws Exception{

                JSONObject jsonObj = new JSONObject(str);
                JSONObject jsonObjOutPut = new JSONObject(str);
                
                List<User> contacts = new ArrayList<User>();

		System.out.println(jsonObj.getString("username"));
                
                boolean b = false;
                
                if(jsonObj.getString("username").equals("reymesson")){
                    b=true;
                    jsonObjOutPut.put("token", "2391dkajsdlskjdljdada");
                    User s1 = new User();
                    s1.setUsername(jsonObj.getString("username"));
                    s1.setToken("ekkejqiie0ied3434");

                    contacts.add(s1);

                }
                
                return contacts;
        }
                        
//        @CrossOrigin(origins="http://localhost:4200")
//        @RequestMapping(value = "/masters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//
//        public List<Master> getMaster() throws Exception{
//            
//            return master;
//        }
                                
        @CrossOrigin(origins="http://localhost:4200")
        @RequestMapping(value = "/uploadexcelexams", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public void uploadFileExcelExams(@RequestParam("file") MultipartFile file) throws IOException {

            uploadService.uploadFileExcelExams(file);
        }
            
}