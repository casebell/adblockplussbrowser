/*
 * This file is part of Adblock Plus <https://adblockplus.org/>,
 * Copyright (C) 2006-present eyeo GmbH
 *
 * Adblock Plus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3 as
 * published by the Free Software Foundation.
 *
 * Adblock Plus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Adblock Plus.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.adblockplus.sbrowser.contentblocker.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Set;

public class SharedPrefsUtils
{

  public static void putBoolean(Context context, int keyResId, boolean value)
  {
    final SharedPreferences.Editor editor = getDefaultSharedPreferences(context).edit();
    editor.putBoolean(context.getString(keyResId), value).apply();
  }

  public static boolean getBoolean(Context context, int keyResId, boolean defValue)
  {
    final SharedPreferences preferences = getDefaultSharedPreferences(context);
    try
    {
      return preferences.getBoolean(context.getString(keyResId), defValue);
    }
    catch (ClassCastException e)
    {
      return defValue;
    }
  }

  public static void putInt(Context context, int keyResId, int value)
  {
    final SharedPreferences.Editor editor = getDefaultSharedPreferences(context).edit();
    editor.putInt(context.getString(keyResId), value).apply();
  }

  public static int getInt(Context context, int keyResId, int defValue)
  {
    final SharedPreferences preferences = getDefaultSharedPreferences(context);
    try
    {
      return preferences.getInt(context.getString(keyResId), defValue);
    }
    catch (ClassCastException e)
    {
      return defValue;
    }
  }

  public static void putLong(final Context context, final int keyResId, final long value)
  {
    final SharedPreferences.Editor editor = getDefaultSharedPreferences(context).edit();
    editor.putLong(context.getString(keyResId), value).apply();
  }

  public static long getLong(final Context context, final int keyResId, final long defValue)
  {
    final SharedPreferences preferences = getDefaultSharedPreferences(context);
    try
    {
      return preferences.getLong(context.getString(keyResId), defValue);
    }
    catch (final ClassCastException e)
    {
      return defValue;
    }
  }

  public static void putString(Context context, int keyResId, String value)
  {
    final SharedPreferences.Editor editor = getDefaultSharedPreferences(context).edit();
    editor.putString(context.getString(keyResId), value).apply();
  }

  public static String getString(Context context, int keyResId, String defValue)
  {
    final SharedPreferences preferences = getDefaultSharedPreferences(context);
    try
    {
      return preferences.getString(context.getString(keyResId), defValue);
    }
    catch (ClassCastException e)
    {
      return defValue;
    }
  }

  public static void putStringSet(Context context, int keyResId, Set<String> values)
  {
    final SharedPreferences.Editor editor = getDefaultSharedPreferences(context).edit();
    editor.putStringSet(context.getString(keyResId), values).apply();
  }

  public static Set<String> getStringSet(Context context, int keyResId, Set<String> defValues)
  {
    final SharedPreferences preferences = getDefaultSharedPreferences(context);
    try
    {
      return preferences.getStringSet(context.getString(keyResId), defValues);
    }
    catch (ClassCastException e)
    {
      return defValues;
    }
  }

  public static void registerOnSharedPreferenceChangeListener(Context context,
      OnSharedPreferenceChangeListener listener)
  {
    getDefaultSharedPreferences(context).registerOnSharedPreferenceChangeListener(listener);
  }

  public static void unregisterOnSharedPreferenceChangeListener(Context context,
      OnSharedPreferenceChangeListener listener)
  {
    getDefaultSharedPreferences(context).unregisterOnSharedPreferenceChangeListener(listener);
  }

  private static SharedPreferences getDefaultSharedPreferences(Context context)
  {
    return PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
  }

  public abstract static class OnSharedPreferenceChangeListener
      implements SharedPreferences.OnSharedPreferenceChangeListener
  {

    @Override
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
    {
      this.onSharedPreferenceChanged(key);
    }

    protected abstract void onSharedPreferenceChanged(String key);
  }
}