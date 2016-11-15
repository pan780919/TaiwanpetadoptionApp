package com.hos;


import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adbert.AdbertInterstitialAD;
import com.adbert.AdbertListener;
import com.adbert.AdbertLoopADView;
import com.adbert.AdbertNativeAD;
import com.adbert.AdbertNativeADListener;
import com.adbert.AdbertNativeADView;
import com.adbert.AdbertOrientation;
import com.adbert.AdbertTrace;
import com.adbert.ExpandVideoPosition;
import com.adlocus.Ad;
import com.adlocus.AdListener;
import com.adlocus.AdLocusLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.gson.Gson;
import com.jackpan.TaiwanpetadoptionApp.R;


import org.json.JSONException;
import org.json.JSONObject;

import Appkey.MyAdKey;


public class TwoActivity extends Activity {
	private TextView textview, textview2, textview3, textview4, textview5,
			textview6, textview7, textview8, textview9, textview10, textview11,
			textview12, textview13, textview14, textview15, textview16,
			textview17, textview18, textview19, textview20, textview21
			, textview22, textview23, textview24, textview25, textview26,textview81;
	private ImageView img;
	private Button btn;
	private boolean isCencel = false;
	private ProgressDialog progressDialog;
	private String name;
	private Bitmap bitmap = null;
	private String mArea;
	private InterstitialAd interstitial;
	private WebView mWebVirw;
	private   double latitude ,longitude;
	private Button googlbtn;
	private ResultData data;
	private boolean isThread = true;
	AdbertLoopADView adbertView;
	private LinearLayout mLayoutMain = null;
	AdbertInterstitialAD adbertInterstitialAD;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 //開啟全螢幕
		 getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		 WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 //設定隱藏APP標題
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_two_2);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		textview = (TextView) findViewById(R.id.textView1);
		textview2 = (TextView) findViewById(R.id.textView2);
		textview3 = (TextView) findViewById(R.id.textView3);
		textview4 = (TextView) findViewById(R.id.textView4);
		textview5 = (TextView) findViewById(R.id.textView5);
		textview6 = (TextView) findViewById(R.id.textView6);

		textview7 = (TextView) findViewById(R.id.textView7);
		textview8 = (TextView) findViewById(R.id.textView8);
		textview81 = (TextView) findViewById(R.id.textView81);
		textview9 = (TextView) findViewById(R.id.textView9);
		textview10 = (TextView) findViewById(R.id.textView10);
		textview11 = (TextView) findViewById(R.id.textView11);
		textview12 = (TextView) findViewById(R.id.textView12);
		textview13 = (TextView) findViewById(R.id.textView13);
		textview14 = (TextView) findViewById(R.id.textView14);
		textview15 = (TextView) findViewById(R.id.textView15);
		textview16 = (TextView) findViewById(R.id.textView16);
		textview17 = (TextView) findViewById(R.id.textView17);
		textview18 = (TextView) findViewById(R.id.textView18);
		textview19 = (TextView) findViewById(R.id.textView19);
		textview20 = (TextView) findViewById(R.id.textView20);
		textview21 = (TextView) findViewById(R.id.textView21);
		textview22 = (TextView) findViewById(R.id.textView22);
		textview23 = (TextView) findViewById(R.id.textView23);
		textview24 = (TextView) findViewById(R.id.textView24);
		textview25 = (TextView) findViewById(R.id.textView25);
		textview26 = (TextView) findViewById(R.id.textView26);
		googlbtn = (Button) findViewById(R.id.button1);
		googlbtn.setVisibility(View.GONE);
//		 textview4.setVisibility(View.GONE);
//		 textview5.setVisibility(View.GONE);
//		 textview6.setVisibility(View.GONE);
//		 textview7.setVisibility(View.GONE);
//		 textview8.setVisibility(View.GONE);
//		 textview81.setVisibility(View.GONE);
		 textview9.setVisibility(View.GONE);
		 textview10.setVisibility(View.GONE);
		 textview11.setVisibility(View.GONE);
		 textview12.setVisibility(View.GONE);
		textview13.setVisibility(View.GONE);
		textview14.setVisibility(View.GONE);
		textview15.setVisibility(View.GONE);
		textview16.setVisibility(View.GONE);
		textview17.setVisibility(View.GONE);
		textview18.setVisibility(View.GONE);
		textview19.setVisibility(View.GONE);
		textview20.setVisibility(View.GONE);
		textview21.setVisibility(View.GONE);
		textview22.setVisibility(View.GONE);
		textview23.setVisibility(View.GONE);
		textview24.setVisibility(View.GONE);
		textview25.setVisibility(View.GONE);
		textview26.setVisibility(View.GONE);
		img = (ImageView) findViewById(R.id.pageimg);
		img.setVisibility(View.GONE);
		setAdBert();
