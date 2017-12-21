http://blog.csdn.net/luoyanglizi/article/details/51586437
service:

1.与其他组件联系方式：startService()、bindService()
    “其他组件”不包括Broadcast receiver，其无法直接启动或绑定service。
    功能：
    1.启动service的方式：s/b_在其他组件中，调用方法后，服务即处于启动状态。

    区别：
    1.停止service的方式
        s_service调用stopSelf()，或者其他组件调用stopService()后，service 停止运行。
        b_所有与service绑定的组件被销毁，或者他们都调用了unbindService()后，service 停止运行。
    2.service与启动它的组件之间的通信方式
        s_没有提供默认的通信方式，启动service后该service就处于独立运行状态.
        b_可以通过 ServiceConnection进行通信，组件可以与service进行交互、
            发送请求、获取结果，甚至是利用IPC跨进程执行这些操作
    3.service的生命周期
        s_一旦启动，service即可在后台无限期运行，即使启动service的组件已被销毁也不受其影响，
            直到其被停止
        b_当所有与其绑定的组件都取消绑定(可能是组件被销毁也有可能是其调用了unbindService()方法)后，
            service将停止

2.生命周期方法：
    1. int onStartCommand(Intent intent, int flags, int startId)
        service主要的操作，
        当其他组件通过startService()方法启动service时，此方法将会被调用。
    2. IBinder onBind(Intent intent)
        当其他组件通过bindService()方法与service相绑定之后，此方法将会被调用；
        重写它的时候必须返回一个IBinder对象，用来支撑其他组件与service之间的通信；
        如果你不想让这个service被其他组件所绑定，可以通过在这个方法返回一个null值来实现。

3.Manifests属性：
    <service
        android:enabled=["true" | "false"]
        android:exported=["true" | "false"]
        android:icon="drawable resource"
        android:isolatedProcess=["true" | "false"]
        android:label="string resource"
        android:name="string" //唯一必填
        android:permission="string"
        android:process="string" >
    </service>

    1.enabled:是否可以被系统实例化
    2.explorted:
        true_其他应用的组件可以调用此service,并可以互动。
        false_只有与service统一应用或相同userId的应用可以开启或绑定。
        默认值取决于service是否有intent filters,
            若没有，默认false,只有指定了service的准确类名才能调用，即只能应用内使用。
            若有，默认true,考虑了外界使用的情况。
    3.label:
        显示给用户的这个service的名字。如果不设置，将会默认使用<application>的label属性。
    4.isolatedProcess:
        默认为false，
        如果设置为true，这个service将运行在一个从系统中其他部分分离出来的特殊进程中，
        我们只能通过Service API来与它进行交流。
    5.process:
        service运行的进程的name。默认启动的service是运行在主进程中的。












