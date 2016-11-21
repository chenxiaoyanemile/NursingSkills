package com.example.lenovo.hulijinengtong.util;

import java.util.Map;
import java.util.Set;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.SyncStateContract;

public class SpUtil {

	private SharedPreferences sp;

	public SpUtil(Context context) {
		sp = context.getSharedPreferences(SyncStateContract.Constants.ACCOUNT_NAME, Context.MODE_PRIVATE);
	}


	public boolean contains(String key) {
		return sp.contains(key);
	}


	public void saveBoolean(String key, boolean value) {
		sp.edit().putBoolean(key, value).commit();
	}


	public void saveFloat(String key, float value) {
		sp.edit().putFloat(key, value).commit();
	}


	public void saveLong(String key, long value) {
		sp.edit().putLong(key, value).commit();
	}


	public void saveInt(String key, int value) {
		sp.edit().putInt(key, value).commit();
	}


	public void saveString(String key, String value) {
		sp.edit().putString(key, value).commit();
	}


	@SuppressLint("NewApi")
	public void saveStringSet(String key, Set<String> values) {
		sp.edit().putStringSet(key, values).commit();
	}


	public String getString(String key, String... defValue) {
		if (defValue.length > 0) {
			return sp.getString(key, defValue[0]);
		} else {
			return sp.getString(key, "");
		}
	}


	public int getInt(String key, int... defValue) {
		if (defValue.length > 0) {
			return sp.getInt(key, defValue[0]);
		} else {
			return sp.getInt(key, 0);
		}
	}


	public boolean getBoolean(String key, boolean... defValue) {
		if (defValue.length > 0) {
			return sp.getBoolean(key, defValue[0]);
		} else {
			return sp.getBoolean(key, false);
		}
	}


	public float getFloat(String key, float... defValue) {
		if (defValue.length > 0) {
			return sp.getFloat(key, defValue[0]);
		} else {
			return sp.getFloat(key, 0);
		}
	}


	public long getLong(String key, long... defValue) {
		if (defValue.length > 0) {
			return sp.getLong(key, defValue[0]);
		} else {
			return sp.getLong(key, 0);
		}
	}


	public Map<String, ?> getAll() {
		return sp.getAll();
	}


	@SuppressLint("NewApi")
	public Set<String> getStringSet(String key, Set<String>... defValue) {
		if (defValue.length > 0) {
			return sp.getStringSet(key, defValue[0]);
		} else {
			return sp.getStringSet(key, null);
		}
	}
}
