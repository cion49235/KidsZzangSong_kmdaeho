package com.kids.zzangsong.kmadeho.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

import com.kids.zzangsong.kmadeho.R;

public class Intro_Activity extends Activity {
	public static LinearLayout intro_layout;
	public Handler handler;
	public Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		context = this;
		handler = new Handler();
		handler.postDelayed(runnable, 0);
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(handler != null) handler.removeCallbacks(runnable);
	}
	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			Intent intent = new Intent(context, SubActivity.class);
			intent.putExtra("num", "436");
			intent.putExtra("subject", context.getString(R.string.txt_channel_title0));
			intent.putExtra("thumb", "http://m1.daumcdn.net/thumb/C138x78/U03/kids_infant/4FC438AE012E100054");
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intent);
			
//			Intent intent = new Intent(context, TabContent.class);
//			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
//			startActivity(intent);
			finish();
			//fade_animation
			overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
		}
	};
		@Override
		public void onBackPressed() {
			super.onBackPressed();
			if(handler != null) handler.removeCallbacks(runnable);
			finish();
		}
	}