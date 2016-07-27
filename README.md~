# OuterLayout
offer a layout that out the screen

## Useage
add com.example.qzzhu.outerlayout.OuterLayout.java to your project

## xml 
<com.example.qzzhu.outerlayout.OuterLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
	<br/>
	**add view that has android:contentDescription property such as:<br/>
	<EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/editText"
        android:layout_gravity="center_horizontal|top"
        android:text="top"
        android:contentDescription="top"
        android:gravity="center"
        />   
</com.example.qzzhu.outerlayout.OuterLayout>

##原理
 OuterLayout继承自FrameLayout，并且在onmeasure的时候遍历所有子View,把包含特定contentDescription属性值<br/>
的View放在合适的位置(即超出屏幕之外)

## contentDescription属性值
see OuterLayout.java 常量定义

## Public Function
getLoatedView(POSITION position):得到某个方向的View
