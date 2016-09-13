package com.example.g40_70m.framedemo.selectimage.view;

import android.view.View;

import com.example.g40_70m.framedemo.R;
import com.example.g40_70m.framedemo.selectimage.bean.ImageFloder;


public class SelectMothedPopupWindow extends BasePopupWindowForListView<ImageFloder>
{

	public SelectMothedPopupWindow(int width, int height, View convertView)
	{
		super(convertView, width, height, true);
	}

	@Override
	public void initViews()
	{
	}

	public interface OnMothedSelected
	{
		void mothedSelected(int mothed);
	}

	private OnMothedSelected onMothedSelected;

	public void setOnImageDirSelected(OnMothedSelected onMothedSelected)
	{
		this.onMothedSelected = onMothedSelected;
	}

	@Override
	public void initEvents()
	{

		findViewById(R.id.btn_camera).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(onMothedSelected!=null){
					onMothedSelected.mothedSelected(1);
				}
				dismiss();
			}
		});
		findViewById(R.id.btn_album).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(onMothedSelected!=null){
					onMothedSelected.mothedSelected(2);
				}
				dismiss();
			}
		});
		findViewById(R.id.btn_cancle).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
	}

	@Override
	public void init()
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void beforeInitWeNeedSomeParams(Object... params)
	{
		// TODO Auto-generated method stub
	}

}
