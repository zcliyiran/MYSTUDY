package com.zcliyiran.admin.xmlparsing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author admin
 */
public class SaxActivity extends AppCompatActivity {
    private  String  TAG="SaxActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sax);
    MyContentHandler myContentHandler=    new MyContentHandler();
        try {
            ByteArrayInputStream inputStream =
                    new ByteArrayInputStream(ReadUtils.getString(this, "xmltest.xml").toByteArray());
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //reader对象，从解析器得到reader
            XMLReader reader  = factory.newSAXParser().getXMLReader();
            //为xmlreader设置内容处理器，逐行扫描，调用函数，要调用的函数就在MyContentHandler实现类中
            reader.setContentHandler(myContentHandler);
            reader.parse(new InputSource(inputStream));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < myContentHandler.getPersons().size() ; i++) {
            Log.e(TAG,myContentHandler.getPersons().get(i).toString());

        }

    }
}
