package com.example.listmultichoise;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class MyListAdapter extends BaseAdapter {
	private Context mContext;
	private ListView mListView;

	private String[] mStrings = { 
			"One", "Two", "Three",
			"Four", "Five", "Six"};

	private  int[] imageIds=new int[]
			{R.drawable.lion ,R.drawable.tiger , R.drawable.monkey, R.drawable.dog,R.drawable.cat,
					R.drawable.elephant};
	public MyListAdapter(Context context, ListView list) {
		mContext = context;
		mListView = list;
	}
 
	public int getCount() {
		return mStrings.length;
	}
	@Override
	public boolean areAllItemsEnabled() {
		return false;
	}

	@Override
	public boolean isEnabled(int position) {
		return !mStrings[position].startsWith("-");
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		TextView tv;
		ImageView image;
		View layout=View.inflate(mContext, R.layout.list_item, null);
		image = (ImageView)layout.findViewById(R.id.image);
		tv =(TextView)layout.findViewById(R.id.title);
		tv.setText(mStrings[position]);
        image.setImageResource(imageIds[position]);
		updateBackground(position , tv);
		updateBackground(position, image);
		return layout;
	}

	@SuppressLint("NewApi")
	public void updateBackground(int position, View view) {
		int backgroundId;
		if (mListView.isItemChecked(position)) {
			backgroundId = R.drawable.list_selected_holo_light;
		} else {
			backgroundId = R.drawable.conversation_item_background_read;
		}
		Drawable background = mContext.getResources().getDrawable(backgroundId);
		view.setBackground(background);
	}
 
}
