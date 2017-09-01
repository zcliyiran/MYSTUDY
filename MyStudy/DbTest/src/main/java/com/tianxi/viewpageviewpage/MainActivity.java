package com.tianxi.viewpageviewpage;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.tianxi.viewpageviewpage.db.UserBean;
import com.tianxi.viewpageviewpage.db.UserDataBaseOperate;
import com.tianxi.viewpageviewpage.db.UserSQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 原生数据库控制
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener {
    List<ShopGoods>list=new ArrayList<>();


//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
//
//        DBHelper  dbHelper=new DBHelper(this);
////        for (int i = 0; i <10 ; i++) {
////            ShopGoods shop=new ShopGoods();
////            shop.setPrice(i);
////            shop.setGoodsBrand(i+"setGoodsBrand");
////            shop.setUnit(i+"setUnit");
////            shop.setPicture(i+"setPicture");
////            shop.setGoodNum(i+10);
////            shop.setGoodsId(i+200);
////            shop.setThumbnail(i+"路径");
////            list.add(shop);
////
////
////        }
//
//
////        for (int i = 0; i <10 ; i++) {
////
////            ContentValues values=new ContentValues();
////            /**
////             * supplierId
////             * goodsId
////             * goodsName
////             * goodsBrand
////             * price
////             * picture
////             * thumbnail
////             * goodsNum
////             * goodsUtil
////             *
////             */
////            values.put("supplierId",400);
////            values.put("goodsId",list.get(i).getGoodsId());
////            values.put("goodsName",list.get(i).getGoodName());
////            values.put("goodsBrand",list.get(i).getGoodsBrand());
////            values.put("price",list.get(i).getPrice());
////            values.put("picture",list.get(i).getPicture());
////            values.put("thumbnail",list.get(i).getThumbnail());
////            values.put("goodsNum",list.get(i).getGoodNum());
////            values.put("goodsUtil",list.get(i).getUnit());
////            dbHelper.insert(values);
////        }
//
//
//        Cursor cursor=dbHelper.query("300");
//
//        while (cursor.moveToNext()) {
//
//             StringBuffer  sb=new StringBuffer();
//          String supplierId=   cursor.getString(cursor.getColumnIndex("supplierId"));
//          String goodsName=   cursor.getString( cursor.getColumnIndex("goodsName"));
//          String goodsBrand=   cursor.getString(cursor.getColumnIndex("goodsBrand"));
//          String price=   cursor.getString(cursor.getColumnIndex("price"));
//          String thumbnail=   cursor.getString(cursor.getColumnIndex("thumbnail"));
//          String goodsNum=   cursor.getString(cursor.getColumnIndex("goodsNum"));
//          String goodsUtil=   cursor.getString(cursor.getColumnIndex("goodsUtil"));
//            sb.append("supplierId"+supplierId);
//            sb.append("goodsName"+goodsName);
//            sb.append("goodsBrand"+goodsBrand);
//            sb.append("price"+price);
//            sb.append("thumbnail"+thumbnail);
//            sb.append("goodsNum"+goodsNum);
//            sb.append("goodsUtil"+goodsUtil);
//            Log.d("MainActivity", sb.toString());
//
////            point.setPointName(cursor.getString(cursor
////                    .getColumnIndex("point_name")));
////            point.setLongitude(cursor.getDouble(cursor
////                    .getColumnIndex("longitude")));
////            point.setLatitude(cursor.getDouble(cursor
////                    .getColumnIndex("latitude")));
////            pointList.add(point);
//        }
//
//
//
//    }
//
//    @Override
//    public void onClick(View view) {
//
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//    }



    private EditText mEdTtSearch, mEdTtInsert;
    private TextView mTvEnsure,mTvInsert, mTvClear;
    private ListView mListView;

    private MyAdapter mAdapter;
    private List<UserBean> mUserDataList;
    private UserSQLiteOpenHelper mUserSQLiteOpenHelper;
    private UserDataBaseOperate mUserDataBaseOperate;
    private EditText mEdTtPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserSQLiteOpenHelper = UserSQLiteOpenHelper.getInstance(this);
        mUserDataBaseOperate = new UserDataBaseOperate(mUserSQLiteOpenHelper.getWritableDatabase());
        mUserDataList = mUserDataBaseOperate.findAll();
        initView();
    }

    private void initView() {
        mEdTtSearch = (EditText) findViewById(R.id.et_username_search);
        mEdTtInsert = (EditText) findViewById(R.id.et_username_insert);
        mEdTtPwd = (EditText)findViewById(R.id.et_userpwd_insert);
        mTvEnsure = (TextView) findViewById(R.id.tv_ensure);
        mTvEnsure.setOnClickListener(this);
        mTvInsert = (TextView)findViewById(R.id.tv_insert);
        mTvInsert.setOnClickListener(this);
        mTvClear = (TextView)findViewById(R.id.tv_clear_history);
        mTvClear.setOnClickListener(this);
        mAdapter = new MyAdapter(this);
        mListView = (ListView) findViewById(R.id.listview_uid);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.tv_ensure:
                mUserSQLiteOpenHelper.getReadableDatabase();
                String nameSearch = mEdTtSearch.getText().toString();
                if(null == nameSearch || nameSearch.length() == 0)return;
                mUserDataList = mUserDataBaseOperate.findUserByName(nameSearch);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.tv_insert:
                String name =mEdTtInsert.getText().toString();
                String pwd = mEdTtPwd.getText().toString();
                if(null == name || name.length()==0
                        ||null==pwd||pwd.length()==0)return;
                UserBean user = new UserBean();
                user.setName(name);
                user.setPwd(pwd);
                user.setModifyTime(System.currentTimeMillis());
                mUserDataBaseOperate.insertToUser(user);
                mEdTtInsert.setText("");
                mEdTtPwd.setText("");
                mUserDataList = mUserDataBaseOperate.findAll();
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.tv_clear_history:
                mUserDataBaseOperate.deleteAll();
                break;
            default:
                break;
        }

    }
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        setUserDialog(arg2);

    }

    protected void setUserDialog(int position) {
        final int p = position;
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(mUserDataList.get(position).getName());
        builder.setPositiveButton("修改", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                showChangeDialog(p);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });
        builder.setNeutralButton("删除", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                mUserDataBaseOperate.deleteUserByname(mUserDataList.get(p).getName());
                mUserDataList = mUserDataBaseOperate.findAll();
                mAdapter.notifyDataSetChanged();
            }
        });
        builder.create().show();
    }
    protected void showChangeDialog(int posi) {
        final int position = posi;
        final String username = mUserDataList.get(position).getName();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.modifyuser, null);
        final EditText nameEt = (EditText)view.findViewById(R.id.et_username_update);
        final EditText pwdEt = (EditText)view.findViewById(R.id.et_userpwd_update);
        builder.setView(view);
        builder.setTitle(username);
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(pwdEt.getText().toString().length()>0 && nameEt.getText().toString().length()>0){
                    UserBean user = new UserBean();
                    user.set_id(mUserDataList.get(position).get_id());
                    user.setName(nameEt.getText().toString());
                    user.setPwd(pwdEt.getText().toString());
                    user.setModifyTime(System.currentTimeMillis());
                    mUserDataBaseOperate.updateUser(user);
                    mUserDataList = mUserDataBaseOperate.findAll();
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.create().show();

    }

    public class MyAdapter extends BaseAdapter {
        LayoutInflater inflater;

        public MyAdapter(Context context) {
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            if (null == mUserDataList) {
                return 0;
            }
            return mUserDataList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            final int mPosition = position;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.sqlite_listitem, null);
                holder.userName = (TextView) convertView
                        .findViewById(R.id.tv_usernae);
                holder.userPwd = (TextView) convertView
                        .findViewById(R.id.tv_pwd);
                holder.userModifyTime = (TextView) convertView
                        .findViewById(R.id.tv_modifytime);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.userName.setText(mUserDataList.get(position)
                    .getName());
            holder.userPwd.setText(mUserDataList.get(position)
                    .getPwd());
            holder.userModifyTime.setText(mUserDataList.get(position)
                    .getModifyTime()+"");
            return convertView;
        }
    }

    class ViewHolder {
        TextView userName,userPwd,userModifyTime;
    }

}
