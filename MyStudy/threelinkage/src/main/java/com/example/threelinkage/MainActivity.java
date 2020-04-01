package com.example.threelinkage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.example.threelinkage.bean.A;
import com.example.threelinkage.util.GsonUtil;
import com.example.threelinkage.util.JsonFileReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 此module 主要是用到了
 * 1   原生的json解析
 * 2   gson 解析json
 * 3 从assets中读取文件
 * 4  仿ios的pickerview
 */
public class MainActivity extends AppCompatActivity {

    String  testStr="{\"age\":\"age333\",\"name\":\"name333\"}";
    String  testStr1="[{\"age\":\"age111\",\"name\":\"name111\"},{\"age\":\"age222\",\"name\":\"name222\"},{\"age\":\"age333\",\"name\":\"name333\"}]";

    /**
     * 显示选择的textview
     */
    private TextView mTextViewAddress;
    /**
     * 开源的optinview
     */
    OptionsPickerView pvOptions;


    /**
     * json中的集合
     */
    //  省份
//    ArrayList<ProvinceBean> provinceBeanList = new ArrayList<>();
    ArrayList<String> provinceBeanList2 = new ArrayList<>();
    //  城市
    ArrayList<List<String>> cityList = new ArrayList<>();
    //  区/县

    ArrayList<List<List<String>>> districtList = new ArrayList<>();
    /**
     * age : age333
     * name : name333
     */

    private String age;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        pvOptions = new OptionsPickerView(this);

        mTextViewAddress = (TextView) findViewById(R.id.tv_address);
        //  获取json数据
        final String province_data_json = JsonFileReader.getJson(this, "province_data.json");
        //  解析json数据
        parseJson(province_data_json);


        pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {

                String city = provinceBeanList2.get(options1);
                String address;
//                如果是直辖市或者特别行政区只设置市和区/县
                if ("北京市".equals(city) || "上海市".equals(city) || "天津市".equals(city) || "重庆市".equals(city) || "澳门".equals(city) || "香港".equals(city)) {
                    address = provinceBeanList2.get(options1)
                            + " " + districtList.get(options1).get(options2).get(options3);
                } else {
                    address = provinceBeanList2.get(options1)
                            + " " + cityList.get(options1).get(options2)
                            + " " + districtList.get(options1).get(options2).get(options3);
                }
                mTextViewAddress.setText(address);
            }
        }).setTitleText("选择城市").setCyclic(false, false, false)

                .build();
        pvOptions.setPicker(provinceBeanList2, cityList, districtList);
        pvOptions.setSelectOptions(0, 0, 0);

        //  点击弹出选项选择器
        mTextViewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pvOptions.show();
//               List<MyJsonBean> list= new ArrayList<>();

                //对于无数组的
                A a = (A) GsonUtil.stringToObject(testStr, A.class);
                // 对于有数组的
                ArrayList<A> list= (ArrayList<A>) GsonUtil.stringToList(testStr1,  A.class);
                String json1 = GsonUtil.objectToString(list  ) ;

                Log.e("TAG", GsonUtil.objectToString(a));

                Log.e("TAG", json1);



            }
        });
    }


    //json 解析
    public void parseJson(String str) {
        //城市的几何
        ArrayList<String> cities;

        ArrayList<String> district;

        ArrayList<List<String>> districts;
        try {
            JSONArray jsonArray = new JSONArray(str);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject provinceObject = jsonArray.getJSONObject(i);
                String provinceName = provinceObject.getString("name");
                provinceBeanList2.add(provinceName);
                JSONArray cityArray = provinceObject.getJSONArray("city");

                cities = new ArrayList<>();//   声明存放城市的集合

                districts = new ArrayList<>();//声明存放区县集合的集合
                for (int j = 0; j < cityArray.length(); j++) {

                    JSONObject cityObject = cityArray.optJSONObject(j);
//                    //  将城市放入集合
                    String cityName = cityObject.optString("name");
                    cities.add(cityName);
                    //没个城市都有一个
                    district = new ArrayList<>();// 声明存放区县的集合

                    JSONArray areaArray = cityObject.optJSONArray("area");

                    for (int k = 0; k < areaArray.length(); k++) {
                        String areaName = areaArray.getString(k);
                        district.add(areaName);
                    }
                    //  将区县的集合放入集合
                    districts.add(district);
                }
                //  将存放区县集合的集合放入集合
                districtList.add(districts);
                //  将存放城市的集合放入集合
                cityList.add(cities);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //    //  解析json填充集合
//    public void parseJson(String str) {
//        //城市的几何
//        ArrayList<String> cities;
//
//        ArrayList<String> district;
//        ArrayList<List<String>> districts;
//
//        try {
//            //  获取json中的数组
//            JSONArray jsonArray = new JSONArray(str);
//            //  遍历数据组
//            for (int i = 0; i < jsonArray.length(); i++) {
//                //  获取省份的对象
//                JSONObject provinceObject = jsonArray.optJSONObject(i);
//                //  获取省份名称放入集合
//                String provinceName = provinceObject.getString("name");
//                provinceBeanList2.add(provinceName);
////                provinceBeanList.add(new ProvinceBean(provinceName));
//                //  获取城市数组
//                JSONArray cityArray = provinceObject.optJSONArray("city");
//
//                cities = new ArrayList<>();//   声明存放城市的集合
//
//                districts = new ArrayList<>();//声明存放区县集合的集合
//
//                //  遍历城市数组
//                for (int j = 0; j < cityArray.length(); j++) {
//                    //  获取城市对象
//                    JSONObject cityObject = cityArray.optJSONObject(j);
//                    //  将城市放入集合
//                    String cityName = cityObject.optString("name");
//                    cities.add(cityName);
//                    district = new ArrayList<>();// 声明存放区县的集合
//                    //  获取区县的数组
//                    JSONArray areaArray = cityObject.optJSONArray("area");
//                    //  遍历区县数组，获取到区县名称并放入集合
//                    for (int k = 0; k < areaArray.length(); k++) {
//                        String areaName = areaArray.getString(k);
//                        district.add(areaName);
//                    }
//                    //  将区县的集合放入集合
//                    districts.add(district);
//                }
//                //  将存放区县集合的集合放入集合
//                districtList.add(districts);
//                //  将存放城市的集合放入集合
//                cityList.add(cities);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
}
