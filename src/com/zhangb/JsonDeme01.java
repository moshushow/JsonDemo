package com.zhangb;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author zhangb
 * @time 0514
 * @desccription 拼接、封装json字符串
 */
public class JsonDeme01 {

    public static void main(String[] args) {
        joinAliJson();
    }

    private static void joinAliJson(){
       JSONObject json = new JSONObject();
        json.put("status",0);
        json.put("desc","成功");
        JSONArray jsonArray = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("name","zhangb");
        obj.put("sex","男");
        obj.put("desc","JSON教程");
        //向obj中添加 对象
        jsonArray.add(obj);
        //此时obj中已经有了对象，如需要继续添加单独对象，需重新new或者清空obj
        obj.clear();
        obj.put("name","lidan");
        obj.put("sex","女");
        obj.put("desc","测试");
        jsonArray.add(obj);
        json.put("data",jsonArray);
        System.out.println("阿里巴巴json封装");
        System.out.println(json.toJSONString());
    }
}