//		AdView mAdView = (AdView) findViewById(R.id.adView);
//		AdRequest adRequest = new AdRequest.Builder().build();
//		mAdView.loadAd(adRequest);
			loadIntent();
//		LoadNetAsyncTask loadNetAsyncTask2 = new LoadNetAsyncTask();
//		loadNetAsyncTask2.execute(MyAdKey.jsondata2);

		interstitial = new InterstitialAd(this);
		interstitial.setAdUnitId(MyAdKey.AdmobinterstitialBannerId);
		AdRequest adRequest = new AdRequest.Builder().build();
		interstitial.loadAd(adRequest);

//		startAdLocus();


	}

	private void loadIntent() {
		String json = getIntent().getStringExtra("json");
		final String lat = getIntent().getStringExtra("Latitude");
		final String lon = getIntent().getStringExtra	("Longitude");
//		final String latList = getIntent().getStringExtra("latList");
//		final double latList = getIntent().getDoubleExtra("latList", 0);
////		final String lonList = getIntent().getStringExtra("lonList");
//		final double lonList = getIntent().getDoubleExtra("lonList", 0);

//		Log.e("Jack","lat"+Double.parseDouble(latList)+""+"lon"+Double.parseDouble(lonList));
		 data = new Gson().fromJson(json, ResultData.class);
		// loadImage(data.album_file, img);
//
		textview.setText("字號:" + data.字號);
		textview2.setText("名稱:" + data.機構名稱);




		textview3.setText("所在縣市:" + data.縣市);
		textview4.setText("負責獸醫:" + data.負責獸醫);
		textview5.setText("執照類別:" + data.執照類別);

		textview6.setText("電話:" + data.機構電話);

		textview7.setText("機構地址:" + data.機構地址);
		textview8.setText("狀態:" + data.狀態);
		textview81.setText("發照日期 :" + data.發照日期);
//		textview9.setText("停車場（腳踏車）總車架數 :" + data.TOTALBIKE);
//		textview10.setText("停車場收費資訊:" + data.PAYEX);
//		if(data.TEL.equals("")) textview11.setVisibility(View.GONE);
//		textview11.setText("停車場電話:" + data.TEL);
//		textview11.setTextSize(24);
//		textview11.setTextColor(Color.RED);
//
//		textview11.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//
//			        Intent myIntentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+data.TEL));
//			        startActivity(myIntentDial);
//
//			}
//		});
//		MyApi.cal_TWD97_To_lonlat(Double.parseDouble(data.TW97X), Double.parseDouble(data.TW97Y));
////
//
////        boolean isGpsOpen = MySharedPreferences.getIsGPSState(TwoActivity.this);
//		googlbtn.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//
//			}
//		});
//////
//		MyApi.mGecoder(getApplicationContext(), data.機構地址);




//
//




	}
	
	@Override
	protected void onPause() {
				super.onPause();
		adbertView.pause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		adbertView.destroy();
		adbertInterstitialAD.destroy();

	}
	

	@Override
	protected void onResume() {
		interstitial.show();
		super.onResume();
		adbertView.resume();
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if ((keyCode == KeyEvent.KEYCODE_BACK)) { // 確定按下退出鍵

			this.finish();
			return true;

		}

		return super.onKeyDown(keyCode, event);

	}

	WebViewClient mWebViewClient = new WebViewClient() {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	};
