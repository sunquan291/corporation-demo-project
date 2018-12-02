package com.zte.sunquan.jaxb;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.dom.DOMResult;
import java.io.StringReader;
import java.io.StringWriter;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by 10184538 on 2017/10/20.
 */
public class PersonTest {
    private Person person;
    int age = 29;
    String name = "Foo";
    String hobby = "singing";

    @Before
    public void init() {
        person = new Person("xy");
        person.name = name;
        person.age = age;
        person.addHobby(hobby);

    }

    @Test
    public void testMarshallerDocument() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(person.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);//格式化xml输出
        DOMResult res = new DOMResult();
        marshaller.marshal(person, res);
        Element doc = ((Document) res.getNode()).getDocumentElement();
        assertEquals(name, doc.getAttribute("name"));
        assertEquals(age, Integer.parseInt(doc.getAttribute("age")));
        //((Document) res.getNode()).getDocumentElement()
        NodeList hobbys = doc.getChildNodes();
        assertEquals(hobby, hobbys.item(0).getTextContent());
    }

    @Test
    public void testMarshallerString() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(person.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);//格式化xml输出

        StringWriter writer = new StringWriter();
        marshaller.marshal(person, writer);
        String outString = writer.toString();
        System.out.println(outString);
        assertTrue(outString.contains("</person"));
    }

    @Test
    public void testUnMarshaller() throws JAXBException {

        String outString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<person name=\"Foo\" age=\"29\">\n" +
                "    <hobbys>\n" +
                "        <hobby>singing</hobby>\n" +
                "    </hobbys>\n" +
                "</person>";

        JAXBContext context = JAXBContext.newInstance(Person.class, Person.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(outString);
        Person reciever = (Person) unmarshaller.unmarshal(reader);
        assertEquals(name, reciever.name);
        assertEquals(age, reciever.age);
        assertEquals(hobby, reciever.getHobby().get(0));
    }
}
