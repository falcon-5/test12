package com.example.web;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.simpleqrcodeviewer.R;

public class MyWebViewClient extends WebViewClient
{
	//ロード中のダイアログ表示
	private ProgressDialog _dialog;

	public MyWebViewClient(Context context)
	{
		_dialog = new ProgressDialog(context);
		_dialog.setIndeterminate(true);
		_dialog.setMessage(context.getString(R.string.message));
	}

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url)
	{
		//URLの再読み込み（リンクをタップした）時にもWebViewに遷移先のURLを読み込ませる
		view.loadUrl(url);

		//trueを返すとアプリケーションで遷移先のURLを処理する
		//falseを返すとWebViewで遷移先のURLを処理する
		return false;
	}

	@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon)
	{
		super.onPageStarted(view, url, favicon);

		//ページの読み込み開始時にダイアログ表示
		_dialog.show();
	}

	@Override
	public void onPageFinished(WebView view,String url)
	{
		super.onPageFinished(view, url);

		//ページ読み込み終了時にダイアログを閉じる
		_dialog.dismiss();
	}
}
