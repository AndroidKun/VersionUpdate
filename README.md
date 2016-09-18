# 一分钟实现版本更新功能
##效果图
 ![github](https://github.com/AndroidKun/VersionUpdate/blob/master/image/device-2016-09-18-095154.png)
 ![github](https://github.com/AndroidKun/VersionUpdate/blob/master/image/device-2016-09-18-095926.png)

##集成步骤
### 1.bulid.gradle添加依赖库

    compile 'com.androidkun:version_update:1.0.2'
### 2.调用下载方法并设置参数

    /**
     * 启动下载服务
     *
     * @param context           上下文
     * @param appName           应用名称
     * @param url               下载地址
     * @param iconId            图标资源id
     * @param activityReference 点击通知时跳转目标Activity类路径
     */ 
    VersionUpdateService.beginUpdate(MainActivity.this,"Plants vs. Zombies",url,R.mipmap.icon,"com.androidkun.activity.MainActivity");
