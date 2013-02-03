package com.codenauts.packagedata;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_view);
    fillPackageData();
  }

  private void fillPackageData() {
    TextView textView = (TextView)findViewById(R.id.text_view);
    
    try {
      PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
      StringBuilder builder = new StringBuilder();
      builder.append("Application Name:\n" + getPackageManager().getApplicationLabel(packageInfo.applicationInfo) + "\n\n");
      builder.append("Package Name:\n" + packageInfo.packageName + "\n\n");
      builder.append("Version Code:\n" + packageInfo.versionCode + "\n\n");
      builder.append("Version Name:\n" + packageInfo.versionName + "\n\n");
      builder.append("◆\n\n");
      builder.append("First Install Time:\n" + packageInfo.firstInstallTime + "\n\n");
      builder.append("Last Update Time:\n" + packageInfo.lastUpdateTime + "\n\n");
      builder.append("◆\n\n");
      builder.append("Data Dir:\n" + packageInfo.applicationInfo.dataDir + "\n\n");
      builder.append("Source Dir:\n" + packageInfo.applicationInfo.sourceDir + "\n\n");
      builder.append("Installation Source:\n" + getPackageManager().getInstallerPackageName(getPackageName()) + "\n\n");
      textView.setText(builder.toString());
    } 
    catch (NameNotFoundException e) {
      textView.setText("PackageManager raised exception: " + e.toString());
    }
  }
}
