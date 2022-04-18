# LuaInMinecraftBukkt

用Lua来编写Minecraft Bukkit插件!

LuaInMinecraftBukkit是一个可以让Minecraft Bukkit服务端及其的延伸端能使用lua脚本, 并利用lua脚本来编写插件.

### 快速开始文档

[快速开始文档](https://blog.smileyik.tk/?blog=other&album=MinecraftPost&post=LuaInMinecraftBukkit-quickStart)

### 什么是lua?

> Lua 是一门强大、快速、轻量的嵌入式脚本语言。它由巴西里约热内卢 Pontifical Catholic 大学的 PUC-Rio 团队 开发。 Lua 是一个 自由软件， 广泛应用于世界上无数产品和项目。

可以在这里快速体验: [Lua模拟测试](https://wiki.luatos.com/_static/luatos-emulator/lua.html)  
当然, 你也可以查阅他们的参考手册: [中文(5.3)](https://wiki.luatos.com/_static/lua53doc/contents.html) | [英文(5.4)](http://www.lua.org/manual/5.4/manual.html)

### 这个插件能干什么?

这个插件主要是在mc的java的bukkit插件与lua两个之间搭建了一个桥梁, 让lua脚本能够**快速**且**动态**的被加载入bukkit服务器中, 并且能够让lua脚本实现大部分java插件能够实现的功能. 例如:

+ 可以监听绝大多数服务器中的事件
+ 可以创建多个同步/异步线程
+ 可以注册指令
+ 可以连接数据库
+ 可以....

而在没有脚本运行的过程中, 几乎不会对服务器性能带来损耗.

同时, 插件提供两种lua脚本运行模式.

1. 利用java自身实现lua脚本语言规范(默认模式)
2. 使用原本的c语言去运行lua脚本(native模式)

第一种模式为默认模式, 它的兼容性较强
第二种模式需要在配置文件中启用, 在运行较为繁琐复杂的脚本时, 相对比第一种模式而言第二种模式的运行速度会相对而言更快一些.

##### java原生方法运行1 + 2 + ... + 1000000000所耗费的时间:

![java](https://blog.smileyik.tk/blogs/other/markdowns/Minecraft/LuaInMinecraftBukkit/LuaInMinecraftBukkit/cwf9hy.png)

##### 第二种模式去执行相同的方法(在服务器中运行)

![lua](https://blog.smileyik.tk/blogs/blogs/other/markdowns/Minecraft/LuaInMinecraftBukkit/LuaInMinecraftBukkit/oxgyr3.png)

##### 第一种模式去执行相同的方法(在服务器中运行)

时间长到服务器崩溃.

### 如何使用?

下载本插件, 放入服务端的plugins文件夹后重启即可


#### 脚本生命周期

脚本被加载 -> 执行脚本内的onEnable函数 -> 脚本运行 -> 执行脚本内的onDisable函数 -> 脚本被销毁

