package com.liujie.upload.utils;

import lombok.Data;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@Data
public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {
//
//    private final byte[] body;
//
//    public MyHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
//        super(request);
//        body = getBodyStringFromReq(request).getBytes(Charset.forName("UTF-8"));
//    }
//
//    public String getBodyString() {
//        try {
//            return new String(body, "UTF-8");
//        } catch (UnsupportedEncodingException ex) {
//            return new String(body);
//        }
//    }
//
//    private String getBodyStringFromReq(ServletRequest request) {
//        StringBuilder sb = new StringBuilder();
//        InputStream inputStream = null;
//        BufferedReader reader = null;
//        try {
//            inputStream = request.getInputStream();
//            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return sb.toString();
//    }













//    private final byte[] body; // 报文
//
//    public MAPIHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
//        super(request);
//        body = StreamUtil.readBytes(request.getInputStream());
//    }
//
//    @Override
//    public BufferedReader getReader() throws IOException {
//        return new BufferedReader(new InputStreamReader(getInputStream()));
//    }
//
//    @Override
//    public ServletInputStream getInputStream() throws IOException {
//        final ByteArrayInputStream bais = new ByteArrayInputStream(body);
//        return new ServletInputStream() {
//
//            @Override
//            public int read() throws IOException {
//                return bais.read();
//            }
//        };
//    }














    private String requestBody = null;

    public MyHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        if (requestBody == null) {
            requestBody = readBody(request);
        }
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new CustomServletInputStream(requestBody);
    }

    private static String readBody(ServletRequest request) {
        StringBuilder sb = new StringBuilder();
        String inputLine;
        BufferedReader br = null;
        try {
            br = request.getReader();
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read body.", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        return sb.toString();
    }

    private class CustomServletInputStream extends ServletInputStream {
        private ByteArrayInputStream buffer;

        public CustomServletInputStream(String body) {
            body = body == null ? "" : body;
            this.buffer = new ByteArrayInputStream(body.getBytes());
        }

        @Override
        public int read() throws IOException {
            return buffer.read();
        }

        @Override
        public boolean isFinished() {
            return buffer.available() == 0;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener listener) {
            throw new RuntimeException("Not implemented");
        }
    }
}
