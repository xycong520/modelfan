package com.yijing.modelfan;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by xycong on 2016/5/19.
 */
public class Constant {

    public static int pageNum = 10;
    public static void showToast(Context mContext,String msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }
    public static boolean isLogin = false;
}
