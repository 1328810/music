package com.javaclimb.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.javaclimb.music.domain.Consumer;
import com.javaclimb.music.service.ConsumerService;
import com.javaclimb.music.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 用户控制类
 * */
@Component
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    /**
     *
     */
        @Autowired
        private ConsumerService consumerService;

        /*
         * 添加用户
         * */
        @RequestMapping(value = "/add",method = RequestMethod.POST)
        public Object addConsumer(HttpServletRequest request) {
            JSONObject jsonObject = new JSONObject();
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String sex = request.getParameter("sex").trim();
            String phoneNum = request.getParameter("phoneNum").trim();
            String email = request.getParameter("email").trim();
            String birth = request.getParameter("birth").trim();
            String location = request.getParameter("location").trim();
            String introduction = request.getParameter("introduction").trim();
            String avator = request.getParameter("avator").trim();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //把生日转换Date格式
            Date birthDate = new Date();
            try {
                birthDate = dateFormat.parse(birth);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (username == null || username.equals("")){
                jsonObject.put(Consts.CODE,0);
                jsonObject.put(Consts.MSG,"用户不能为空");
                return  jsonObject;
            }
            if (password == null || password.equals("")) {
                jsonObject.put(Consts.CODE, 0);
                jsonObject.put(Consts.MSG, "密码不能为空");
                return jsonObject;
            }
            //保存到用户的对象中
            Consumer consumer = new Consumer();
            consumer.setUsername(username);
            consumer.setPassword(password);
            consumer.setSex(new Byte(sex));
            consumer.setPhoneNum(phoneNum);
            consumer.setEmail(email);
            consumer.setBirth(birthDate);
            consumer.setLocation(location);
            consumer.setIntroduction(introduction);
            consumer.setAvator(avator);
            boolean flag = consumerService.insert(consumer);
            if(flag){   //保存成功
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"添加成功");
                return jsonObject;
            }   //保存失败
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"添加失败");
            return  jsonObject;
        }
        /*
         * 修改用户
         * */
        @RequestMapping(value = "/update",method = RequestMethod.POST)
        public Object updateConsumer(HttpServletRequest request) {
            JSONObject jsonObject = new JSONObject();
            String id = request.getParameter("id").trim();
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String sex = request.getParameter("sex").trim();
            String phoneNum = request.getParameter("phoneNum").trim();
            String email = request.getParameter("email").trim();
            String birth = request.getParameter("birth").trim();
            String location = request.getParameter("location").trim();
            String introduction = request.getParameter("introduction").trim();
            String avator = request.getParameter("avator").trim();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //把生日转换Date格式
            Date birthDate = new Date();
            try {
                birthDate = dateFormat.parse(birth);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (username == null || username.equals("")){
                jsonObject.put(Consts.CODE,0);
                jsonObject.put(Consts.MSG,"用户不能为空");
                return  jsonObject;
            }
            if (password == null || password.equals("")) {
                jsonObject.put(Consts.CODE, 0);
                jsonObject.put(Consts.MSG, "密码不能为空");
                return jsonObject;
            }
            //保存到用户的对象中
            Consumer consumer = new Consumer();
            consumer.setId(Integer.parseInt(id));
            consumer.setUsername(username);
            consumer.setPassword(password);
            consumer.setSex(new Byte(sex));
            consumer.setPassword(phoneNum);
            consumer.setEmail(email);
            consumer.setBirth(birthDate);
            consumer.setIntroduction(introduction);
            consumer.setLocation(location);
            consumer.setAvator(avator);
            consumer.setIntroduction(introduction);
            boolean flag = consumerService.update(consumer);
            if(flag){
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"修改成功");
                return jsonObject;
            }
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"修改失败");
            return  jsonObject;
        }
        /*
         * 删除用户
         * */
        @RequestMapping(value = "/delete",method = RequestMethod.GET)
        public Object deleteConsumer(HttpServletRequest request) {
            String id = request.getParameter("id").trim();
            boolean flag = consumerService.delete(Integer.parseInt(id));
            return flag;
        }
        /*
         * 根据主键查询整个对象
         * */
        @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
        public  Object selectByPrimaryKey(HttpServletRequest request){
            String id = request.getParameter("id").trim();
            return consumerService.selectByPrimaryKey(Integer.parseInt(id));
        }
        /*
         * 查询所以用户
         * */
        @RequestMapping(value = "/allConsumer",method = RequestMethod.GET)
        public  Object allConsumer(HttpServletRequest request){
            return consumerService.allConsumer();
        }

       /*
       * 更新用户图片
       * */
       @RequestMapping(value = "/updateConsumerPic",method = RequestMethod.POST)
       public Object updateConsumerPic(@RequestParam("file") MultipartFile avatorFile,@RequestParam("id") int id){
           JSONObject jsonObject = new JSONObject();
            if (avatorFile.isEmpty()){
                jsonObject.put(Consts.CODE,0);
                jsonObject.put(Consts.MSG,"上传文件失败");
                return  jsonObject;
            }
//           文件名 =当前时间到毫秒+原来的文件名
            String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
//            文件路径
            String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"avatorImages";
//           如果文件路径不存在，新增该路径
             File file1 = new File(filePath);
                if(!file1.exists()){
                file1.mkdir();
            }
//            实际文件地址
           File dest = new File(filePath+System.getProperty("file.separator")+fileName);
//            存储到数据库的相对应文件地址
           String storeAvatorPath = "/avatorImages/"+fileName;
           try {
               avatorFile.transferTo(dest);
               Consumer consumer = new Consumer();
               consumer.setId(id);
               consumer.setAvator(storeAvatorPath);
               boolean flag = consumerService.update(consumer);
               if(flag){
                   jsonObject.put(Consts.CODE,1);
                   jsonObject.put(Consts.MSG,"上传成功");
                   jsonObject.put("avator",storeAvatorPath);
                   return jsonObject;
               }
               jsonObject.put(Consts.CODE,0);
               jsonObject.put(Consts.MSG,"上传失败");
               return jsonObject;
           } catch (IOException e) {
               e.printStackTrace();
               jsonObject.put(Consts.CODE,0);
               jsonObject.put(Consts.MSG,"上传失败"+e.getMessage());
           }finally {
               return jsonObject;
           }
       }
    }

