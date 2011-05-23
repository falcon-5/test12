package com.example.web;

import android.app.Activity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class MyWebChromeClient extends WebChromeClient
{
	private Activity _activity;

	public MyWebChromeClient(Activity activity)
	{
		_activity = activity;
	}

	@Override
	public void onProgressChanged(WebView view, int newProgress)
	{
		super.onProgressChanged(view, newProgress);
		if(newProgress >= 100)
		{
			_activity.setProgressBarVisibility(false);
		}
		_activity.setProgress(newProgress * 100);
	}

}
