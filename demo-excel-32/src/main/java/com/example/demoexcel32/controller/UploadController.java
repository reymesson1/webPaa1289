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
	
	private final UploadService uploadService;
        public List<Master> master = new ArrayList<Master>();
        public List<Qualification> qualifications = new ArrayList<Qualification>();
        List<Exam> exams = new ArrayList<Exam>();
        List<Question> questions = new ArrayList<Question>();


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
                            return cellVal;
                    })
                    .collect(Collectors.toList());

                    System.out.println(cellVals);
                    System.out.println(cellVals.get(0));

                    Qualification q = new Qualification();
                    q.setId("1");
                    q.setActividad(cellVals.get(0));
                    q.setCalificacion(cellVals.get(1));
                    q.setStudent("dddsd12313ffd");
                    q.setCreator("132klj23ljdsd");
                    qualifications.add(q);

            });

            System.out.println(file.getOriginalFilename());

        }
        
        @CrossOrigin(origins="http://localhost:4200")
        @RequestMapping(value = "/uploadexcelexams", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public void uploadFileExcelExams(@RequestParam("file") MultipartFile file) throws IOException {
            
            Path filepath = Paths.get("C:\\folderA\\", file.getOriginalFilename());

            try (OutputStream os = Files.newOutputStream(filepath)) {
                os.write(file.getBytes());
            }        

            File files = new File("C:/folderA/"+file.getOriginalFilename());

            Workbook workbook = WorkbookFactory.create(files);

            Sheet sheet = workbook.getSheetAt(0);
            
            Stream<Row> rowStream = StreamSupport.stream(sheet.spliterator(), false);
            
            Exam e = new Exam();                        
            e.setId("1");
            e.setName("Exam 1");

            rowStream.forEach(row->{

                    Stream<Cell> cellStream = StreamSupport.stream(row.spliterator(),false);
                    List<String> cellVals =	cellStream.map(cell->{
                            String cellVal = cell.getStringCellValue();
                            return cellVal;
                    })
                    .collect(Collectors.toList());

                    System.out.println(cellVals);
                    System.out.println(cellVals.get(0));
                    
//                              Question #1                                            
                                Question q = new Question();
                                q.setId("1");
                                q.setName(cellVals.get(0));
                                    List<Answer> answers = new ArrayList<Answer>();
                                    Answer a = new Answer();
                                    a.setId("1");
                                    a.setName(cellVals.get(1));
                                    Answer a2 = new Answer();
                                    a2.setId("2");
                                    a2.setName(cellVals.get(2));
                                    Answer a3 = new Answer();
                                    a3.setId("4");
                                    a3.setName(cellVals.get(3));
                                    Answer a4 = new Answer();
                                    a4.setId("4");
                                    a4.setName(cellVals.get(4));
                                    answers.add(a);
                                    answers.add(a2);
                                    answers.add(a3);
                                    answers.add(a4);
                                q.setAnswers(answers);
                            questions.add(q);

            });
            
            e.setQuestions(questions);
            exams.add(e);

            System.out.println(file.getOriginalFilename());

        }
        
        @CrossOrigin(origins="http://localhost:4200")
        @RequestMapping(value = "/qualification", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Qualification> getQualification(@RequestBody String str){
            
            return qualifications;
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
            return qualifications;
        }
        
}