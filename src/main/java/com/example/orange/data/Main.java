//package com.example.orange.data;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.thoughtworks.xstream.XStream;
//
//import java.io.*;
//import java.util.stream.Stream;
//
//
//public class Main {
//
//
//    public static Stream<Valute> getCurrencies() throws Exception {
//
////        String absoluteXmlPath = FileSystems.getDefault().getPath("resources/xml/currencies.xml").normalize().toAbsolutePath().toString();
//
//        File xmlFile = new File("C:\\Users\\suruc\\Desktop\\orange\\src\\main\\resources\\xml\\currencies.xml");
//
//
//        FileReader fileReader = new FileReader(xmlFile);
//        BufferedReader rd = new BufferedReader(fileReader);
//===========================
//        HttpClient client = new DefaultHttpClient();
//                HttpGet request = new HttpGet(PropertyReader.getProperty("bnmUrl"));
//                HttpResponse response = client.execute(request);
//
//                //Get the response
//                BufferedReader rd = new BufferedReader(new InputStreamReader(
//                response.getEntity().getContent()));
//============================
//        String line = "";
//        String fullResponse = "";
//
//        while ((line = rd.readLine()) != null) {
//            fullResponse += line + "\r\n";
//        }
//
//        XStream xstream = new XStream();
//        xstream.allowTypes(new Class[] {Valute.class, ValCurs.class});
//
//        xstream.processAnnotations(ValCurs.class);
//        xstream.processAnnotations(Valute.class);
//
//        xstream.addImplicitCollection(ValCurs.class, "valutes", Valute.class);
//        ValCurs valCurs = (ValCurs) xstream.fromXML(fullResponse);
//
////        System.out.println(xstream.toXML(valCurs));
////        for (Valute valute : valCurs.getValutes()) {
////            System.out.println(valute.getName());
////        }
//
////        valCurs.getValutes().stream().filter(x -> x.getCharCode().equals("EUR")).forEach(x -> System.out.println(x.getValue()));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
////        System.out.println(objectMapper.writeValueAsString(valCurs));
//
//        return valCurs.getValutes().stream();
//    }
//
//}
