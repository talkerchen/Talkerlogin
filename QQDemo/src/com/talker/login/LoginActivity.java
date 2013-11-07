package com.talker.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**登陆界面activity*/
public class LoginActivity extends Activity implements OnClickListener{

	/**更多菜单，默认收起，点击后展开，再点击收起*/
	private Button btn_login_regist;
	/**更所登陆项的菜单是否展开，默认收起*/
	private Button login;
	  
	private EditText username;
	private EditText password;
	private Intent intent;
	
	public static final int MENU_PWD_BACK = 1;
	public static final int MENU_HELP = 2;
	public static final int MENU_EXIT = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		
		initView();
		 login = (Button)findViewById(R.id.btn_login);
	        login.setOnClickListener(ocl);
	}
	
	private void initView(){
		btn_login_regist = (Button) findViewById(R.id.btn_login_regist);
		btn_login_regist.setOnClickListener(this);
	}
	
	OnClickListener ocl = new OnClickListener(){
		public void onClick(View arg0) {
			username = (EditText)findViewById(R.id.username);
			password = (EditText)findViewById(R.id.password);
			if("13370221869".equals(username.getText().toString())&& 
					"chen".equals(password.getText().toString())){
				System.out.println("你点击了按钮");
				intent = new Intent(LoginActivity.this, SencondActivity.class);
				//启动Activity
				startActivity(intent);
			}else{
				Toast.makeText(LoginActivity.this,"用户登录信息错误" , Toast.LENGTH_SHORT).show();
			}
		}
    };
	
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		
		
		case R.id.btn_login_regist:
			Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
			startActivity(intent);
			break;

		}
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {//创建系统功能菜单
		// TODO Auto-generated method stub
		menu.add(0, MENU_PWD_BACK, 1, "密码找回").setIcon(R.drawable.menu_findkey);
		menu.add(0,MENU_HELP,2,"帮助").setIcon(R.drawable.menu_setting);
		menu.add(0, MENU_EXIT, 3, "退出").setIcon(R.drawable.menu_exit);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case MENU_PWD_BACK:
			break;
		case MENU_HELP:
			break;
		case MENU_EXIT:
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	

}
