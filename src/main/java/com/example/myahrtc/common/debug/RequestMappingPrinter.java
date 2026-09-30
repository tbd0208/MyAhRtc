package com.example.myahrtc.common.debug;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Spring MVC에 등록된 RequestMapping URL을 확인하기 위한 DEBUG 유틸리티.
 *
 * <p>자동 실행/자동 Bean 등록은 하지 않는다.
 * 필요 시 개발 환경에서 Spring Bean으로 등록한 뒤 print()를 호출한다.</p>
 */
public class RequestMappingPrinter {

    @Autowired
    private Map<String, RequestMappingHandlerMapping> handlerMappings;

    public void print() {
        List<String> mappings = new ArrayList<String>();

        for (RequestMappingHandlerMapping handlerMapping : handlerMappings.values()) {
            Map<RequestMappingInfo, HandlerMethod> handlerMethods =
                    handlerMapping.getHandlerMethods();

            for (Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {
                HandlerMethod handlerMethod = entry.getValue();
                Method method = handlerMethod.getMethod();

                for (String urlPattern : entry.getKey()
                        .getPatternsCondition()
                        .getPatterns()) {

                    mappings.add(
                            urlPattern
                            + " > "
                            + method.getDeclaringClass().getName()
                            + "."
                            + method.getName());
                }
            }
        }

        Collections.sort(mappings);

        String currentGroup = null;

        for (String mapping : mappings) {
            String urlPattern = mapping.substring(0, mapping.indexOf(" > "));
            String group = getGroup(urlPattern);

            if (!group.equals(currentGroup)) {
                System.out.println();
                System.out.println("### " + group);
                currentGroup = group;
            }

            System.out.println(mapping);
        }
    }

    private String getGroup(String urlPattern) {
        if (urlPattern == null || urlPattern.length() <= 1) {
            return "";
        }

        int index = urlPattern.indexOf('/', 1);

        return index < 0
                ? urlPattern.substring(1)
                : urlPattern.substring(1, index);
    }
}
