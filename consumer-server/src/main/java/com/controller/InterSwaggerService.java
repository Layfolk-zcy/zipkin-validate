package com.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.bean.ServerInterfaceInfoResBean;
import com.constants.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class InterSwaggerService {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("get")
    public List<ServerInterfaceInfoResBean> getPaths(String serverInstance) {

        Map<String, String> ipMap = new HashMap<>();
        List<String> services = discoveryClient.getServices();
        if (CollectionUtils.isEmpty(services)) {
            throw new RuntimeException("获取不到对应的注册服务");
        }


        services.stream().forEach(service -> {
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            instances.forEach(instance -> {
                ipMap.put(instance.getHost() + ":" + instance.getPort(), service);

            });
        });

        List<ServerInterfaceInfoResBean> serverInterfaceInfoResBeans = new ArrayList<>();
        Set<Map.Entry<String, String>> entries1 = ipMap.entrySet();
        for (Map.Entry<String, String> entry : entries1) {
            ResponseEntity<String> entity = restTemplate(entry);
            if (entity == null) {
                continue;
            }
            if (entity.getStatusCodeValue() == Constant.JSON_STATUSCODE_SUCCESS) {
                JSONObject resultJson = JSONUtil.parseObj(entity.getBody());

                JSONObject j = resultJson.getJSONObject("paths");
                Set<Map.Entry<String, Object>> entries = j.entrySet();
                for (Map.Entry<String, Object> en : entries) {
                    JSONObject jsonObject = j.getJSONObject(en.getKey());

                    jsonObject.entrySet().forEach(e -> {

                        //先清理原始数据
                        ServerInterfaceInfoResBean serverInterfaceInfoResBean = new ServerInterfaceInfoResBean();
                        serverInterfaceInfoResBean.setIntId(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16));
                        serverInterfaceInfoResBean.setIntName(en.getKey());
                        serverInterfaceInfoResBean.setIntPath(en.getKey());

                        if (e.getKey().equals("get") || e.getKey().equals("post")) {
                            serverInterfaceInfoResBean.setReType(e.getKey());
                            JSONObject param = (JSONObject) e.getValue();
                            JSONArray consumes = param.getJSONArray("consumes");
                            if (consumes != null) {
                                serverInterfaceInfoResBean.setResType(consumes.toString());
                            }

                            JSONArray parameters = param.getJSONArray("parameters");
                            JSONObject paramJsonObject = new JSONObject();
                            paramJsonObject.put("param", parameters);

                            serverInterfaceInfoResBean.setReqPara(paramJsonObject.toString());
                            serverInterfaceInfoResBean.setStatus(1);

                            JSONObject jsonObject1 = (JSONObject) param.get("responses");
                            JSONArray jsonObject2 = getJsonObject(jsonObject1);

                            JSONObject responseJsonObject = new JSONObject();
                            responseJsonObject.put("response", jsonObject2);

                            serverInterfaceInfoResBean.setResCode(responseJsonObject.toString());
                            JSONArray responseAarry = param.getJSONArray("produces");
                            serverInterfaceInfoResBean.setReqType(responseAarry.toString());
                            serverInterfaceInfoResBean.setVersion("2.0");
                            serverInterfaceInfoResBean.setBelSer(entry.getValue());
                            serverInterfaceInfoResBean.setResExp(getResexp().toString());
                            serverInterfaceInfoResBean.setBelNode(entry.getValue());
                            serverInterfaceInfoResBeans.add(serverInterfaceInfoResBean);
                        }
                    });
                }

            }
        }

        return serverInterfaceInfoResBeans;
    }

    private ResponseEntity<String> restTemplate(Map.Entry<String, String> entry) {
        ResponseEntity<String> entity = null;
        try {
            String url = "http://" + entry.getKey() + "/v2/api-docs?group=SwaggerApi";
            Map<String, String> headers = new HashMap<>();
            headers.put(Constant.HEADER_CONTENT_TYPE, Constant.HEADER_CONTENT_TYPE_VALUE);
            headers.put(Constant.HEADER_ACCEPT, Constant.HEADER_ACCEPT_VALUE);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAll(headers);
            HttpEntity<?> requestEntity = new HttpEntity<>(headers);
            entity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        } catch (RestClientException e) {
            return null;
        }
        return entity;
    }

    private JSONArray getJsonObject(JSONObject jsonObject) {
        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
        JSONArray jsonArray = new JSONArray();

        for (Map.Entry<String, Object> en : entries) {
            String key = en.getKey();
            JSONObject response = new JSONObject();
            JSONObject value = (JSONObject) en.getValue();
            String s = (String) value.get("description");
            response.put(key, s);
            jsonArray.add(response);
        }
        return jsonArray;
    }


    private JSONObject getResexp() {
        JSONObject resexp = new JSONObject();
        resexp.put("code", 200);
        resexp.put("data", "{}");
        resexp.put("msg", "string");
        return resexp;
    }

}

