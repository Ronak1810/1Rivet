package com.onerivet.deskbook.filters;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class UppercaseQueryParamHttpServletRequestWrapper extends HttpServletRequestWrapper {
	
	private final Map<String, String[]> modifiedParameters;

    public UppercaseQueryParamHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        modifiedParameters = convertParametersToUppercase(request.getParameterMap());
    }

    @Override
    public String getParameter(String name) {
        String[] values = modifiedParameters.get(name);
        return values != null && values.length > 0 ? values[0] : null;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return Collections.unmodifiableMap(modifiedParameters);
    }

    @Override
    public String[] getParameterValues(String name) {
        return modifiedParameters.get(name);
    }

    private Map<String, String[]> convertParametersToUppercase(Map<String, String[]> originalParameters) {
        Map<String, String[]> uppercaseParameters = new HashMap<>();
        for (Map.Entry<String, String[]> entry : originalParameters.entrySet()) {
            String[] values = entry.getValue();
            String[] uppercaseValues = new String[values.length];
            for (int i = 0; i < values.length; i++) {
                uppercaseValues[i] = values[i].toUpperCase();
            }
            uppercaseParameters.put(entry.getKey(), uppercaseValues);
        }
        return uppercaseParameters;
    }
}
