package com.zcliyiran.admin.xmlparsing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zcliyiran.admin.xmlparsing.bean.PersonData;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 */
public class PullActivity extends AppCompatActivity {

    private String TAG = "PullActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);


        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(ReadUtils.getString(this, "xmltest.xml").toByteArray());


        List<PersonData> persons = parserXml(inputStream);


        for (PersonData person : persons) {
            Log.i(TAG, person.toString());
        }

    }

    private List<PersonData> parserXml(InputStream inputStream) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);

            XmlPullParser parser = factory.newPullParser();
            parser.setInput(inputStream, "utf-8");
            int type = parser.getEventType();
            List<PersonData> persons = new ArrayList<>();

            PersonData personData = null;
            while (type != XmlPullParser.END_DOCUMENT) {

                switch (type) {


                    case XmlPullParser.START_TAG:
                        if (parser.getName().equals("person")) {
                            personData = new PersonData();
                            personData.setId(Integer.parseInt(parser.getAttributeValue(null, "id")));
                        }else  if (parser.getName().equals("age")){
                            personData.setAge(Short.parseShort(parser.nextText()));
                        }else if (parser.getName().equals("name")){
                            personData.setName((parser.nextText()));
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("person")) {
                            persons.add(personData);
                        }

                        break;
                    default:
                        break;


                }
                type = parser.next();


            }

                return persons;


        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;

    }
}
