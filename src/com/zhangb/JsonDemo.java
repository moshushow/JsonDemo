package com.zhangb;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author zhangb
 * @time 0514
 * @desccription 拼接、封装json字符串
 */
public class JsonDemo {

    public static void main(String[] args) {
        setJson();
        joinJsonlib();
    }

    /**
     * 采用字符串拼接json
     * 此处注意转义符
     */
    private  static void setJson(){
        String str = "{\"status\":0,\"desc\":\"成功\",\"data\":[{\"name\":\"zhangb\",\"sex\":\"男\",\"description\":\"JSON教程\"},{\"name\":\"lidan\",\"sex\":\"女\",\"description\":\"测试\"}]}";
        System.out.println("输出字符串拼接的json");
        System.out.println(str);
    }

    /**
     * appache的json,需导入以下包才可以使用
     * json-lib-2.4-jdk15.jar
     * commons-lang.jar
     * commons-beanutils.jar
     * commons-collections.jar
     * commons-logging.jar
     * ezmorph.jar
     */
    private static void joinJsonlib(){
        JSONObject json = new JSONObject();
        //可用put或者element添加对象，大部分时候无区别，value为空时候需要注意
        json.put("status",0);
        json.element("desc","成功");
        JSONObject obj = new JSONObject();
        JSONArray jsonArray = new JSONArray();
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
        //添加到最开始的json
        json.put("data",jsonArray);
        System.out.println("输出json封装方法");
        System.out.println(json.toString());
    }


}
