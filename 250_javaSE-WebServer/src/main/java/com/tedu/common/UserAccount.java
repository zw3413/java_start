package com.tedu.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class UserAccount {

	private static String head= "UserAccount "+Thread.currentThread().getId()+" ";
	public static final int USER_NOT_EXSIST=-1;
	public static final int USER_PASSWORD_NOT_MATCH=0;
	public static final int USER_PASSWORD_MATCH=1;
	public static final int REG_EXSISTED=0;
	public static final int REG_INVALID=-1;
	public static final int REG_OK=1;
	private String userName;
	private String passWord;
	private String nickName;
	private static final String PATH="webapp/userinfo.txt";
	private static Map<String,UserAccount> userAccountMap;
	
	static{
		try {
			refreshFromFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public UserAccount(String userName,String passWord,String nickName){
	
		this.userName=userName;
		this.passWord=passWord;
		this.nickName=nickName;
	}
	
	public static void refreshFromFile() throws Exception{
		userAccountMap=new HashMap<String,UserAccount>();
		getUserMap();
	}
	private static void getUserMap() throws Exception {
		BufferedReader br=null;
		try{
			br=new BufferedReader(new InputStreamReader(new FileInputStream(PATH)));
			String line="";
			while((line=br.readLine())!=null){
				String[] str=line.split(",");
				String un=str[0].trim().split("=")[1].trim();
				String pw=str[1].trim().split("=")[1].trim();
				String nn=str[2].trim().split("=")[1].trim();
				UserAccount user=new UserAccount(un,pw,nn);
				userAccountMap.put(user.userName,user);
			}
			Set<Entry<String, UserAccount>> set=userAccountMap.entrySet();
			System.out.print(head+"获取文件中存储的用户信息如下：");
			System.out.println(head+"map.size():"+userAccountMap.size());
			for(Entry<String, UserAccount> e:set){
				System.out.println(head+e.getKey()+":"+e.getValue().userName+" "+e.getValue().passWord+" "+e.getValue().nickName);
			}
		
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			br.close();
		}
	}
	
	public static int verifyUser(String username, String password) {
	
		Set<Entry<String,UserAccount>> set=userAccountMap.entrySet();
		for(Entry<String,UserAccount> e:set){
			if(!userAccountMap.containsKey(username)){
				System.out.println(head+"用户名不存在");
				return USER_NOT_EXSIST;
			}
			if(userAccountMap.get(username).getPassWord().equals(password)){
				System.out.println(head+"用户名密码正确");
				return USER_PASSWORD_MATCH;
			}else{
				System.out.println(head+"用户名密码不匹配");
				return USER_PASSWORD_NOT_MATCH;
			}
	
		
		}
		return -1;
	}
	
	public static int regNewUser(String userName,String passWord,String nickName) throws Exception{
		
		refreshFromFile();		

		if(!verifyInput(userName,passWord,nickName)){
			return UserAccount.REG_INVALID;
		}
		UserAccount user=new UserAccount(userName,passWord,nickName);
		if(userAccountMap.containsKey(user.userName)){
			return UserAccount.REG_EXSISTED;
		}else{
			append(user);
			return UserAccount.REG_OK;
		}
	}
	
	private static boolean verifyInput(String userName,String passWord,String nickName) {
		
		boolean b1=userName.matches("\\w+(\\d|_|@){2}"); //用户名必须由：a-z A-Z 0-9 或 _ @ 组成，必须由英文字母开始，位数大于3个字符。
		boolean b2=passWord.matches("(\\w|_|@){6}");
		boolean b3=nickName.matches("\\w+");
		return b1&&b2&&b3;
	}

	private static void append(UserAccount user) {
		PrintWriter pw=null;
		try{
			String newLine="username = "+user.userName+","+"password = "+user.passWord+","+"nickname = "+user.nickName;
			System.out.println(head+"开始将注册信息写入文件.");
			pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream(PATH,true),"utf-8"),true);
			pw.println(newLine);
			System.out.println(head+"注册信息已经写入文件，注册成功。");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pw!=null){
				try{
					pw.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	private String getPassWord() {
		return passWord;
	}
	private String getNickName(){
		return nickName;
	}
}
