
### luaBukkit.event:registerEvent
+ **Description**:  注册事件.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `luaBukkit.event:registerEvent(listener:LuaEvent<?extendsEvent>, priority:int)`

|Name|Type|Description|
|-|-|-|
|listener|**LuaEvent<?extendsEvent>**|监听器|
|priority|**int**|优先级,范围为[0,5],不再此区间内则为正常默认等级.|
### luaBukkit.event:registerListener
+ **Description**:  注册监听事件.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `luaBukkit.event:registerListener(event:String, id:String, priority:int)`

|Name|Type|Description|
|-|-|-|
|event|**String**|要注册的事件.|
|id|**String**|闭包id|
|priority|**int**|优先级,范围为[0,5],不再此区间内则为正常默认等级.|
### luaBukkit.event:register
+ **Description**:  注册监听事件.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `luaBukkit.event:register(event:String, id:String, priority:int)`

|Name|Type|Description|
|-|-|-|
|event|**String**|要注册的事件名.|
|id|**String**|闭包id|
|priority|**int**|优先级,范围为[0,5],不再此区间内则为正常默认等级.|
### luaBukkit.event:register
+ **Description**:  创建一个事件监听器.
+ **Return Type**: **String**
+ **Return Desc**: 
+ **Usage**: `luaBukkit.event:register(plugin:LuaPlugin, closure:Object, event:String, priority:int)`

|Name|Type|Description|
|-|-|-|
|plugin|**LuaPlugin**|脚本插件实例.|
|closure|**Object**|脚本函数|
|event|**String**|事件名|
|priority|**int**|优先级,范围为[0,5],不再此区间内则为正常默认等级.|
### luaBukkit.event:unregisterEvent
+ **Description**:  移除插件脚本用指定id注册的事件.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `luaBukkit.event:unregisterEvent(id:String)`

|Name|Type|Description|
|-|-|-|
|id|**String**|注册事件所用的id.|
### luaBukkit.event:unregisterAll
+ **Description**:  移除插件脚本所有注册的事件.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `luaBukkit.event:unregisterAll(pluginId:String)`

|Name|Type|Description|
|-|-|-|
|pluginId|**String**|插件脚本id|