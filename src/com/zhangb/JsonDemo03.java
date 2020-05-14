package com.zhangb;

import com.alibaba.fastjson.JSON;
import com.zhangb.Entity.BaseEntity;
import com.zhangb.Entity.Person;
import net.sf.json.JSONObject;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangb
 * @time 0514
 * @desccription 实体与json之间的转换
 */
public class JsonDemo03 {

    public static void main(String[] args) {
        entityToJson();
    }

    private  static void entityToJson(){
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setStatus("0");
        baseEntity.setDesc("成功");

    List<Person> list = new ArrayList<>();
        Person p = new Person();
        p.setName("zhangb");
        p.setSex("男");
        p.setDescription("JSON培训");
        list.add(p);
        Person p1 = new Person();
        p1.setName("lidan");
        p1.setSex("女");
        p1.setDescription("测试");
        list.add(p1);
        //实体封装完成
        baseEntity.setData(list);

//        Json lib的转换方法
        JSONObject jsonObject = JSONObject.fromObject(baseEntity);

//        FastJson的转换方法
        String jsonObject1 = new com.alibaba.fastjson.JSONObject().toJSONString(baseEntity);
        //也可以反着来JSON串转实体对象
        BaseEntity baseEntity1 = JSON.parseObject(jsonObject1,BaseEntity.class);

        System.out.println("json-lib的实体 to json");
        System.out.println(jsonObject);

        System.out.println("Fastjson的实体 to json");
        System.out.println(jsonObject1);
    }

}
