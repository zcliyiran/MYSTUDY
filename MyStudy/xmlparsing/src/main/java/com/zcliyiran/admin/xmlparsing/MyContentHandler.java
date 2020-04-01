package com.zcliyiran.admin.xmlparsing;

import android.util.Log;

import com.zcliyiran.admin.xmlparsing.bean.PersonData;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 甘罗
 * @date 2018/9/17.
 */
public class MyContentHandler extends DefaultHandler {

    private String TAG="MyContentHandler";
    String tagName;


    String name;
    Short age;
    int id;

    private PersonData personData;

  private   List<PersonData> persons =new ArrayList<>();;

    @Override
    public void startDocument() throws SAXException {


    }

    @Override
    public void endDocument() throws SAXException {


    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tagName = localName;
        if (localName.equals("person")) {
            personData = new PersonData();
//            personData.setId(Integer.parseInt(attributes.getValue(0)));
            Log.e(TAG,"id"+attributes.getValue(0));

            personData.setId(Integer.valueOf(attributes.getValue(0)));

        }
        super.startElement(uri, localName, qName, attributes);


    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (localName.equals("person")){
            persons.add(personData);
        }
        tagName="";
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (tagName.equals("person")) {
//            personData = new PersonData();
        } else if (tagName.equals("name")) {
            name = new String(ch, start, length);
            personData.setName(name);
            Log.e(TAG,"name"+new String(ch, start, length).trim());
        }
        else if (tagName.equals("age")) {
            age = Short.parseShort(new String(ch, start, length));
            personData.setAge(age);
            Log.e(TAG,"age"+new String(ch, start, length).trim());
        }
        super.characters(ch, start, length);
    }


    public List<PersonData> getPersons() {
        return persons;
    }

    public void setPersons(List<PersonData> persons) {
        this.persons = persons;
    }
}
