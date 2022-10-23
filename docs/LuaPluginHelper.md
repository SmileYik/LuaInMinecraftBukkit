
### luaBukkit.helper:isLoadPlugin
+ **Description**:  指定脚本插件是否加载.
+ **Return Type**: **boolean**
+ **Return Desc**: 如果已经加载则返回true.
+ **Usage**: `luaBukkit.helper:isLoadPlugin(id:String)`

|Name|Type|Description|
|-|-|-|
|id|**String**|脚本插件id|
### luaBukkit.helper:newLuaRunnable
+ **Description**:  以指定id对应的函数为run方法主体创建一个Runnable子类实例
+ **Return Type**: **LuaRunnable**
+ **Return Desc**: LuaRunnable实例
+ **Usage**: `luaBukkit.helper:newLuaRunnable(id:String)`

|Name|Type|Description|
|-|-|-|
|id|**String**|函数路径|
### luaBukkit.helper:newLuaRunnable
+ **Description**:  以指定id对应的函数为run方法主体创建一个Runnable子类实例
+ **Return Type**: **LuaRunnable**
+ **Return Desc**: LuaRunnable实例
+ **Usage**: `luaBukkit.helper:newLuaRunnable(id:String, obj:Object)`

|Name|Type|Description|
|-|-|-|
|id|**String**|函数路径|
|obj|**Object**|带入的参数.|
### luaBukkit.helper:getPlugin
+ **Description**:  获取本插件实例对象.
+ **Return Type**: **Plugin**
+ **Return Desc**: 本插件的实例对象.
+ **Usage**: `luaBukkit.helper:getPlugin()`

|Name|Type|Description|
|-|-|-|

### luaBukkit.helper:getClass
+ **Description**:  通过全类名去获取java类类型.
+ **Return Type**: **Class<?>**
+ **Return Desc**: 如果类存在则返回对应的类
+ **Usage**: `luaBukkit.helper:getClass(name:String)`

|Name|Type|Description|
|-|-|-|
|name|**String**|全类名|
### luaBukkit.helper:isNativeMode
+ **Description**:  插件是否在Native模式下运行.
+ **Return Type**: **boolean**
+ **Return Desc**: 如果是在Native模式下运行则返回true.
+ **Usage**: `luaBukkit.helper:isNativeMode()`

|Name|Type|Description|
|-|-|-|
