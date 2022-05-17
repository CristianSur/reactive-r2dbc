package com.example.orange.actions;




import com.example.orange.actions.dto.BaseResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Map;


public class BaseAction {

    private static final CloseableHttpClient HTTP_CLIENT = HttpClients.createDefault();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    protected static final <R extends BaseResponseDTO> R post(final String url,
                                                              final Map<String, String> queryParameters, final Map<String, String> headers, final Object requestBody,
                                                              final Class<R> responseType) {
        // url validation
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("url '" + url + "' is not valid");
        }

        URIBuilder uriBuilder = null;

        try {
            uriBuilder = new URIBuilder(url);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("URL '" + url + "' is not valid", e);
        }

        // add query parameters
        if (queryParameters != null) {
            for (Map.Entry<String, String> queryParameter : queryParameters.entrySet()) {
                uriBuilder.addParameter(queryParameter.getKey(), queryParameter.getValue());
            }
        }

        HttpPost post;

        try {
            URI uri = uriBuilder.build();
            post = new HttpPost(uri);
        } catch (URISyntaxException e1) {
            throw new IllegalStateException(e1);
        }

        // add headers
        if (headers != null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                post.addHeader(header.getKey(), header.getValue());
            }
        }

        // add request body
        if (requestBody != null) {
            try {
                post.setEntity(new StringEntity(OBJECT_MAPPER.writeValueAsString(requestBody)));
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }

        return doRequest(post, responseType);
    }

    protected static final <R extends BaseResponseDTO> R get(final String url,
                                                             final Map<String, String> queryParameters, final Map<String, String> headers,
                                                             final Class<R> responseType) {
        // url validation
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("url '" + url + "' is not valid");
        }

        URIBuilder uriBuilder = null;

        try {
            uriBuilder = new URIBuilder(url);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("URL '" + url + "' is not valid", e);
        }

        // add query parameters
        if (queryParameters != null) {
            for (Map.Entry<String, String> queryParameter : queryParameters.entrySet()) {
                uriBuilder.addParameter(queryParameter.getKey(), queryParameter.getValue());
            }
        }

        HttpGet get;

        try {
            URI uri = uriBuilder.build();

            get = new HttpGet(uri);
        } catch (URISyntaxException e1) {
            throw new IllegalStateException(e1);
        }

        // add headers
        if (headers != null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                get.addHeader(header.getKey(), header.getValue());
            }
        }

        return doRequest(get, responseType);
    }

    @SuppressWarnings("unchecked")
    private static <R extends BaseResponseDTO> R doRequest(final HttpRequestBase post, final Class<R> responseType) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(post.getMethod() + " " + post.getURI().toASCIIString() + "\n\n");


        Header[] allHeaders = post.getAllHeaders();
        for (Header header : allHeaders) {
            stringBuilder.append(header.getName() + ": " + header.getValue());
        }

        System.out.print("\nRequest: " + stringBuilder.toString() + "\n");

        try (CloseableHttpResponse httpResponse = HTTP_CLIENT.execute(post)) {
            HttpEntity entity = httpResponse.getEntity();
            R response = null;

            if ( entity != null && !stringBuilder.toString().contains("cash") && !stringBuilder.toString().contains("transaction")) {
                String rawHttpResponseBody = EntityUtils.toString(entity);
                response = OBJECT_MAPPER.readValue(rawHttpResponseBody, responseType);
            } else {
                response = (R) new BaseResponseDTO();
            }

            response.setResponseHeaders(Arrays.asList(httpResponse.getAllHeaders()));
            response.setResponseStatusCode(httpResponse.getStatusLine().getStatusCode());

            return response;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}

