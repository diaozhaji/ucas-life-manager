package com.calm.lifemanager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CloudSyncTestActivity extends Activity {
	Button btn_user_register;
	Button btn_user_login;
	Button btn_user_logout;
	Button btn_userprofile_push;
	Button btn_userprofile_pull;
	Button btn_todolist_push;
	Button btn_todolist_pull;
	Button btn_get_time_tip;
	Button btn_get_mood_tip;
	Button btn_check_network;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud_sync_test);

        Log.i("Cloud", "Start Init Cloud Sync Test Buttons");
        
        Log.i("Cloud","Creating NetToolUtil Manager");
        
        btn_user_register = (Button)findViewById(R.id.act_cloud_sync_test_btn_user_register);
        
        btn_user_register.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
		        
		        new Thread() {
		        	public void run() {
		        	     Log.i("Cloud", "Start Testing User Register ...");
		        	     
		        	     Map<String, String> newUser = new HashMap<String, String>();
		        	     newUser.put("username", "created-by-android-client");
		        	     newUser.put("password", "daydayup");
			        	    
			        	    String retStr = null;
			        	    try {
								retStr = NetToolUtil.sendPostRequest(NetToolUtil.accountRegisterUrl, newUser, "utf-8");
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			        	    
			        	    if(retStr != null) {
			        	    	Log.i("User Login","result:" + retStr);
			        	    }
		        	     
//			        	     String newUser = null;
//				        		try {
//				        			newUser = new JSONStringer().object()
//											.key("username")
//											.value("created-by-android-client-2")
//											.key("password")
//											.value("daydayup")
//											.endObject()
//											.toString();
//								} catch (JSONException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
//				        		
//				        		String retStr = null;
//				        		try {
//									retStr = NetToolUtil.userRegister(NetToolUtil.accountRegisterUrl, new JSONObject(newUser), CloudSyncTestActivity.this);
//								} catch (JSONException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								} catch (Exception e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
//				        		
//				        		Log.i("User Login","result: " + retStr);
		        	}
		        }.start();
			}
        });
        
    	btn_user_login = (Button)findViewById(R.id.act_cloud_sync_test_btn_user_login);
    	
    	btn_user_login.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
		        
		        new Thread() {
		        	public void run() {
		        	    Log.i("Cloud", "Start Testing User Login...");
		        	    
		        	    Map<String, String> loginUser = new HashMap<String, String>();
		        	    loginUser.put("username", "lilihang");
		        	    loginUser.put("password", "daydayup");
		        	    
		        	    String retStr = null;
		        	    try {
							retStr = NetToolUtil.sendPostRequest(NetToolUtil.accountLoginUrl, loginUser, "utf-8");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	    
		        	    if(retStr != null) {
		        	    	Log.i("User Login","result:" + retStr);
		        	    }
		        	    
//		        	    String loginUser = null;
//		        		try {
//		        			loginUser = new JSONStringer().object()
//									.key("username")
//									.value("lilihang")
//									.key("password")
//									.value("daydayup")
//									.endObject()
//									.toString();
//						} catch (JSONException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//		        		
//		        		String retStr = null;
//		        		try {
//							retStr = NetToolUtil.userLogin(NetToolUtil.accountLoginUrl, new JSONObject(loginUser), CloudSyncTestActivity.this);
//						} catch (JSONException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//		        		
//		        		Log.i("User Login","result: " + retStr);
		        	}
		        }.start();
			}
        });
    	
    	btn_user_logout = (Button)findViewById(R.id.act_cloud_sync_test_btn_user_logout);
    	
    	btn_user_logout.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
		        
		        new Thread() {
		        	public void run() {
		        		Log.i("Cloud", "Start Testing User Logout...");
		        		
		        		//JSONArray logoutMessage = null;
		        		String logoutMessage = null;
		        		
		        		//logoutMessage = NetToolUtil.userLogout(NetToolUtil.accountLogoutUrl, CloudSyncTestActivity.this);
		        		try {
							logoutMessage = NetToolUtil.sendGetRequest(NetToolUtil.accountLogoutUrl, null, "utf-8");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        		
		        		if(logoutMessage.length() > 0){
		        			Log.i("User Logout","Success To Logout");
		        		}
		        		else{
		        			Log.i("User Logout","Fail to Logout");
		        		}
		        		
		        		Log.i("User Logout","Return Message: " + logoutMessage);
		        	}
		        }.start();
			}
        });
    	
    	btn_userprofile_push = (Button)findViewById(R.id.act_cloud_sync_test_btn_userprofile_push);
    	
    	btn_userprofile_push.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
		        Log.i("Cloud", "Start Testing ...");
			}
        });
    	
    	btn_userprofile_pull = (Button)findViewById(R.id.act_cloud_sync_test_btn_userprofile_pull);
    	
    	btn_userprofile_pull.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
		        
		        new Thread() {
		        	public void run() {
		        		Log.i("Cloud", "Start Testing User Profile pull...");
		        		
		        		
		        	}
		        }.start();
			}
        });
    	
    	btn_todolist_push = (Button)findViewById(R.id.act_cloud_sync_test_btn_todolist_push);
    	
    	btn_todolist_push.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
		        Log.i("Cloud", "Start Testing Todolist Push...");
		        
		        JSONObject todolistToPush = new JSONObject();
		        try {
					todolistToPush.put("username","lilihang");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        JSONObject todolistData = new JSONObject();
		        try {
					todolistData.put("ctime", System.currentTimeMillis());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        JSONArray todolistDataArray = new JSONArray();
		        
		        try {
		        	todolistDataArray.put(todolistData);
					todolistToPush.put("data",todolistDataArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        String retStr = null;
        	    try {
					retStr = NetToolUtil.sendPostRequestJson(NetToolUtil.todolistPushUrl, todolistToPush, "utf-8");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	    
        	    if(retStr != null) {
        	    	Log.i("Todolist Push","result:" + retStr);
        	    }
			}
        });
    	
    	btn_todolist_pull = (Button)findViewById(R.id.act_cloud_sync_test_btn_todolist_pull);
    	
    	btn_todolist_pull.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
		        
		        new Thread() {
		        	public void run() {
		        		Log.i("Cloud", "Start Testing Todolist Pull...");
		        		
		        		  Map<String, String> todolistRet = new HashMap<String, String>();
		        		  todolistRet.put("username", "lilihang");
		        		  //todolistRet.put("last_time", System.currentTimeMillis());
		        		  todolistRet.put("last_time", "0");
			        	    
			        	    String retStr = null;
			        	    try {
								retStr = NetToolUtil.sendPostRequest(NetToolUtil.todolistPullUrl, todolistRet, "utf-8");
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			        	    
			        	    if(retStr != null) {
			        	    	Log.i("Todolist Pull","result:" + retStr);
			        	    }
			        	    
//		        		String todolistRet = null;
//		        		try {
//							todolistRet = new JSONStringer().object()
//									.key("username")
//									.value("lilihang")
//									.key("last_time")
//									.value(System.currentTimeMillis())
//									.endObject()
//									.toString();
//						} catch (JSONException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//		        		
//		        		String retStr = null;
//		        		try {
//							retStr = NetToolUtil.todolistPull(NetToolUtil.todolistPullUrl, new JSONObject(todolistRet), CloudSyncTestActivity.this);
//						} catch (JSONException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//		        		
//		        		Log.i("Todolist Pull","result: " + retStr);
		        	}
		        }.start();
			}
        });
    	
    	btn_get_time_tip = (Button)findViewById(R.id.act_cloud_sync_test_btn_get_timp_tip);
    	
    	btn_get_time_tip.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
				
				new Thread() {
					public void run() {
						Log.i("Cloud", "Start Getting Time Tips ...");
						
						//JSONObject timeTips = new JSONObject();

				        JSONArray timeTips = null;
						try {
							timeTips = new JSONArray(NetToolUtil.getTimeTips(NetToolUtil.timeTipUrl, CloudSyncTestActivity.this));
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				        
				        if(timeTips.length() > 0) {
				        	Log.i("Time Tips","Success to get Time Tips.");
				        	Log.i("Time Tips","results = " + timeTips.toString());
				        }
				        else {
				        	Log.i("Time Tips","Fail to get Time Tips.");
				        }
					}
				}.start();
		        
			}
        });
    	
    	btn_get_mood_tip = (Button)findViewById(R.id.act_cloud_sync_test_btn_get_mood_tip);
    	
    	btn_get_mood_tip.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
		        
		        new Thread() {
					public void run() {
						Log.i("Cloud", "Start Getting Mood Tips ...");
						
						//JSONObject timeTips = new JSONObject();

				        JSONArray moodTips = null;
				        
						try {
							moodTips = new JSONArray(NetToolUtil.getMoodTips(NetToolUtil.moodTipUrl, CloudSyncTestActivity.this));
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				        
				        if(moodTips.length() > 0) {
				        	Log.i("Time Tips","Success to get Mood Tips.");
				        	Log.i("Time Tips","results = " + moodTips.toString());
				        }
				        else {
				        	Log.i("Time Tips","Fail to get Mood Tips.");
				        }
					}
				}.start();
			}
        });
    	
    	btn_check_network = (Button)findViewById(R.id.act_cloud_sync_test_btn_check_network);
    	
    	btn_check_network.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
		        Log.i("Cloud", "Start Testing ...");
		        if(NetToolUtil.isConnnected(CloudSyncTestActivity.this))
		        	Log.i("Cloud","Network is Up.");
		        else
		        	Log.i("Cloud","Network is Down.");
			}
        });
        
    }
}
