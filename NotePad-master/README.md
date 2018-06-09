# NotePad  

## 1.Notepad基本要求实现  
### 1.1 获取Note创建时间，添加时间戳  
获取Note创建时的系统时间（最终修改时间），并对时间的显示格式进行统一化要求，以列表的形式将Note的标题，图标和所获取的创建时间显示出来，
代码：  
<br>
```Java
添加显示时间的TextView
    <TextView
        android:id="@+id/text1_time"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textAppearance="?android:attr/textAppearanceSmall"
        android:paddingLeft="5dip"
        android:textColor="@color/colorBlack"/>
```  
效果如下图：  

![main](https://github.com/Sev7nzy/Lab/blob/master/NotePad-master/notepad/QQ%E5%9B%BE%E7%89%8720180603102014.png)  

## 1.2 NotePad搜索功能实现  
从数据库中获取搜索结果，实现Note的标题搜索功能，效果如下：  

  
![search1](https://github.com/Sev7nzy/Lab/blob/master/NotePad-master/notepad/QQ%E5%9B%BE%E7%89%8720180603102505.png)
![search2](https://github.com/Sev7nzy/Lab/blob/master/NotePad-master/notepad/QQ%E5%9B%BE%E7%89%8720180603105055.png)



## 2.Notepad额外功能实现  
### 2.1. 简单的UI优化  
对首页背景颜色，功能选项菜单，Note显示效果，Note编辑界面进行了简单的统一的优化，使看上去更加简洁美观，效果如下：  

![1](https://github.com/Sev7nzy/Lab/blob/master/NotePad-master/notepad/QQ%E5%9B%BE%E7%89%8720180603124903.png)
![2](https://github.com/Sev7nzy/Lab/blob/master/NotePad-master/notepad/QQ%E5%9B%BE%E7%89%8720180603125455.png)  

## 2.2 背景颜色变更  

笔记背景颜色选择功能，使用自定义Dialog，在自定义Dialog中展示不同的颜色，并对展示的颜色进行设置ClickListener，当受到某种颜色点击响应后，背景颜色将会改变成所选择的笔记的颜色，背景颜色将会以SharesdPreferenced的方式进行保存。再次进入是会显示上次保存的背景色，使用户可以选择自己喜欢的风格来编辑Note。效果截图：      

![yellow](https://github.com/Sev7nzy/Lab/blob/master/NotePad-master/notepad/QQ%E5%9B%BE%E7%89%8720180603125308.png)
![gray](https://github.com/Sev7nzy/Lab/blob/master/NotePad-master/notepad/QQ%E5%9B%BE%E7%89%8720180603125328.png)  
![red](https://github.com/Sev7nzy/Lab/blob/master/NotePad-master/notepad/QQ%E5%9B%BE%E7%89%8720180603125342.png)  

## 2.3 Note输出功能  
添加了输出文件的功能，可以将Note文件提取出来，效果展示：  

![export](https://github.com/Sev7nzy/Lab/blob/master/NotePad-master/notepad/QQ%E5%9B%BE%E7%89%8720180603102540.png)  
![result](https://github.com/Sev7nzy/Lab/blob/master/NotePad-master/notepad/Screenshot_20180603-104536.png)

