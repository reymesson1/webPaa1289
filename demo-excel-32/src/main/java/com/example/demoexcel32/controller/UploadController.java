/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demoexcel32.controller;

import com.example.demoexcel32.model.Master;
import com.example.demoexcel32.model.Detail;
import com.example.demoexcel32.model.Task;
import com.example.demoexcel32.model.User;
import com.example.demoexcel32.model.Qualification;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demoexcel32.service.UploadService;
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
import javax.validation.Valid;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class UploadController {
	
	private final UploadService uploadService;
        public List<Master> master = new ArrayList<Master>();
        public List<Qualification> qualifications = new ArrayList<Qualification>();

        public int counter = 0;
	
	public UploadController(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	@PostMapping("/upload")
	public void upload(@RequestParam("file") MultipartFile file) throws Exception{
		uploadService.upload(file);
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
        
        @CrossOrigin(origins="http://localhost:4200")
        @RequestMapping(value = "/addmaster", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public void addMaster(@RequestBody String str) throws Exception{
            
            List<Task> tasks = new ArrayList<Task>();
            Task t = new Task();
            t.setId("1");
            t.setName("Task 1");
            t.setCreator("3131938139183sfdfdsf");
            Task t2 = new Task();
            t2.setId("2");
            t2.setName("Task 2");
            t2.setCreator("3131938139183sfdfdsf");
            tasks.add(t);
            tasks.add(t2);        
            counter++;
            JSONObject jsonObj = new JSONObject(str);
            List<Detail> details = new ArrayList<Detail>();
            Master m = new Master();
            m.setId(""+this.counter);
            m.setName(jsonObj.getString("name"));
            m.setActive(true);
            Detail d = new Detail();
            Detail d2 = new Detail();
            Detail d3 = new Detail();
            Detail d4 = new Detail();
            Detail d5 = new Detail();
            d.setId("1");
            d.setName("Modulo 1");
            d.setCreator("ekkejqiie0ied3434");
            d.setTasks(tasks);
            d2.setId("2");
            d2.setName("Modulo 2");
            d2.setTasks(tasks);
            d2.setCreator("ekkejqiie0ied3434");
            d3.setId("3");
            d3.setName("Modulo 3");
            d3.setCreator("ekkejqiie0ied3434");
            d4.setId("4");
            d4.setName("Modulo 4");
            d4.setCreator("ekkejqiie0ied3434");
            d5.setId("5");
            d5.setName("Modulo 5");
            d5.setCreator("ekkejqiie0ied3434");
            details.add(d);
            details.add(d2);
            details.add(d3);
            details.add(d4);
            details.add(d5);
            m.setDetails(details);
            master.add(m);
            
            System.out.println(str);
        }
                
        @CrossOrigin(origins="http://localhost:4200")
        @RequestMapping(value = "/masters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

        public List<Master> getMaster() throws Exception{
            
            return master;
        }
        
        @CrossOrigin(origins="http://localhost:4200")
        @RequestMapping(value = "/removemaster", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public void removeDetail(@RequestBody String str) throws Exception{
        
            JSONObject jsonObj = new JSONObject(str);
            Integer masterId = Integer.parseInt(jsonObj.getString("masterid"));
            Integer detailId = Integer.parseInt(jsonObj.getString("detailid"));
            System.out.println(this.master.get(masterId-1).getDetails().get(detailId-1).getName());
            this.master.get(masterId-1).getDetails().remove(detailId-1);

        }    
        
        @CrossOrigin(origins="http://localhost:4200")
        @RequestMapping(value = "/adddetail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public void addDetail(@RequestBody String str) throws Exception{
            
            List<Task> tasks = new ArrayList<Task>();
            Task t = new Task();
            t.setId("1");
            t.setName("Task");
            t.setCreator("2313231987jkdjsdks");
            System.out.println(str);
            JSONObject jsonObj = new JSONObject(str);
            Integer masterId = Integer.parseInt(jsonObj.getString("id"));
            Detail d = new Detail();
            d.setId(jsonObj.getString("id"));
            d.setName(jsonObj.getString("name")); 
            d.setCreator(jsonObj.getString("creator"));
            this.master.get(masterId-1).getDetails().add(d);
                                    
        }
        
        @CrossOrigin(origins="http://localhost:4200")
        @RequestMapping(value = "/editdetail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public void editDetail(@RequestBody String str) throws Exception{

            JSONObject jsonObj = new JSONObject(str);
            Integer masterId = Integer.parseInt(jsonObj.getString("masterid"));
            Integer detailId = Integer.parseInt(jsonObj.getString("detailid"));

            System.out.println(str);
            System.out.println( this.master.get(masterId-1).getDetails().get(detailId-1).getName() );
//            JSONObject jsonObj = new JSONObject(str);
//            Integer masterId = Integer.parseInt(jsonObj.getString("masterid"));
//            Integer detailId = Integer.parseInt(jsonObj.getString("detailid"));
            Detail d = new Detail();
            d.setId(jsonObj.getString("detailid"));
            d.setName(jsonObj.getString("name"));            
            this.master.get(masterId-1).getDetails().set(detailId-1,d);
                                    
        }
        
        @CrossOrigin(origins="http://localhost:4200")
        @RequestMapping(value = "/addtask", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public void addTask(@RequestBody String str) throws Exception{
            
//            List<Task> tasks = new ArrayList<Task>();
            Task t = new Task();
            t.setId("1");
            t.setName("Task");
            t.setCreator("2313231987jkdjsdks");
//            System.out.println(str);
            JSONObject jsonObj = new JSONObject(str);
            Integer masterId = Integer.parseInt(jsonObj.getString("id"));
            Integer detailId = Integer.parseInt(jsonObj.getString("idModulo"));
//            Detail d = new Detail();
//            d.setId(jsonObj.getString("id"));
//            d.setName(jsonObj.getString("name")); 
//            d.setCreator(jsonObj.getString("creator"));
            this.master.get(masterId-1).getDetails().get(detailId-1).getTasks().add(t);
                                    
        }
        
        @CrossOrigin(origins="http://localhost:4200")
        @RequestMapping(value = "/edittask", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public void editTask(@RequestBody String str) throws Exception{
            
            Task t = new Task();
            t.setId("1");
            t.setName("Task");
            t.setCreator("2313231987jkdjsdks");
            System.out.println(str);
            JSONObject jsonObj = new JSONObject(str);
            Integer masterId = Integer.parseInt(jsonObj.getString("idCurso"));
            Integer detailId = Integer.parseInt(jsonObj.getString("idModulo"));
            Integer taskId = Integer.parseInt(jsonObj.getString("idTask"));
            this.master.get(masterId-1).getDetails().get(detailId-1).getTasks().set(taskId-1,t);
                                    
        }
        
        @CrossOrigin(origins="http://localhost:4200")
        @RequestMapping(value = "/removetask", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public void removeTask(@RequestBody String str) throws Exception{
        
            System.out.println(str);
            JSONObject jsonObj = new JSONObject(str);
            Integer masterId = Integer.parseInt(jsonObj.getString("idCurso"));
            Integer detailId = Integer.parseInt(jsonObj.getString("idModulo"));
            Integer taskId = Integer.parseInt(jsonObj.getString("idTask"));
            System.out.println(this.master.get(masterId-1).getDetails().get(detailId-1).getName());
            this.master.get(masterId-1).getDetails().get(detailId-1).getTasks().remove(taskId-1);

        }
                
        @CrossOrigin(origins="http://localhost:4200")
        @RequestMapping(value = "/uploadtask", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
            
            Path filepath = Paths.get("C:\\folderA\\", file.getOriginalFilename());

            try (OutputStream os = Files.newOutputStream(filepath)) {
                os.write(file.getBytes());
            }        
            System.out.println(file.getOriginalFilename());
        }
        
        @CrossOrigin(origins="http://localhost:4200")
        @RequestMapping(value = "/uploadexcel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public void uploadFileExcel(@RequestParam("file") MultipartFile file) throws IOException {
            
            Path filepath = Paths.get("C:\\folderA\\", file.getOriginalFilename());

            try (OutputStream os = Files.newOutputStream(filepath)) {
                os.write(file.getBytes());
            }        

            File files = new File("C:/folderA/"+file.getOriginalFilename());

            Workbook workbook = WorkbookFactory.create(files);

            Sheet sheet = workbook.getSheetAt(0);
            
            Stream<Row> rowStream = StreamSupport.stream(sheet.spliterator(), false);

            rowStream.forEach(row->{

                    Stream<Cell> cellStream = StreamSupport.stream(row.spliterator(),false);
                    List<String> cellVals =	cellStream.map(cell->{
                            String cellVal = cell.getStringCellValue();
//                            System.out.println(cellVal);

                            return cellVal;
                    })
                    .collect(Collectors.toList());

                    System.out.println(cellVals);
                    System.out.println(cellVals.get(0));

                    Qualification q = new Qualification();
                    q.id = "1";
                    q.actividad = cellVals.get(0);
                    q.calificacion = cellVals.get(1);
                    q.student = "dddsd12313ffd";
                    q.creator = "132klj23ljdsd";
                    qualifications.add(q);

            });

            System.out.println(file.getOriginalFilename());

        }
        
        @CrossOrigin(origins="http://localhost:4200")
        @RequestMapping(value = "/qualification", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Qualification> getQualification(@RequestBody String str){
            
            return qualifications;
        }
        
}