/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demoexcel32.service;

import com.example.demoexcel32.document.Masters;
import com.example.demoexcel32.model.Detail;
import com.example.demoexcel32.model.Exam;
import com.example.demoexcel32.model.Master;
import com.example.demoexcel32.model.Qualification;
import com.example.demoexcel32.model.Question;
import com.example.demoexcel32.model.Task;
import com.example.demoexcel32.repository.MasterRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Rey Messon
 */
@Service
public class MasterService {
    
    public List<Master> master = new ArrayList<Master>();
    public List<Qualification> qualifications = new ArrayList<Qualification>();
    public List<Exam> exams = new ArrayList<Exam>();
    public List<Question> questions = new ArrayList<Question>();
    public int counter = 0;
    MasterRepository masterRepository;
    
    public MasterService(MasterRepository masterRepository){
        
        this.masterRepository = masterRepository;    
    }
            
    public List<Masters> getMasterList(){
    
        return this.masterRepository.findAll();
//          return this.masterRepository.getMastersById("2");

    }
    
    public void addMaster(String str) throws Exception{
        
        long last = masterRepository.count();
            
        List<Task> tasks = new ArrayList<Task>();
        Task t = new Task();
        t.setId("1");
        t.setName("Task 1");
        t.setCreator("3131938139183sfdfdsf");
        t.setExams(this.exams);//ponle examen a este task
        Task t2 = new Task();
        t2.setId("2");
        t2.setName("Task 2");
        t2.setCreator("3131938139183sfdfdsf");
        tasks.add(t);
        tasks.add(t2);        
        counter++;
        JSONObject jsonObj = new JSONObject(str);
        List<Detail> details = new ArrayList<Detail>();
        Masters m = new Masters();
        last++;
        m.setId(""+last);
        m.setName(jsonObj.getString("name"));
        m.setActive(true);
        m.setCreator(jsonObj.getString("creator"));
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
//        master.add(m);
//        Masters m20 = new Masters();
        masterRepository.insert(m);

        System.out.println(str);
    }
    

    public void addDetail(String str) throws Exception{

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
//        this.master.get(masterId-1).getDetails().add(d);
        
        System.out.println(this.masterRepository.findAll());
        
        this.masterRepository.setMastersById();
                
    }
    
    public void removeDetail(String str) throws Exception{

        JSONObject jsonObj = new JSONObject(str);
        Integer masterId = Integer.parseInt(jsonObj.getString("masterid"));
        Integer detailId = Integer.parseInt(jsonObj.getString("detailid"));
        System.out.println(this.master.get(masterId-1).getDetails().get(detailId-1).getName());
        this.master.get(masterId-1).getDetails().remove(detailId-1);

    }    


    public void editDetail(String str) throws Exception{

        JSONObject jsonObj = new JSONObject(str);
        Integer masterId = Integer.parseInt(jsonObj.getString("masterid"));
        Integer detailId = Integer.parseInt(jsonObj.getString("detailid"));

        System.out.println(str);
        System.out.println( this.master.get(masterId-1).getDetails().get(detailId-1).getName() );
        Detail d = new Detail();
        d.setId(jsonObj.getString("detailid"));
        d.setName(jsonObj.getString("name"));            
        this.master.get(masterId-1).getDetails().set(detailId-1,d);

    }

    public void addTask(String str) throws Exception{

    //            List<Task> tasks = new ArrayList<Task>();
        Task t = new Task();
        t.setId("1");
        t.setName("Task");
        t.setCreator("2313231987jkdjsdks");
        JSONObject jsonObj = new JSONObject(str);
        Integer masterId = Integer.parseInt(jsonObj.getString("id"));
        Integer detailId = Integer.parseInt(jsonObj.getString("idModulo"));
        this.master.get(masterId-1).getDetails().get(detailId-1).getTasks().add(t);

    }

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

    public void removeTask(@RequestBody String str) throws Exception{

        System.out.println(str);
        JSONObject jsonObj = new JSONObject(str);
        Integer masterId = Integer.parseInt(jsonObj.getString("idCurso"));
        Integer detailId = Integer.parseInt(jsonObj.getString("idModulo"));
        Integer taskId = Integer.parseInt(jsonObj.getString("idTask"));
        System.out.println(this.master.get(masterId-1).getDetails().get(detailId-1).getName());
        this.master.get(masterId-1).getDetails().get(detailId-1).getTasks().remove(taskId-1);

    }
    
    public List<Qualification> getQualification(String str){

        return qualifications;
    }
    
    public void checkIt(){
    
        System.out.println("I am here!");
    }
    
}
