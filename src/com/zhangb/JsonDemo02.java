package com.zhangb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangb
 * @time 0514
 * @desccription map与json之间的转换
 */
public class JsonDemo02 {

    public static void main(String[] args) {
        mapToJson();
    }

    private static void mapToJson(){
        //新建一个map
        Map<String,Object> map = new HashMap<>();
        map.put("status",0);
        map.put("desc","成功");
        //新建list<map>
        List<Map<String,Object>> mapList = new ArrayList<>();
        Map<String,Object> obj = new HashMap<>();
        obj.put("name","zhangb");
        obj.put("sex","男");
        obj.put("desc","JSON教程");
        mapList.add(obj);
        Map<String,Object> mobj = new HashMap<>();
        mobj.put("name","lidan");
        mobj.put("sex","女");
        mobj.put("desc","测试");
        mapList.add(mobj);
        //将maplist加入map中
        map.put("data",mapList);

        //将map转换成json
        JSONObject jsonObject = JSONObject.fromObject(map);
        //alibaba将map转化为json ,各种方法
        String  str = JSON.toJSONString(map);
        com.alibaba.fastjson.JSONObject str1 = new com.alibaba.fastjson.JSONObject(map);
        String str2 = new com.alibaba.fastjson.JSONObject().toJSONString(map);

        System.out.println("json-lib的map to json");
        System.out.println(jsonObject);

        System.out.println("Fastjson的map to json");
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
    }

}
