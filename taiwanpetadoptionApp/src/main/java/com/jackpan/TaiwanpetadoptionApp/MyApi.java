package com.jackpan.TaiwanpetadoptionApp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by HYXEN20141227 on 2016/6/24.
 */
public class MyApi {

    public static long getTime(String dateTime){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try {
            Date date = sdf.parse(dateTime);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static void copyToClipboard(Context context,String str){
        int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(str);
            Log.e("version", "1 version");
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("text label",str);
            clipboard.setPrimaryClip(clip);
            Log.e("version","2 version");
        }
        Toast.makeText(context, "複製內容成功!!可以貼上並分享訊息囉", Toast.LENGTH_SHORT).show();
    }

}
