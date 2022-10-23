
### luaBukkit.task:runTask
+ **Description**:  在服务器下一刻运行一个任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTask(luaPlugin:LuaPlugin, functionId:String)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|functionId|**String**|函数id.|
### luaBukkit.task:runTask
+ **Description**:  在服务器下一刻运行一个任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTask(luaPlugin:LuaPlugin, functionId:String, obj:Object)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|functionId|**String**|函数id.|
|obj|**Object**|运行时要给函数传入的参数.|
### luaBukkit.task:runTask
+ **Description**:  在服务器下一刻运行一个任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTask(luaPlugin:LuaPlugin, function:Object)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|function|**Object**|脚本函数.|
### luaBukkit.task:runTask
+ **Description**:  在服务器下一刻运行一个任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTask(luaPlugin:LuaPlugin, function:Object, obj:Object)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|function|**Object**|脚本函数.|
|obj|**Object**|运行时要给函数传入的参数.|
### luaBukkit.task:runTaskAsync
+ **Description**:  运行一个异步任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTaskAsync(luaPlugin:LuaPlugin, functionId:String)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|functionId|**String**|函数id.|
### luaBukkit.task:runTaskAsync
+ **Description**:  运行一个异步任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTaskAsync(luaPlugin:LuaPlugin, functionId:String, obj:Object)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|functionId|**String**|函数id.|
|obj|**Object**|运行时要给函数传入的参数.|
### luaBukkit.task:runTaskAsync
+ **Description**:  运行一个异步任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTaskAsync(luaPlugin:LuaPlugin, function:Object)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|function|**Object**|脚本函数.|
### luaBukkit.task:runTaskAsync
+ **Description**:  运行一个异步任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTaskAsync(luaPlugin:LuaPlugin, function:Object, obj:Object)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|function|**Object**|脚本函数.|
|obj|**Object**|运行时要给函数传入的参数.|
### luaBukkit.task:runTaskLater
+ **Description**:  延迟运行一个任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTaskLater(luaPlugin:LuaPlugin, functionId:String, delay:int)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|functionId|**String**|函数id.|
|delay|**int**|延迟刻数.|
### luaBukkit.task:runTaskLater
+ **Description**:  延迟运行一个任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTaskLater(luaPlugin:LuaPlugin, functionId:String, delay:int, obj:Object)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|functionId|**String**|函数id.|
|delay|**int**|延迟刻数.|
|obj|**Object**|运行时要给函数传入的参数.|
### luaBukkit.task:runTaskLater
+ **Description**:  延迟运行一个任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTaskLater(luaPlugin:LuaPlugin, function:Object, delay:int)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|function|**Object**|脚本函数.|
|delay|**int**|延迟刻数.|
### luaBukkit.task:runTaskLater
+ **Description**:  延迟运行一个任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTaskLater(luaPlugin:LuaPlugin, function:Object, delay:int, obj:Object)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|function|**Object**|脚本函数.|
|delay|**int**|延迟刻数.|
|obj|**Object**|运行时要给函数传入的参数.|
### luaBukkit.task:runTaskLaterAsync
+ **Description**:  延迟运行一个异步任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTaskLaterAsync(luaPlugin:LuaPlugin, functionId:String, delay:int)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|functionId|**String**|函数id.|
|delay|**int**|延迟刻数.|
### luaBukkit.task:runTaskLaterAsync
+ **Description**:  延迟运行一个异步任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTaskLaterAsync(luaPlugin:LuaPlugin, functionId:String, delay:int, obj:Object)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|functionId|**String**|函数id.|
|delay|**int**|延迟刻数.|
|obj|**Object**|运行时要给函数传入的参数.|
### luaBukkit.task:runTaskLaterAsync
+ **Description**:  延迟运行一个异步任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTaskLaterAsync(luaPlugin:LuaPlugin, function:Object, delay:int)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|function|**Object**|脚本函数.|
|delay|**int**|延迟刻数.|
### luaBukkit.task:runTaskLaterAsync
+ **Description**:  延迟运行一个异步任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTaskLaterAsync(luaPlugin:LuaPlugin, function:Object, delay:int, obj:Object)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|function|**Object**|脚本函数.|
|delay|**int**|延迟刻数.|
|obj|**Object**|运行时要给函数传入的参数.|
### luaBukkit.task:runTimer
+ **Description**:  运行一个重复运行的任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTimer(luaPlugin:LuaPlugin, functionId:String, delay:int, period:int)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|functionId|**String**|函数id.|
|delay|**int**|延迟刻数.|
|period|**int**|重复间隔刻数.|
### luaBukkit.task:runTimer
+ **Description**:  运行一个重复运行的任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTimer(luaPlugin:LuaPlugin, functionId:String, delay:int, period:int, obj:Object)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|functionId|**String**|函数id.|
|delay|**int**|延迟刻数.|
|period|**int**|重复间隔刻数.|
|obj|**Object**|运行时要给函数传入的参数.|
### luaBukkit.task:runTimer
+ **Description**:  运行一个重复运行的任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTimer(luaPlugin:LuaPlugin, function:Object, delay:int, period:int)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|function|**Object**|脚本函数.|
|delay|**int**|延迟刻数.|
|period|**int**|重复间隔刻数.|
### luaBukkit.task:runTimer
+ **Description**:  运行一个重复运行的任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTimer(luaPlugin:LuaPlugin, function:Object, delay:int, period:int, obj:Object)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|function|**Object**|脚本函数.|
|delay|**int**|延迟刻数.|
|period|**int**|重复间隔刻数.|
|obj|**Object**|运行时要给函数传入的参数.|
### luaBukkit.task:runTimerAsync
+ **Description**:  运行一个重复运行的任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTimerAsync(luaPlugin:LuaPlugin, functionId:String, delay:int, period:int)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|functionId|**String**|函数id.|
|delay|**int**|延迟刻数.|
|period|**int**|重复间隔刻数.|
### luaBukkit.task:runTimerAsync
+ **Description**:  运行一个重复运行的异步任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTimerAsync(luaPlugin:LuaPlugin, functionId:String, delay:int, period:int, obj:Object)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|functionId|**String**|函数id.|
|delay|**int**|延迟刻数.|
|period|**int**|重复间隔刻数.|
|obj|**Object**|运行时要给函数传入的参数.|
### luaBukkit.task:runTimerAsync
+ **Description**:  运行一个重复运行的异步任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTimerAsync(luaPlugin:LuaPlugin, function:Object, delay:int, period:int)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|function|**Object**|脚本函数.|
|delay|**int**|延迟刻数.|
|period|**int**|重复间隔刻数.|
### luaBukkit.task:runTimerAsync
+ **Description**:  运行一个重复运行的异步任务.
+ **Return Type**: **BukkitTask**
+ **Return Desc**: 一个包含任务id的BukkitTask.
+ **Usage**: `luaBukkit.task:runTimerAsync(luaPlugin:LuaPlugin, function:Object, delay:int, period:int, obj:Object)`

|Name|Type|Description|
|-|-|-|
|luaPlugin|**LuaPlugin**|脚本插件实例.|
|function|**Object**|脚本函数.|
|delay|**int**|延迟刻数.|
|period|**int**|重复间隔刻数.|
|obj|**Object**|运行时要给函数传入的参数.|
### luaBukkit.task:cancel
+ **Description**:  通过BukkitTask的id去取消一个任务.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `luaBukkit.task:cancel(id:int)`

|Name|Type|Description|
|-|-|-|
|id|**int**|BukkitTask中的id.|
### luaBukkit.task:cancelAll
+ **Description**:  取消一个脚本插件中的所有的任务.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `luaBukkit.task:cancelAll(plugin:LuaPlugin)`

|Name|Type|Description|
|-|-|-|
|plugin|**LuaPlugin**|脚本插件实例.|