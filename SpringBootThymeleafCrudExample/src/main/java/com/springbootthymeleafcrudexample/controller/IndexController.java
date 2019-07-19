package com.springbootthymeleafcrudexample.controller;

import com.springbootthymeleafcrudexample.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by A.A.MAMUN on 7/19/2019.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    private String init(ModelMap modelMap){

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try{
           List<Student> stuList = session.createQuery("from Student order by id asc", Student.class).list();
           modelMap.addAttribute("stuList", stuList);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
        return "index";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String addStudent(@ModelAttribute Student student)
    {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
        return "redirect:/";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    private String updateStudent(@ModelAttribute Student update_student)
    {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            Transaction transaction = session.beginTransaction();
            session.update(update_student);
            transaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }

        return "redirect:/";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    private String deleteStudent(@RequestParam Integer id)
    {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            Transaction transaction = session.beginTransaction();
            Student del_student = session.get(Student.class, id);
            session.delete(del_student);
            transaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }

        return "redirect:/";
    }

}
