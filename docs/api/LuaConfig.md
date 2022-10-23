
### loadInsideLuaConfig
+ **Description**:  用默认运行模式加载一个脚本配置.
+ **Return Type**: **LuaConfig**
+ **Return Desc**: 一个脚本配置.
+ **Usage**: `loadInsideLuaConfig(script:String)`

|Name|Type|Description|
|-|-|-|
|script|**String**|脚本.|
### loadInsideLuaConfig
+ **Description**:  用默认运行模式加载一个脚本配置.
+ **Return Type**: **LuaConfig**
+ **Return Desc**: 一个脚本配置.
+ **Usage**: `loadInsideLuaConfig(path:Path)`

|Name|Type|Description|
|-|-|-|
|path|**Path**|脚本路径.|
### loadOutsideLuaConfig
+ **Description**:  用Native原生运行模式加载一个脚本配置.
+ **Return Type**: **LuaConfig**
+ **Return Desc**: 一个脚本配置.
+ **Usage**: `loadOutsideLuaConfig(script:String)`

|Name|Type|Description|
|-|-|-|
|script|**String**|脚本.|
### loadOutsideLuaConfig
+ **Description**:  用Native原生运行模式加载一个脚本配置.
+ **Return Type**: **LuaConfig**
+ **Return Desc**: 一个脚本配置.
+ **Usage**: `loadOutsideLuaConfig(path:Path)`

|Name|Type|Description|
|-|-|-|
|path|**Path**|脚本路径.|
### newTableBuilder
+ **Description**:  构造一张Lua表.
+ **Return Type**: **LuaTableBuilder<?>**
+ **Return Desc**: LuaTableBuilder
+ **Usage**: `newTableBuilder()`

|Name|Type|Description|
|-|-|-|

### setGlobal
+ **Description**:  增加一个全局变量.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `setGlobal(key:String, value:Object)`

|Name|Type|Description|
|-|-|-|
|key|**String**|全局变量名.|
|value|**Object**|全局变量值.|
### addGlobal
+ **Description**:  增加一个全局变量.
+ **Return Type**: **LuaConfig**
+ **Return Desc**: 本实例对象.
+ **Usage**: `addGlobal(key:String, value:Object)`

|Name|Type|Description|
|-|-|-|
|key|**String**|全局变量名.|
|value|**Object**|全局变量值.|
### config
+ **Description**:  运行脚本.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `config()`

|Name|Type|Description|
|-|-|-|

### close
+ **Description**:  关闭并释放LuaConfig所使用的资源. 需要注意的是, 如果传入闭包, 在调用闭包时候, 则必须要保持LuaConfig未被关闭.
+ **Return Type**: **void**
+ **Return Desc**: 
+ **Usage**: `close()`

|Name|Type|Description|
|-|-|-|

### callClosureReturnString
+ **Description**:  运行一个Lua闭包对象并且返回为字符串类型. <p>   对于默认模式有:   如果传递的参数大于3个的时候, 将只会传递前三个参数给闭包. </p> <p>   对于Native模式有:   如果在运行此闭包时, LuaConfig已经关闭, 闭包将会运行失败并抛出异常. </p>
+ **Return Type**: **String**
+ **Return Desc**: 如果闭包返回为nil, 则此方法返回null.         如果此闭包运行后返回的字符串结果.
+ **Usage**: `callClosureReturnString(closureObj:Object, objs:Object...)`

|Name|Type|Description|
|-|-|-|
|closureObj|**Object**|由lua脚本返回的一个闭包实例对象.|
|objs|**Object...**|传递给闭包的参数.|
### callClosureReturnObject
+ **Description**:  运行一个Lua闭包对象并且返回为java对象. 成功且正确的返回java对象的前提是, 在闭包 中返回的对象必须是一个java对象. <p>   对于默认模式有:   如果传递的参数大于3个的时候, 将只会传递前三个参数给闭包. </p> <p>   对于Native模式有:   如果在运行此闭包时, LuaConfig已经关闭, 闭包将会运行失败并抛出异常. </p>
+ **Return Type**: **Object**
+ **Return Desc**: 如果闭包返回为nil, 则此方法返回null.         如果此闭包运行后返回的java对象结果.
+ **Usage**: `callClosureReturnObject(closureObj:Object, objs:Object...)`

|Name|Type|Description|
|-|-|-|
|closureObj|**Object**|由lua脚本返回的一个闭包实例对象.|
|objs|**Object...**|传递给闭包的参数.|
### callClosureReturnNumber
+ **Description**:  运行一个Lua闭包对象. 并且返回一个Number实例. <p>   对于默认模式有:   如果传递的参数大于3个的时候, 将只会传递前三个参数给闭包. </p> <p>   对于Native模式有:   如果在运行此闭包时, LuaConfig已经关闭, 闭包将会运行失败并抛出异常. </p>
+ **Return Type**: **Number**
+ **Return Desc**: 如果闭包返回为nil, 则此方法返回null.         如果此闭包运行后返回的数字结果.
+ **Usage**: `callClosureReturnNumber(closureObj:Object, objs:Object...)`

|Name|Type|Description|
|-|-|-|
|closureObj|**Object**|由lua脚本返回的一个闭包实例对象.|
|objs|**Object...**|传递给闭包的参数.|
### callClosureReturnBoolean
+ **Description**:  运行一个Lua闭包对象. 并且返回一个布尔值. <p>   对于默认模式有:   如果传递的参数大于3个的时候, 将只会传递前三个参数给闭包. </p> <p>   对于Native模式有:   如果在运行此闭包时, LuaConfig已经关闭, 闭包将会运行失败并抛出异常. </p>
+ **Return Type**: **boolean**
+ **Return Desc**: 如果闭包返回为nil, 则此方法返回false.         如果此闭包运行后返回的布尔值结果.
+ **Usage**: `callClosureReturnBoolean(closureObj:Object, objs:Object...)`

|Name|Type|Description|
|-|-|-|
|closureObj|**Object**|由lua脚本返回的一个闭包实例对象.|
|objs|**Object...**|传递给闭包的参数.|
### callClosureReturnClosure
+ **Description**:  运行一个Lua闭包对象. 并且返回一个闭包. <p>   对于默认模式有:   如果传递的参数大于3个的时候, 将只会传递前三个参数给闭包. </p> <p>   对于Native模式有:   如果在运行此闭包时, LuaConfig已经关闭, 闭包将会运行失败并抛出异常. </p>
+ **Return Type**: **Object**
+ **Return Desc**: 如果闭包返回为nil, 则此方法返回null.         如果此闭包运行后返回的闭包结果.
+ **Usage**: `callClosureReturnClosure(closureObj:Object, objs:Object...)`

|Name|Type|Description|
|-|-|-|
|closureObj|**Object**|由lua脚本返回的一个闭包实例对象.|
|objs|**Object...**|传递给闭包的参数.|