//	private class LoadNetAsyncTask extends
//	AsyncTask<String, Void, ArrayList<ResultData>> {
//
//		@Override
//		protected void onPostExecute(final ArrayList<ResultData> result) {
//			super.onPostExecute(result);
//
//		}
//
//
//		@Override
//		protected ArrayList<ResultData> doInBackground(String... params) {
//			BufferedReader br = null;
//			StringBuilder sb = new StringBuilder();
//			try {
//				URL url = new URL(params[0]);
//				HttpURLConnection httpUrlCon = (HttpURLConnection) url
//						.openConnection();
//				httpUrlCon.setConnectTimeout(20000);// 連線
//				httpUrlCon.setReadTimeout(20000);// 讀取
//
//				InputStream inputStream = httpUrlCon.getInputStream();
//				InputStreamReader inputStreamReader = new InputStreamReader(
//						inputStream);
//				br = new BufferedReader(inputStreamReader);
//				String value = null;
//
//				while ((value = br.readLine()) != null) {
//					sb.append(value);
//				}
//				String result = sb.toString();
//
//				ArrayList<ResultData> allData = new ArrayList<ResultData>();
//	
//				try {
//			
//			
//					JSONArray jsonarry = new JSONArray(result);
//					for (int i = 0; i < jsonarry.length(); i++) {
//						JSONObject jsonObject = jsonarry.getJSONObject(i);
//						Gson gson = new Gson();
//						
//						final ResultData data2 = gson.fromJson(jsonObject.toString(),
//								ResultData.class);
//				
//						if(data.ID.equals(data2.ID)){
//							Log.e("Jack", data.ID);
//							Log.e("Jack", data2.ID);
//							if(data2.AVAILABLECAR.equals("-9"))
//							{
//								 continue;
//								
//							}else 
//							
//							{	runOnUiThread(new Runnable() {
//								public void run() {
//								textview8.setVisibility(View.VISIBLE);
//								textview8.setTextSize(28);
//								textview8.setTextColor(Color.BLUE);
//								textview8.setText("剩餘車位:" + data2.AVAILABLECAR);
//								Log.e("Jack", data2.AVAILABLECAR);
//								
//								new Thread(){
//									
//									public void run() {
//										while(isThread){
//											Calendar cal = Calendar.getInstance();
//											int a = cal.get(Calendar.SECOND);
//											if(a>=30) a=a-30;
//											final String etime = String.valueOf(30-a);
//											
//											runOnUiThread(new Runnable() {
//												public void run() {
//												textview81.setVisibility(View.VISIBLE);
//												textview81.setText("更新倒數:" + etime );
//							
//												}
//											});
//											if(a%30==0){
//												runOnUiThread(new Runnable() {
//													public void run() {
//														LoadNetAsyncTask loadNetAsyncTask2 = new LoadNetAsyncTask();
//														loadNetAsyncTask2.execute(MyAdKey.jsondata2);
//								
//													}
//												});
//											}
//											try {
//												Thread.sleep(100);
//												
//								
//											} catch (InterruptedException e) {
//												// TODO Auto-generated catch block
//												e.printStackTrace();
//											}
//											
//										}
//										
//									};
//									
//								}.start();
//								if(!isThread) Thread.interrupted();
////								new CountDownTimer(30000, 1000) {
////
////									 @Override
////
////									 public void onTick(long millisUntilFinished) {
////									                //倒數秒數中要做的事
////										 textview81.setText("倒數時間:" + new SimpleDateFormat("s").format(millisUntilFinished));
////									 }
////
////									 @Override
////									 public void onFinish() {
////											runOnUiThread(new Runnable() {
////												public void run() {
////												textview8.setVisibility(View.VISIBLE);
////												textview8.setTextSize(28);
////												textview8.setTextColor(Color.BLUE);
////												textview8.setText("剩餘（汽車）車位數:" + data2.AVAILABLECAR);
////							
////												}
////											});
////											 try {
////												Thread.sleep(3000);
////											} catch (InterruptedException e) {
////												// TODO Auto-generated catch block
////												e.printStackTrace();
////											}
////										 new CountDownTimer(30000, 1000) {
////
////											 @Override
////
////											 public void onTick(long millisUntilFinished) {
////											                //倒數秒數中要做的事
////												 textview81.setText("倒數時間:" + new SimpleDateFormat("s").format(millisUntilFinished));
////											 }
////
////											 @Override
////											 public void onFinish() {
////											                 //倒數完成後要做的事
////													runOnUiThread(new Runnable() {
////														public void run() {
////														textview8.setVisibility(View.VISIBLE);
////														textview8.setTextSize(28);
////														textview8.setTextColor(Color.BLUE);
////														textview8.setText("剩餘（汽車）車位數:" + data2.AVAILABLECAR);
////									
////														}
////													});
////											 }
////											}.start();
////									 }
////									}.start();	
//								}
//							});
//						
//							}
//							
//						}
//						
//					
//
//
//						allData.add(data2);
//						
//					}
//
//				} catch (JSONException e) {
//					Log.e("Jack", "JSONException:" + e);
//				}
//
//				return allData;
//			} catch (MalformedURLException e) {
//				Log.e("test", "MalformedURLException:" + e);
//			} catch (IOException e) {
//				Log.e("test", "IOException:" + e);
//			} finally {
//
//				try {
//					if (br != null)
//						br.close();
//				} catch (IOException e) {
//					Log.e("Howard", "IOException:" + e);
//				}
//			}
//			Log.d("test", "JSON:" + sb);
//
//			return null;
//
//		}
//
//	}
		private static final String TAG = "TwoActivity";
	 private  void setAdBert(){
		 adbertView = (AdbertLoopADView)findViewById(R.id.adbertADView);
		 adbertView.setMode(AdbertOrientation.NORMAL);
		 adbertView.setExpandVideo(ExpandVideoPosition.BOTTOM);
		 adbertView.setFullScreen(false);
		 adbertView.setBannerSize(AdSize.BANNER);
		 adbertView.setAPPID("20161111000002", "5a73897de2c53f95333b6ddaf23639c7");
		 adbertView.setListener(new AdbertListener() {
			 @Override
			 public void onReceive(String msg) {
				 Log.d(TAG, "onReceive: " + msg);
			 }

			 @Override
			 public void onFailedReceive(String msg) {
				 Log.d(TAG, "onFailedReceive: " + msg);

			 }
		 });
		 adbertView.start();


		 //建立插頁式廣告
		 adbertInterstitialAD = new AdbertInterstitialAD(this);

		 //設定appId與appKey，請跟艾普特申請。
		 adbertInterstitialAD.setAPPID("20161111000002", "5a73897de2c53f95333b6ddaf23639c7");

		 //設定廣告載入成功或失敗的Listener
		 adbertInterstitialAD.setListener(new AdbertListener() {
			 @Override
			 public void onReceive(String arg0) {

			 }

			 @Override
			 public void onFailedReceive(String arg0) {

			 }
		 });

		 //開始載入廣告
		 adbertInterstitialAD.loadAd();
//
//		 final AdbertNativeAD nativeAD = new AdbertNativeAD(this,  "20161111000002", "5a73897de2c53f95333b6ddaf23639c7");
//
//// 定義視覺呈現的AdbertNativeADView
//		 final AdbertNativeADView nativeContainer =  new AdbertNativeADView(getBaseContext());
//// 方式一, 以程式方式產生
//
//		 nativeAD.setListener(new AdbertNativeADListener() {
//
//			 @Override
//			 public void onReceived(String arg0) {
//				 if (nativeAD.isReady()) {
//
//					 try {
//						 TextView headline =(TextView)findViewById(R.id.headline);
//						 JSONObject jsonObject = nativeAD.getData();
//						 Log.d(TAG, "onReceived: "+jsonObject.toString());
//						 headline.setText((String)jsonObject.getString("headline"));
//
//						 String desc = (String)jsonObject.getString("desc");
//						 String companyName = (String) jsonObject.getString("companyName");
//						 String image = (String)jsonObject.getString("image");
//						 String icon = (String)jsonObject.getString("icon");
//					 } catch (JSONException e) {
//						 e.printStackTrace();
//					 }
//				// 利用此處所取得的資料進行廣告素材的載入
//					 nativeContainer.setAd(nativeAD);
//				 }
//			 }
//
//			 @Override
//			 public void onFailReceived(String arg0) {
//			 }
//
//		 });
//
//
//		 setContentView(nativeContainer); // 將視覺化的View進行定義
//
//		 nativeAD.loadAD();


	 }
	private void startAdLocus() {
		AdLocusLayout adlocusLayout = new AdLocusLayout(this, AdLocusLayout.AD_SIZE_BANNER, "7fd30836d67285c1023c79740d4832a5688bdc6b", 15);
		// 設定輪播時間，最低 15 秒，-1 為不輪播只顯示一則
		// 設定輪播動畫，預設為淡入，範例設定為隨機動畫
		adlocusLayout.setTransitionAnimation(AdLocusLayout.ANIMATION_RANDOM);
		LinearLayout.LayoutParams adlocusLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		// 設定置中
		adlocusLayoutParams.gravity = Gravity.CENTER;
		// 加入到你的 layout 中
		mLayoutMain = (LinearLayout) findViewById(R.id.mylayout);
		mLayoutMain.addView(adlocusLayout, adlocusLayoutParams);
		mLayoutMain.setGravity(Gravity.CENTER_HORIZONTAL);
		mLayoutMain.invalidate();
		adlocusLayout.setListener(new AdListener() {
			@Override
			public void onReceiveAd(Ad ad) {
				Log.d(TAG, "onReceiveAd: "+ad.toString());

			}

			@Override
			public void onFailedToReceiveAd(Ad ad, AdLocusLayout.ErrorCode errorCode) {
				Log.d(TAG, "onReceiveAd: "+errorCode);
			}


		});
	}
}
