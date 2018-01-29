# SlideBackLayoutDemo
侧滑关闭 Activity 的控件
推荐在 BaseActivity 中添加该容器，记得设置 Activity 主题为透明背景：

//创建侧滑关闭 Activity 控件
SlideBackLayout mSlideBackLayout = new SlideBackLayout(this);
//绑定 Activity
mSlideBackLayout.bindActivity(this);

1.可以在不需要侧滑的 Activity 解绑：
mSlideBackLayout.unbindActivity();

2.可以添加希望不被拦截触摸事件的控件：
mSlideBackLayout.addNotInterceptView(View view);