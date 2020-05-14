package com.zhangb;

import com.alibaba.fastjson.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author zhangb
 * @time 0514
 * @desccription json的解析
 */
public class JsonDemo04 {

    public static void main(String[] args) {
        getJson();
    }

    /**
     * 采用字符串拼接json
     * 此处注意转义符
     */
    private  static String setJson(){
        String str = "{\"status\":0,\"desc\":\"成功\",\"data\":[{\"name\":\"zhangb\",\"sex\":\"男\",\"description\":\"JSON教程\"},{\"name\":\"lidan\",\"sex\":\"女\",\"description\":\"测试\"}]}";
        System.out.println("输出字符串拼接的json");
        System.out.println(str);
        return str;
    }

    private static void getJson(){

     String str = setJson();
     //json lib格式化
     JSONObject jsonObject = JSONObject.fromObject(str);

        String status = jsonObject.getString("status");
        String desc = jsonObject.getString("desc");
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        System.out.println("状态："+status);
        System.out.println("描述："+desc);
        for (int i=0;i<  jsonArray.size();i++){
            JSONObject json = jsonArray.getJSONObject(i);
            String name = json.getString("name");
            String sex = json.getString("sex");
            String description = json.getString("description");
            System.out.println("name:"+name+"sex"+sex+"description:"+description);
        }
        System.out.println("阿里巴巴解析json!");
        //阿里巴巴json格式化
        com.alibaba.fastjson.JSONObject jsonObject1 = JSON.parseObject(str);
        String status1 = jsonObject.getString("status");
        String desc1 = jsonObject.getString("desc");
        com.alibaba.fastjson.JSONArray jsonArray1 = jsonObject1.getJSONArray("data");
        for (int i= 0; i< jsonArray1.size();i++){
            com.alibaba.fastjson.JSONObject jsonObject2 = jsonArray1.getJSONObject(i);
            String name = jsonObject2.getString("name");
            String sex = jsonObject2.getString("sex");
            String description = jsonObject2.getString("description");
            System.out.println("name:"+name+"sex"+sex+"description:"+description);
        }
        System.out.println("状态："+status1);
        System.out.println("描述："+desc1);
    }


}
