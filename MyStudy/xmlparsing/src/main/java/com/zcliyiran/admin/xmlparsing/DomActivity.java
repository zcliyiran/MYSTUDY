package com.zcliyiran.admin.xmlparsing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zcliyiran.admin.xmlparsing.bean.PersonData;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * @author admin
 */
public class DomActivity extends AppCompatActivity {

    private String TAG = "DomActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dom);


        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(ReadUtils.getString(this, "xmltest.xml").toByteArray());


        List<PersonData> persons = parserXml(inputStream);


        for(PersonData person : persons) {
            Log.i(TAG, person.toString());
        }

    }

    private List<PersonData>  parserXml(InputStream inputStream) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            List<PersonData> persons = new ArrayList<>();
            Element element = document.getDocumentElement();    //获得根结点
            NodeList personNodes = element.getElementsByTagName("person");  //根据person获得结点
            for (int i = 0; i < personNodes.getLength(); i++) {
                PersonData person = new PersonData();
                Element personElement = (Element) personNodes.item(i);

                person.setId(new Integer(personElement.getAttribute("id")));
                NodeList childNodes = personElement.getChildNodes();

                for (int j = 0; j < childNodes.getLength(); j++) {
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {  //判断当前结点是否是元素结点
                        Element childElement = (Element) childNodes.item(j);
                        if ("name".equals(childElement.getNodeName())) {
                            person.setName(childElement.getFirstChild().getNodeValue());
                        } else if ("age".equals(childElement.getNodeName())) {
                            person.setAge(new Short(childElement.getFirstChild().getNodeValue()));
                        }
                    }
                    persons.add(person);

                }
                return persons;
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;

    }
}
